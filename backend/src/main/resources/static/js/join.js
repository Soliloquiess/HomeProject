$(document).ready(function() {
		$("#registerBtn").click(function() {

			if ($("#username").val() == "") {
				alert("이름 입력!!!");
				return;
			} else if ($("#userid").val() == "") {
				alert("아이디 입력!!!");
				return;
			} else if ($("#userpwd").val() == "") {
				alert("비밀번호 입력!!!");
				return;
			} else if ($("#userpwd").val() != $("#pwdcheck").val()) {
				alert("비밀번호 확인!!!");
				return;
			} else {
				$("#memberform").submit();
			}
		});

		$('#zipcode').focusin(function() {
			$('#zipModal').modal();
		});
	});