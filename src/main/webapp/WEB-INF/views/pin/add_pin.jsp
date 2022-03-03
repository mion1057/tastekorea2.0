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
	href="<c:url value='/resources/css/header.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/add_pin.css'/>" />
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
				<form:form modelAttribute="pinCommand" method="post"
				enctype="multipart/form-data">
				<form:input path="member" value="${pinCommand.member }" style="display:none;"/>
                    <div class="titlebox">
                        <form:select path="region" required="required">
                            <option value="0">---------</option>
                            <form:options items="${regionList }" itemLabel="region"
                            itemValue="regionId"/>
                        </form:select>
                        <form:select path="category" required="required">
                            <option value="0">---------</option>
                            <form:options items="${categoryList }" itemLabel="category"
                            itemValue="categoryId"/>
                        </form:select>
                        <form:input path="title" placeholder="제목" autofocus="autofocus"/>
                    </div>
                    <div class="filebox">
                        <input class="upload-name" value="첨부파일" readonly="readonly"/>
                        <label for="imagePath">파일찾기</label>
                        <form:input type="file" path="imagePath"/>
                    </div>
                    <div class="mapbox">
                        <form:input path="mapData" required="required" placeholder="map 좌표값"/>
                    </div>
                    <div class="introbox">
                        <form:textarea path="description" maxlength="3000" placeholder="3000자 이내 작성"/>
                    </div>
                    <button>등록</button>
                </form:form>
			</div>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
	<script>
        $("#imagePath").on('change',function(){
        var fileName = $("#imagePath").val();
        $(".upload-name").val(fileName);
        });
    </script>
</body>
</html>