$(document).ready(function() {
		$("#updateBtn").click(function() {

			if ($("#username").val() == "") {
				alert("이름은 필수값!!!");
				return;
			} else if ($("#userpwd").val() == "") {
				alert("비밀번호는 필수값!!!");
				return;
			} else if ($("#userpwd").val() != $("#pwdcheck").val()) {
				alert("비밀번호가 맞지 않아유!!!");
				return;
			} else {
				document.getElementById("memberform").action = "./update";
				document.getElementById("memberform").submit();
			}
		});
		$("#deleteBtn").click(function(){
			var chk = confirm("삭제하면 돌이킬 수 없습니다. 진심이십니까?");
			if(chk == true){
				document.getElementById("memberform").action = "./delete";
				document.getElementById("memberform").submit();
			}
			else if(chk == false){
				document.location.href = "./userInfo";
			}
		});
	});