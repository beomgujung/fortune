package com.fortuneforall.drink.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fortuneforall.boardfile.domain.BoardFile;
import com.fortuneforall.drink.dao.DrinkDAO;
import com.fortuneforall.drink.domain.Drink;
import com.fortuneforall.member.domain.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/com.fortuneforall.drink.controller/drinkinsertcontroller")
public class DrinkInsertController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String saveDirectory = "c:/java97";
		
		MultipartRequest mRequest = new MultipartRequest(
				request	,
				saveDirectory,
				1024 * 1024 * 100,
				"utf-8",
				new DefaultFileRenamePolicy()
				);
		
		String title = mRequest.getParameter("title");
		String content = mRequest.getParameter("content");
		String id = mRequest.getParameter("id");

		HttpSession session = request.getSession();			
		Member m = (Member)session.getAttribute("member");
		
		System.out.println(title);
		Drink d = new Drink();
		d.setTitle(title);
		d.setWriter(id);
		d.setContent(content);
		
		
		DrinkDAO dao = new DrinkDAO();
		
		int no = dao.selectBoardNo();
		d.setBoard_no(no);
		dao.insertDrink(d);
		
		File f  = mRequest.getFile("attachFile");
		if(f != null) {
			String orgName = mRequest.getOriginalFileName("attachFile");
			String systemName = mRequest.getFilesystemName("attachFile");
			
			BoardFile file = new BoardFile();
			file.setBoard_no(no);
			file.setFile_org_name(orgName);
			file.setFile_system_name(systemName);
			file.setFile_path(saveDirectory);
			file.setFile_size((int)f.length());
			dao.insertFile(file);
		}
		
		response.sendRedirect("/FortuneForAll/com.fortuneforall.drink.controller/DrinkSelectController?page=1&id="+id);
	}
}