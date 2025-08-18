package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.OrderDetailVO;

public interface OrderDetailMapper {
	 List<OrderDetailVO> selectOrderList(String userId);
}
