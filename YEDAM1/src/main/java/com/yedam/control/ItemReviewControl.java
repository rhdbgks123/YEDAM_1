package com.yedam.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ItemReviewService;
import com.yedam.service.ItemReviewServiceImpl;
import com.yedam.vo.ReviewVO;

public class ItemReviewControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String userId = (String) req.getSession().getAttribute("logId");

        String itemCode = req.getParameter("itemCode");
        int starPoint = Integer.parseInt(req.getParameter("starPoint"));
        String detail = req.getParameter("reviewDetail");
        
        ReviewVO review = new ReviewVO();
        review.setItemCode(itemCode);
        review.setStarPoint(starPoint);
		review.setReviewDetail(detail);
		review.setUserId(userId);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
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
