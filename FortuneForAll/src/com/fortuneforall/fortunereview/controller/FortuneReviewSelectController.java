package com.fortuneforall.fortunereview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;

@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController")
public class FortuneReviewSelectController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FortuneReviewDAO dao = new FortuneReviewDAO();
		String id = request.getParameter("id");
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("id", id);
		request.setAttribute("board", dao.selectBoard(page));
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FortuneReview/fortunereview.jsp");
		rd.forward(request, response);
	}
}
