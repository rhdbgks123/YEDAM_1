package com.yedam.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.vo.MyBasketVO;
import com.yedam.vo.OrderDetailVO;

public class PaymentControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
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

		OrderService svc = new OrderServiceImpl();

		// 1) 품목/수량 수집 + 서버 합계 계산
		int productTotal = 0;
		int lineNo = 0;
		List<OrderDetailVO> items = new ArrayList<>();

		for (String code : selectedCodes) {
			MyBasketVO b = svc.getBasketItem(userId, code);
			if (b == null)
				continue;

			int qty = parseInt(req.getParameter("qty_" + code), 1);
			if (qty < 1)
				qty = 1;

			int unit = (b.getSalePrice() > 0) ? b.getSalePrice() : b.getPrice();

			OrderDetailVO d = new OrderDetailVO();
			d.setOrderDetailNo(++lineNo);
			d.setItemCode(code);
			d.setItemQty(qty);
			d.setItemPrice(unit);
			items.add(d);

			productTotal += unit * qty;
		}

		if (items.isEmpty()) {
			res.sendRedirect("myCart.do");
			return;
		}

		int deliveryFee = (productTotal < 5_000_000) ? 3_000 : 0;
		int amount = productTotal + deliveryFee;

		// 2) 임시 결제ID(토스 orderId) 생성
		String checkoutId = "CHK-" + System.currentTimeMillis() + "-" + (int) (Math.random() * 9000 + 1000);

		// 3) 세션에 체크아웃 스냅샷 저장 (성공 시 여기서 주문을 생성함)
		session.setAttribute("checkoutId", checkoutId);
		session.setAttribute("checkoutUser", userId);
		session.setAttribute("checkoutItems", items); // 주문상세로 저장할 소스
		session.setAttribute("checkoutProductTotal", productTotal);
		session.setAttribute("checkoutDeliveryFee", deliveryFee);
		session.setAttribute("checkoutAmount", amount);

		// 4) 모달로 넘길 값 셋팅
		req.setAttribute("orderNo", checkoutId); // 토스 orderId로 사용
		req.setAttribute("amount", amount);
		req.setAttribute("orderName", "장바구니 상품 결제"); // 필수! 간단명으로 OK
		req.setAttribute("customerName", userId);
		req.setAttribute("successUrl", req.getContextPath() + "/payApiSuccess.do");
		req.setAttribute("failUrl", req.getContextPath() + "/payApiFail.do");

		req.getRequestDispatcher("/WEB-INF/jsp/payment.jsp").forward(req, res);
	}

	private int parseInt(String s, int def) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return def;
		}
	}
}
