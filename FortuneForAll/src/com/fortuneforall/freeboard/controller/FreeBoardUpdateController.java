package com.fortuneforall.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.freeboard.dao.FreeBoardDAO;
import com.fortuneforall.freeboard.domain.FreeBoard;

@WebServlet("/com.fortuneforall.freeboard.controller/FreeBoardUpdateController")
public class FreeBoardUpdateController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String[] arr = request.getParameter("n").split("-");
		int board_no = Integer.parseInt(arr[0]);
		String id = arr[1];
		System.out.println("fingerfood update id : "+id);
		
		FreeBoard f = new FreeBoard();
		f.setBoard_no(board_no);
		f.setTitle(title);
		f.setContent(content);
		
		System.out.println("update");
		FreeBoardDAO dao = new FreeBoardDAO();
		dao.updateFreeBoard(f);

		request.setAttribute("freeboard", f);
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1&id="+id);
		rd.forward(request, response);
	}
}
