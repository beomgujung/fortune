package com.fortuneforall.pubcomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pubcomment.dao.PubCommentDAO;
import com.fortuneforall.pubcomment.domain.PubComment;

@WebServlet("/com.fortuneforall.pubcomment.controller/PubCommentUpdateController")
public class PubCommentUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cContent = request.getParameter("cContent");
		String arr[] = request.getParameter("cNo").split("-");
		int cNo = Integer.parseInt(arr[0]);
		String id = arr[1];
		
		System.out.println("comment update controller id : "+ id);
		PubComment c = new PubComment();
		c.setContent(cContent);
		c.setComment_no(cNo);
		
		PubCommentDAO dao = new PubCommentDAO();
		dao.updateComment(c);

		System.out.println("commentUpdatecontroller");
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.pub.controller/PubSelectController?page=1&id="+id);
		rd.forward(request, response);
	}

}
