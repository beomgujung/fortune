<%@page import="com.fortuneforall.member.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Member m = (Member)request.getAttribute("member");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
	<link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
<header class="w3-container w3-center w3-padding-32"> 
  <h1><a href='main.jsp'>Fortune For All</a></h1>
  <p>Welcome to the My Page of <span class="w3-tag">Fortune Cafe</span></p>
</header>

<div class="panel panel-info">
	<div class="panel-heading">개인 정보</div>
      <div class="panel-body">
      	<p>ID		: ${member.userID}</p>
      	<p>E-mail	: ${member.userEmail}</p>
      	<p>Gender	: ${member.userGender}</p>
      	<p>Birth	: ${member.userBirth}</p>
      	<p align="right">
      	<button onclick="location.href='data.html'">수정</button>
      	</p>
	  </div>
</div>

<div class="panel panel-info">
	<div class="panel-heading">운세 기록</div>
      <div class="panel-body">
      	<table class="table">
			<thead>
			<tr>
				<th>글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>날짜</th>
				<th>조회수</th>
			</tr>
			</thead>
			<tbody>
			<tr>
				<td>1</td>
				<td><a href="data.html">운세 후기 입니다. ㅎㅎㅎㅎ</a></td>
				<td>범구님</td>
				<td>2017-08-24</td>
				<td>98456</td>
				
			</tr>
			<tr>
				
				<td>1</td>
				<td><a href="data.html">운세 후기 입니다. ㅎㅎㅎㅎ</a></td>
				<td>범구님</td>
				<td>2017-08-24</td>
				<td>98456</td>
				
			</tr>
			<tr>
				
				<td>1</td>
				<td><a href="data.html">운세 후기 입니다. ㅎㅎㅎㅎ</a></td>
				<td>범구님</td>
				<td>2017-08-24</td>
				<td>98456</td>
				
			</tr>
			<tr>
				
				<td>1</td>
				<td><a href="data.html">운세 후기 입니다. ㅎㅎㅎㅎ</a></td>
				<td>범구님</td>
				<td>2017-08-24</td>
				<td>98456</td>
				
			</tr>
			<tr>
				
				<td>1</td>
				<td><a href="data.html">운세 후기 입니다. ㅎㅎㅎㅎ</a></td>
				<td>범구님</td>
				<td>2017-08-24</td>
				<td>98456</td>
				
			</tr>
			</tbody>
			
		</table>
		      
	  </div>
</div>
<div class="text-center">
<ul class="pagination">
	<li><a href="#"><</a></li>
	<li><a href="#">1</a></li>
	<li><a href="#">2</a></li>
	<li><a href="#">3</a></li>
	<li><a href="#">4</a></li>
	<li><a href="#">5</a></li>
	<li><a href="#">></a></li>
</ul>
</div> 
</body>
</html>