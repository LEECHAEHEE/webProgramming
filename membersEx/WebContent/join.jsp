<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" >
	<!-- ��й�ȣ Ȯ�� -->
		function isSame(){
			var pw = document.getElementById("password").value;
			var chkpw = document.getElementById("checkPassword").value;
			if(pw.length < 8 || pw.legnth > 16){
				document.getElementById("pwValid").innerHTML = "8�ڸ��̻� 16�ڸ� ����";
				document.getElementById("pwValid").style.color="red";
			}else{
				document.getElementById("pwValid").innerHTML = "��밡���մϴ�.";
				document.getElementById("pwValid").style.color="blue";
			}
			if(document.getElementById("password").value !="" && document.getElementById("checkPassword").value!=""){
				if(document.getElementById("password").value == document.getElementById("checkPassword").value){
					document.getElementById("same").innerHTML = "��й�ȣ�� ��ġ�մϴ�.";
					document.getElementById("same").style.color="blue";
				}else{
					document.getElementById("same").innerHTML = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
					document.getElementById("same").style.color="red";
				}
			}
		}
		
		<!-- ���̵� �ߺ� Ȯ�� -->
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
				<td width="5px">���̵�</td>
				<td><input type="text" name="id"></td>
				<td><input type="button" value="���̵� �ߺ��˻�" onclick="idCheck()"></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">��й�ȣ</td>
				<td><input type="password" name="pw" id="password" onkeyup="isSame()"/>&nbsp;&nbsp;<span id="pwValid"></span></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">��й�ȣ Ȯ��</td>
				<td><input type="password" name="chkpw" id="checkPassword" onkeyup="isSame()"/>&nbsp;&nbsp;<span id="same"></span></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">�̸���</td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr height="5">
				<td colspan="3"><hr/></td>
			</tr>
			<tr height="5">
				<td width="5%" align="left">*</td>
				<td width="15%">�ּ�</td>
				<td><input type="text" name="address"/></td>
			</tr>
			<tr height="5">
				<td width="15%"><input type="button" value="ȸ������" onclick="infoConfirm()">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td width="15%"><input type="reset" value="���"></td>
			</tr>
		</table>
	</form>
</body>
</html>