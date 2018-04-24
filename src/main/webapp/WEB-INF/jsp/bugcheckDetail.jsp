<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 引入jstl -->
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!--让IE使用最新的渲染模式-->
<meta http-equiv="X-UA-Compatible" content="IE=EDGE" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<meta charset="UTF-8">
<!--针对移动设备,网站显示宽度等于设备屏幕显示宽度,内容缩放比例为1:1-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>View - Offline Dump View Application</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet" />
</head>

<body>
	<div class="container-fuild body-content" style="margin: 25px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4 class="panel-title">BugCheck ${bugcheck}</h4>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>File</th>
							<th>Upload</th>
							<th>Summary Analysis</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="list" items="${list}">
							<tr>
								<td><a href="/OfflineDumpView/result/view/${list.id}">${list.id}</a></td>
								<td>${list.dumpFile}</td>
								<td>${list.endTime}</td>
								<td>${list.summary}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<hr />
		<footer>
			<p>&copy; 2018 - Dump View Offline Application V1.0</p>
		</footer>
	</div>

	
		<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
</body>



</html>

