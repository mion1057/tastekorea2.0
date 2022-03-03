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
	href="<c:url value='/resources/css/infomanagement_companion.css'/>" />
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
					<h2>프로필 정보</h2>
					<div class="profile">
						<form:form modelAttribute="" method="get">
							<div class="profile_first">
								<span class="profileImage"><img
									src="${tasteMember.profileImage }" alt=""></span>
								<h3>이름</h3>
								<form:input path="firstName" value="${tasteMember.firstName }"
									readonly="readonly" />
								<h3>성</h3>
								<form:input path="lastName" value="${tasteMember.lastName }"
									readonly="readonly" />
								<h3>이메일</h3>
								<form:input path="email" value="${tasteMember.email }" readonly="readonly" />
							</div>
							<div class="profile_second">
								<h2>생년월일</h2>
								<form:input path="ssn" value="${tasteMember.ssn }" readonly="readonly" />
								<h2>전화번호</h2>
								<form:input path="phone" value="${tasteMember.phone }" readonly="readonly" />
								<h2>지역</h2>
								<form:input path="region" value="${tasteMember.region }"
									readonly="readonly" />
								<h2>소개글</h2>
								<form:input path="introduction" value="${tasteMember.introduction })"
								readonly="readonly"/>
							</div>
						</form:form>
						<div class="profile_third">
							<a href="/">홈</a>
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