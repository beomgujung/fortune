package com.fortuneforall.fortunereview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;
import com.fortuneforall.fortunereview.domain.FortuneReview;

@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewUpWriteController")
public class FortuneReviewUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FortuneReviewDAO dao = new FortuneReviewDAO();
		String id = request.getParameter("id");
		int board_no = Integer.parseInt(request.getParameter("num"));
		int result = dao.checkId(id, board_no);
		
		FortuneReview fr = dao.selectByNo(board_no);
		
		request.setAttribute("fortunereview", fr);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FortuneReview/upWrite.jsp");
		rd.forward(request, response);
		
	}
}
