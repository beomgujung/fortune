package com.fortuneforall.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.member.domain.Member;
import com.fortuneforall.mypage.dao.myPageDAO;

@WebServlet("/com.fortuneforall.mypage.controller/mypagecontroller")
public class MyPageController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();			
		Member m = (Member)session.getAttribute("member");
		myPageDAO dao = new myPageDAO();
		Member member = dao.selectMyInfo(m.getUserID());
		
		request.setAttribute("member", member);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/mypage/mypage.jsp");
		rd.forward(request, response);
	}
}
