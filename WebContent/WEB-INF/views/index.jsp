<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href ="css/reset.css" type ="text/css" rel ="stylesheet">
<link href ="css/style.css" type ="text/css" rel ="stylesheet">
</head>
<body>   
	<!-- header부분 -->
	<jsp:include page="inc/header.jsp"/>

	
	<div id="body" class="clearfix">
		
	</div>
	
	<!-- footer부분 -->
	<jsp:include page="inc/footer.jsp"/>
	
</body>
</html>