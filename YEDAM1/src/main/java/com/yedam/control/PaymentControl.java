package com.yedam.control;

import java.awt.print.Printable;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.OrderService;
import com.yedam.service.OrderServiceImpl;
import com.yedam.vo.MyBasketVO;
import com.yedam.vo.OrderDetailVO;
import com.yedam.vo.OrderVO;

public class PaymentControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userId = (String) req.getSession().getAttribute("logId");
		if (userId == null || userId.isEmpty()) {
			res.sendRedirect("loginForm.do");
			return;
		}

		OrderService svc = new OrderServiceImpl();

		String orderNo = svc.nextOrderNo();

		OrderVO order = new OrderVO();
		order.setOrderNo(orderNo);
		order.setUserId(userId);
		order.setOrderDate(new java.util.Date());

		String[] selectedCodes = req.getParameterValues("selectItem");
		if (selectedCodes == null || selectedCodes.length == 0) {
			res.sendRedirect("myCart.do");
			return;
		}

		boolean chkOrder = svc.registerOrder(order);

		if (chkOrder) {

			for (String code : selectedCodes) {
				 MyBasketVO basketItem = svc.getBasketItem(userId, code);
				
				OrderDetailVO detail = new OrderDetailVO();
				detail.setOrderNo(orderNo);
				detail.setItemCode(basketItem.getItemCode());
				detail.setItemQty(basketItem.getItemQty());
				detail.setItemPrice(basketItem.getSalePrice()); // 가격 필드명 맞게
				boolean chkDetail = svc.registerDetail(detail);
				
				if(chkDetail) {
					svc.removeBasket(userId, code);
				}
			}
		} 
		
		// 2번 registerOrder 호출
		// if(registerOrder( == OK)) {if (registerDetail() == 'OK') { REMOVE()}}}

	}

}
