package com.fortuneforall.member.controller;

import java.io.IOException;
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


@WebServlet("/com.fortuneforall.member.controller/MemberLoginController")
public class MemberLoginController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPassword");
		System.out.println("member login id : "+id);
		System.out.println("member login pw : "+pw);
		
		Cookie c = new Cookie(id, pw);
		c.setMaxAge(60*60*60);
		response.addCookie(c);

		Login login = new Login();
		login.setId(id);
		login.setPw(pw);
		
		// 로그인 성공 : 메인페이지로 이동
		MemberDAO memberdao = new MemberDAO();
		
		int l = memberdao.login(id, pw);
		System.out.println("l:" +l);
		
		if(l == 1) {
			System.out.println("success");
			System.out.println(login.getId());
			HttpSession session = request.getSession();			
			session.setAttribute("login", login);
			response.sendRedirect("/FortuneForAll/com.fortuneforall.common.controller/commonlogincontroller?id="+id);
		}
		// 로그인 실패 : loginForm.jsp로 이동
		else {
			String page = "Member/member_login.jsp";
			request.setAttribute("error", "입력하신 정보가 올바르지 않습니다.");
			System.out.println("fail");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/"+page);
			rd.forward(request, response);
		}
	}
}
