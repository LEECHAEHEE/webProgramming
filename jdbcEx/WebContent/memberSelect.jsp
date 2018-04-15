<%@page import="com.javalec.ex.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.javalec.ex.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> dtos = dao.memberselect();
		
		for(int i=0;i<dtos.size();i++){
			MemberDTO dto = dtos.get(i);
			String name = dto.getName();
			String id = dto.getId();
			String pw = dto.getPw();
			String gender = dto.getGender();
			String phone = dto.getPhone1() + "-" + dto.getPhone2()  + "-" + dto.getPhone3();
			
			out.println("name : " + name);
			out.println("id : " + id);
			out.println("pw : " + pw);
			out.println("gender : " + gender);
			out.println("phone : " + phone + "<br/>");
		}
	%>
</body>
</html>