package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.ItemMapper;
import com.yedam.vo.ItemVO;

public class MainEventServiceImpl implements MainEventService {
	SqlSession session = DBUtil.getInstance().openSession();
	ItemMapper mapper = session.getMapper(ItemMapper.class);
	
	@Override
	public List<ItemVO> todaySale() {		
		return mapper.todaySaleList();
	}

	@Override
	public List<ItemVO> todayHot() {		
		return mapper.todayHotList();
	}

	@Override
	public List<ItemVO> onClickMenuList(String menuCode) {		
		return mapper.onClickMenuList(menuCode);
	}

	@Override
	public List<ItemVO> itemDetailView(String itemCode) {
		return mapper.itemDetailView(itemCode);
	}

}
