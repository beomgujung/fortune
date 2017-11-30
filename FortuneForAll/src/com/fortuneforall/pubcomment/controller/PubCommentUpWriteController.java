package com.fortuneforall.pubcomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pub.dao.PubDAO;
import com.fortuneforall.pubcomment.dao.PubCommentDAO;

@WebServlet("/com.fortuneforall.pubcomment.controller/pubcommentupwritecontroller")
public class PubCommentUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String cContent = request.getParameter("cContent");
		
		PubCommentDAO cDAO = new PubCommentDAO();
		PubDAO dao = new PubDAO();
		request.setAttribute("board", dao.selectByPub(board_no));
		request.setAttribute("comment", cDAO.selectBoard(board_no));
		request.setAttribute("id", id);
		request.setAttribute("cNo", cNo);
		request.setAttribute("board_no", board_no);
		request.setAttribute("cContent", cContent);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/PubCommon/boardComment.jsp");
		rd.forward(request, response);
	}
}
