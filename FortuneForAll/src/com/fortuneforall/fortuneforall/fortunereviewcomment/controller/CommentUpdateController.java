package com.fortuneforall.fortuneforall.fortunereviewcomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.comment.dao.CommentDAO;
import com.fortuneforall.comment.domain.Comment;

@WebServlet("/com.fortuneforall.fortunereviewcomment.controller/CommentUpdateController")
public class CommentUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int comment_no = Integer.parseInt(request.getParameter("comment_upNo"));
		Comment c = new Comment();
		c.setBoard_no(board_no);
		c.setContent(content);
		c.setComment_no(comment_no);
		
		CommentDAO dao = new CommentDAO();
		dao.updateComment(c);

		request.setAttribute("comment", c);
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.comment.controller/DrinkSelectByNoController");
		rd.forward(request, response);
	}

}
