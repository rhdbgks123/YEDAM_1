package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.LastItemVO;

public interface LastItemMapper {
	public int lastItemViewAdd(Map<String, Object> values);
	public List<LastItemVO> lastItemViewList(String logId);
}
