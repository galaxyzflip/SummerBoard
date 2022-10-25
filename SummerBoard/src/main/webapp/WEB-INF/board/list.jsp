<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글 목록 보기</title>

<link href="<%=request.getContextPath() %>/css/board/css" rel="stylesheet" type="text/css"/>
<script type="text/JavaScript" src="<%=request.getContextPath() %>/js/jquery-1.7.1.js"></script>
<script type="text/JavaScript">

	function selectedOptionCheck(){
		$("#type > option[value=<%=request.getParameter("type")%>]").attr("selected", "true");
		
	}
	
	function moveAction(where){
		switch (where){
		case 1:
			location.href = "write.do";
			break;
		case 2:
			location.href="list.do";
			break;
		}
	}

</script>

</head>
<body>

</body>
</html>