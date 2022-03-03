<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/login_member.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<div id="container">
			<div id="content_wrap">
				<div id="content">
					<h1>
						taste<span>Korea</span>
					</h1>
					<form:form modelAttribute="memberCommand" method="post">
						<h3>Email</h3>
						<div class="input_email_wrap">
							<form:input path="email" required="required" />
							<span class="remove_email rbtn" onclick="remove_email()"><span>delete</span></span>
						</div>
						<h3>Password</h3>
						<div class="input_email_wrap">
							<form:password path="passwd" required="required" />
							<span class="remove_passwd rbtn" onclick="remove_passwd()"><span>delete</span></span>
						</div>
						<button class="loginbtn">Log in</button>
					</form:form>
					<p>${err}</p>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
	<script>
    function remove_email() {
        $('#email').val('');
    }
    function remove_passwd() {
        $('#passwd').val('');
    }
		$('.loginbtn')
				.on(
						'click',
						function() {
							var email = $('#email').val();
							var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;

							if (!regEmail.test(email)) {
								alert("Please enter your email");
								email.focus();
								return false;
							}

							if ($('#passwd').val().length == 0) {
								alert("Please enter your password");
								$('#passwd').focus();
								return false;
							}
						})
	</script>

</body>
</html>