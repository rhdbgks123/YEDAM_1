package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ItemVO;

public interface ItemMapper {
	public List<ItemVO> todaySaleList();
	public List<ItemVO> todayHotList();
	public List<ItemVO> onClickMenuList(String menuCode);
	public List<ItemVO> itemDetailView(String itemCode);
}
