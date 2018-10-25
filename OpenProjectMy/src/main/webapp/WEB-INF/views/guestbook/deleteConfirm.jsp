<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${errorMsg==null}">
			<h3>메세지를 삭제하시겠습니까?</h3>
		</c:when>
		<c:otherwise>
			<h3>${errorMsg}</h3>
		</c:otherwise>
	</c:choose>

	<form method="post">
		<input type="hidden" name=messageId value="${param.messageId}"><br/>
		<input type="submit" value="메세지삭제">
	</form>
	<a href="list">[돌아가기]</a>
</body>
</html>