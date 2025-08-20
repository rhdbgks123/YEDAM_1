package com.yedam.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.vo.OrderDetailVO;
import com.yedam.vo.OrderVO;

public class payApiSuccessControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
        if (session == null) { res.sendError(400, "세션 만료"); return; }
        String userId = (String) session.getAttribute("logId");
        if (userId == null || userId.isEmpty()) { res.sendRedirect("loginForm.do"); return; }

        // 1) 콜백 파라미터
        String paymentKey = req.getParameter("paymentKey");
        String orderId    = req.getParameter("orderId");
        String amountStr  = req.getParameter("amount");
        if (paymentKey == null || orderId == null || amountStr == null) {
            res.sendError(400, "필수 파라미터 누락"); return;
        }

        int amount;
        try { amount = Integer.parseInt(amountStr); }
        catch (Exception e) { res.sendError(400, "amount 형식 오류"); return; }

        // 2) 세션 스냅샷 검증
        String checkoutId = (String) session.getAttribute("checkoutId");
        Integer expected  = (Integer) session.getAttribute("checkoutAmount");
        @SuppressWarnings("unchecked")
        List<OrderDetailVO> items = (List<OrderDetailVO>) session.getAttribute("checkoutItems");

        if (checkoutId == null || expected == null || items == null) { res.sendError(400, "결제 세션 누락"); return; }
        if (!checkoutId.equals(orderId)) { res.sendError(400, "orderId 불일치"); return; }
        if (expected != amount) { res.sendError(400, "결제 금액 불일치"); return; }

        // 3) Toss 결제 승인(Confirm)
        final String secretKey = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6"; // 테스트 시크릿키
        String encodedAuth = Base64.getEncoder().encodeToString((secretKey + ":").getBytes(StandardCharsets.UTF_8));
        String json = String.format("{\"paymentKey\":\"%s\",\"orderId\":\"%s\",\"amount\":%d}", paymentKey, orderId, amount);

        int code;
        String tossResponse;
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) URI.create("https://api.tosspayments.com/v1/payments/confirm").toURL().openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Basic " + encodedAuth);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes(StandardCharsets.UTF_8));
            }

            code = conn.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (code == 200 ? conn.getInputStream() : conn.getErrorStream()), StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (String line; (line = br.readLine()) != null;) sb.append(line);
            tossResponse = sb.toString();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            res.sendError(500, "결제 승인 중 오류");
            return;
        } finally {
            if (conn != null) conn.disconnect();
        }

        if (code != 200) {
            req.setAttribute("error", tossResponse);
            req.getRequestDispatcher("/WEB-INF/jsp/pay_fail.jsp").forward(req, res);
            return;
        }

        // 4) DB 저장 (주문/상세) + 장바구니 삭제
        OrderService svc = new OrderServiceImpl();
        String orderNo = svc.nextOrderNo();

        OrderVO order = new OrderVO();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setOrderDate(new Date());
        if (!svc.registerOrder(order)) { res.sendError(500, "주문 저장 실패"); return; }

        int lineNo = 0;
        for (OrderDetailVO d : items) {
            OrderDetailVO nd = new OrderDetailVO();
            nd.setOrderNo(orderNo);
            nd.setOrderDetailNo(++lineNo);
            nd.setItemCode(d.getItemCode());
            nd.setItemQty(d.getItemQty());
            nd.setItemPrice(d.getItemPrice());
            if (!svc.registerDetail(nd)) { res.sendError(500, "주문상세 저장 실패"); return; }
            svc.removeBasket(userId, d.getItemCode());
        }

        // 5) 완료 페이지
        req.setAttribute("orderNo", orderNo);
        req.setAttribute("paymentJson", tossResponse);
        req.getRequestDispatcher("/WEB-INF/jsp/pay_success.jsp").forward(req, res);

        // 6) 세션 스냅샷 정리
        session.removeAttribute("checkoutId");
        session.removeAttribute("checkoutUser");
        session.removeAttribute("checkoutItems");
        session.removeAttribute("checkoutProductTotal");
        session.removeAttribute("checkoutDeliveryFee");
        session.removeAttribute("checkoutAmount");
    }
}
