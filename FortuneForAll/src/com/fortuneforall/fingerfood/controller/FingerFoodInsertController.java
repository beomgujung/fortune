package com.fortuneforall.fingerfood.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.fingerfood.dao.FingerFoodDAO;
import com.fortuneforall.fingerfood.domain.FingerFood;
import com.fortuneforall.member.domain.Member;

@WebServlet("/com.fortuneforall.fingerfood.controller/FingerFoodInsertController")
public class FingerFoodInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");

		HttpSession session = request.getSession();			
		Member m = (Member)session.getAttribute("member");
		
		System.out.println(title);
		FingerFood f = new FingerFood();
		f.setTitle(title);
		f.setWriter(id);
		f.setContent(content);
				
		FingerFoodDAO dao = new FingerFoodDAO();
		dao.insertFingerFood(f);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.fingerfood.controller/fingerfoodselectcontroller?page=1&id="+id);
	}
}