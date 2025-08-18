package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.OrderDetailVO;

public interface OrderDetailMapper {
	List<Map<String, Object>> selectOrderList(@Param("userId") String userId);
	 List<OrderDetailVO> selectOrderDetailList(@Param("orderNo") String orderNo);
}
