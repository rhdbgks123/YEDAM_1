package com.yedam1.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
	
}
