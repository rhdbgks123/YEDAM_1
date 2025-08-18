package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class ItemDetailViewControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String itemCode = req.getParameter("itemCode"); //item 카테고리
		MainEventService srv = new MainEventServiceImpl();
		List<ItemVO> list = srv.itemDetailView(itemCode);
		
		//권한에 따라 템플릿적용.
		HttpSession session = req.getSession();
		String logId = (String) session.getAttribute("logId");
		
				
		Map<String, Object> map = new HashMap<>();
		
		LastItemService srvtwo = new LastItemServiceImpl();
		map.put("userId", logId);
		map.put("itemCode", itemCode);
		int r = srvtwo.lastItemViewInsert(map);
		if(r>0) {
			System.out.println("lastitemview카운트 정상작동");
		} else {
			System.out.println("lastitemview카운트 작동안됨");
		}
		
		req.setAttribute("itemInfoList", list);
		req.setAttribute("itemCode", itemCode);
		
		
		
		req.getRequestDispatcher("user/item_detail_view.tiles").forward(req, res);
	}

}
