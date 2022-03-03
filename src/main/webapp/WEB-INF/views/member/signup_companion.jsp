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
	href="<c:url value='/resources/css/signup_companion.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/header.css'/>" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="<c:url value='/resources/js/menu.js'/>"></script>
<link rel="stylesheet" type="text/css"
	href="<c:url value='/resources/css/footer.css'/>" />
</head>
<body>
	<header>
		<%@ include file="/WEB-INF/views/incl/header.jsp"%>
	</header>
	<section>
		<!-- 중앙에 모아질 회원가입 틀 -->
		<div id="container">
			<form:form method="post" modelAttribute="memberCommand"
				enctype="multipart/form-data">
				<form:input path="guide" style="display: none;" value="true"/>
				<div id="content_wrap">
					<div id="content">
						<!-- 이메일 & 패스워드 -->
						<div id="first_box">					
							<h3>이메일</h3>
							<form:input path="email" autocomplete="off" required="required" />
							<span class="errorTxt"></span>
							<h3>패스워드</h3>
							<form:password path="passwd" minlength="8" maxlenth="14"
								placeholder="8~14자리" required="required" autocomplete="off" />
						</div>
						<!-- 개인정보 -->
						<div id="second_box">
							<h3>닉네임</h3>
							<form:input path="alias" autocomplete="off" placeholder="닉네임"
							 required="required"/>
							<h3>이름</h3>
							<form:input path="firstName" autocomplete="off"
								placeholder="영문 이름" required="required" />
							<h3>성</h3>
							<form:input path="lastName" autocomplete="off"
								placeholder="영문 성" required="required" />
							<h3>생년월일</h3>
							<form:input path="ssn" maxlength="8" autocomplete="off"
								pattern="[0-9]+" required="required" placeholder="예)19901213" />
							<h3>성별</h3>
							<form:select path="sex">
								<option value="m">남자</option>
								<option value="f">여자</option>
							</form:select>
							<h3>전화번호</h3>
							<form:input path="phone" placeholder="휴대전화번호 '-' 제외"
								autocomplete="off" required="required" pattern="[0-9]+"
								maxlength="11" />
							<h3>지역</h3>
							<form:select path="region" required="required">
								<option value="0">------</option>
								<form:options items="${regionList}" itemLabel="region" itemValue="regionId"/>
							</form:select>
						</div>
						<div id="third_box">
							<!-- 언어 옵션 forEach -->
							<h3>언어 능력</h3>
							<c:forEach begin="0" end="2" var="i">
								<form:select path="languageSkillCommandList[${i}].languageId">
									<option value="0">-- 선택 --</option>
									<form:options items="${foreignLanguageList}" itemLabel="lang"
										itemValue="languageId" />
								</form:select>
								<form:select path="languageSkillCommandList[${i}].skillLevel">
									<option value="0">-- 선택 --</option>
									<form:options items="${languageLevelList}" />
								</form:select>
								<br>
							</c:forEach>
							<h3>프로필 사진</h3>
							<form:input path="profileImage" type="file" />
							<br>
							<h3>자기 소개</h3>
							<textarea id="introduction" name="introduction"></textarea>
							<button id="submit_btn">등록</button>
						</div>
					</div>
				</div>
			</form:form>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/views/incl/footer.jsp"%>
	</footer>
	<script>
	$('#submit_btn').on('click', function() {
        var email = $('#email').val();
        var firstName = $('#firstName').val();
		var lastName = $('#lastName').val();
		var regName = /^[a-zA-Z]*$/; 
		var regEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
        
		if(!regEmail.test(email)){
			alert('이메일을 형식에 맞게 입력해주세요');
			email.focus();
			return false;
		}

        if(!regName.test(firstName)) {
            alert("영문 이름을 입력해주세요");
            firstName.focus();
            return false;
        }
		if(!regName.test(lastName)) {
			alert("영문 성을 입력해주세요");
            lastName.focus();
            return false;
		}

    })
    document.getElementById('languageSkillCommandList1.languageId').setAttribute('required', 'required');
	</script>
</body>
</html>