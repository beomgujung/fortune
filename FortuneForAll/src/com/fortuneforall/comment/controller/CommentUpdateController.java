package com.fortuneforall.comment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.comment.dao.CommentDAO;
import com.fortuneforall.comment.domain.Comment;

@WebServlet("/com.fortuneforall.comment.controller/CommentUpdateController")
public class CommentUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cContent = request.getParameter("cContent");
		String arr[] = request.getParameter("cNo").split("-");
		int cNo = Integer.parseInt(arr[0]);
		String id = arr[1];
		
		System.out.println("comment update controller id : "+ id);
		Comment c = new Comment();
		c.setContent(cContent);
		c.setComment_no(cNo);
		
		CommentDAO dao = new CommentDAO();
		dao.updateComment(c);

		System.out.println("commentUpdatecontroller");
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.drink.controller/DrinkSelectController?page=1&id="+id);
		rd.forward(request, response);
	}

}
