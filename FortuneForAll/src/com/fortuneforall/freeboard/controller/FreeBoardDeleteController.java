package com.fortuneforall.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.freeboard.dao.FreeBoardDAO;

@WebServlet("/com.fortuneforall.freeboard.controller/FreeBoardDeleteController")
public class FreeBoardDeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDAO dao = new FreeBoardDAO();
		int no = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		dao.deleteFreeBoard(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1&id="+id);
	}
}
