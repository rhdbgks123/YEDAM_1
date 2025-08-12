package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.MainControl;
import com.yedam.control.MenuControl;

public class FrontController extends HttpServlet
{

	Map<String, Control> map;

	public FrontController()
	{
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException
	{
		map.put("/main.do", new MainControl());
		map.put("/menu.do", new MenuControl());
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		// url vs uri
		// http://localhost:8080/HelloJSP/boardList.do - URL
		// /HelloJSP/boardList.do - URI

		String uri = req.getRequestURI();  
		String context = req.getContextPath(); // /HelloJSP - 프로젝트
		String page = uri.substring(context.length()); // context의 length부터 끝까지 자르기

		Control control = map.get(page);
		control.execute(req, res);
	}

}
