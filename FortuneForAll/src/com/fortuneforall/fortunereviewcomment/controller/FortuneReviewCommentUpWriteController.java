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
import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;
import com.fortuneforall.fortunereviewcomment.dao.FortuneReviewCommentDAO;

@WebServlet("/com.fortuneforall.fortunereviewcomment.controller/fortunereviewcommentupwritecontroller")
public class FortuneReviewCommentUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String cContent = request.getParameter("cContent");
		
		FortuneReviewCommentDAO cDAO = new FortuneReviewCommentDAO();
		FortuneReviewDAO dao = new FortuneReviewDAO();
		request.setAttribute("board", dao.selectByNo(board_no));
		request.setAttribute("comment", cDAO.selectBoard(board_no));
		request.setAttribute("id", id);
		request.setAttribute("cNo", cNo);
		request.setAttribute("board_no", board_no);
		request.setAttribute("cContent", cContent);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/common/boardComment.jsp");
		rd.forward(request, response);
	}
}
