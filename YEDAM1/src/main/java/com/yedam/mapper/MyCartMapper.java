package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MyBasketVO;

public interface MyCartMapper {
	public List<MyBasketVO> selectCartList(String userId); // 장바구니 목록 조회
	public int insertMyCart(MyBasketVO cart);
	public int deleteItemList(@Param("itemCode") String itemCode, @Param("userId")  String userId);
	public MyBasketVO selectCartCount(String userId);
}
