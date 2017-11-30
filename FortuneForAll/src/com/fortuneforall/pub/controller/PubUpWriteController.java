package com.fortuneforall.pub.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pub.dao.PubDAO;
import com.fortuneforall.pub.domain.Pub;

@WebServlet("/com.fortuneforall.pub.controller/PubUpWriteController")
public class PubUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PubDAO dao = new PubDAO();
		String id = request.getParameter("id");
		int board_no = Integer.parseInt(request.getParameter("num"));
		int result = dao.checkId(id, board_no);
		
		Pub p = dao.selectByPub(board_no);

		request.setAttribute("pub", p);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Pub/upWrite.jsp");
		rd.forward(request, response);
	}
}
