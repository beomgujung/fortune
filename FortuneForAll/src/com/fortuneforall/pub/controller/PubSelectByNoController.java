package com.fortuneforall.pub.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.comment.dao.CommentDAO;
import com.fortuneforall.comment.domain.Comment;
import com.fortuneforall.pub.dao.PubDAO;


@WebServlet("/com.fortuneforall.pub.controller/PubSelectByNoController")
public class PubSelectByNoController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PubDAO dao = new PubDAO();
		int no = Integer.parseInt(request.getParameter("no"));
		String id = request.getParameter("id");
		int result = dao.checkId(id, no);
		request.setAttribute("result", result);
		
		request.setAttribute("board", dao.selectByPub(no));
		request.setAttribute("id", id);
		
		CommentDAO cDAO = new CommentDAO();
		List<Comment> list = cDAO.selectBoard(no);
		request.setAttribute("comment", list);

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Pub/board.jsp");
		rd.forward(request, response);
	}
}
