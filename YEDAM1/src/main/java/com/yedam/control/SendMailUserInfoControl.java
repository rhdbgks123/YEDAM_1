package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.MailSender;
import com.yedam.service.UserService;
import com.yedam.service.UserServiceImpl;
import com.yedam.vo.UserVO;

public class SendMailUserInfoControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		String uName = req.getParameter("userName");
		String uBirth = req.getParameter("birth");
		String uIdenti = req.getParameter("identi");
		String uEmail = req.getParameter("email");
		
		UserVO user = new UserVO();
		user.setUserName(uName);
		user.setBirth(uBirth);
		user.setIdenti(uIdenti);
		user.setEmail(uEmail);
		        
		UserService srv = new UserServiceImpl();
				
		UserVO users = srv.searchUserId(user); 
		if(users != null)
		{
			MailSender.send(uEmail, uName +" 님 아이디와 비밀번호입니다", uName + "님 아이디는 " + users.getUserId() + ", 비밀번호는 " + users.getUserPw() +" 입니다.");
			res.sendRedirect("main.do");
		}
	}

}
