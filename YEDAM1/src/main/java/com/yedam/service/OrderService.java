package com.yedam.service;

import java.util.List;

import com.yedam.vo.MyBasketVO;
import com.yedam.vo.OrderDetailVO;
import com.yedam.vo.OrderVO;

public interface OrderService {
	public List<MyBasketVO> orderItem(String userId);
	String nextOrderNo();
	public boolean registerOrder(OrderVO order);
	public boolean registerDetail(OrderDetailVO detail);
	public int orderTotal(String orderNo);
	public boolean removeBasket(String userId, String itemCode);
	public MyBasketVO getBasketItem(String userId, String itemCode); // 단일 목록 조회
}
