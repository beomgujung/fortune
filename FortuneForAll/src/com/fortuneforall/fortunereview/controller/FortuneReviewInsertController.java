package com.fortuneforall.fortunereview.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.fortunereview.dao.FortuneReviewDAO;
import com.fortuneforall.fortunereview.domain.FortuneReview;
import com.fortuneforall.member.domain.Member;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/com.fortuneforall.fortunereview.controller/FortuneReviewInsertController")
public class FortuneReviewInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = request.getParameter("id");

		HttpSession session = request.getSession();			
		Member m = (Member)session.getAttribute("member");
		
		FortuneReview fr = new FortuneReview();
		fr.setTitle(title);
		fr.setWriter(id);
		fr.setContent(content);
		
//		String upload = "C:\\java97\\server-work\\wtpwebapps\\05_servletjsp\\upload";
//		String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
//		File f = new File(upload+path);
//		if(f.exists() == false) f.mkdirs();
//		MultipartRequest mRequest = new MultipartRequest(request, upload+path,1024*1024*30,"utf-8",new MlecFileRenamePolicy());
		
		FortuneReviewDAO dao = new FortuneReviewDAO();
		dao.insertFortuneReview(fr);
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController?page=1&id="+id);
	}
}