package com.fortuneforall.fingerfoodcomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fingerfoodcomment.dao.FingerFoodCommentDAO;
import com.fortuneforall.fingerfoodcomment.domain.FingerFoodComment;


@WebServlet("/com.fortuneforall.fingerfoodcomment.controller/FingerFoodCommentUpdateController")
public class FingerFoodCommentUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cContent = request.getParameter("cContent");
		String arr[] = request.getParameter("cNo").split("-");
		int cNo = Integer.parseInt(arr[0]);
		String id = arr[1];
		
		System.out.println("comment update controller id : "+ id);
		FingerFoodComment ff = new FingerFoodComment();
		ff.setContent(cContent);
		ff.setComment_no(cNo);
		
		FingerFoodCommentDAO dao = new FingerFoodCommentDAO();
		dao.updateComment(ff);

		System.out.println("commentUpdatecontroller");
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.fingerfood.controller/FingerFoodSelectController?page=1&id="+id);
		rd.forward(request, response);
	}

}
