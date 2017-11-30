package com.fortuneforall.fortunereview.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;
import com.fortuneforall.fortunereview.domain.FortuneReview;

@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewUpdateController")
public class FortuneReviewUpdateController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int board_no = Integer.parseInt(request.getParameter("n"));
		
		FortuneReview fr = new FortuneReview();
		fr.setBoard_no(board_no);
		fr.setTitle(title);
		fr.setContent(content);
		
		System.out.println("update");
		FortuneReviewDAO dao = new FortuneReviewDAO();
		dao.updateFortuneReview(fr);

		request.setAttribute("fortunereview", fr);
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController?page=1");
		rd.forward(request, response);
	}
}
