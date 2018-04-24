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
<title>View_${result.id} - Offline Dump View Application</title>
	<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet" />

<style>
.nav-tabs {
	margin-top: 20px;
	border-radius: 4px;
	border: 1px solid #ddd;
	box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
}

ul.nav-tabs li {
	margin: 0;
	border-top: 1px solid #ddd;
}

ul.nav-tabs li:first-child {
	border-top: none;
}

ul.nav-tabs li a {
	margin: 0;
	padding: 3px 8px;
	border-radius: 0;
}

ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover {
	color: #fff;
	background: #0088cc;
	border: 1px solid #0088cc;
}

ul.nav-tabs li:first-child a {
	border-radius: 4px 4px 0 0;
}

ul.nav-tabs li:last-child a {
	border-radius: 0 0 4px 4px;
}

ul.nav-tabs.affix {
	top: 10px;
}
</style>
</head>

<body data-spy="scroll" data-target="#myScrollspy">
	<div class="container-fuild body-content" style="margin: 25px;">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordioninfo"
						href="#collapseinfo">Job Information</a>
				</h3>
			</div>
			<div id="collapseinfo" class="panel-collapse collapse in">
				<div class="panel-body">
					<dl class="dl-horizontal" style="font-size: larger;">
						<dt>Id</dt>
						<dd>${result.id}</dd>
						<dt>Dump File</dt>
						<dd>${result.dumpFile}</dd>
						<dt>End Time</dt>
						<dd>${result.endTime}</dd>
						<dt>Bugcheck</dt>
						<dd>${result.bugcheck}</dd>
					</dl>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordionsummary"
						href="#collapseSummary">Analysis Summary</a>
				</h3>
			</div>
			<div id="collapseSummary" class="panel-collapse collapse in">
				<div class="panel-body">
					<pre>${result.summary}</pre>
				</div>
			</div>
		</div>

		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<a data-toggle="collapse" data-parent="#accordionoutput"
						href="#collapseOutput">Windbg Output</a>
				</h3>
			</div>
			<div id="collapseOutput" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="row">
						<div class="col-lg-10 col-md-12">
							<c:forEach var="content" items="{contents}">
 								<h4 id="${content.title}">${content.title}</h4> 
								<pre>${content.information}</pre>
							</c:forEach>

						</div>
						<nav class="col-lg-2 hidden-md hidden-sm hidden-xs"
							id="myScrollspy">
							<ul data-spy="affix" data-offset-top="750"
								class="nav nav-tabs nav-stacked">
								<c:forEach var="content" items="contents">
									<li><a href="#${content.title}">${content.title}</a></li> 
								</c:forEach>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<hr />
		<footer>
			<p>&copy; 2018 - Dump View Offline Application V1.0</p>
		</footer>
	</div>
	<script>	
		<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>
</body>



</html>
