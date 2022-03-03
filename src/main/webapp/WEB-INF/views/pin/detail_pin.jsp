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
	href="<c:url value='/resources/css/detail_pin.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3161b0bfdd239c9b2b2377d6feedf2fd"></script>
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<div id="container">
			<div class="content">
					<div class="title_box">
						<input type="text" id="title" value="${pin.title }"
							readonly="readonly"> <input type="text" id="region"
							value="${pin.region.eng }" readonly="readonly"><br>
						<input type="text" id="category" value="${pin.category.eng }"
							readonly="readonly">
					</div>
					<div class="pin_detail">
						<div class="image_box">
							<!-- img 태그에 핀에서 작성한 이미지가 올라감 -->
							<img
								src='<c:url value="/resource/companion/profie/${pin.imagePath }"/>'
								alt="">
						</div>
						<div class="information_box">
						<pre>
${pin.description }
						</pre>
							</div>
						<div id="map"></div>
					</div>
					<div class="guide_info">
						<div>
							<!-- 이 img 태그에 가이드 프로필 사진이 들어감 -->
							<img src='<c:url value="/resource/companion/profie/${pin.member.profileImage }"/>'>
						</div>
						<div>
							<p>
								<span>${pin.member.alias}</span>
							</p>
						</div>
					</div>
					<div class="comments_wrap">
						<!-- 댓글 입력공간 -->

						<div class="comments_box">
							<input type="text" id="comments"
								placeholder="Enter the comments here">
						</div>
						<div class="btn_box">
							<button>submit</button>
							<span class="cancel">cancel</span>
						</div>

						<div class="comments_here">
							<!-- 위에서 쓴 댓글이 들어감 -->
							<input type="text" id="comment" value="" readonly="readonly">
						</div>
					</div>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
	<script>
		$('#comments').on('click', function() {
			$('.btn_box').css({
				display : "block"
			});
			$('#comments').css({
				borderBottom : "3px solid rgb(187, 187, 187)"
			})
		})
		$('.cancel').on('click', function() {
			$('.btn_box').css({
				display : "none"
			});
			$('#comments').css({
				borderBottom : "1px solid rgb(187, 187, 187)"
			})
		})
		
		<!--지도 api-->
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 	
		mapOption = {
			center : new kakao.maps.LatLng(<c:out value='${pin.mapData}'/>), // 지도의 중심좌표
			level : 4
		// 지도의 확대 레벨
		};

		var map = new kakao.maps.Map(mapContainer, mapOption); // 지도를 생성합니다
		

		// 마커가 표시될 위치입니다 
		var markerPosition = new kakao.maps.LatLng(<c:out value='${pin.mapData}'/>);

		// 마커를 생성합니다
		var marker = new kakao.maps.Marker({
			position : markerPosition
		});

		// 마커가 지도 위에 표시되도록 설정합니다
		marker.setMap(map);

		// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
		// marker.setMap(null);
	</script>
</body>
</html>