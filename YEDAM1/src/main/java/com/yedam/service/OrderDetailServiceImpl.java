package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.OrderDetailMapper;
import com.yedam.vo.OrderDetailVO;

public class OrderDetailServiceImpl implements OrderDetailService{
	
	SqlSession session = DBUtil.getInstance().openSession();
	OrderDetailMapper mapper = session.getMapper(OrderDetailMapper.class);
	
	@Override
	public List<OrderDetailVO> orderList(String userId) {
		return mapper.selectOrderList(userId);
	}

}
