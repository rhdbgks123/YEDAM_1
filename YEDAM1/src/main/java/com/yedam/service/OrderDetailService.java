package com.yedam.service;

import java.util.List;

import com.yedam.vo.OrderDetailVO;

public interface OrderDetailService {
	List<OrderDetailVO> orderList(String userId);
}
