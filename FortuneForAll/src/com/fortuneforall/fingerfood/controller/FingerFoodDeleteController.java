package com.fortuneforall.fingerfood.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.fingerfood.dao.FingerFoodDAO;

@WebServlet("/com.fortuneforall.fingerfood.controller/FingerFoodDeleteController")
public class FingerFoodDeleteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FingerFoodDAO dao = new FingerFoodDAO();
		int no = Integer.parseInt(request.getParameter("num"));
		String id = request.getParameter("id");
		dao.deleteFingerFood(no);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.fingerfood.controller/fingerfoodselectcontroller?page=1&id="+id);
	}
}
