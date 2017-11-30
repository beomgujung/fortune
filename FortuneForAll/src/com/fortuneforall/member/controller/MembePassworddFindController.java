package com.fortuneforall.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.member.dao.MemberDAO;

@WebServlet("/com.fortuneforall.member.controller/memberpasswordfindcontroller")
public class MembePassworddFindController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String id=request.getParameter("id");
	String question=request.getParameter("question");
	String answer=request.getParameter("answer");
	MemberDAO memdao = new MemberDAO();
	String password=memdao.passwordfind(id, question, answer);
	System.out.println("패스워드"+password);
	
	if(password==null) {
		request.setAttribute("error","정보를을 잘못입력했습니다");
	}
	else {
		request.setAttribute("findid", password);

	}
	RequestDispatcher rd = 
			request.getRequestDispatcher(
					"/jsp/Member/passwordfindview.jsp");
	rd.forward(request, response);
	}
	

}
