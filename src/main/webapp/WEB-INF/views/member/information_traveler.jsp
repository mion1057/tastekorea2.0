<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/infomanagement_traveler.css'/>" />
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
                        <div class="profile">
                            <div class="profile_first">
                                <h3>First name</h3>
                                <input id="firstName" value="${user.firstName }" readonly="readonly"/>
                                <h3>Last name</h3>
                                <input id="lastName" value="${user.lastName }" readonly="readonly"/>
                                 <h3>Alias</h3>
                                <input id="lastName" value="${user.alias }" readonly="readonly"/>
                            </div>
                            <div class="profile_second">
                                <h2>Email</h2>
                                <input id="email" value="${user.email }" readonly="readonly"/>
                                <h2>Region</h2>
                                <input id="region" value="${user.region.eng }" readonly="readonly"/>
                            </div>
                            <div class="profile_third">
                                <a href="/" >prev page</a>
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