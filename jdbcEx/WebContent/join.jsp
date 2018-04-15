<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="JoinOk" method="post">
		이름<input type="text" name="name" size="15"><br/>
		아이디 <input type="text" name="id" size="15"><br/>
		비밀번호<input type="password" name="pw" size="15"><br/>
		전화번호 <select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
		</select>-
		<input type="text" name="phone2" size="4">-
		<input type="text" name="phone3" size="4"><br/>
		성별 
		남<input type= "radio" name="gender" value="man">
		여<input type= "radio" name="gender" value="woman"><br/>
		<input type= "submit" value="회원가입"> &nbsp; <input type= "reset" value="취소">
	</form>
</body>
</html>