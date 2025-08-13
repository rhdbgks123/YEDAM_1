package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.MainEventService;
import com.yedam.service.MainEventServiceImpl;
import com.yedam.vo.ItemVO;

public class TodaySaleControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("실행되나?MenuListControl");
		res.setContentType("text/json;charset=utf-8");
		MainEventService srv = new MainEventServiceImpl();
		List<ItemVO> list = srv.todaySale();
		System.out.println(list);
		//Gson 라이브러리 활용해서 json문자열 만들기.
				Gson gson = new GsonBuilder().create();
				String json = gson.toJson(list);
				
				// 출력 스트림.
				res.getWriter().print(json);

	}

}
