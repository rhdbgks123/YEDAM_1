package com.yedam.service;

import java.util.List;

import com.yedam.vo.MyBasketVO;

public interface MyCartService {
	public List<MyBasketVO> cartList(String userId);
	public boolean addMyCart(MyBasketVO cart);
}
