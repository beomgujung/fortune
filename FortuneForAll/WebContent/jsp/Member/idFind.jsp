<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewpoint" content="width=device-width", initial-sacle="1">
<link rel="stylesheet" href="../../css/bootstrap.css">
<title>운세 프로젝트</title>
</head>
<body>
<%@ include file="/jsp/common/top.jsp" %>  
아아디 찾기
   <form action="/FortuneForAll/com.fortuneforall.member.comtroller/memberidfindcontroller">
   이메일 주소를 입력하세요
   <input type="text" name="email" />
   <button>찾기</button>
   </form>
</body>
</html>