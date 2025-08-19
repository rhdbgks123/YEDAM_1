package com.yedam.control;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.vo.MyBasketVO;
import com.yedam.vo.OrderDetailVO;
import com.yedam.vo.OrderVO;

public class payApiControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
        String userId = (String) req.getSession().getAttribute("logId");
        if (userId == null || userId.isEmpty()) {
            res.sendRedirect("loginForm.do");
            return;
        }

        String[] selectedCodes = req.getParameterValues("selectItem");
        if (selectedCodes == null || selectedCodes.length == 0) {
            res.sendRedirect("myCart.do");
            return;
        }

        // 2) 주문번호 채번 및 주문 레코드 생성(READY 성격)
        OrderService svc = new OrderServiceImpl();
        String orderNo = svc.nextOrderNo();

        OrderVO order = new OrderVO();
        order.setOrderNo(orderNo);
        order.setUserId(userId);
        order.setOrderDate(new java.util.Date());

        boolean okOrder = svc.registerOrder(order);
        if (!okOrder) {
            res.sendError(500, "주문 생성에 실패했습니다.");
            return;
        }

        // 3) 상세 라인 저장 + 서버에서 합계 계산
        int productTotal = 0;
        int lineNo = 1;

        // 선택한 code -> qty 매핑(수량 파라미터 안정 파싱)
        Map<String, Integer> qtyMap = new LinkedHashMap<>();
        for (String code : selectedCodes) {
            int qty = parseInt(req.getParameter("qty_" + code), 1);
            if (qty < 1) qty = 1;
            qtyMap.put(code, qty);
        }

        for (String code : selectedCodes) {
            MyBasketVO basketItem = svc.getBasketItem(userId, code);
            if (basketItem == null) {
                // 장바구니와 불일치 → 스킵/롤백 판단 (여기선 스킵)
                continue;
            }

            int newQty = qtyMap.getOrDefault(code, Math.max(1, basketItem.getItemQty()));
            int unitPrice = (basketItem.getSalePrice() > 0) ? basketItem.getSalePrice() : basketItem.getPrice();

            OrderDetailVO detail = new OrderDetailVO();
            detail.setOrderNo(orderNo);
            detail.setOrderDetailNo(lineNo++);
            detail.setItemCode(basketItem.getItemCode());
            detail.setItemQty(newQty);
            detail.setItemPrice(unitPrice);

            boolean okDetail = svc.registerDetail(detail);
            if (!okDetail) {
                res.sendError(500, "주문 상세 저장에 실패했습니다.");
                return;
            }

            productTotal += unitPrice * newQty;
        }

        // 4) 배송비 및 총액 (서버 규칙과 화면 규칙 일치!)
        int deliveryFee = (productTotal < 5_000_000) ? 3_000 : 0;
        int grandTotal = productTotal + deliveryFee;
        String orderName = "주문번호 " + orderNo;
        
        // 5) 결제 모달 페이지로 forward (여기서 토스 위젯 띄움)
        req.setAttribute("orderNo", orderNo);                // 토스 orderId에 사용
        req.setAttribute("amount", grandTotal);              // 결제 총금액
        req.setAttribute("customerName", userId);
        req.setAttribute("orderName", orderName);
        req.setAttribute("successUrl", req.getContextPath() + "/payApiSuccess.do");
        req.setAttribute("failUrl", req.getContextPath() + "/payApiFail.do");

        req.getRequestDispatcher("/WEB-INF/jsp/paymentAPI.jsp").forward(req, res);
    }

    private int parseInt(String s, int def) {
        try { return Integer.parseInt(s); } catch (Exception e) { return def; }
	}

}
