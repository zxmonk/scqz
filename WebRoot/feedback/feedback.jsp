<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="/includeFile/header.jsp"%>

<div id="main">
<h1>学科质量监控</h1>
	<iframe src="http://10.51.2.6/monitoring_daily4.php" width="750"
		height="1000" scrolling="yes" frameborder="0" seamless="seamless"></iframe>


	<%@ include file="/includeFile/footer.jsp"%>