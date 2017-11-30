package com.fortuneforall.fortunereview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewInWriteController")
public class FortuneReviewInWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FortuneReview/write.jsp");
		rd.forward(request, response);
	}
}
