package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.MenuVO;

public interface MenuMapper {
	public List<MenuVO> menuList();
//	<insert id ="insertMyCart" parameterType="myCart">
//	MERGE INTO tb_basket BAS
//	 USING (SELECT #{userId} user_id, #{itemCode} item_code, #{itemQty} item_qty FROM DUAL) new
//	    on (bas.item_code = new.item_code)
//		()
//</insert>
}
