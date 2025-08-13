package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.UserService;
import com.yedam.service.UserServiceImpl;
import com.yedam.vo.UserVO;

public class RegisterUserControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("utf-8");
		String uid = req.getParameter("userId");
		String pwd = req.getParameter("pwd");
		String pwdChk = req.getParameter("pwdChk");
		String nickname = req.getParameter("nickname");
		String uname = req.getParameter("userName");
		String birth = req.getParameter("birth");
		String identi = req.getParameter("identi");
		String phone = req.getParameter("phone");
		String email = req.getParameter("userEmail");
		String address = req.getParameter("address");
		String addressdetail = req.getParameter("addressdetail");
		


		UserService srv = new UserServiceImpl();
		UserVO user = new UserVO();
		user.setUserId(uid);
		user.setUserPw(pwd);
		user.setNickname(nickname);
		user.setUserName(uname);
		user.setBirth(birth);
		user.setIdenti(identi);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		user.setAddressdetail(addressdetail);
		
		if(srv.registerUser(user))
			res.sendRedirect("main.do");
		else
			System.out.println("에러발생");
	}

}
