package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ItemVO;
import com.yedam.vo.ReviewVO;

public interface MainEventService {
	public List<ItemVO> todaySale();
	public List<ItemVO> todayHot();
	public List<ItemVO> onClickMenuList(String menuCode);
	public List<ItemVO> itemDetailView(String itemCode);
	public List<ReviewVO> reviewList(Map<String, Object> values);
}
