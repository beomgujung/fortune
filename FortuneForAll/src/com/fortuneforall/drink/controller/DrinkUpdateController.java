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

@WebServlet("/com.fortuneforall.drink.controller/DrinkUpdateController")
public class DrinkUpdateController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String[] arr = request.getParameter("n").split("-");
		int board_no = Integer.parseInt(arr[0]);
		String id = arr[1];
		System.out.println("fingerfood update id : "+id);
		
		Drink d = new Drink();
		d.setBoard_no(board_no);
		d.setTitle(title);
		d.setContent(content);
		
		System.out.println("update");
		DrinkDAO dao = new DrinkDAO();
		dao.updateDrink(d);

		request.setAttribute("drink", d);
		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.drink.controller/DrinkSelectController?page=1&id="+id);
		rd.forward(request, response);
	}
}
