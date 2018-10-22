<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>
		<c:choose>
			<c:when test="${members!=null}">
				<c:forEach var="i" items="${members}">
					<div class="userbox">
						<div class="userPhoto">
							<img class="profile" alt="경로이상" src="${i.USERFILE}" />
						</div>
						<div class="userInfo">
							<p>아이디 = ${i.USERID}</p>
							<p>비밀번호 = ${i.USERPW}</p>
							<p>이름 = ${i.USERNAME}</p>
							<p>프로필사진 = ${i.USERFILE}</p>
							<p>가입일 = ${i.REGDATE}</p>
						</div>
						<div class="userModi">
							<a href="/op/member/modify?mkey=${i.USERID}" role="button"
								class="btn modibtn" id="modifybtn">수정</a> <br> 
								<a href="/op/member/delete?dkey=${i.USERID}" role="button" class="btn modibtn" id="deletebtn">삭제</a>
						</div>
					</div>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<h1>회원목록이 없습니다.</h1>
			</c:otherwise>
		</c:choose>