

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="<%=request.getContextPath()%>/css/main.css" rel="stylesheet"
	type="text/css">

<c:if test="${errCode == null }">
	<c:set var="errCode" value="\"\"" />
</c:if>

<script type="text/JavaScript">

	function checkErrCode(){
		var errCode = ${errCode};
		
		if(errCode != null || errCode != ""){
			switch (errCode){
			case 1:
				alert("가입된 이메일 주소가 아닙니다");
				break;
				
			
			case 2:
				alert("비밀번호가 일치하지 않습니다.");
				break;
				
			
			case 3:
				alert("회원가입 처리가 완료되었습니다.! 로그인 해 주세요!");
				location.href='<%=request.getContextPath()%>
	/login.do';
				break;
			}
		}
	}
</script>

</head>


<body onload="checkErrCode()">

	<div class="wrapper">

		<h3>스프링 게시판</h3>
		<spring:hasBindErrors name="loginModel" />

		<form:errors path="loginModel" />


		<form action="login.do" method="post">

			<fieldset>

				<label for="userId"> 메일주소 : </label> 
				<input type="text" id="userId"	name="userId" class="loginInput" value="${userId }"> 
				<span class="error"><form:errors path="loginModel.userId"/></span> <br>
				
				<label	for="userPw"> 비밀번호 : </label> 
				<input type="password" id="userPw" name="userPw" class="loginInput" value="${userPw }">
				<span class="error"><form:errors path="loginModel.userId"/></span> <br>

				<center>
					<input type="submit" value="로그인" class="submitBt" /> <br> <br>
					<a href="<%=request.getContextPath()%>/member/join.do">회원가입</a>
				</center>
			</fieldset>
		</form>

	</div>

</body>
</html>


















