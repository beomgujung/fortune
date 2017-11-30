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

@WebServlet("/com.fortuneforall.drink.controller/DrinkUpWriteController")
public class DrinkUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DrinkDAO dao = new DrinkDAO();
		String id = request.getParameter("id");
		int board_no = Integer.parseInt(request.getParameter("num"));
		int result = dao.checkId(id, board_no);
		
		Drink d = dao.selectByNo(board_no);
		
		request.setAttribute("drink", d);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/common/upWrite.jsp");
		rd.forward(request, response);
		
	}
}
