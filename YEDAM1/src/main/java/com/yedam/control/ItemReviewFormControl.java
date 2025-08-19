package com.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.OrderDetailService;
import com.yedam.service.OrderDetailServiceImpl;
import com.yedam.vo.OrderDetailVO;

public class ItemReviewFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String itemCode = req.getParameter("itemCode");
		String orderNo = req.getParameter("orderNo");
		String logId = (String) session.getAttribute("logId");
		
		OrderDetailService svc = new OrderDetailServiceImpl();
		List<Map<String, Object>> headers = svc.orderHeaderList(logId);
		List<OrderDetailVO> list = svc.orderList(orderNo);
		
		Map<String, Object> orderHeader = null;
		
		for (Map<String, Object> h : headers) {
            if (h.get("ORDERNO").equals(orderNo)) {
                orderHeader = h;
                break;
            }
        }
		
		req.setAttribute("orderNo", orderNo);
		req.setAttribute("itemCode", itemCode);
		req.setAttribute("orderHeader", orderHeader);
		req.setAttribute("list", list);
        
        req.getRequestDispatcher("WEB-INF/jsp/itemReviewForm.jsp").forward(req, res);
		
	}

}
