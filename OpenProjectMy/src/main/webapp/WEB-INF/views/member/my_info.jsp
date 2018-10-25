<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>

<script>
	$(document).ready(function(){
	});
	</script>

		<div class="userbox">
			<div class="userPhoto">
				<img class="profile" src="${loginfo.USERFILE}" />
			</div>
			<div class="userInfo">
				<p>아이디 = ${loginfo.USERID}</p>
				<p>이름 = ${loginfo.USERNAME}</p>
				<p>프로필사진 = ${loginfo.USERFILE}</p>
				<p>가입일 = ${loginfo.REGDATE}</p>
			</div>
		</div>
