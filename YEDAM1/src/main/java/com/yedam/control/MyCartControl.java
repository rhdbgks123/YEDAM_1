package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MyCartService;
import com.yedam.service.MyCartServiceImpl;
import com.yedam.vo.MyBasketVO;

public class MyCartControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String itemCode = req.getParameter("itemCode");
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		
		if(logId == null || logId.isEmpty()){
            res.sendRedirect("loginForm.do"); 
            return;
        }
		
		MyCartService svc = new MyCartServiceImpl();
		List<MyBasketVO> list = svc.cartList(logId);
		
		req.setAttribute("cartList", list);
		req.setAttribute("itemCode", itemCode);
		
		
		req.getRequestDispatcher("myPage/myCart.tiles").forward(req, res);
		
	}

}
