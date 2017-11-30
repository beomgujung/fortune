package com.fortuneforall.pub.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.member.domain.Member;
import com.fortuneforall.pub.dao.PubDAO;
import com.fortuneforall.pub.domain.Pub;
import com.fortuneforall.util.MlecFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;


@WebServlet("/com.fortuneforall.pub.controller/PubInsertController")
public class PubInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String id = request.getParameter("id");
		String content = request.getParameter("content");
		
		HttpSession session = request.getSession();			
		Member m = (Member)session.getAttribute("member");
		
		Pub p = new Pub();
		p.setTitle(title);
		p.setWriter(id);
		p.setContent(content);
		
//		String upload = "C:\\java97\\server-work\\wtpwebapps\\05_servletjsp\\upload";
//		String path = new SimpleDateFormat("/yyyy/MM/dd/HH").format(new Date());
//		File f = new File(upload+path);
//		if(f.exists() == false) f.mkdirs();
//		MultipartRequest mRequest = new MultipartRequest(request, upload+path,1024*1024*30,"utf-8",new MlecFileRenamePolicy());
		
		PubDAO dao = new PubDAO();
		dao.insertPub(p);

		RequestDispatcher rd = request.getRequestDispatcher("/com.fortuneforall.pub.controller/PubSelectController?page=1&id="+id);
	}
}