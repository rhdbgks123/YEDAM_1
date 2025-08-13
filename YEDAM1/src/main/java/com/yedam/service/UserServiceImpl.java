package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DBUtil;
import com.yedam.mapper.UserMapper;
import com.yedam.vo.UserVO;

public class UserServiceImpl implements UserService
{
	SqlSession session = DBUtil.getInstance().openSession();
	UserMapper mapper = session.getMapper(UserMapper.class);


	@Override
	public UserVO searchUser(String id, String pw)
	{
		return mapper.selectUser(id, pw);
	}


	@Override
	public int checkUserID(String id) {
		// TODO Auto-generated method stub
		return mapper.checkUser(id);
	}


	@Override
	public boolean registerUser(UserVO user) {
		int r = mapper.insertUser(user);
		if (r> 0)
		{
			session.commit();
			return true;
		}
		
		return false;
	}


	@Override
	public int checkUserPW(String id, String pw) {
		// TODO 자동 생성된 메소드 스텁
		return mapper.selectUserPW(id, pw);
	}


	@Override
	public boolean modifyUser(UserVO user) {
		int r = mapper.updateUser(user);
		if (r> 0)
		{
			session.commit();
			return true;
		}
		
		return false;
	}

}
