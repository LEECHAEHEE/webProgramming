<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function formCheck(){
		var title = document.forms[0].title.value;
		var writer = document.forms[0].writer.value;
		var regdate = document.forms[0].regdate.value;
		var content = document.forms[0].content.value;

		if(title==null||title==""){
			alert("제목을 입력하세요");
			document.forms[0].totle.focus();
			return false;
		}
		if(witer==null||writer==""){
			alert("작성자를 입력하세요");
			document.forms[0].writer.focus();			
			return false;
		}
		
		if(content==null||content==""){
			alter("내용을 입력하세요");
			document.forms[0].contetnt.focus();
			return false;
		}
		
		if(regdata==null||regdata==""){
			alert("날짜를 입력하세요");
			 document.forms[0].regdata.focus()
			 return false;
		}
			
	}
</script>
</head>
<body>
<form action="insert.jsp" method="post" onsubmit="formcheck();">
	제　목 <input type="text" name="title"/><br/>
	작성자 <input type="text" name="writer"><br/>
	날　짜 <input type="text" name="regdate"><br/>
	내  용 <textarea rows="10" cols="20" name="content"></textarea>
	<input type="submit">
</form>
</body>
</html>