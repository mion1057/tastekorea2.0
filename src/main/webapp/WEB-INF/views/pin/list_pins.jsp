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
	href="<c:url value='/resources/css/list_pins.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<div id="container">
			<div class="content">
				<h3 class="p_title">PIN</h3>
				<div class="region_bar">
					<form action="">
						<input type="button" value="Seoul" onclick=""> <input
							type="button" value="Busan" onclick=""> <input
							type="button" value="Jeju" onclick=""> <input
							type="button" value="Daegu" onclick=""> <input
							type="button" value="Chuncheon" onclick=""> <input
							type="button" value="Incheon" onclick=""> <input
							type="button" value="Gwangju" onclick=""> <input
							type="button" value="Ulleungdo" onclick=""> <input
							type="button" value="Pyongyang" onclick="">
					</form>
				</div>
				<div class="region_bar">
					<form action="">
						<input type="button" value="food&amp;drink" onclick=""> <input
							type="button" value="sigthseeing" onclick=""> <input
							type="button" value="shopping" onclick=""> <input
							type="button" value="play&amp;arcade" onclick=""> <input
							type="button" value="medical&amp;beauty" onclick=""> <input
							type="button" value="sports&amp;leisure" onclick=""> <input
							type="button" value="job&amp;education" onclick="">
					</form>
				</div>
				<c:forEach var="pin" items="${pinPage.content}">
					<div class="pin_box">
						<a href="/pin/details?id=${pin.id }"></a>
						<div class="user_profile">
							<a href="#"> <!-- 강드 프로필 사진 들어갈 부분 src 수정--> <img
								src='<c:url value="/resource/companion/profie/${pin.member.profileImage }"/>'>
								<span class="user_name">${pin.member.alias }</span>
							</a> <span class="pin_region"> <img src="<c:url value='/resources/images/icon/marker.png'/>" >
								${pin.region.eng }
							</span>
						</div>
						<div class="pin_image">
							<img
								src='<c:url value="/resource/companion/profie/${pin.imagePath }"/>'>
						</div>
						<div class="pin_title">
							<div class="title_zone">
								 <p>${pin.title }</p>
							</div>
							<div class="pin_category">
								<p>${pin.category.eng }</p>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
</body>
</html>