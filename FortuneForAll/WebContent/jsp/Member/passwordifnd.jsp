<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

   <form action="/FortuneForAll/com.fortuneforall.member.comtroller/MembePassworddFindController">
   
   아이디를를 입력하세요 : <input type="text" name="id" /><br>
    고르십시오 <br>
    <select name="question">
    <option value="q1">너의 가장 소중한 보물은 무엇이냐</option>
   <option value="q2">너의 직업은 무엇이냐</option>
   </select><br>
    
    
    질문에 답을 넣어주세요
<input type="text" name="answer" />
   
   <button>찾기</button>
   </form>
</body>
</html>