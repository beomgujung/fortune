<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewpoint" content="width=device-width" , initial-sacle="1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
<title>운세 프로젝트</title>
</head>
<body>
	<%@ include file="/jsp/common/top.jsp"%>
	<div class="container">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
						<h3 style="text-align: center;">회원가입 화면</h3>
				<div class="jumbotron" style="padding-top: 20px;">
			<c:choose>
					<c:when test="${result == true} or ${empty result}">
						<link rel="stylesheet" href="../../css/bootstrap.css">
						<form
							action="/FortuneForAll/com.f
							ortuneforall.member.controller/membercheckidcontroller">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="아이디"
									name="userID" maxlength="20">
									사용 불가능 합니다.<br>
								<button name="overlap" value="${member.userId}" onclick="pop();">중복
									확인</button>
							</div>
						</form>
					</c:when>

					<c:when test="${result == false }">
						<input type="text" class="form-control" value="${id}"
							name="userID" disabled maxlength="20">
							사용가능 합니다.<br>
						<button name="overlap" value="${id}" onclick="pop(); disabled">중복
							확인</button>
					</c:when>

					<c:otherwise>
						<form
							action="/FortuneForAll/com.fortuneforall.member.controller/membercheckidcontroller">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="아이디"
									name="userID" maxlength="20">
								<button name="overlap" value="${member.userId}" onclick="pop();">중복 확인</button>
							</div>
						</form>
					</c:otherwise>

			</c:choose>
				</div>
			<form action="/FortuneForAll/com.fortuneforall.member.controller/MemberJoinController">
			<div class="form-group">
				<input type="password" class="form-control" placeholder="비밀번호"
					name="userPassword" maxlength="20">
			</div>

			<div class="form-group">
				<input type="text" class="form-control" placeholder="이름"
					name="userName" maxlength="20">
			</div>

			<div class="form-group">
				<input type="email" class="form-control" placeholder="이메일"
					name="userEmail" maxlength="20">
			</div>

			<div class="form-group">
				질문 : <select name="userQuestion">
					<option value="q1">고향은 어디닝</option>
					<option value="q2">좌우명이 뭐닝</option>
				</select>
			</div>

			<div class="form-group">
				<input type="text" name="userAnswer" class="form-control"
					placeholder="응답" name="userAnswer" maxlength="20">
			</div>
			<div class="form-group" style="text-align: center;">
				<div class="btn-group" data-toggle="buttons">
					<label class="btn btn-primary"> <input type="radio"
						onclick="active" name="userGender" autocomplete="off" value="0"
						checked>남자
					</label> <label class="btn btn-primary"> <input type="radio"
						name="userGender" autocomplete="off" value="1" checked>여자
					</label>
				</div>
			</div>

			<div class="form-group">
				<select name="userCalender">
					<option value="1">양력</option>
					<option value="2">음력 양달</option>
					<option value="3">음력 평달</option>
				</select>
			</div>
			<div class="form-group">
				시간 : <select name="userBirth_time">
					<option value="자">자</option>
					<option value="축">축</option>
					<option value="평달">음력 평달</option>
				</select>
			</div>

			<input type="date" name="userBirth" value="2017-12-13"
				min="1980-01-01" max="2017-12-31"> <br>
			<br> <button name="userID" class="btn btn-primary form-control"
				value="${id}">회원가입</button>
		</form>
		</div>
		 <script type="text/javascript">
		 </script>

	</div>
</body>
</html>