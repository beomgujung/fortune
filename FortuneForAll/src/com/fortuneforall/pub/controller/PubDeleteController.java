package com.fortuneforall.pub.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.pub.dao.PubDAO;

@WebServlet("/com.fortuneforall.pub.controller/PubDeleteController")
public class PubDeleteController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PubDAO dao = new PubDAO();
		int no = Integer.parseInt(request.getParameter("num"));
		System.out.println(no);
		dao.deletePub(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.pub.controller/PubSelectController?page=1");
	}
	
}
