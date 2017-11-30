package com.fortuneforall.member.controller;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fortuneforall.member.dao.MemberDAO;
import com.fortuneforall.member.domain.Member;

@WebServlet("/com.fortuneforall.member.controller/MemberJoinController")
public class MemberJoinController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("userID");
		String pw = request.getParameter("userPassword");
		String email = request.getParameter("userEmail");
		String name = request.getParameter("userName");
		String birth = request.getParameter("userBirth");
		int calender = Integer.parseInt(request.getParameter("userCalender"));
		String birth_time = request.getParameter("userBirth_time");
		int gender = Integer.parseInt(request.getParameter("userGender"));
		String question = request.getParameter("userQuestion");
		String answer = request.getParameter("userAnswer");
		
		Member m = new Member();
		m.setUserID(id);
		m.setUserPassword(pw);
		m.setUserEmail(email);
		m.setUserName(name);
		m.setUserBirth(birth);
		m.setUserCalender(calender);
		m.setUserBirth_time(birth_time);
		m.setUserGender(gender);
		m.setUserQuestion(question);
		m.setUserAnswer(answer);

		MemberDAO dao = new MemberDAO();
		dao.insertMember(m);
		
		request.setAttribute("member", m);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/Member/member_login.jsp");
		rd.forward(request, response);	
		
	}
}
