package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ItemVO;
import com.yedam.vo.ReviewVO;

public interface ItemMapper {
	public List<ItemVO> todaySaleList();
	public List<ItemVO> todayHotList();
	public List<ItemVO> onClickMenuList(@Param("menuCode") String menuCode,@Param("itemName") String itemName);
	public List<ItemVO> itemDetailView(String itemCode);
	public List<ReviewVO> reviewList(Map<String, Object> values);
	public int selectCount(String itemCode);
}
