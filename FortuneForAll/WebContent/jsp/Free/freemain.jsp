<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <link rel="stylesheet" type="text/css" href="fotune.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
   <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">

   
   <!-- 부가적인 테마 -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
   
   <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


</head>
<body>
<div class="dropdown">
    <button class="btn btn-default dropdown-toggle" type="button" id="menu1" data-toggle="dropdown">목록
    <span class="caret"></span></button>
    <ul class="dropdown-menu" role="menu" aria-labelledby="menu1">
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">메인 게시판</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">술 정보</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">술 시음 후기</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">술 안주 정보</a></li>
      <li role="presentation"><a role="menuitem" tabindex="-1" href="#">운세 후기</a></li>
      <li role="presentation" class="divider"></li>
    </ul>
  </div>


<header class="w3-container w3-center w3-padding-32">
  <h1 style="bold"><a href="fortuneMain.html" >Fortune For All</a></h1>
   <p>Welcome to the FreeBoard of <span class="w3-tag">Fortune Cafe</span></p>
</header>
<table class="table">
	<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>글쓴이</th>
		<th>날짜</th>
	</tr>
	<tr>
		<th><a href="#">1</a></th>
		<th><a href="#">2</a></th>
		<th><a href="#">3</a></th>
		<th><a href="#">4</a></th>
	</tr>

</thead>
</table>

		<p align="right">
		<button type="button" onclick="location.href='../common/write.jsp'">글쓰기</button>
		</p>

<p align="center">		
<select name="info">
	<option value="1">글쓴이</option>
	<option value="2">제목</option>
	<option value="3">내용</option>
</select>
<input type="text" name="search" />
<button type="button" >확인</button>
</p>
</body>
</html>