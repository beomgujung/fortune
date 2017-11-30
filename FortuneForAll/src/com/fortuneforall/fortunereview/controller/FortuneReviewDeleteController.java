package com.fortuneforall.fortunereview.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;

@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewDeleteController")
public class FortuneReviewDeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FortuneReviewDAO dao = new FortuneReviewDAO();
		int no = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		dao.deleteFortuneReview(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController?page=1&id="+id);
	}
}
