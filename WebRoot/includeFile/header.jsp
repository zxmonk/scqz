<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import="dao.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/scqz/css/style.css" />
<script type="text/javascript"
	src="/scqz/My97DatePicker/WdatePicker.js"></script>


<script src="/scqz/report/jquery-1.4.4.min.js" type="text/javascript"></script>
<title>四川前兆</title>
<link rel="shortcut icon" type="image/x-icon"
	href="/scqz/images/shortcut.png" />

</head>
<body>
	<div id="leftcont">
		<div id="leftimg">
			<a title="首页" href="/scqz/index.html"><img alt="image description"
				src="/scqz/images/logo2.png" /></a>
		</div>
		<div id="menu">
			<ul>
				<li><a title="首页" href="/scqz/index.html">首页</a></li>
				<li><a title="月报年报" href="/scqz/report/report_read.jsp">月报年报</a></li>
				<li><a title="质量监控" href="/scqz/feedback/feedback.jsp">质量监控</a></li>
				<li><a title="运行评价" href="/scqz/review/excel_read.jsp">运行评价</a></li>
				<li><a title="运行管理" href="/scqz/index.html">运行管理</a></li>

			</ul>
		</div>
	</div>