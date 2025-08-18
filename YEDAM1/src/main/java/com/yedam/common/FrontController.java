package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddMyCartControl;
import com.yedam.control.CheckUserControl;
import com.yedam.control.CheckUserPwControl;
import com.yedam.control.FindUserControl;
import com.yedam.control.FindUserFormControl;
import com.yedam.control.ItemDetailViewControl;
import com.yedam.control.ItemListFormControl;
import com.yedam.control.ItemReviewControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.MenuControl;
import com.yedam.control.MenuListControl;
import com.yedam.control.MyCartControl;
import com.yedam.control.MyOrderDetailControl;
import com.yedam.control.OnClickMenuControl;
import com.yedam.control.PaymentControl;
import com.yedam.control.RegisterUserControl;
import com.yedam.control.RegisterUserFormControl;
import com.yedam.control.RemoveSingControl;
import com.yedam.control.SearchItemListControl;
import com.yedam.control.SendMailUserInfoControl;
import com.yedam.control.TodayHotControl;
import com.yedam.control.TodaySaleControl;
import com.yedam.control.UserinfoChangeControl;
import com.yedam.control.UserinfoChangeFormControl;
import com.yedam.control.reviewListControl;

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
		map.put("/checkUserPw.do", new CheckUserPwControl());
		map.put("/userinfochange.do", new UserinfoChangeControl());
		map.put("/findUserForm.do", new FindUserFormControl());
		map.put("/findUser.do", new FindUserControl());
		map.put("/removeSign.do", new RemoveSingControl());
		map.put("/sendMailUserInfo.do", new SendMailUserInfoControl());
		map.put("/logout.do", new LogoutControl());
		
		//메인메뉴
		map.put("/menu.do", new MenuControl());
		map.put("/menuList.do", new MenuListControl());
		map.put("/todaySale.do", new TodaySaleControl());
		map.put("/todayHot.do", new TodayHotControl());
		map.put("/onClickMenu.do", new OnClickMenuControl());
		map.put("/itemDetailView.do", new ItemDetailViewControl());
		map.put("/reviewList.do", new reviewListControl());
		
		//상품
		map.put("/searchItemList.do", new SearchItemListControl());
		map.put("/itemListForm.do", new ItemListFormControl());
		map.put("/addMyCart.do", new AddMyCartControl());
		
		
		
		//마이페이지
		map.put("/myCart.do", new MyCartControl());  // 장바구니
		map.put("/payments.do", new PaymentControl());  // 결제
		map.put("/myOrderDetail.do", new MyOrderDetailControl()); // 주문내역
		map.put("/itemReview.do", new ItemReviewControl()); // 리뷰작성
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
