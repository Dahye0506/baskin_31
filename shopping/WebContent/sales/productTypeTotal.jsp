<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.rawgit.com/openhiun/hangul/14c0f6faa2941116bb53001d6a7dcd5e82300c3f/nanumbarungothic.css" rel='stylesheet' type='text/css'>
    <link href="css/style.css" rel="stylesheet" type="text/css">
<title>product Type Total</title>

<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	 <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawVisualization);
   
      function drawVisualization() { 
         var data = google.visualization.arrayToDataTable(${googleList});
         var options = {
               title : '제품별 판매현황 ',
               vAxis: {title: '금액 및 수량'},
               hAxis: {title: '제품명'}, 
               seriesType: 'bars',
               series: {4: {type: 'line'}}
            };        
         var chart = new google.visualization.ComboChart(document.getElementById('chart_div'));
         chart.draw(data, options);
      }
   </script>
</head>
<body>
<div id="wrap">
<h2>상품별 판매 현황</h2>
<ul class="top_menu floatclear">
	<li><a href="javascript:;">판매 리스트</a></li>
	<li><a href="customerTotal.vnt" target="_blank">고객 별 판매 현황</a></li>
	<li><a href="productTypeTotal.vnt" target="_blank">상품 별 판매 현황</a></li>
	<li><a href="javascript:;">년도 별 판매 현황</a></li>
	<li><a href="javascript:;">월 별 판매 현황</a></li>
</ul>
</div>
<div id="chart_div" style="width:900px; height: 500px;"></div>
<table >
	<tr><td>상품번호</td><td>상품명</td><td>상품금액</td>
		<td>총 상품금액</td></tr>
<c:forEach items="${list }" var="dto">
	<tr><td>${dto.prodNum }/${dto.prodName }</td>
		<td>${dto.prodPrice }</td><td>${dto.sumPrice }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>