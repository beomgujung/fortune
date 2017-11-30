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

@WebServlet("/com.fortuneforall.pub.controller/PubUpdateController")
public class PubUpdateController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int Bno = Integer.parseInt(request.getParameter("n"));
		
		Pub p = new Pub();
		p.setBno(Bno);
		p.setTitle(title);
		p.setContent(content);
		
		PubDAO dao = new PubDAO();
		dao.updatePub(p);

		request.setAttribute("pub", p);
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.pub.controller/PubSelectController?page=1");
		rd.forward(request, response);
	}
}
