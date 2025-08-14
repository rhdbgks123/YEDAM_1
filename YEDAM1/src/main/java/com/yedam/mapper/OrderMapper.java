package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.MyBasketVO;
import com.yedam.vo.OrderDetailVO;
import com.yedam.vo.OrderVO;

public interface OrderMapper {
	List<MyBasketVO> selectItem(String userId);
	String nextOrderNo();  // 주문번호 생성
	int insertOrder(OrderVO order);
	int insertOrderDetail(OrderDetailVO detail);
	int deleteBasket(@Param("userId") String userId, @Param("itemCode") String itemCode);
	int selectOrderTotal(String orderNO);
	MyBasketVO selectBasketItem(@Param("userId") String userId, @Param("itemCode") String itemCode);
}
