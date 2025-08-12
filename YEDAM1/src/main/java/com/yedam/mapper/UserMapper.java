package com.yedam.mapper;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.UserVO;

public interface UserMapper {
	public UserVO selectUser(@Param("id")String id, @Param("pw")String pw);
}
