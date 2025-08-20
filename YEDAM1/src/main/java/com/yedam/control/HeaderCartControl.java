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
import com.yedam.service.MyCartService;
import com.yedam.service.MyCartServiceImpl;
import com.yedam.vo.MyBasketVO;

public class HeaderCartControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		
		String id = session.getAttribute("logId").toString();
		
		MyCartService srv = new MyCartServiceImpl();
		
		MyBasketVO cart = new MyBasketVO();
		Map<String, Object> map = new HashMap<String, Object>();
		if(id == null)
		{
			map.put("retCode", "NG");
		}
		else 
		{
			cart = srv.searchCartCount(id);
		}
		
		if(cart != null)
		{
			map.put("retCode", "OK");
			map.put("data", cart);
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
