<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>

<%@ include file="/includeFile/header.jsp"%>
<%@ page import="java.util.*"%>  
<%@ page import="java.text.*"%> 
<script type="text/javascript">
$(function() {
    $(".gallery").jCarouselLite({
        btnNext: ".next",
        btnPrev: ".prev"
    });
});
</script>
<script type="text/javascript" src="js/jquery-1.7.js"></script>
<script type="text/javascript" src="js/jcarousellite_1.0.1.min.js"></script>
<div id="main">












	<!-- <div id="social"> 
	 <a href="#"> <img src="images/twitter.png" alt="" />  </a>
	<a href="#"> <img src="images/facebook.png" alt="" />   </a>
	<a href="#"> <img src="images/plus.png" alt="" /></a>
	<a href="#"> <img src="images/linkedin.png" alt="" /></a> 
	<p></p>
	</div>  -->
	<div class="inner_copyright">
			<!-- Collect from <a href="http://www.cssmoban.com/" target="_blank" title="????">????</a> -->
		</div>
	<div class="clr"></div>
	<h1>四川地震前兆台网</h1>
    
    
    <% 
/*     String agent = request.getHeader("User-Agent"); 
if (agent.indexOf("MSIE 6.0") != -1  || agent.indexOf("MSIE 7.0") != -1) {
    out.println("<h1>IE浏览器版本过低，部分网页（服务器监控界面）将无法正常显示，推荐浏览器：IE8.0或者以上，firefox，chrome（包括使用急速模式的猎豹浏览器，360浏览器等）</h1>");
    out.println(agent);
} else {
    //不是IE6
    //doanother
	out.println(agent);
} */
    %>
	<p class="tag">欢迎光临本站,本站主要面向四川区域地震前兆工作人员，提供前兆数据系统日常运行查询和维护相关功能的服务<br/>
    
    
     <h2>快速导航</h2>      
     <div id="slider">
               <div class="gallery">
                        <ul>
                            <li><a class="photo" target="_blank" href="admin/monitor.jsp" title="服务器监控">
                            	<img src="images/monitor.png" alt="服务器监控" width="180" height="120" /></a></li>
                            
                            <li><a class="photo" target="_blank" href="admin/overview.jsp" title="运行总览">
                            	<img src="images/data_overview.png" alt="运行总览" width="180" height="120" /></a></li>
                            
                            <li><a class="photo" target="_blank" href="admin/overview_beijingchang.jsp" title="运行总览（背景场）">
                            	<img src="images/data_overview_beijingchang.png" alt="运行总览（背景场）" width="180" height="120" /></a></li>
                            	
                            <li><a class="photo" target="_blank" href="admin/reboot.jsp" title="前兆管理系统重启">
                            	<img src="images/reboot.png" alt="前兆管理系统重启" width="180" height="120" /></a></li>
                            
                            <li><a class="photo" target="_blank" href="report/report_up.jsp" title="报告提交">
                            	<img src="images/report_up.png" alt="报告提交" width="180" height="120" /></a></li>
                            	
                            
                            
                        </ul>
                </div> 
               <a href="#" class="prev"><img src="images/arrow-prev1.png" width="40" height="40" alt="Arrow Prev" /></a>
               <a href="#" class="next"><img src="images/arrow-next1.png" width="40" height="40" alt="Arrow Next" /></a>
      </div>
      
      
      
      <!--slider ends-->
          <div class="clr"></div>
          
          <br/>
          <br/>
	<h2>本站功能介绍</h2>
	<p>月报年报：前兆台网运行月报和年报的提交，查询和下载</p>
		<p>质量评价：学科质量监控与反馈</p>
          <p>运行评价：用于公示前兆监测台站的台网运行月评和年评情况</p>
          <p>运行管理：监控各节点和区域中心服务器的基本工作状态以及数据库的远程控制</p>
          <br/>
          <br/>
          <div class="row">
        <div class="col">
           <h3>联系方式</h3>
          <p>地址：四川省成都市武侯区人民南路三段29号
          <br/>电话：028-85436363
          <br/>邮箱：scqzsj@eqsc.gov.cn</p>
        </div>
        <!--.col-->
        <div class="col">
         <h3>业务服务</h3>
          <p>四川前兆台网运行的相关信息和文件在四川前兆QQ群内发布欢迎广大前兆工作人员加入本群，QQ群号341372480
          </p>
        </div>
        <!--.col-->
        <div class="col last">
          <h3>技术支持</h3>
          	<p>关于本站有什么问题或者建议请联系本站建筑工人
          <br/>建筑工姓名：张晓明 
          <br/>建筑工手机：15208130416
          <br/>建筑工QQ：471697580</p>
        </div>
        <!--.col-->
      </div>
      
       <div class="clr"></div> 
 
       
	
</div>
	
	<%@ include file="/includeFile/footer.jsp"%>