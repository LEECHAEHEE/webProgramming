<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
<%
request.setCharacterEncoding("UTF-8");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String idx = request.getParameter("idx");
	int count = 100;
	
	if(title==null||title=="")
		out.println("input title");

	if(content==null||content=="")
		out.println("input content");
	
	try{
		String driverName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String id = "board", pw = "board";
		
		Class.forName(driverName);
		Connection conn = DriverManager.getConnection(url,id,pw);
		out.println("Conection successful");
		
		/*
				update board set title = "" where idx = "" ;
		*/
		Statement stmt = conn.createStatement();
		String sql = "update board set title = '" + title + "' where idx = " + idx ;
		out.println(sql);
		stmt.executeQuery(sql);
		
		sql ="update board set content = '" + content + "' where idx = " + idx ;
		out.println(sql);
		stmt.executeQuery(sql);
		
		conn.close();
	}catch(Exception e){
		out.println("Connection failed");
		out.println(e.getMessage());
		e.printStackTrace();	
	}
	
%>
</head>
<body>
<script>
		alert('수정되었습니다'); 
		location.href='redirect.jsp';
</script>
</body>
</html>