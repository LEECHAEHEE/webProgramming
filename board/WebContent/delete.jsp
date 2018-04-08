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
		String sql = "delete from board where idx=" + idx;
		rs = stmt.executeQuery(sql);

		conn.close();
		}catch(Exception e){
			out.println("Connection Failed");
			out.println(e.getMessage());
			e.printStackTrace();
		}
%>		
<script>
	alert("게시글이 삭제 되었습니다");
	location.href="redirect.jsp";
</script>
<body>
</body>
</html>