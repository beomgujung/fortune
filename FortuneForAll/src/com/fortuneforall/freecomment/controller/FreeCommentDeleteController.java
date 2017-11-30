package com.fortuneforall.freecomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.freecomment.dao.FreeCommentDAO;

@WebServlet("/com.fortuneforall.freecomment.controller/freecommentdeletecontroller")
public class FreeCommentDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FreeCommentDAO dao = new FreeCommentDAO();
		int no = Integer.parseInt(request.getParameter("comment_no"));
		dao.deleteBoard(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1");
	}

}
