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
	href="<c:url value='/resources/css/information_companion.css'/>" />
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
			<div id="content">
				<h2>Membership information</h2>
				<div class="profile_info">
					<!-- 가이드가 등록한 본인 사진이 들어갈 공간 -->
					<h2>profile information</h2>
					<div class="profile">
						<div class="profile_first">
							<span class="profileImage"><img src="<c:url value='/resource/companion/profie/${user.profileImage }'/>"></span>
							<h3>alias</h3>
							<input type="text" id="alias" name="alias" 
							value = "${user.alias }"readonly="readonly"/>
							<h3>first name</h3>
							<input type="text" name="firstName" id="firstName"
								value="${user.firstName }",readonly="readonly">
							<h3>last name</h3>
							<input type="text" id="lastName" name="lastName"
								value="${user.lastName }"readonly="readonly">
						</div>
						<div class="profile_second">
							<h2>birth</h2>
							<input type="text" id="ssn" value="${user.ssn }" readonly="readonly">
							<h2>region</h2>
							<input type="text" id="region" value="${user.region.kor }" readonly="readonly">
							<c:forEach var="language" items="${list}">
								<h2>language</h2>
                            	<input type="text" id="language" 
                            	value="${language.skill.kor}" readonly="readonly">
                            	<h2>language skill level</h2>
                            	<input type="text" id="languageSkillLevel" 
                            	value="${language.skill.skillLevel }" readonly="readonly">
							</c:forEach>
							<h3>introduction</h3>
							<div class="introduction">
								<pre>${user.introduction }</pre>
							</div>
						</div>
						<div class="profile_third">
							<a href="/">prev page</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
</body>
</html>