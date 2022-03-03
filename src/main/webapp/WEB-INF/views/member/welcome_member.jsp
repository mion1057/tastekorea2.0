<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tasteKorea</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />	
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/welcome_member.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>

</head>
<body>
	<header id="header">
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<div id="container">
			<div id="content_wrap">
				<div id="content">
					<h1>
						taste<span>Korea</span>
					</h1>
					<h2>Welcome</h2>
					<div id="text_box">
						<h2>Enjoy your trip</h2>
						<a href="/member/login">Login</a> <a href="/">Home</a>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
	<script>
		var name = $('h2').text()
		console.log(name);
	</script>
</body>
</html>