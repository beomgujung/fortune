package com.fortuneforall.fingerfoodcomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.fingerfoodcomment.dao.FingerFoodCommentDAO;
import com.fortuneforall.fingerfoodcomment.domain.FingerFoodComment;


@WebServlet("/com.fortuneforall.fingerfoodcomment.controller/FingerFoodCommentInsertController")
public class FingerFoodCommentInsertController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int board_no = Integer.parseInt(request.getParameter("board_no"));
		String ori = request.getParameter("board_no");
		String[] arr = ori.split("-");
		int board_no = Integer.parseInt(arr[0]);
		System.out.println("arr[0] : "+arr[0]);
		System.out.println("arr[1] : "+arr[1]);
		String id = arr[1];
		String content = request.getParameter("content");

		
		FingerFoodComment ff = new FingerFoodComment();
		ff.setBoard_no(board_no);
		ff.setId(id);
		ff.setContent(content);
		
		FingerFoodCommentDAO dao = new FingerFoodCommentDAO();
		dao.insertComment(ff);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.fingerfood.controller/FingerFoodSelectController?page=1");
	}
}
