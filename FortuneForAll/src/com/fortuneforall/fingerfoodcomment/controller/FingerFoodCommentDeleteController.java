package com.fortuneforall.fingerfoodcomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fingerfoodcomment.dao.FingerFoodCommentDAO;


@WebServlet("/com.fortuneforall.fingerfoodcomment.controller/fingerfoodcommentdeletecontroller")
public class FingerFoodCommentDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		FingerFoodCommentDAO dao = new FingerFoodCommentDAO();
		int no = Integer.parseInt(request.getParameter("comment_no"));
		dao.deleteBoard(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.fingerfood.controller/FingerFoodSelectController?page=1");
	}

}
