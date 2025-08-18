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
		if(svc.writeReview(review)) {
			map.put("retCode", "OK");
			 map.put("msg", "리뷰가 등록되었습니다!");
			 map.put("redirect", "myOrderDetail.do");
		} else {
			map.put("retCode", "NG");
            map.put("msg", "리뷰 등록에 실패했습니다.");
		}
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); 
		res.getWriter().print(json);
		
	}

}
