package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.CheckUserControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.MainControl;
import com.yedam.control.MenuControl;
import com.yedam.control.MenuListControl;
import com.yedam.control.MyCartControl;
import com.yedam.control.RegisterUserControl;
import com.yedam.control.RegisterUserFormControl;
import com.yedam.control.UserinfoChangeFormControl;

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
		
		//회원정보
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/registerUserForm.do", new RegisterUserFormControl());
		map.put("/registUser.do", new RegisterUserControl());
		map.put("/checkUser.do", new CheckUserControl());
		map.put("/userinfoChangeForm.do", new UserinfoChangeFormControl());
		
		//메인메뉴
		map.put("/menu.do", new MenuControl());
		map.put("/menuList.do", new MenuListControl());
		
		//상품
		
		//마이페이지
		map.put("/myCart.do", new MyCartControl());
//		map.put("/myInfo.do", new MyInfoControl());
//		map.put("/myOrder.do", new MyOrderControl());
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
