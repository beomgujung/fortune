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


@WebServlet("/com.fortuneforall.freeboard.controller/FreeBoardUpWriteController")
public class FreeBoardUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDAO dao = new FreeBoardDAO();
		String id = request.getParameter("id");
		int board_no = Integer.parseInt(request.getParameter("num"));
		int result = dao.checkId(id, board_no);
		
		FreeBoard f = dao.selectByNo(board_no);
		
		request.setAttribute("freeboard", f);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FreeBoard/upWrite.jsp");
		rd.forward(request, response);
		
	}
}