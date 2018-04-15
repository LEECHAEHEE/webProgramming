<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%!
	String name, id, pw, phone1, phone2, phone3, gender;

	Connection conn = null;
	Statement stmt= null;
	ResultSet rs= null;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String u_id ="scott", u_pw="tiger";
	
	String sql;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	id = (String)session.getAttribute("id");
 	sql ="select * from member where id = '" + id + "'";
 	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url, u_id, u_pw);
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			name = rs.getString("name");
			pw = rs.getString("pw");
			phone1 = rs.getString("phone1");
			phone2 = rs.getString("phone2");
			phone3 = rs.getString("phone3");
			gender = rs.getString("gender");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(conn!=null) conn.close();
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
		}catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
%>
	<form action="ModifyOk" method="post">
		이름<input type="text" value=<%=name %> name="name" size="15"><br/>
		아이디 <input type="text" value=<%=id %> name="id" size="15"  disabled><br/>
		비밀번호<input type="password" name="pw" size="15"><br/>
		전화번호 <select name="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			<option value="018">018</option>
			<option value="019">019</option>
		</select>-
		<input type="text" value=<%=phone2 %> name="phone2" size="4">-
		<input type="text" value=<%=phone3 %> name="phone3" size="4"><br/>
		성별 
		<%
			if(gender.equals("man")){
		%>
		남<input type= "radio" name="gender" value="man" checked="checked">
		여<input type= "radio" name="gender" value="woman"><br/>
		<%}else{ %>
		남<input type= "radio" name="gender" value="man" checked="checked">
		여<input type= "radio" name="gender" value="woman" checked="checked"><br/>
		<%} %>
		<input type= "submit" value="수정완료"> &nbsp; <input type= "reset" value="취소">
	</form>
</body>
</html>