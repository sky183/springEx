<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div>
	<form id="USERJOIN" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td><label for="USERID">아이디</label></td>
				<td><input type="text" class="input_login readOnly" id="USERID"
					name="USERID" value="${mkey}" readonly></td>
			</tr>
			<tr>
				<td><label for="USERPW">비밀번호</label></td>
				<td><input type="password" class="input_login" id="USERPW" name="USERPW"></td>
			</tr>
			<tr>
				<td><label for="USERNAME">이름</label></td>
				<td><input type="text" class="input_login" id="USERNAME" name="USERNAME"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="file" id="PHOTOFILE" name="PHOTOFILE"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">${errorMsg}</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
				<input type="submit" class="btn" id="USERSUB" name="USERSUB" value="회원정보수정"></td>
			</tr>
		</table>
	</form>
</div>
