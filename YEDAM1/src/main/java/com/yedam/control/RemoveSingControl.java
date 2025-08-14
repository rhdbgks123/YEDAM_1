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

public class RemoveSingControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid = req.getParameter("userId");
		
		UserService srv = new UserServiceImpl();
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		boolean check = srv.removeUserSign(uid);
		
		if(check)
		{
			map.put("retCode", "OK");
		}
		else
		{
			map.put("retCode", "NG");
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		res.getWriter().print(json);
		
	}

}
