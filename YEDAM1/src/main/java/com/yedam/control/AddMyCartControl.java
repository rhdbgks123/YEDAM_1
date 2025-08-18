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

public class AddMyCartControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String item_code = req.getParameter("itemCode");
		String item_qty = req.getParameter("itemQty");

		HttpSession session = req.getSession();
		
		String user_id = session.getAttribute("logId").toString();
		
		MyCartService srv = new MyCartServiceImpl();
		
		MyBasketVO cart = new MyBasketVO();
		
		cart.setUserId(user_id);
		cart.setItemCode(item_code);
		cart.setItemQty(Integer.parseInt(item_qty));
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(srv.addMyCart(cart))
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
