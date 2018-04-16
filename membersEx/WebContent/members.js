/**
 * 
 */


function idCheck(){
	
}


function infoConfirm(){
	if(document.reg_frm.id.length==0){
		alert("아이디를 입력하세요.");
		reg_frm.id.focus();
		return;
	}
	
	if(document.reg_frm.id.legnth < 4){
		alert("아이디가 한글, 숫자 조합 4자 이상이어야 합니다.");
		reg_frm.id.focus();
		return;
	}
	
}