<%@page import="com.fortuneforall.fingerfoodcomment.dao.FingerFoodCommentDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.fortuneforall.fingerfoodcomment.domain.FingerFoodComment"%>
<%@page import="com.fortuneforall.fingerfood.domain.FingerFood"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	FingerFood p = (FingerFood) request.getAttribute("board");
	String id = (String) request.getAttribute("id");
	int cNo = (int) request.getAttribute("cNo");
	int board_no = (int) request.getAttribute("board_no");
	String cContent = (String) request.getAttribute("cContent");
	List<FingerFoodComment> c = (List<FingerFoodComment>) request.getAttribute("comment");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

</head>
<body>
	<%@ include file="/jsp/common/top.jsp"%>

	<div class="panel panel-default">
		<div class="panel-heading" align="center">술 안주 후기 게시판-게시글</div>
		<div class="panel-body">
			<div class="container">
				제목<br> ${board.title} <br> <br>
				<div class="w3-container">
					내용
					<p>${board.content} ${board.board_no} id = ${id}</p>
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
					<%int i=0; %>
						<c:forEach var="comment" items="${comment}">
							<tr>
							<%
								if(cNo==c.get(i).getComment_no()) {%>
									<form action="/FortuneForAll/com.fortuneforall.fingerfoodcomment.controller/FingerFoodCommentUpdateController">
									<td> <input type="text" name="cContent" value = "${comment.content}"/></td>
									<td>${comment.id}</td>
									<td>${comment.reg_date}</td>
								<td>
										<button name="cNo" value="${cNo}-${id}">수정</button>
									</form>
								</td>
									<%
								}
								else {
									%>
								<td>${comment.content}</td>
								<td>${comment.id}</td>
								<td>${comment.reg_date}</td>
									<%
								}
							i++;
							%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br>
				<br>
				<p align="left">
					<button type="button" onclick="location.href='/FortuneForAll/com.fortuneforall.fingerfood.controller/FingerFoodSelectController?page=1'">목록으로</button>
				</p>
			</div>
		</div>
	</div>
</body>
</html>