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
import com.yedam.service.MainEventService;
import com.yedam.service.MainEventServiceImpl;
import com.yedam.vo.ReviewVO;

public class reviewListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/json;charset=utf-8"); // 한글있을지도 모르니 코드지정
		String bno = req.getParameter("bno");		
		String page = req.getParameter("page");	
		
		MainEventService srv = new MainEventServiceImpl();
		Map<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("page", page);
		List<ReviewVO> list = srv.reviewList(map);
		
		
		//Gson 라이브러리 활용해서 json문자열 만들기.
		Gson gson = new GsonBuilder().create();
		String json = gson.toJson(list);
		
		// 출력 스트림.
		res.getWriter().print(json);


	}

}
