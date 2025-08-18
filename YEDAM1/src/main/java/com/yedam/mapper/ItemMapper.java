package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.vo.ItemVO;
import com.yedam.vo.ReviewVO;

public interface ItemMapper {
	public List<ItemVO> todaySaleList();
	public List<ItemVO> todayHotList();
	public List<ItemVO> onClickMenuList(String menuCode);
	public List<ItemVO> itemDetailView(String itemCode);
	public List<ReviewVO> reviewList(Map<String, Object> values);
}
