package com.fortuneforall.fortunereviewcomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fortunereviewcomment.dao.FortuneReviewCommentDAO;

@WebServlet("/com.fortuneforall.fortunereviewcomment.controller/fortunereviewcommentdeletecontroller")
public class FortuneReviewCommentDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FortuneReviewCommentDAO dao = new FortuneReviewCommentDAO();
		int no = Integer.parseInt(request.getParameter("comment_no"));
		dao.deleteBoard(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.drink.controller/FortuneReviewSelectController?page=1");
	}

}
