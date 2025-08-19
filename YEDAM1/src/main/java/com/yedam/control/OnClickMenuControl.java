package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.LastItemService;
import com.yedam.service.LastItemServiceImpl;
import com.yedam.service.MainEventService;
import com.yedam.service.MainEventServiceImpl;
import com.yedam.vo.ItemVO;
import com.yedam.vo.LastItemVO;

public class OnClickMenuControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String menuCode = req.getParameter("menuCode"); //item 카테고리
		String itemName = req.getParameter("itemName");
		MainEventService srv = new MainEventServiceImpl();
		
		List<ItemVO> list = srv.onClickMenuList(menuCode, itemName);
		
		req.setAttribute("itemList", list);
		
		//250818 최근 클릭한 상품 목록3개 출력 기능
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");		
		
		
		LastItemService srvsec = new LastItemServiceImpl();
		List<LastItemVO> lastItemlist = srvsec.lastItemViewList(logId);
		System.out.println(lastItemlist);
		req.setAttribute("lastItemList", lastItemlist);

		
		
		
		
		req.getRequestDispatcher("user/on_click_menuList.tiles").forward(req, res);
	}

}
