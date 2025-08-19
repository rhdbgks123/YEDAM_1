package com.yedam.control;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import com.yedam.common.Control;

public class payApiFailControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/jsp/pay-fail.jsp").forward(req, res);

	}

}
