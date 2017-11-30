<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
     비밀번호 찾기
   <form action="/FortuneForAll/com.fortuneforall.fingerfood.controller/FingerFoodController.java">
   이메일 주소를 입력하세요
   <br>
   <input type="text" name="email" />
   
   <br>
   <select name=findq>
   <option value="findq1">너의 가장 소중한 보물은 무엇이냐</option>
   <option value="findq2">너의 직업은 무엇이냐</option>
   </select>
   <br>
   <input type="text" name="id" />
<button>찾기</button>
   </form>
</body>
</html>
