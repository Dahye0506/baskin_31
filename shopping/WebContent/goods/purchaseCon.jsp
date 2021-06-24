<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang='ko'>
<head>
<meta charset="UTF-8">
<style type="text/css">
body,html{width:800px; margin:0 auto;}
.floatclear:after{content:''; clear:both; display:block;}
ul,li{list-style:none;}
h2{text-align:center;}
.purchse_list{float:right;}
.purchse_list>li{float:left; margin:0 0 0 10px ;}
.purchse_list>li>a{display:block; padding:10px 0px}

</style>
<title>Insert title here</title>
</head>
<body>
<h2> 주문 리스트</h2>
<ul class="purchse_list floatclear">
	<li><a href="myPage.mem">마이페이지</a></li>
	<li><a href="main.sm">홈으로</a></li>
</ul>
<table width="800" border="1" align="center">
	<tr><td>주문일(결제번호)</td>
		<td>상품명/주문번호</td>
		<td>판매자</td>
		<td>주문상태</td></tr>
<c:forEach items="${list }" var="dto">
	<tr>
		<td >
			${dto.purchaseDate } / ${dto.paymentApprNum }
		</td>
		<td rowspan="2">
			<img width="50" src="goods/upload/${dto.prodImage.split(',')[0] }" />
			${dto.prodName } / ${dto.purchaseNum }
		</td>
		<td rowspan="2">${dto.prodSupplyer }</td>
		
		<td rowspan="2">
		<c:if test="${dto.paymentApprNum == null}">
			<a href="paymentOk.gd?purchaseNum=${dto.purchaseNum }&purchaseTotPrice=${dto.purchaseTotPrice }">결제하기</a>
		</c:if>
		<c:if test="${dto.paymentApprNum != null}">
			결제완료<br />
			<c:if test="${dto.reviewContent == null }">
		   		<a href="goodsReview.gd?purchaseNum=${dto.purchaseNum }&prodNum=${dto.prodNum }">리뷰작성</a>
		   		
			</c:if>		
			<c:if test="${dto.reviewContent != null }">
				<a href="goodsReviewUpdate.gd?purchaseNum=${dto.purchaseNum }&prodNum=${dto.prodNum }">리뷰수정</a>
				
			</c:if>				  
		</c:if>
		</td>
	</tr>
	<tr><td>결제금액 : ${dto.purchaseTotPrice }</td></tr>
</c:forEach>

</table>
</body>
</html>