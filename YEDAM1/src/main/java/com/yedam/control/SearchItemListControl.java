package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.common.MailSender;
import com.yedam.vo.ItemVO;

public class SearchItemListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setCharacterEncoding("UTF-8");
		String category = req.getParameter("category");
		
		//ItemService srv = new IterServiceImpl();
		
		//List<ItemVO> item = srv.searchItemList(category);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// DB처리 -> 반환
		//if(item != null)
		//{
			map.put("retCode", "OK");
			//map.put("itemList", item);
		//}
		//else
		//{
			map.put("retCode", "NG");
		//}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		res.getWriter().print(json);
	}

}
