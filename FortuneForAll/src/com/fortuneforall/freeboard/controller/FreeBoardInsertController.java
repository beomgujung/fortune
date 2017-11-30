package com.fortuneforall.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.freeboard.dao.FreeBoardDAO;
import com.fortuneforall.freeboard.domain.FreeBoard;
import com.fortuneforall.member.domain.Member;

@WebServlet("/com.fortuneforall.freeboard.controller/FreeBoardInsertController")
public class FreeBoardInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");

		FreeBoard f = new FreeBoard();
		f.setTitle(title);
		f.setWriter(id);
		f.setContent(content);

		FreeBoardDAO dao = new FreeBoardDAO();
		dao.insertFreeBoard(f);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1&id="+id);
	}
}