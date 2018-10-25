<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>
<script>
 $(document).ready(function(){
	 
 });
</script>
</head>
<body>
	<div class="guestMsBox">
		<form class="writeMsg" action="write">
			<table>
				<tr>
				<td>아이디 : </td>
				<td>${loginfo.USERID}
				<input type="hidden" id="USERID" name="USERID" 
				readonly="readonly" value="${loginfo.USERID}"></td>
				</tr>
				<tr>
				<td>이름 : </td>
				<td>${loginfo.USERNAME}
				<input type="hidden" id="USERNAME" name="USERNAME" 
				readonly="readonly" value="${loginfo.USERNAME}"></td>
				</tr>
				<tr>
				<td>내용</td>
				<td><textarea  name="message" rows="10" style="width:100%;"></textarea></td>
				</tr>
				<tr><td colspan="2"><input type="submit" value="등록"></td></tr>
			</table>
		</form>
	</div>
	<hr>
	<table border="1">
	<c:choose>
		<c:when test="${listView==null or listView.isEmpty()}">
			등록된 메시지가 없습니다.
		</c:when>
		<c:otherwise>
			<c:forEach var="message" items="${listView.messageList}">
				<tr>
					<td>
					메시지 번호: ${message.message_id}<br/>
					아이디: ${message.USERID}<br/>
					이름: ${message.USERNAME}<br/> 
					메시지: ${message.message} <br/>
					<br/> 
                    <a href="view/${message.message_id}" class="delBtn">상세보기</a>
                    <c:if test="${message.USERID==loginfo.USERID}">
                        <a href="delete?messageId=${message.message_id}" class="delBtn">삭제하기</a>
					</c:if>
					<script type="text/javascript">
                    	$('.delBtn').addClass('btn');
                    </script>
					</td>
				</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
	<c:if test="${listView!=null}">
	<c:forEach var="i" begin="1" end="${listView.pageTotalCount}">
	<a href="list?page=${i}">[${i}]
	</a>
	</c:forEach>
	</c:if>
	<c:if test="${message.USERID==loginfo.USERID}">
	</c:if>
</body>
</html>