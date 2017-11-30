<%@page import="java.util.List"%>
<%@page import="com.fortuneforall.comment.domain.Comment"%>
<%@page import="com.fortuneforall.drink.domain.Drink"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    	Drink d = (Drink)request.getAttribute("board");
    	List<Comment> c = (List<Comment>)request.getAttribute("comment");
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
  <div class="panel-heading" align="center">술 후기 게시판-게시글</div>
  <div class="panel-body">
  	<div class="container">
  제목<br>
${board.title}
  <br>
<br>
<div class="w3-container"> 
내용
  <p> ${board.content} 
  	${board.board_no}
  </p>
</div>
  <br>
  	 <table class="table table-striped">
  	 <thead>
      <tr>
        <th>내용</th>
        <th>작성자</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="comment" items="${comment}">
          <tr>
           <td>${comment.content }</td>
            <td>${comment.id }</td>
            <td>${comment.reg_date }</td>
            <td>
            <form action="/FortuneForAll/com.fortuneforall.comment.controller/CommentUpdateController">
  				<button name="comment_upNo" value="${comment.comment_no}">수정</button>
 	 		</form>
 	 		</td>
 	 		<td>
 	 		<form action="/FortuneForAll/com.fortuneforall.comment.controller/commentdeletecontroller">
  				<button name="comment_no" value="${comment.comment_no}">삭제</button>
 	 		</form>	
 	 		</td>
          </tr>
   </c:forEach>

    </tbody>
  </table>
  <form action="/FortuneForAll/com.fortuneforall.comment.controller/CommentInsertController">
  <textarea name="content" rows="1" cols="130"></textarea>
  <button name="board_no" value="${board.board_no}-${id}">확인</button>
  </form>
  
  <br><br>
  <p align="left">
  <button type="button"  onclick="location.href='../Drink/drink.jsp'">목록으로</button>
  </p>
  <p align="right">
  <form method="POST" action="/FortuneForAll/com.fortuneforall.drink.controller/DrinkUpWriteController?num=${board.board_no}&content=${board.content}&title=${board.title}">
  <button>수정</button>
  </form>
  <form method="POST" action="/FortuneForAll/com.fortuneforall.drink.controller/DrinkDeleteController?num=${board.board_no}">
  <button>삭제</button>
  </form>
  </p></div>
  </div>
  </div>  
</body>
</html>