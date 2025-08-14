package com.yedam.service;

import com.yedam.vo.UserVO;

public interface UserService
{
	public UserVO searchUser(String id, String pw);
	public int checkUserID(String id);
	public int checkUserPW(String id, String pw);
	public boolean registerUser(UserVO user);
	public boolean modifyUser(UserVO user);
	public boolean checkUserMail(UserVO user, String signkey);
	public UserVO searchUserId(UserVO user);
	public boolean removeUserSign(String userId);
}
