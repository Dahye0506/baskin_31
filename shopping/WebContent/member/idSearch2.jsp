<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디찾기</title>
</head>
<h2>아이디찾기 페이지</h2>
<body>
<form action="idFind.mem" method="post" >
<table>
	<tr><td>주소</td>
		<td><input type="text" name="memAddress" required="required"/></td></tr>
	<tr><td>연락처</td>
		<td><input type="text" name="memPhone" required="required"> </td></tr>
	<tr><td>이메일</td>
		<td><input type="EMAIL" name="memEmail" required="required"></td></tr>
	<tr><td colspan="2" align="center">
		<input type="submit" value="아이디 찾기" />
	</td></tr>
</table>
</form>
</body>
</html>