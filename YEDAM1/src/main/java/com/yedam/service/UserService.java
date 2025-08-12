package com.yedam.service;

import com.yedam.vo.UserVO;

public interface UserService
{
	public UserVO userCheck(String id, String pw);
}
