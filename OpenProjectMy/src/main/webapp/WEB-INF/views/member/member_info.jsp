<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://code.jquery.com/jquery-1.10.0.js"></script>
<script>


	$(document).ready(function() {
		$('.memList').load('viewType');
		$('#viewType').change(function() {
			if ($(this).val() == 'HTML') {
				$.ajax({
					url : 'viewType?type=HTML',
					data : {
						viewType : $(this).val()
					},
					error : function(error) {
				        alert("Error!");
				    },
					success : function(data) {
						$('.memList').empty();
						$('.memList').append(data);
					}
				});
			}
			if ($(this).val() == 'JSON') {
				$.getJSON('viewType?type=JSON', function(data) {
					success : 
						$('.memList').empty();
						$('.memList').append(JSON.stringify(data)+"<hr>");
						$.each(data, function(key, value) {
						$('.memList').append("아이디:"+value.USERID+"<br>"+"비밀번호:"+value.USERPW+"<br>"
								+"이름:"+value.USERNAME+"<br>"+"파일명:"+value.USERFILE+"<br>"
								+"가입일:"+value.REGDATE+"<hr>");
					});

				});
			}
			if ($(this).val() == 'XML') {
				$.ajax({
					url : 'viewType?type=XML',
					error : function(error) {
				        alert('error');
				    },
					success : function(data) {
						$('.memList').empty();
						$('.memList').append($(data).text()+'<hr>');
						$(data).find('members').find('member').each(function(){
							var htmlstr = '아이디:'+$(this).find('USERID').text()+'<br>'
							+'비밀번호:'+$(this).find('USERPW').text()+'<br>'
							+'이름:'+$(this).find('USERNAME').text()+'<br>'
							+'파일:'+$(this).find('USERFILE').text()+'<br>'
							+'가입일'+$(this).find('REGDATE').text()+'<hr>';
							$('.memList').append(htmlstr);
						});	
					}
				});
			}
		});
	});

	function deleteM(key) {
		location.href = "../control/btnAction.jsp?dkey=" + key;
	}
</script>

<div class="memHeader">
	<select name="viewType" id="viewType">
		<option value="" selected disabled hidden="hidden">viewType</option>
		<option value="HTML">HTML</option>
		<option value="JSON">JSON</option>
		<option value="XML">XML</option>
	</select>
</div>
<hr>

<div class="memList"></div>