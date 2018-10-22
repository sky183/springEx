<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Open Project</title>
<link rel="stylesheet" href="/op/resources/cssAll.css" type="text/css">
</head>
<body>
	<div id="test_container">
		<div id="test_header">
			<jsp:include page="../views/layout/header.jsp"></jsp:include>
			<div id="test_navi">
				<jsp:include page="../views/layout/navi.jsp"></jsp:include>
			</div>
		</div>
		<div id="test_wrap">
			<div id="test_box1">
			<div id="test_con1">
				<jsp:include page="../views/layout/con1.jsp"></jsp:include>
			</div>
			</div>
			<div id="test_box2">
			<div id="test_con2">
				<jsp:include page="../views/layout/con2.jsp"></jsp:include>
			</div>
			</div>
		</div>
		<div id="test_footer">
			<jsp:include page="../views/layout/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>