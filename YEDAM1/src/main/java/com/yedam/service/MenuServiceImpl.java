package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.MenuMapper;
import com.yedam.vo.MenuVO;

public class MenuServiceImpl implements MenuService{
	SqlSession session = DBUtil.getInstance().openSession();
	MenuMapper mapper = session.getMapper(MenuMapper.class);
	@Override
	public List<MenuVO> menuList() {
		
		return mapper.menuList();
	}

}
