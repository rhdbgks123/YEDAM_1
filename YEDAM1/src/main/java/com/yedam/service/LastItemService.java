package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.LastItemVO;

public interface LastItemService {
	public int lastItemViewInsert(Map<String, Object> values);
	public List<LastItemVO> lastItemViewList(String logId);
}
