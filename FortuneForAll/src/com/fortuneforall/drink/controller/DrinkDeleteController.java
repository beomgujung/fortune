package com.fortuneforall.drink.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;

@WebServlet("/com.fortuneforall.drink.controller/DrinkDeleteController")
public class DrinkDeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DrinkDAO dao = new DrinkDAO();
		int no = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		dao.deleteDrink(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.drink.controller/DrinkSelectController?page=1&id="+id);
	}
}
