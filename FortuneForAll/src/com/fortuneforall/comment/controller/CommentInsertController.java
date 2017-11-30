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

import sun.awt.RepaintArea;

@WebServlet("/com.fortuneforall.comment.controller/CommentInsertController")
public class CommentInsertController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String ori = request.getParameter("board_no");
		String[] arr = ori.split("-");
		int board_no = Integer.parseInt(arr[0]);
		System.out.println("arr[0] : "+arr[0]);
		System.out.println("arr[1] : "+arr[1]);
		String id = arr[1];
		String content = request.getParameter("content");

		
		Comment c = new Comment();
		c.setBoard_no(board_no);
		c.setId(id);
		c.setContent(content);
		
		CommentDAO dao = new CommentDAO();
		dao.insertComment(c);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.drink.controller/DrinkSelectController?page=1&id="+id);
	}
}
