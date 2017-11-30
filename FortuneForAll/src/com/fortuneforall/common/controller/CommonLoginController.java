package com.fortuneforall.common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.common.dao.CommonDAO;
import com.fortuneforall.member.dao.MemberDAO;
import com.fortuneforall.member.domain.Login;
import com.fortuneforall.member.domain.Member;

@WebServlet("/com.fortuneforall.common.controller/commonlogincontroller")
public class CommonLoginController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("common login controller id : "+id);
		
		CommonDAO dao  = new CommonDAO();
		
		request.setAttribute("member", dao.checkDate(id));
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/common/main.jsp");
		rd.forward(request, response);
	}
}
