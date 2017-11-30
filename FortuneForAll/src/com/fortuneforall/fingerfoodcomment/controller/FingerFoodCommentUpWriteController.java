package com.fortuneforall.fingerfoodcomment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fingerfood.dao.FingerFoodDAO;
import com.fortuneforall.fingerfoodcomment.dao.FingerFoodCommentDAO;


@WebServlet("/com.fortuneforall.fingerfoodcomment.controller/fingerfoodcommentupwritecontroller")
public class FingerFoodCommentUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int cNo = Integer.parseInt(request.getParameter("cNo"));
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String cContent = request.getParameter("cContent");
		
		FingerFoodCommentDAO cDAO = new FingerFoodCommentDAO();
		FingerFoodDAO dao = new FingerFoodDAO();
		request.setAttribute("board", dao.selectByNo(board_no));
		request.setAttribute("comment", cDAO.selectBoard(board_no));
		request.setAttribute("id", id);
		request.setAttribute("cNo", cNo);
		request.setAttribute("board_no", board_no);
		request.setAttribute("cContent", cContent);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FingerFoodCommon/boardComment.jsp");
		rd.forward(request, response);
	}
}
