package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.MyBasketVO;

public interface MyCartMapper {
	public List<MyBasketVO> selectCartList(String userId); // 장바구니 목록 조회
}
