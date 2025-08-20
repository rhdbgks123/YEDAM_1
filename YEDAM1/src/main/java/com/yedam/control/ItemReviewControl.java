package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.ItemReviewService;
import com.yedam.service.ItemReviewServiceImpl;
import com.yedam.vo.ReviewVO;

public class ItemReviewControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");             
	    res.setCharacterEncoding("UTF-8");
	    res.setContentType("text/html; charset=UTF-8");
		
		
		String userId = (String) req.getSession().getAttribute("logId");

        String itemCode = req.getParameter("itemCode");
        int starPoint = Integer.parseInt(req.getParameter("starPoint"));
        String detail = req.getParameter("reviewDetail");
        String upload = req.getServletContext().getRealPath("img/review");
        
        MultipartRequest mr = new MultipartRequest(
				req, // 요청정보
				upload, // 업로드 경로
				1024 * 1024 * 5, // 최대 업로드 파일 크기 5MB
				"UTF-8", // 인코딩 방식
				new DefaultFileRenamePolicy() // 동일한 이름이 있으면 rename
		);
        
        String title = mr.getParameter("title");
		String writer = mr.getParameter("userId");
		String content = mr.getParameter("content");
		String img = mr.getFilesystemName("images");
        
        
        
        ReviewVO review = new ReviewVO();
        review.setItemCode(itemCode);
        review.setStarPoint(starPoint);
		review.setReviewDetail(detail);
		review.setUserId(userId);
		
		
		
		ItemReviewService svc = new ItemReviewServiceImpl();
		boolean result = svc.writeReview(review);
		
		if (result) {
            res.sendRedirect("myOrderDetail.do");
        } else {
            req.setAttribute("errorMsg", "리뷰 등록에 실패했습니다.");
            req.getRequestDispatcher("reviewForm.jsp").forward(req, res);
        }
		
	}

}
