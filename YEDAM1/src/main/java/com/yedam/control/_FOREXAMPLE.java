package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;

public class _FOREXAMPLE implements Control
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
//		String strPage = req.getParameter("page");
//		String con = req.getParameter("searchCondition");
//		String key = req.getParameter("keyword");
//		SearchDTO search = new SearchDTO();
//		
//		strPage = strPage==null ? "1" : strPage;
//		search.setPage(Integer.parseInt(strPage));
//		search.setSearchCondition(con);
//		search.setKeyword(key);
//		
//		// WEB-INF/html/board_list.html
//		BoardService srv = new BoardServiceImpl();
//		List<BoardVO> list = srv.boardList(search);
//		
//		//페이징
//		int totalCnt = srv.totalCount(search);
//		PageDTO paging = new PageDTO(Integer.parseInt(strPage), totalCnt);
//		
//		req.setAttribute("board_list", list);
//		req.setAttribute("paging", paging);
//		req.setAttribute("search", search);
//		HttpSession session = req.getSession();
//		String authority = (String) session.getAttribute("auth");
//
//		if(authority==null) 
//		{
//			req.getRequestDispatcher("user/board_list.tiles").forward(req, res);
//			return;
//		}
//		
////		req.getRequestDispatcher("WEB-INF/html/board_list.jsp").forward(req, res);
//		if(authority.equals("Admin"))
//			req.getRequestDispatcher("admin/board_list.tiles").forward(req, res);
//		else
//			req.getRequestDispatcher("user/board_list.tiles").forward(req, res);
//		//jsp(뷰 역할) 페이지에 데이터 전달
//		
//		
	}

}
