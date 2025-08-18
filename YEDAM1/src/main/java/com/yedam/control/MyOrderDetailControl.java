package com.yedam.control;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DBUtil;
import com.yedam.mapper.OrderDetailMapper;
import com.yedam.vo.OrderDetailVO;

public class MyOrderDetailControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String userId = (String) req.getSession().getAttribute("logId");
		
		SqlSession sqlSession = DBUtil.getInstance().openSession();
		OrderDetailMapper mapper = sqlSession.getMapper(OrderDetailMapper.class);

		List<Map<String,Object>> headers = mapper.selectOrderList(userId);

		for (Map<String,Object> h : headers) {
		    String orderNo = String.valueOf(h.get("orderNo")); 
		    List<OrderDetailVO> details = mapper.selectOrderDetailList(orderNo);
		    h.put("details", details); 
		}

		req.setAttribute("headers", headers);
		req.getRequestDispatcher("myPage/orderDetail.tiles").forward(req, res);

		
	}

}
