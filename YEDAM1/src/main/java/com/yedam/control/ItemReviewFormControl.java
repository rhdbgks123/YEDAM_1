package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class ItemReviewFormControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String itemCode = req.getParameter("itemCode");
        req.setAttribute("itemCode", itemCode);
        
        req.getRequestDispatcher("WEB-INF/jsp/itemReviewForm.jsp").forward(req, res);
		
	}

}
