package com.fortuneforall.pub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pub.dao.PubDAO;


@WebServlet("/com.fortuneforall.pub.controller/PubSelectController")
public class PubSelectController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PubDAO dao = new PubDAO();
		String id = request.getParameter("id");
		int page = Integer.parseInt(request.getParameter("page"));
		
		request.setAttribute("id", id);
		request.setAttribute("board", dao.selectBoard(page));

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Pub/pub.jsp");
		rd.forward(request, response);
	}
}
