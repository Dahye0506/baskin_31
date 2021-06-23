<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="reviewWrite.gd" method="post" enctype="multipart/form-data">
<inpur type="hidden" name="prodNum" value="${pordNum }" />
<inpur type="hidden" name="purchaseNum" value="${purchaseNum }" />

<table>
	<tr><td>리뷰작성</td><td row="5" cols="30" name="reviewContent"></td></tr>
	<tr><td>파일</td><td><input type="file" name="reviewImg" /></td></tr>
	<tr><td colspan="2"><input type="submit" name="리뷰 등록" /></td></tr>
</table>
</form>
</body>
</html>