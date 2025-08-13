package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class UserinfoChangeFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		System.out.println(session.getAttribute("userVO"));
		req.setAttribute("userVO", session.getAttribute("userVO"));
		req.getRequestDispatcher("WEB-INF/jsp/user_infochange_form.jsp").forward(req, res);
		
	}

}
