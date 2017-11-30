package com.fortuneforall.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/com.fortuneforall.member.controller/memberlogoutcontroller")
public class MemberLogoutController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 로그아웃 처리 : 세션을 삭제
		HttpSession session = request.getSession();
		session.invalidate();
		
		response.sendRedirect("../jsp/common/main.jsp");
	}

}
