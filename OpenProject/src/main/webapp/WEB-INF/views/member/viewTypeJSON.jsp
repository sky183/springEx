<%@page import="java.util.List"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${members!=null}">
[
<c:forEach var="i" items="${members}" varStatus="status">
{"USERID":"${i.USERID}","USERPW":"${i.USERPW}",
"USERNAME":"${i.USERNAME}","USERFILE":"${i.USERFILE}","REGDATE":"${i.REGDATE}"}
<c:if test="${status.last==false}">
,
</c:if>
</c:forEach>
]
</c:if>
