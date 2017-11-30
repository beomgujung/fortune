<%@page import="com.fortuneforall.freeboard.domain.FreeBoard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	List<FreeBoard> f = (List<FreeBoard>)request.getAttribute("board");
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
	
	<style>

	</style>
</head>
<body>
<%@ include file="/jsp/common/top.jsp" %>  

  <div class="panel panel-default">
  <div class="panel-heading" align="center">술 후기 게시판</div>
  <div class="panel-body">
  	<div class="container">
  <p>술에 대한 후기를 작성하는 게시판입니다
  </p>            
  <table class="table table-hover">
    <thead>
      <tr>
        <th>글 번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
      </tr>
    </thead>
    <tbody>
    	<c:forEach var="freeboard" items="${board}">
    		<tr>
    		<td><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectByNoController?no=${freeboard.board_no}&id=${id}">${freeboard.board_no}</a></td>
    		<td><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectByNoController?no=${freeboard.board_no}&id=${id}">${freeboard.title}</a></td>
    		<td><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectByNoController?no=${freeboard.board_no}&id=${id}">${freeboard.writer}</a></td>
    		<td><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectByNoController?no=${freeboard.board_no}&id=${id}">${freeboard.regDate}</a></td>
    		</tr>
		</c:forEach>    		
    </tbody>
  </table>
  
  <div class="text-center">
		<ul class="pagination">
			<li><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController"><</a></li>
			<li><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1">1</a></li>
			<li><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=2">2</a></li>
			<li><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=3">3</a></li>
			<li><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=4">4</a></li>
			<li><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=5">5</a></li>
			<li><a href="#">></a></li>
		</ul>
	</div>
	<c:choose>
	<c:when test="${not empty id}">
   <form action= "/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardInWriteController">
   <p align="right">
   <button name="id" value="${id}">글쓰기</button>
   </p>
   </form>
	</c:when>	
	</c:choose>
	
   <p align="center">
     <form>
  <select>
	 		<option value = "a">제목+작성자</option>
	 		<option value = "b">제목</option>
	 		<option value = "c">작성자</option>
  </select>
  <input type="text" placeholder="검색할 항목을 입력해">
  <button type="submit">검색</button>
  </p>
  
  </form>
</div>
  </div>
</div>
</body>
</html>