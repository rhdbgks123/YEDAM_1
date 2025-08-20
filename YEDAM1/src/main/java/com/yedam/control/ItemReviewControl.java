package com.yedam.control;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        // 1) 업로드 경로를 먼저 준비하고 폴더 생성
        String upload = req.getServletContext().getRealPath("/img/review");
        new File(upload).mkdirs();

        // (옵션) 멀티파트 요청인지 방어
        String ct = req.getContentType();
        if (ct == null || !ct.toLowerCase().startsWith("multipart/")) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "multipart/form-data 요청이 아닙니다.");
            return;
        }

        // 2) 멀티파트 파싱 (여기서부터는 무조건 mr에서 파라미터 꺼냄)
        MultipartRequest mr = new MultipartRequest(
                req,
                upload,
                5 * 1024 * 1024,        // 5MB
                "UTF-8",
                new DefaultFileRenamePolicy()
        );

        // 세션 사용자
        String userId = (String) req.getSession().getAttribute("logId");

        // 3) 파라미터 읽기 (mr로!)
        String itemCode = mr.getParameter("itemCode");
        String starStr  = mr.getParameter("starPoint");
        String detail   = mr.getParameter("reviewDetail");

        // JSP의 파일 input name은 "reviewImages" (multiple). cos는 보통 마지막만 잡힘.
        // 단일 한 장만 쓸 거면 아래 한 줄이면 충분.
        String img = mr.getFilesystemName("reviewImages");

        // 안전한 정수 파싱 (기본 3점)
        int starPoint = 3;
        try {
            if (starStr != null && !starStr.isBlank()) {
                starPoint = Integer.parseInt(starStr);
            }
        } catch (NumberFormatException ignore) {
            starPoint = 3;
        }

        // 4) VO 채우기
        ReviewVO review = new ReviewVO();
        review.setUserId(userId);          // writer를 userId로 쓰는 정책이면 이 한 줄로 충분
        review.setItemCode(itemCode);
        review.setStarPoint(starPoint);
        review.setReviewDetail(detail);
        review.setImage(img);              // 이미지 한 장만 저장할 때

        // 5) 서비스 호출
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
