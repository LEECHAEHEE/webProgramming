<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
function isSame() {
    var pw = document.twin.wUserPW.value;
    var confirmPW = document.twin.wUserPWConfirm.value;
    if (pw.length < 6 || pw.length > 16) {
        window.alert('��й�ȣ�� 6���� �̻�, 16���� ���ϸ� �̿� �����մϴ�.');
        document.getElementById('pw').value=document.getElementById('pwCheck').value='';
        document.getElementById('same').innerHTML='';
    }
    if(document.getElementById('pw').value!="" && document.getElementById('pwCheck').value!="") {
        if(document.getElementById('pw').value == document.getElementById('pwCheck').value) {
            document.getElementById('same').innerHTML='��й�ȣ�� ��ġ�մϴ�.';
            document.getElementById('same').style.color='blue';
        }
        else {
            document.getElementById('same').innerHTML='��й�ȣ�� ��ġ���� �ʽ��ϴ�.';
            document.getElementById('same').style.color='red';
        }
    }
}
   </script>
	</head>
	<body>
	<table>
		<tr height="30">
	   		 <td width="5%" align="center">*</td>
	   		 <td width="15%">��й�ȣ</td>
	  		 <td><input type="password" name="wUserPW" id="pw" onchange="isSame()" /></td>
		</tr>
		<tr height="7">
	   		 <td colspan="3"><hr /></td>
		</tr>
		<tr height="30">
	  		 <td width="5%" align="center">*</td>
		  	 <td width="15%">��й�ȣ Ȯ��</td>
		  	 <td><input type="password" name="wUserPWConfirm" id="pwCheck" onchange="isSame()" />&nbsp;&nbsp;<span id="same"></span></td>
		</tr>
</table>
	</body>
</html>