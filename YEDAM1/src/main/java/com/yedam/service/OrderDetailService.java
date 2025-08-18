package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.OrderDetailVO;

public interface OrderDetailService {
	List<Map<String, Object>> orderHeaderList(String userId);
	List<OrderDetailVO> orderList(String orderNo);
}
