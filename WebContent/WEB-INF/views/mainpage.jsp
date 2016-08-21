<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sentiment Analysis of bfcpzk</title>
	<link href="css/jquery-ui.css" rel="stylesheet">
	<script src="bootstrap/js/jquery-1.9.1.min.js"></script>
 	<script src="bootstrap/js/bootstrap.min.js"></script> 
  	<script src="js/mainpage.js"></script>
  	<script src="js/jquery.js"></script>
	<script src="js/jquery-ui.js"></script>
	 <script>
    $(function() {
	    $("#keyword").autocomplete({
	        source: function( request, response ) {
	            $.ajax({
	                url: "realTimeSearch.do",
	                dataType: "json",
	                data:{
	                    "search": $("#keyword").val()
	                },
	                success: function( data ) {
	                    response( $.map( data, function( item ) {
	                        return {
	                            label : item,
	                            value : item
	                        }
	                    }));
	                }
	            });
	        },
	        minLength: 1,
	        select: function( event, ui ) {
	        }
	    });
    });
    </script>
 <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<input type="hidden" id="lastId" value="${lastId}">
		<div class="row">
			<div class="col-md-4">
				<h3>Sentiment Analysis Annotation</h3>
			</div>
			<div class="col-md-1" style="margin-top:20px">
				<select id="year" class="form-control">
					<option>2010</option>
					<option>2011</option>
					<option>2012</option>
					<option>2013</option>
					<option>2014</option>
					<option>2015</option>
				</select>
			</div>
			<div class="col-md-1" style="margin-top:20px">
				<select id="month" class="form-control" onchange="judgeDay()">
					<option>01</option>
					<option>02</option>
					<option>03</option>
					<option>04</option>
					<option>05</option>
					<option>06</option>
					<option>07</option>
					<option>08</option>
					<option>09</option>
					<option>10</option>
					<option>11</option>
					<option>12</option>
				</select>
			</div>
			<div class="col-md-1" style="margin-top:20px">
				<select id="day" class="form-control">
				</select>
			</div>
			<div class="col-md-1" style="margin-top:20px">
				<a href="javascript:void" onclick="showListByDate()" class="btn btn-warning">日期查询</a>
			</div>
			<div class="col-md-1">
			</div>
			<div class="col-md-2">
				<input type="text" class="form-control" id="keyword" placeholder="关键字查询" style="margin-top:20px">
			</div>
			<div class="col-md-1">
				<a href="javascript:void" onclick="getWeiboByKeyword()" class="btn btn-info" style="margin-top:20px">关键字查询</a>
			</div>
		</div>
		<hr>
		<div id="content" class="row set" style="overflow-y:scroll; margin-top:35px">
			<table class="table table-striped table-bordered table-hover">
				<thead>
					<tr>
						<th width="7%">ID</th>
						<th width="7%">微博编号</th>
						<th width="8%">发布人</th>
						<th width="40%">微博内容</th>
						<th width="10%">日期</th>
						<th width="18%">标注操作</th>
						<th width="8%">情感标签</th>
					</tr>
				</thead>
				<tbody id="tbody_content">
					<c:forEach items="${hwlist}" var="hw">
						<tr>
							<td id="id_${hw.id}">${hw.id}</td>
							<td id="wid_${hw.id}">${hw.wid}</td>
							<td id="author_${hw.id}">${hw.author}</td>
							<td id="text_${hw.id}">${hw.text}</td>
							<td id="date_${hw.id}">${hw.date}</td>
							<td id="action_${hw.id}">
								<a id="button_${hw.id}_up" href="javascript:void" onclick="addAnnotation(${hw.id},1)" class="btn btn-success">正性</a>
								<a id="button_${hw.id}_mid" href="javascript:void" onclick="addAnnotation(${hw.id},0)" class="btn btn-info">中性</a>
								<a id="button_${hw.id}_down" href="javascript:void" onclick="addAnnotation(${hw.id},-1)" class="btn btn-danger">负向</a>
							</td>
							<td id="sent_label_${hw.id}">
								<c:if test="${hw.sent_label == -1}">
									<p style="color:red">负向情感</p>
								</c:if>
								<c:if test="${hw.sent_label == 0}">
									<p style="color:blue">中性情感</p>
								</c:if>
								<c:if test="${hw.sent_label == 1}">
									<p style="color:green">正向情感</p>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>	
		</div>		
	</div>
</body>
</html>