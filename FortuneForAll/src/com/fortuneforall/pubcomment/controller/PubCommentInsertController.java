package com.fortuneforall.pubcomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pubcomment.dao.PubCommentDAO;
import com.fortuneforall.pubcomment.domain.PubComment;

@WebServlet("/com.fortuneforall.pubcomment.controller/PubCommentInsertController")
public class PubCommentInsertController extends HttpServlet{
	
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

		
		PubComment c = new PubComment();
		c.setBoard_no(board_no);
		c.setId(id);
		c.setContent(content);
		
		PubCommentDAO dao = new PubCommentDAO();
		dao.insertComment(c);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.pub.controller/PubSelectController?page=1");
	}
}
