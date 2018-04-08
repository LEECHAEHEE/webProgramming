<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function formCheck(){
		var title = document.forms[0].title.value;
		var content = document.forms[0].content.value;
		
		if(title==null||title==""){
			alert("제목을 입력하세요");
			document.forms[0].totle.focus();
			return false;
		}
		
		if(content==null||content==""){
			alter("내용을 입력하세요");
			document.forms[0].contetnt.focus();
			return false;
		}
	}
<%
	String idx = request.getParameter("idx");
%>
</script>
</head>
<body>
<form action="updateInsert.jsp" method="post" onsubmit="formcheck();">
	제　목 <input type="text" name="title"/><br/>
	내  용 <textarea rows="10" cols="20" name="content"></textarea>
	<input type = "hidden" name="idx" value="<%=idx %>">
	<input type="submit">
</form>
</body>
</html>