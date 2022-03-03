<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/index.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
<script src="<c:url value='/resources/js/slideshow.js'/>"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<!-- index 메인 -->
	<section>
		<div id="container">
			<div id="first_main">
				<div id="slideshow-containerider">
					<div class="mySlideDiv fimg fade active"></div>
					<div class="mySlideDiv simg fade"></div>
					<div class="mySlideDiv timg fade"></div>
					<div class="mySlideDiv yimg fade"></div>
				</div>
				<div class="search_bar">
					<input type="text" placeholder="What are you interested in? Which city do you want to go?">
					<button>Search</button>
				</div>
				<span class="welcome_msg">Are you coming to Korea?<br>Meet
					your friend at tasteKorea.
				</span>
			</div>
			<div id="fifth_main">
				<div class="fifth_content">
					<a href="/member/companion/list">Guide List</a>
					<div class="fifth_background"></div>
				</div>
			</div>
			<div id="second_main">
				<div class="pinbox_wrap">
					<h2>Recently Updated</h2>
					<c:forEach var="pin" items="${pinPage.content}" begin="0" end="2" >
						<div class="pinbox">
						<div class="pinbox_image">
							<a href="/pin/details?id=${pin.id }"><img
								src='<c:url value="/resource/companion/profie/${pin.imagePath }"/>'></a>
						</div>

						<div class="pinbox_text">
							<div class="text1">
								<h3>${pin.title }</h3>
							</div>
							<div class="text2">
								<!-- 가이드 프로필 사진 들어감-->
								<div class="companion_profile"><img
								src='<c:url value="/resource/companion/profie/${pin.member.profileImage }"/>'>
								</div>
								<div class="companion_alias"><span>${pin.member.alias }</span></div>
								<div class="companion_category">
									<span>${pin.category.eng }</span>
								</div>
								<div class="companion_region">
									<span>${pin.region.eng }</span>
								</div>
							</div>
						</div>
					</div>
					</c:forEach>

				</div>
			</div>
			<div id="third_main">
				<!-- 우측스크롤바 가진 지역 PIN -->
				<h2>Regional PIN</h2>
				<div id="region_content_wrap">
					<div class="region_pin_wrap">
						<div class="region_pin_box">
							<a href=""></a> <span>Seoul</span> <img
								src="<c:url value='/resources/images/region/seoul.jpg'/>">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Busan</span> <img
								src="<c:url value='/resources/images/region/busan.jpg'/>" alt="">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Jejudo</span> <img
								src="<c:url value='/resources/images/region/jeju.jpg'/>" alt="">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Daegu</span> <img
								src="<c:url value='/resources/images/region/daegu1.jpg'/>"
								alt="">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Ulleungdo</span> <img
								src="<c:url value='/resources/images/region/ulleungdo.jpg'/>"
								alt="">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Chuncheon</span> <img
								src="<c:url value='/resources/images/region/chuncheon.png'/>"
								alt="">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Gwangju</span> <img
								src="<c:url value='/resources/images/region/gwangju.jpg'/>"
								alt="">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Incheon</span> <img
								src="<c:url value='/resources/images/region/incheon.jpg'/>"
								alt="">
						</div>
						<div class="region_pin_box">
							<a href=""></a> <span>Pyongyang</span> <img
								src="<c:url value='/resources/images/region/pyongyang.jpg'/>"
								alt="">
						</div>
						<div class="view_more">
							<a href="">View more</a>
						</div>
					</div>
				</div>
			</div>
			<div id="fourth_main">
				<div class="fourth_content">
					<div class="top_background">
						<span>Categories</span>
					</div>
					<div class="category">
						<div class="category_pin_wrap">
							<div class="category_pin">
								<div class="nothing">
									<a href=""></a> <span>food &amp; drink</span> <img
										src="<c:url value='/resources/images/category/food.jpg'/>">
								</div>
							</div>
							<div class="category_pin">
								<div class="nothing">
									<a href=""></a> <span>sightseeing</span> <img
										src="<c:url value='/resources/images/category/sightseeing.jpg'/>">
								</div>
							</div>
							<div class="category_pin">
								<div class="nothing">
									<a href=""></a> <span>shopping</span> <img
										src="<c:url value='/resources/images/category/shopping.jpg'/>">
								</div>
							</div>
							<div class="category_pin">
								<div class="nothing">
									<a href=""></a> <span>play &amp; arcade</span> <img
										src="<c:url value='/resources/images/category/arcade.jpg'/>">
								</div>
							</div>
							<div class="category_pin">
								<div class="nothing">
									<a href=""></a> <span>medical &amp; beauty</span> <img
										src="<c:url value='/resources/images/category/medical.jpg'/>">
								</div>
							</div>
							<div class="category_pin">
								<div class="nothing">
									<a href=""></a> <span>sports &amp; leisure</span> <img
										src="<c:url value='/resources/images/category/sports.jpg'/>">
								</div>
							</div>
							<div class="category_pin">
								<div class="nothing">
									<a href=""></a> <span>job &amp; education</span> <img
										src="<c:url value='/resources/images/category/education.jpg'/>">
								</div>
							</div>
							<div class="cview_more">
								<a href="">View more</a>
							</div>
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