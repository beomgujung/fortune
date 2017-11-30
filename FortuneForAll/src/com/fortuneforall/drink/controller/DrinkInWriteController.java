package com.fortuneforall.drink.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;

@WebServlet("/com.fortuneforall.drink.controller/DrinkInWriteController")
public class DrinkInWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");

		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/common/write.jsp");
		rd.forward(request, response);
	}
}
