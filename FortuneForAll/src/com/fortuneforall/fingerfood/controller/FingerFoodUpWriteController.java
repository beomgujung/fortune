package com.fortuneforall.fingerfood.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.fingerfood.dao.FingerFoodDAO;
import com.fortuneforall.fingerfood.domain.FingerFood;

@WebServlet("/com.fortuneforall.fingerfood.controller/FingerFoodUpWriteController")
public class FingerFoodUpWriteController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FingerFoodDAO dao = new FingerFoodDAO();
		String id = request.getParameter("id");
		int board_no = Integer.parseInt(request.getParameter("num"));
		int result = dao.checkId(id, board_no);
		
		FingerFood f = dao.selectByNo(board_no);
		
		request.setAttribute("fingerfood", f);
		request.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Fingerfood/upWrite.jsp");
		rd.forward(request, response);
		
	}
}
