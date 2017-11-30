package com.fortuneforall.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.member.dao.MemberDAO;
import com.fortuneforall.member.domain.Login;
import com.fortuneforall.member.domain.Member;


@WebServlet("/com.fortuneforall.member.controller/membercheckidcontroller")
public class MemberCheckIdController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userID");

		MemberDAO memberdao = new MemberDAO();
		boolean result = memberdao.memberIDCheck(id);
		
		request.setAttribute("result", result);
		request.setAttribute("id", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Member/join.jsp");
		rd.forward(request, response);
	}
}