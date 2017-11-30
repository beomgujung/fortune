package com.fortuneforall.fortuneforall.fortunereviewcomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.comment.dao.CommentDAO;

@WebServlet("/com.fortuneforall.fortunereviewcomment.controller/commentdeletecontroller")
public class CommentDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentDAO dao = new CommentDAO();
		int no = Integer.parseInt(request.getParameter("comment_no"));
		dao.deleteBoard(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.drink.controller/DrinkSelectController?page=1");
	}

}
