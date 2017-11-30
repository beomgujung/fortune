<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewpoint" content="width=device-width", initial-sacle="1">
<link rel="stylesheet" href="../../css/bootstrap.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	
	<!-- 부가적인 테마 -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	
	<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<title>운세 프로젝트</title>
</head>
<body>
<%@ include file="/jsp/common/top.jsp" %>  
   <div class="container">
      <div class="col-lg-4"></div>
      <div class="col-lg-4">
         <div class="jumbotron" style="padding-top: 20px;">
            <form method="post" action="/FortuneForAll/com.fortuneforall.member.controller/MemberLoginController">
               <h3 style="text-align: center;">로그인 화면</h3>	
               <div class="form-group">
                 <input type="text" class="form-control" placeholder="아이디"  name="userID" maxlength="20">
               </div>
               <div class="form-group">
                 <input type="password" class="form-control" placeholder="비밀번호"  name="userPassword" maxlength="20">
               </div>
               <input type="submit" class="btn btn-primary form-control" value="로그인">
               <a href="../Member/idFind.jsp">아이디 찾기</a>
               <a href="../Member/passwordfind.jsp">비밀번호 찾기</a>
            </form>
         </div>
      </div>
   </div>
   <script src="http://code.jquery.com/jquery-3.1.1.min.js"></script>
   <script src="../../js/bootstrap.js"></script>
</body>
</html>