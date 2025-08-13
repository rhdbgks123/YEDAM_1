package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.UserService;
import com.yedam.service.UserServiceImpl;

public class CheckUserControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		UserService srv = new UserServiceImpl();
		
		String userId = req.getParameter("userId");
		
		Map<String, Object> map = new HashMap<String, Object>();
		int check = srv.checkUserID(userId);
		System.out.print(check);
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
