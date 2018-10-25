<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>아이디 : </td><td>${memberinfo.USERID}</td>
	</tr>
	<tr>
		<td>이름 : </td><td>${memberinfo.USERNAME}</td>
	</tr>
	<tr>
		<td>프로필 : </td><td>${memberinfo.USERFILE}</td>
	</tr>
</table>

</body>
</html>