<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ include file="/includeFile/header.jsp"%>

<div id="main">
	<h1>运行管理</h1>
	
	<br/>
  	<br/>  
  	<div class="row">
        <div class="col">
        <h3>服务器监控</h3>
  			<a href="monitor.jsp" title="服务器监控" target="_blank">
  			<img src="/scqz/images/monitor.png" alt="服务器监控" width="180" height="120"/>
  			</a>
  		<br/>
  		
  		<br/>
  		<h3>前兆管理系统重启</h3>
  			<a href="reboot.jsp" title="前兆管理系统重启" target="_blank">
  			<img src="/scqz/images/reboot.png" alt="前兆管理系统重启" width="180" height="120"/>
  			</a>
  		</div>
  		<div class="col">
        <h3>运行总览</h3>
  			<a href="overview.jsp" title="运行总览" target="_blank">
  			<img src="/scqz/images/data_overview.png" alt="运行总览" width="180" height="120"/>
  			</a>
  		</div>
  		<div class="col">
        <h3>运行总览（背景场）</h3>
  			<a href="overview_beijingchang.jsp" title="运行总览（背景场）" target="_blank">
  			<img src="/scqz/images/data_overview_beijingchang.png" alt="运行总览（背景场）" width="180" height="120"/>
  			</a>
  		</div>
  	</div>
  	</div>
  
<%@ include file="/includeFile/footer.jsp"%>