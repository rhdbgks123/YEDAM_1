package com.yedam.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.LastItemMapper;

public class LastItemServiceImpl implements LastItemService{
	
	SqlSession session = DBUtil.getInstance().openSession();
	LastItemMapper mapper = session.getMapper(LastItemMapper.class);
	
	@Override
	public int lastItemViewInsert(Map<String, Object> values) {	
		int r = mapper.lastItemViewAdd(values);
		if (r>0) {
			session.commit();
		}
		return r;
	}

}
