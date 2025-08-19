package com.yedam.control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
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
		if (session == null) {
			res.sendError(400, "세션 만료");
			return;
		}

		// 1) Toss 콜백 파라미터
		String paymentKey = req.getParameter("paymentKey");
		String orderId = req.getParameter("orderId"); // = checkoutId
		String amountStr = req.getParameter("amount");

		if (paymentKey == null || orderId == null || amountStr == null) {
			res.sendError(400, "필수 파라미터 누락");
			return;
		}
		int amountFromToss;
		try {
			amountFromToss = Integer.parseInt(amountStr);
		} catch (Exception e) {
			amountFromToss = -1;
		}

		// 2) 세션의 체크아웃 스냅샷 검증
		String checkoutId = (String) session.getAttribute("checkoutId");
		String userId = (String) session.getAttribute("checkoutUser");
		Integer expected = (Integer) session.getAttribute("checkoutAmount");
		List<OrderDetailVO> items = (List<OrderDetailVO>) session.getAttribute("checkoutItems");

		if (checkoutId == null || !checkoutId.equals(orderId) || userId == null || expected == null || items == null) {
			res.sendError(400, "유효하지 않은 결제 세션");
			return;
		}
		if (amountFromToss <= 0 || !expected.equals(amountFromToss)) {
			res.sendError(400, "결제 금액 불일치");
			return;
		}

		// 3) Toss confirm
		String secretKey = "test_sk_4yKeq5bgrpweRlLGgXNBVGX0lzW6"; // 테스트용. 운영 전환 시 환경변수로.
		String auth = Base64.getEncoder().encodeToString((secretKey + ":").getBytes(StandardCharsets.UTF_8));
		HttpURLConnection conn = (HttpURLConnection) new URL("https://api.tosspayments.com/v1/payments/confirm")
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Authorization", "Basic " + auth);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setDoOutput(true);

		String body = String.format("{\"paymentKey\":\"%s\",\"orderId\":\"%s\",\"amount\":%d}", paymentKey, orderId,
				expected);
		try (OutputStream os = conn.getOutputStream()) {
			os.write(body.getBytes(StandardCharsets.UTF_8));
		}

		int code = conn.getResponseCode();
		InputStream is = (code == 200) ? conn.getInputStream() : conn.getErrorStream();
		String resp = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines().reduce("",
				(a, b) -> a + b);

		if (code != 200) {
			res.sendRedirect(req.getContextPath() + "/payApiFail.do");
			return;
		}

		// 4) 여기서 DB 저장 (주문/상세) + 장바구니 삭제
		OrderService svc = new OrderServiceImpl();

		String orderNo = svc.nextOrderNo();

		OrderVO order = new OrderVO();
		order.setOrderNo(orderNo);
		order.setUserId(userId);
		order.setOrderDate(new java.util.Date());
		boolean okOrder = svc.registerOrder(order);
		if (!okOrder) {
			res.sendError(500, "주문 저장 실패");
			return;
		}

		int lineNo = 0;
		for (OrderDetailVO d : items) {
			OrderDetailVO nd = new OrderDetailVO();
			nd.setOrderNo(orderNo);
			nd.setOrderDetailNo(++lineNo);
			nd.setItemCode(d.getItemCode());
			nd.setItemQty(d.getItemQty());
			nd.setItemPrice(d.getItemPrice());
			if (!svc.registerDetail(nd)) {
				res.sendError(500, "주문상세 저장 실패");
				return;
			}
			// 장바구니에서 제거
			svc.removeBasket(userId, d.getItemCode());
		}

		// 5) 완료 페이지
		req.setAttribute("orderNo", orderNo);
		req.setAttribute("paymentJson", resp);
		req.getRequestDispatcher("/WEB-INF/jsp/pay-complete.jsp").forward(req, res);

		// 6) 스냅샷 정리
		session.removeAttribute("checkoutId");
		session.removeAttribute("checkoutUser");
		session.removeAttribute("checkoutItems");
		session.removeAttribute("checkoutProductTotal");
		session.removeAttribute("checkoutDeliveryFee");
		session.removeAttribute("checkoutAmount");
	}
}
