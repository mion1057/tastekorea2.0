$(document).ready(function(){
	$('#submit_btn').on('click', function(){
		var email = $('#email').val();
		var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
		
		if(email == null || email == "") {
			alert("이메일을 입력해주세요");
			email.focus();
			return false;
		}else {
			if(!regEmail.test(email)){
				alert("이메일을 형식에 맞게 입력해주세요");
				return false;
			}
		}
		
	})
	$('#email').blur(function(){
		emailCheck();
	})
	
	function emailCheck() {
	
	var email = $('#email').val();
	
	var param = {
		"email": email,		
	}


	$.ajax({
		type: "post",				
		data: JSON.stringify(param),
		url: "/guide/companion/emailCheck",
		contentType: "application/json; charset=UTF-8",
		success: function(data) {
			$('.errorTxt').eq(0).html(data["msg"]).css({fontWeight: "bold"}); 
		},
		error: function(e){
			alert("실패!!");
			console.log(e.responseText);
		}
	});

	}	
})

