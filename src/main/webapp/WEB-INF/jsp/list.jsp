<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
		<title>Reports - Offline Dump View Application</title>
	</head>

	<body>
		<!-- 页面显示部分 -->
	
		<div class="container-fuild body-content" style="margin: 25px;">
	
			<div class="row">
				<div class="col-md-2">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">BugCheck Summary</h4>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>BugCheck</th>
										<th>Count</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="bgc" items="${count}">
										<tr>
											<td><a href="/OfflineDumpView/result/bugcheck/${bgc.bugcheck}">${bgc.bugcheck}</a></td>
											<td>${bgc.number}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
	
	
				<div class="col-md-10">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">Recent Submit</h3>
						</div>
						<div class="panel-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>ID</th>
										<th>Bugcheck</th>
										<th>File</th>
										<th>Upload</th>
										<th>Summary Analysis</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="re" items="${results}">
										<tr>
											<td><a href="/OfflineDumpView/result/view/${re.id}">${re.id}</a></td>
											<td>${re.bugcheck}</td>
											<td>${re.dumpFile}</td>
											<td>${re.endTime}</td>
											<td>${re.summary}</td>
										</tr>
									</c:forEach>
	
								</tbody>
							</table>
						</div>
					</div>
	
				</div>
			</div>
			<!-- row -->
			<hr />
			<!-- 分隔线 -->
			<footer>
				<p>&copy; 2018 - Offline Dump View Application V1.0</p>
			</footer>
		</div><!-- container -->
	
		<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</body>

</html>