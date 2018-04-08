<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	table, td, th {border:1px solid red;}
	th {background-color:green; color:black;}
</style>
<title>Board</title>
</head>
<%
	String idx = request.getParameter("idx");
	out.println("idx : [" + idx + "]");
	try{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		
		ResultSet rs = null;
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,"board","board");
		out.println("Connection Successful");
		
		Statement stmt = conn.createStatement();
		String sql = "select * from board where idx=" + idx;
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			request.setAttribute("idx", rs.getString("idx"));
			request.setAttribute("writer", rs.getString("writer"));
			request.setAttribute("regdate", rs.getString("regdate"));
			request.setAttribute("count", rs.getString("count"));
			request.setAttribute("title", rs.getString("title"));
			request.setAttribute("content", rs.getString("content"));
		}
		conn.close();
		}catch(Exception e){
			out.println("Connection Failed");
			out.println(e.getMessage());
			e.printStackTrace();
		}
%>

<body>
<h1>게시글 조회</h1>
	<table border ="1">
		<tr>					<!-- table row -->
			<th>번호</th>		<!-- table header -->
			<td>${idx}</td>
			<th>작성자</th>
			<td>${writer}</td>
			<th>날짜</th>
			<td>${regdate}</td>
			<th>조회수</th>
			<td>${count}</td>
		</tr>
		<tr>
			<th colspan="2">제목</th>
			<td colspan="6">${title}</td>
		</tr>		
		<tr>
			<th colspan="2">내용</th>
			<td colspan="6">${content}</td>
		</tr>
	</table>
	<a href="delete.jsp?idx=${idx}">게시글 삭제</a>
	<a href="list.do">목록으로</a>
	<a href="update.jsp?idx=${idx}">수정</a>
</body>
</html>