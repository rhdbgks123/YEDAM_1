package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.MyCartService;
import com.yedam.service.MyCartServiceImpl;

public class RemoveItemControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String itemCode = req.getParameter("itemCode");
		System.out.println(itemCode);
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		System.out.println(logId);
		if(logId == null || logId.isEmpty()){
            res.sendRedirect("loginForm.do"); 
            return;
        }
		
		MyCartService svc = new MyCartServiceImpl();
		
		if(svc.removeMyCart(itemCode, logId)) {
			res.getWriter().print("{\"retCode\":\"OK\"}");
		} else {
			res.getWriter().print("{\"retCode\":\"NG\"}");
		}
		
	}

}
