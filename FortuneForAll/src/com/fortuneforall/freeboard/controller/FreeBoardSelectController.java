package com.fortuneforall.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.freeboard.dao.FreeBoardDAO;
import com.fortuneforall.member.domain.Login;

@WebServlet("/com.fortuneforall.freeboard.controller/FreeBoardSelectController")
public class FreeBoardSelectController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDAO dao = new FreeBoardDAO();
		String id = request.getParameter("id");
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("id", id);
		request.setAttribute("board", dao.selectBoard(page));
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/FreeBoard/freeboard.jsp");
		rd.forward(request, response);
	}
}
