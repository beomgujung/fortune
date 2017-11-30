<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/FortuneForAll/jsp/common/main.jsp">ForfuneForAll</a>
    </div>
    <ul class="nav navbar-nav">

      <li class="active"><a href="/FortuneForAll/jsp/common/main.jsp">Home</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.freeboard.controller/FreeBoardSelectController?page=1&id=${login.id}">자유 게시판</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.drink.controller/DrinkSelectController?page=1&id=${login.id}">술 후기 게시판 ${login.id}</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.fingerfood.controller/fingerfoodselectcontroller?page=1&id=${login.id}">술 안주 게시판</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.pub.controller/PubSelectController?page=1&id=${login.id}">술집 후기 게시판</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.fortunereview.controller/FortuneReviewSelectController?page=1&id=${login.id}">운세 후기 게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:choose>
	<c:when test="${empty login}">
      <li><a href="/FortuneForAll/jsp/Member/join.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="/FortuneForAll/jsp/Member/member_login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	</c:when>	
	<c:otherwise>
      <li><a href="/FortuneForAll/com.fortuneforall.mypage.controller/mypagecontroller"><span class="glyphicon glyphicon-user"></span> My Page</a></li>
      <li><a href="/FortuneForAll/com.fortuneforall.member.controller/memberlogoutcontroller">로그아웃</a></li>
	</c:otherwise>	
	</c:choose>
    </ul>
  </div>
</nav>