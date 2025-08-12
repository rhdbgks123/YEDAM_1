package com.yedam.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// mybatis 환경에서 sqlsessionfactory 생성
public class DBUtil
{
	public static SqlSessionFactory getInstance() 
	{
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = null;
		try
		{
			inputStream = Resources.getResourceAsStream(resource);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory;	
	}
}
