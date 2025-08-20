package com.yedam.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.UserService;
import com.yedam.service.UserServiceImpl;
import com.yedam.vo.UserVO;

public class LoginControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		String id = req.getParameter("id");
		String psw = req.getParameter("psw");
		
		UserService srv = new UserServiceImpl();
		UserVO user = srv.searchUser(id, psw);
		if(user == null) 
		{
		    req.setAttribute("errorMsg", "아이디 또는 비밀번호가 올바르지 않습니다.");
			req.getRequestDispatcher("WEB-INF/jsp/login_form.jsp").forward(req, res);
		}
		else
		{
			user.setUserPw("");
			HttpSession session =  req.getSession();
			session.setAttribute("logId", id);
			session.setAttribute("userVO", user);
			res.sendRedirect("main.do");
		}
		
		
	}

}
