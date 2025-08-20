package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.MyCartMapper;
import com.yedam.vo.MyBasketVO;

public class MyCartServiceImpl implements MyCartService {

	SqlSession sqlSession = DBUtil.getInstance().openSession();
	MyCartMapper mapper = sqlSession.getMapper(MyCartMapper.class);

	@Override
	public List<MyBasketVO> cartList(String userId) {
		return mapper.selectCartList(userId);
	}

	@Override
	public boolean addMyCart(MyBasketVO cart) {
		int r = mapper.insertMyCart(cart);
		if (r > 0) {
			sqlSession.commit();
			return true;
		}

		return false;
	}

	@Override
	public boolean removeMyCart(String itemCode, String userId) {
		int r = mapper.deleteItemList(itemCode, userId);
		if (r > 0) {
			sqlSession.commit();
			return true;
		}

		return false;

	}

}
