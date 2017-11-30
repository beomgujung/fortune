<%@page import="com.fortuneforall.drink.domain.Drink"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%
    	String id = (String)request.getAttribute("id");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/jsp/common/top.jsp" %>  

<div class="panel panel-default">
  <div class="panel-heading" align="center">술 후기 게시판-게시글 작성</div>
  <div class="panel-body">
  	<div class="container">
  <p>게시글을 작성하는 곳입니다</p>
  <form action="/FortuneForAll/com.fortuneforall.fingerfood.controller/FingerFoodInsertController">
  제목 <br>
  ${id}<br>
  <input type="text" name="title"/>
  <br>
<br>
<input type="file" name="attachFile"><br>
 <br><br>
  <textarea rows="16" cols="200" name="content"></textarea>
  <button name="id" value="${id}">저장</button>
  <button type="button" onclick="location.href='../fingerfood/fingerfood.jsp'">취소</button>
  </form>
  </div>
  </div>
  </div>    
</body>
</html>