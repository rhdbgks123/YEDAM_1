package com.yedam.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MyBasketVO;

public interface MyCartService {
	public List<MyBasketVO> cartList(String userId);
	public boolean addMyCart(MyBasketVO cart);
	public boolean removeMyCart(String itemCode,String UserId);
}
