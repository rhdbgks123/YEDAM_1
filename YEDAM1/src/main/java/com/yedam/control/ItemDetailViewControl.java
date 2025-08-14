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

public class ItemDetailViewControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String itemCode = req.getParameter("itemCode"); //item 카테고리
		MainEventService srv = new MainEventServiceImpl();
		List<ItemVO> list = srv.itemDetailView(itemCode);
		req.setAttribute("itemInfoList", list);
		
		
		
		req.getRequestDispatcher("user/item_detail_view.tiles").forward(req, res);
	}

}
