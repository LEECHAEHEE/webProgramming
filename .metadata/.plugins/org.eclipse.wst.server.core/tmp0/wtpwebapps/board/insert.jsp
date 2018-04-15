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
	String writer = request.getParameter("writer");
	String regdate = request.getParameter("regdate");
	String content = request.getParameter("content");
	int count = 100;
	
	if(title==null||title=="")
		out.println("input title");
	
	if(writer==null||writer=="")
		out.println("input writer");
	
	if(regdate==null||regdate=="")
		out.println("input regdate");
	
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
			insert into board values(idx, 'values', 'writer', 'regdate', count, 'content');
		*/
		Statement stmt = conn.createStatement();
		String sql = "insert into board" + " values( board_seq.nextval, '" + title + "', '"+writer+"',  sysdate, "+count+", '"+content+"')";
		stmt.executeQuery(sql);
		
		conn.close();
	}catch(Exception e){
		out.println("Connection failed");
		out.println(e.getMessage());
		e.printStackTrace();	
	}finally{
		out.println("<script>location.href='list.do';</script>");
	}
	
	
%>
</head>
<body>

</body>
</html>