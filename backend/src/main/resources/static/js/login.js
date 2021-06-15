function login() {
	if(document.getElementById("ID").value == "") {
		alert("아이디 입력하십시오.");
		return;
	} else if(document.getElementById("PASS").value == "") {
		alert("비밀번호 입력하십시오.");
		return;
	} else {
		document.getElementById("loginform").action = "./login";
		document.getElementById("loginform").submit();
	}
}
	  
function moveJoin() {
//	document.location.href = "../member?act=join";
	document.location.href = "./joinForm";
}	