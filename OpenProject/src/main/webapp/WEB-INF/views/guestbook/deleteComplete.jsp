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
		<c:when test="${InvalidPassword==false}">
			메세지를 삭제하였습니다.<br>
		</c:when>
		<c:otherwise>
			임력한 암호가 올바르지 않습니다. 암호를 확인해 주세요.<br>
		</c:otherwise>
	</c:choose>
	<a href="list">[목록보기]</a>
</body>
</html>