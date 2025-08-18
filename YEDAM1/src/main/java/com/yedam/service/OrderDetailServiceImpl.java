package com.yedam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.OrderDetailMapper;
import com.yedam.vo.OrderDetailVO;

public class OrderDetailServiceImpl implements OrderDetailService{
	
	SqlSession session = DBUtil.getInstance().openSession();
	OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
	
	@Override
	public List<Map<String, Object>> orderHeaderList(String userId) {
		List<Map<String, Object>> headers = mapper.selectOrderList(userId);
        return headers;
	}
	
	@Override
	public List<OrderDetailVO> orderList(String orderNo) {
		List<OrderDetailVO> details = mapper.selectOrderDetailList(orderNo);
        return details;
	}


}
