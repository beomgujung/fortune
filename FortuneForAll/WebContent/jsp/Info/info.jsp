<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.logging.SimpleFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
 <%
 	String birth = (String)request.getAttribute("birth");
 	String zodiac = (String)request.getAttribute("zodiac");
 	String star = (String)request.getAttribute("star");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="../vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
    <link href="../css/business-casual.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <div class="bg-faded p-4 my-4">
        <div class="card card-inverse">
          <img class="card-img img-fluid w-100" src="../img/bg.jpg" alt="">
          <div class="card-img-overlay bg-overlay">
            <h2 class="card-title text-shadow text-white text-uppercase mb-0">생년월일 운세</h2>
            <% SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일"); 
            String date = sdf.format(new Date()); %>
            <h4 class="text-shadow text-white"><%=date %></h4>
            <p class="lead card-text text-shadow text-white w-50 d-none d-lg-block"> ${birth}
          </div>
        </div>
      </div>
 


      <div class="bg-faded p-4 my-4">
        <div class="card card-inverse">
	      	<c:choose>
		       <c:when test="${star2 == '쌍둥이자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/쌍둥이1.jpg" alt="">
		       </c:when>
		       <c:when test="${star2 == '물병자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/물병1.jpg" alt="">
		       </c:when>
		       <c:when test="${star2 == '사수자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/사수1.jpg" alt="">
		       </c:when>
		       <c:when test="${star2 == '물고기자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/물고기1.jpg" alt="">
		       </c:when>
		       <c:when test="${star == '양자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/양1.jpg" alt="">
		       </c:when>
		       <c:when test="${star == '게자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/게자리1.jpg" alt="">
		       </c:when>
		       <c:when test="${star == '사자자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/사자1.jpg" alt="">
		       </c:when>
		       <c:when test="${star == '처녀자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/처녀1.jpg" alt="">
		       </c:when>
		       <c:when test="${star == '천칭자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/천칭1.jpg" alt="">
		       </c:when>
		       <c:when test="${star == '전갈자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/전갈1.jpg" alt="">
		       </c:when>
		       <c:when test="${star == '염소자리'}">
		       		<img class="card-img img-fluid w-100" src="../img/염소1.jpg" alt="">
		       </c:when>
		       <c:otherwise>
		      	 ${"asdfasdfasdf" }
		       </c:otherwise>
	   		</c:choose>
          <div class="card-img-overlay bg-overlay">
            <h2 class="card-title text-shadow text-white text-uppercase mb-0">별자리 별 운세</h2>
            <h4 class="text-shadow text-white"><%=date %></h4>
            <p class="lead card-text text-shadow text-white w-50 d-none d-lg-block">${star}
            </div>
        </div>
      </div>

      <div class="bg-faded p-4 my-4">
        <div class="card card-inverse">
        	<c:choose>
		       <c:when test="${zodiac2 == '양띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/양.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '닭띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/닭.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '개띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/개.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '돼지띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/돼지.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '쥐띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/쥐.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '소띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/소.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '범띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/호랑이.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '토끼띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/토끼.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '용띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/용.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '뱀띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/뱀.PNG" alt="">
		       </c:when>
		       <c:when test="${zodiac2 == '말띠 운세'}">
		       		<img class="card-img img-fluid w-100" src="../img/말.PNG" alt="">
		       </c:when>
	   		</c:choose>
          <div class="card-img-overlay bg-overlay">
            <h2 class="card-title text-shadow text-white text-uppercase mb-0">띠 별 운세</h2>
            <h4 class="text-shadow text-white"><%=date %></h4>
            <p class="lead card-text text-shadow text-white w-50 d-none d-lg-block">${zodiac}
            </div>
        </div>
      </div>


    </div>

    <!-- Bootstrap core JavaScript -->
    <script src="../vendor/jquery/jquery.min.js"></script>
    <script src="../vendor/popper/popper.min.js"></script>
    <script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

  </body>

</html>
