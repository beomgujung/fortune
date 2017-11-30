package com.fortuneforall.pubcomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pubcomment.dao.PubCommentDAO;

@WebServlet("/com.fortuneforall.pubcomment.controller/pubcommentdeletecontroller")
public class PubCommentDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PubCommentDAO dao = new PubCommentDAO();
		int no = Integer.parseInt(request.getParameter("comment_no"));
		dao.deleteBoard(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.pub.controller/PubSelectController?page=1");
	}

}
