package com.fortuneforall.common.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fortuneforall.info.dao.InfoDAO;

@WebServlet("/com.fortuneforall.common.controller/commonbirthfortunecontroller")
public class CommonBirthFortuneController extends HttpServlet {

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String date[] = request.getParameter("date").split("-");
	   String birth=date[0]+date[1]+date[2];
	   String[] arr = request.getParameter("info").split("-");
	   
	   InfoDAO iDao = new InfoDAO();
	   String zodiac= iDao.zodiac(birth);
	   String zodiac2= iDao.zodiac(birth);
	   String star = iDao.star(birth);
	   String star2 = iDao.star(birth);
	   System.out.println(zodiac2);
	   
	   if(arr[0].equals("0")) {
		   arr[0]="m";
	   }
	   else if(arr[1].equals("1")) {
		   arr[0]="f";
	   }
	   if(arr[1].equals("0")) {
		   arr[1] = "solar";
	   }
	   if(arr[1].equals("1")) {
		   arr[1]="lunarGeneral";
	   }
	   if(arr[1].equals("2")) {
		   arr[1] = "lunarLeap";
	   }
      try {
         
         Document doc = Jsoup.connect("https://search.naver.com/p/csearch/dcontent/external_api/json_todayunse_v2.naver?_callback=window.__jindo2_callback._fortune_my_0&gender="+arr[0]+"&birth="+birth+"&solarCal="+arr[1]+"&time=10").get();
         Elements elements = doc.select(
               "body"
         );
         String rp6 = null;
         
         for(Element e : elements) {
            String b = e.select("body").html();
            String[] keyword = b.split("keyword");
            
            String[] content = keyword[1].split("index");
            String rp1 = content[0].replaceAll("\"", "");
            String rp2 = rp1.replace(":", "");
            String rp3 = rp2.replace("<b>","");
            String rp4 = rp3.replace("</b>","");
            String rp5 = rp4.replace(",","");
            rp6 = rp5.replace("desc", "");
         }
         
         Document doc1 =Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&ie=utf8&sm=tab_etc&query="+zodiac).userAgent("Mozilla").get();
		 Elements elements1 = doc1.select("div.cs_sign._cs_fortune p.text._cs_fortune_text");//[] : 해당 태그의 속성----><a href="#">
		 String[] arr1 = new String[4];
		 int i=0;
		 for(Element e : elements1) {
		 	 System.out.println(e.html());
			 arr1[i++] =e.html();
		 }
		 
		 Document doc2 = Jsoup.connect("https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query="+star).userAgent("Mozilla").get();
         Elements elements2 = doc2.select(".cs_sign .infors .detail .text");
         String[] arr2 = new String[4];
		 int j=0;
         for(Element e : elements2) {
            arr2[j++] =e.select("p.text._cs_fortune_text").html();
         }
         
         request.setAttribute("star2", star2);
         request.setAttribute("zodiac2", zodiac2);
         
         request.setAttribute("star", arr2[0]);
		 request.setAttribute("zodiac", arr1[0]);
         request.setAttribute("birth", rp6);
         RequestDispatcher rd = request.getRequestDispatcher("/jsp/Info/info.jsp");
         rd.forward(request, response);
         
         
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}