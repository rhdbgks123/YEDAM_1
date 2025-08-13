package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.UserService;
import com.yedam.service.UserServiceImpl;
import com.yedam.vo.UserVO;

public class UserinfoChangeControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		req.setCharacterEncoding("utf-8");
		HttpSession session = req.getSession();
		String uid = session.getAttribute("logId").toString();
		String pwd = req.getParameter("pwd");		
		String nickname = req.getParameter("nickname");
		String phone = req.getParameter("phone");
		String email = req.getParameter("userEmail");
		String address = req.getParameter("address");
		String addressdetail = req.getParameter("addressdetail");
		


		UserService srv = new UserServiceImpl();
		UserVO user = new UserVO();
		user.setUserId(uid);
		user.setUserPw(pwd);
		user.setNickname(nickname);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		user.setAddressdetail(addressdetail);
		
		if(srv.modifyUser(user))
			res.sendRedirect("main.do");
		else
			System.out.println("에러발생");
	}

}
