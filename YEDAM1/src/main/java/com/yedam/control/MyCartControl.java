package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MyCartService;
import com.yedam.service.MyCartServiceImpl;
import com.yedam.vo.MyBasketVO;

public class MyCartControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String userId = req.getParameter("userId");
		
		MyCartService svc = new MyCartServiceImpl();
		List<MyBasketVO> list = svc.cartList(userId);
		
		req.setAttribute("cartList", list);
		
		req.getRequestDispatcher("myPage/myCart.tiles").forward(req, res);
		
	}

}
