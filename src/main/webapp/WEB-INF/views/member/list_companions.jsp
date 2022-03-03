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
	href="<c:url value='/resources/css/list_companion.css'/>" />
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
		<!-- 중앙에 모아질 회원가입 틀 -->
		<div id="container">
			<div id="content">
				<div class="content_wrap">
					<h2>Guide List</h2>
					<!-- 등록순 정렬바 -->
					<div class="range_bar">
						<ul>
							<li><h3>정렬기준</h3>
							<li>
								<button>최신등록순</button>
							</li>
							<li>
								<button>구등록순</button>
							</li>
						</ul>
					</div>
					<div class="bottom_line"></div>
					<!-- --------------------------------------------------------------------------------------------------- -->
					<!-- 여기서 부터 리스트 -->
					<c:forEach var="member" items="${memberPage.content}">
                  <span style="display: none;">${companion }</span>
                  <div class="guide_wrap">
                     <div class="image_box">
                        <a href=""><img
                           src='<c:url value="/resource/companion/profie/${member.profileImage }"/>'
                           class="guide_intro"></a>
                     </div>
                     <div class="info_box">
                        <p class="guide name">
                           alias <span>${member.alias }</span>
                        </p>
                        <p class="guide age">
                           birth <span>${member.ssn }</span>
                        </p>
                        <p class="guide region">
                           region <span>${member.region.eng }</span>
                        </p>
                     </div>
                  </div>
               </c:forEach>
				</div>
			</div>
		</div>
	</section>
	<footer> </footer>

</body>
</html>