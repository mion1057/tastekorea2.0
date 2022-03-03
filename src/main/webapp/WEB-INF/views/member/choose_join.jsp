<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/choose_join.css'/>" />
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%> 
	</header>
	<div id="container">
		<div class="sign_up_wrap">
			<div class="text_box">
				<h2>Sign up for TasteKorea</h2>
				<p>
					TasteKorea에 여행오신 여러분 환영합니다. <br> 여러분의 여행가방을 꾸리기 위해 회원가입을<br>
					진행해주세요.
				</p>
			</div>
			<div class="sign_up">
				<a href="" class="user">여행객 가입</a>
				<div class="line">
					<p>or</p>
				</div>
				<a href="/guide/companion/add" class="companion">가이드 가입</a>
			</div>
		</div>
	</div>
	<footer> </footer>
	<script src="<%=request.getContextPath()%> /resources/js/menu.js"></script>
</body>
</html>