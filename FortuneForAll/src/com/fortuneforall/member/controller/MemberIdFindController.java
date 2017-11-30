package com.fortuneforall.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.member.dao.MemberDAO;

@WebServlet("/com.fortuneforall.member.comtroller/memberidfindcontroller")
public class MemberIdFindController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String getemail=request.getParameter("email");
	MemberDAO memdao = new MemberDAO();
	String findid=memdao.idFind(getemail);
	System.out.println("아이디"+findid);
	if(findid==null) {
		request.setAttribute("error","이메일을 잘못입력했습니다");
	}
	else {
		request.setAttribute("findid", findid);
	}
	RequestDispatcher rd = 
			request.getRequestDispatcher(
					"/jsp/Member/idfindview.jsp");
	rd.forward(request, response);
	}
	

}
