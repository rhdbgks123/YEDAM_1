package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.OrderDetailService;
import com.yedam.service.OrderDetailServiceImpl;
import com.yedam.vo.OrderDetailVO;

public class MyOrderDetailControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userId = (String) req.getSession().getAttribute("logId");
		
		OrderDetailService service = new OrderDetailServiceImpl();
        List<OrderDetailVO> orders = service.orderList(userId);
        
        req.setAttribute("orders", orders);
        
        req.getRequestDispatcher("/myPage/orderDetail.tiles").forward(req, res);
		
	}

}
