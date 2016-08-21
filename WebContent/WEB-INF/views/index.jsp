<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="bootstrap/js/jquery-1.9.1.min.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script> 
 <link type="text/css" rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
</head>
<body style="background-image:url(images/beijing3.jpg)">
	<div class="container">
		<div class="row">
			<h1>Sentiment Analysis Annotation Platform</h1>
		</div>
		<hr>
		<div class="row" style="margin-top:50px">
			<div class="col-md-7">
				<img src="images/sentiment-analysis.png" style="width:600px;height:280px;">
			</div>
			<div class="col-md-5">
				<div class="panel panel-success">
					<div class="panel-heading">
						<p>欢迎来到bfcpzk的情感分析数据标注平台</p>
					</div>
					<div class="panel-body">
						<form action="toPage.do" name="loginform" method="post">
							<table class="table table-striped table-bordered table-hover">
								<br>
								<br>
								<br>
								<tr>
									<td style='text-align: center;'><input class="btn btn-success" type="submit" name="submit" value="点击直接进入" ></td>
								</tr>
								<br>
								<br>
								<br>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
		<hr style="margin-top:150px;">
		<div class="row" >
			<p align="center">Copyright © bfcpzk.</p>
		</div>
	</div>
</body>
</html>