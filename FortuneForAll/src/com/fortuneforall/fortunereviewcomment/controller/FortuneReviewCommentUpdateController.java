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

@WebServlet("/com.fortuneforall.fortunereviewcomment.controller/FortuneReviewCommentUpdateController")
public class FortuneReviewCommentUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cContent = request.getParameter("cContent");
		String arr[] = request.getParameter("cNo").split("-");
		int cNo = Integer.parseInt(arr[0]);
		String id = arr[1];
		
		System.out.println("comment update controller id : "+ id);
		FortuneReviewComment fc = new FortuneReviewComment();
		fc.setContent(cContent);
		fc.setComment_no(cNo);
		
		FortuneReviewCommentDAO dao = new FortuneReviewCommentDAO();
		dao.updateComment(fc);

		System.out.println("commentUpdatecontroller");
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController?page=1&id="+id);
		rd.forward(request, response);
	}

}
