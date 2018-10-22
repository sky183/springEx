<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
	<div>
		<ul>
			<li><a href="<%=request.getContextPath()%>" class="navi_btn">메인화면</a></li>
			<li><a href="<%=request.getContextPath()%>/member/join" class="navi_btn">회원가입</a></li>
			<li><a href="<%=request.getContextPath()%>/member/login" class="navi_btn">로그인</a></li>
			<li><a href="<%=request.getContextPath()%>/member/myPage" class="navi_btn">마이페이지</a></li>
			<li><a href="<%=request.getContextPath()%>/member/list" class="navi_btn">회원리스트</a></li>
			<li><a href="<%=request.getContextPath()%>/guestbook/list" class="navi_btn">방명록</a></li>
		</ul>
	</div>
</body>
</html>