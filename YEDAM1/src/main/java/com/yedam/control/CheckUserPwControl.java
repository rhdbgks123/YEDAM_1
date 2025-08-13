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
import com.yedam.service.UserService;
import com.yedam.service.UserServiceImpl;

public class CheckUserPwControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO 자동 생성된 메소드 스텁
		UserService srv = new UserServiceImpl();
		HttpSession session = req.getSession();
		String userId = session.getAttribute("logId").toString();
		String userPw = req.getParameter("pw");
		Map<String, Object> map = new HashMap<String, Object>();
		int check = srv.checkUserPW(userId, userPw);
		// DB처리 -> 반환
		if(check > 0 )
		{
			map.put("retCode", "OK");
			map.put("data", check);
			
			
			//res.getWriter().print("{\"retCode\":\"OK\"}");
		}
		else
		{
			map.put("retCode", "NG");
			map.put("data", check);
			//res.getWriter().print("{\"retCode\":\"NG\"}");
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		res.getWriter().print(json);
	}

}
