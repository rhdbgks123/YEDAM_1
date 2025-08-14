package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.UserVO;

public interface UserMapper {
	public UserVO selectUser(@Param("id")String id, @Param("pw")String pw);
	public int checkUser(String id);
	public int insertUser(UserVO user);
	public int selectUserPW(@Param("id")String id, @Param("pw")String pw);
	public int updateUser(UserVO user);
	public int insertUserSign(@Param("user")UserVO user, @Param("signkey")String signkey);
	public UserVO selectUserId(UserVO user);
	public int deleteUserSign(String id);
	
}
