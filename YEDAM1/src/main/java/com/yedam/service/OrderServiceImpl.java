package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.OrderMapper;
import com.yedam.vo.MyBasketVO;
import com.yedam.vo.OrderDetailVO;
import com.yedam.vo.OrderVO;

public class OrderServiceImpl implements OrderService{
	
	SqlSession sqlSession = DBUtil.getInstance().openSession();
	OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
	
	@Override
	public List<MyBasketVO> orderItem(String userId) {
		return mapper.selectItem(userId);
	}

	@Override
	public boolean registerOrder(OrderVO order) {
		int r = mapper.insertOrder(order);
		if (r > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean registerDetail(OrderDetailVO detail) {
		int r = mapper.insertOrderDetail(detail);
		if (r > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean removeBasket(String userId, String itemCode) {
		int r = mapper.deleteBasket(userId, itemCode);
		if (r > 0) {
			sqlSession.commit();
			return true;
		}
		return false;
	}

	@Override
	public int orderTotal(String orderNo) {
		return mapper.selectOrderTotal(orderNo);
	}

	@Override
	public String nextOrderNo() {
		 return mapper.nextOrderNo();
	}

	@Override
	public MyBasketVO getBasketItem(String userId, String itemCode) {
		return mapper.selectBasketItem(userId, itemCode);
	}

}
