package com.fortuneforall.freecomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.freecomment.dao.FreeCommentDAO;
import com.fortuneforall.freecomment.domain.FreeComment;


@WebServlet("/com.fortuneforall.freecomment.controller/FreeCommentInsertController")
public class FreeCommentInsertController extends HttpServlet{
	
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

		
		FreeComment fc = new FreeComment();
		fc.setBoard_no(board_no);
		fc.setId(id);
		fc.setContent(content);
		
		FreeCommentDAO dao = new FreeCommentDAO();
		dao.insertComment(fc);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1");
	}
}
