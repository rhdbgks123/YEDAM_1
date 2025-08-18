package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MainEventService;
import com.yedam.service.MainEventServiceImpl;
import com.yedam.vo.ItemVO;

public class OnClickMenuControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String menuCode = req.getParameter("menuCode"); //item 카테고리
		String itemName = req.getParameter("itemName");
		MainEventService srv = new MainEventServiceImpl();
		System.out.println(itemName);
		List<ItemVO> list = srv.onClickMenuList(menuCode, itemName);
		req.setAttribute("itemList", list);
		req.getRequestDispatcher("user/on_click_menuList.tiles").forward(req, res);
	}

}
