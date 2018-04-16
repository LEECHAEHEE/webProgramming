<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" >
	<!-- 비밀번호 확인 -->
		function isSame(){
			var pw = document.getElementById("password").value;
			var chkpw = document.getElementById("checkPassword").value;
			if(pw.length < 8 || pw.legnth > 16){
				document.getElementById("pwValid").innerHTML = "8자리이상 16자리 이하";
				document.getElementById("pwValid").style.color="red";
			}else{
				document.getElementById("pwValid").innerHTML = "사용가능합니다.";
				document.getElementById("pwValid").style.color="blue";
			}
			if(document.getElementById("password").value !="" && document.getElementById("checkPassword").value!=""){
				if(document.getElementById("password").value == document.getElementById("checkPassword").value){
					document.getElementById("same").innerHTML = "비밀번호가 일치합니다.";
					document.getElementById("same").style.color="blue";
				}else{
					document.getElementById("same").innerHTML = "비밀번호가 일치하지 않습니다.";
					document.getElementById("same").style.color="red";
				}
			}
		}
		
		<!-- 아이디 중복 확인 -->
		function idCheck(){
			alert("idcheck()");
		}
	</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="joinOk.jsp" method="post" name="reg_frm">		
		<table>
			<tr>
				<td width="5%" align="left">*</td>
				<td width="5px">아이디</td>
				<td><input type="text" name="id"></td>
				<td><input type="button" value="아이디 중복검사" onclick="idCheck()"></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">비밀번호</td>
				<td><input type="password" name="pw" id="password" onkeyup="isSame()"/>&nbsp;&nbsp;<span id="pwValid"></span></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">비밀번호 확인</td>
				<td><input type="password" name="chkpw" id="checkPassword" onkeyup="isSame()"/>&nbsp;&nbsp;<span id="same"></span></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">이메일</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">주소</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr height="5">
				<td width="15%"><input type="button" value="회원가입" onclick="infoConfirm()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width="15%"><input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
</body>
</html>