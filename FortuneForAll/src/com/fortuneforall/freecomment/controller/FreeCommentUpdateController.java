package com.fortuneforall.freecomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.freecomment.dao.FreeCommentDAO;
import com.fortuneforall.freecomment.domain.FreeComment;

@WebServlet("/com.fortuneforall.freecomment.controller/FreeCommentUpdateController")
public class FreeCommentUpdateController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cContent = request.getParameter("cContent");
		String arr[] = request.getParameter("cNo").split("-");
		int cNo = Integer.parseInt(arr[0]);
		String id = arr[1];
		
		System.out.println("comment update controller id : "+ id);
		FreeComment fc = new FreeComment();
		fc.setContent(cContent);
		fc.setComment_no(cNo);
		
		FreeCommentDAO dao = new FreeCommentDAO();
		dao.updateComment(fc);

		System.out.println("commentUpdatecontroller");
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1&id="+id);
		rd.forward(request, response);
	}

}
