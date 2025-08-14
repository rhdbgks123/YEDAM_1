package com.yedam.service;

import java.util.List;

import com.yedam.vo.ItemVO;

public interface MainEventService {
	public List<ItemVO> todaySale();
	public List<ItemVO> todayHot();
	public List<ItemVO> onClickMenuList(String menuCode);
	public List<ItemVO> itemDetailView(String itemCode);
	
}
