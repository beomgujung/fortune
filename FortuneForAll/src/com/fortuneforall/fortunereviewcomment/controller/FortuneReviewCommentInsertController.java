package com.fortuneforall.fortunereviewcomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.comment.dao.CommentDAO;
import com.fortuneforall.comment.domain.Comment;
import com.fortuneforall.fortunereviewcomment.dao.FortuneReviewCommentDAO;
import com.fortuneforall.fortunereviewcomment.domain.FortuneReviewComment;

import sun.awt.RepaintArea;

@WebServlet("/com.fortuneforall.fortunereviewcomment.controller/FortuneReviewCommentInsertController")
public class FortuneReviewCommentInsertController extends HttpServlet{
	
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

		
		FortuneReviewComment fc = new FortuneReviewComment();
		fc.setBoard_no(board_no);
		fc.setId(id);
		fc.setContent(content);
		
		FortuneReviewCommentDAO dao = new FortuneReviewCommentDAO();
		dao.insertComment(fc);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController?page=1");
	}
}
