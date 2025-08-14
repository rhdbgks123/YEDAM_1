package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.common.MailSender;
import com.yedam.service.UserService;
import com.yedam.service.UserServiceImpl;
import com.yedam.vo.UserVO;

public class FindUserControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
        int num = (int)(Math.random() * 1000000); // 0 ~ 999999
        String signkey = String.format("%06d", num); // 6자리로 0 채움
        
		UserService srv = new UserServiceImpl();
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean check = srv.checkUserMail(user, signkey);
		
		UserVO users = srv.searchUserId(user); 
		String uid = users.getUserId();
		
		System.out.print(check);
		// DB처리 -> 반환
		if(check)
		{
			MailSender.send(uEmail, uName +" 님 메일을 인증해주세요.(YEDAM 1조)", uName + "님 인증번호는 "+ signkey + " 입니다.");
			map.put("retCode", "OK");
			map.put("data", check);
			map.put("usersign", signkey);
			map.put("userId", uid);
		}
		else
		{
			map.put("retCode", "NG");
			map.put("data", check);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		res.getWriter().print(json);
	}

}
