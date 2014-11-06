<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript"
	src="/scqz/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function check(){
		if(document.getElementById('fileUpload').value=='') {
			  alert('请选择上传文件！');
			  document.getElementById('fileUpload').focus();
			  return false;
		}
		if(document.getElementById('nameUpload').value=='' ||
		   document.getElementById('nameUpload').value==' ') {
			  alert('请填写上传人员姓名！');
			  document.getElementById('nameUpload').focus();
			  return false;
		}
	}
</script>

<title>四川前兆</title>
<link rel="shortcut icon" type="image/x-icon"
	href="../images/shortcut.png" />
<link rel="stylesheet" type="text/css" href="../css/style.css" />
</head>
<body>

	<%
		String result2 = null;
		result2 = (String) request.getSession().getAttribute(
				"result2");
		request.getSession().removeAttribute("result2");
		
		if(result2!=null){
			out.println("<script> alert(\"提交成功!\"); </script>");
			result2 = null;
		}
	%>
	<div id="leftcont">
		<div id="leftimg">
			<a title="首页" href="index.html"><img alt="image description"
				src="../images/logo2.png" /></a>
		</div>
		<div id="menu">
			<ul>
				<li><a title="首页" href="/scqz/index.html">首页</a></li>
				<li><a title="月报年报" href="/scqz/report/report_read.jsp">月报年报</a></li>
				<li><a title="质量监控" href="/scqz/index.html">质量监控</a></li>
				<li><a title="运行评价" href="/scqz/review/excel_read.jsp">运行评价</a></li>
				<li><a title="运行管理" href="/scqz/index.html">运行管理</a></li>

			</ul>
		</div>
	</div>
	<div id="main">
		<h1>前兆台网运行报告提交</h1>
		<a title="点击进入报告提交页面" href="/scqz/report/report_read.jsp">报告查询</a>
		<p class="tag">本页面提供前兆运行月报和前兆运行年报的提交服务，点击上方的“报告查询”进入提交报告页面</p>
		<p class="tag2">
		*请注意在选择日期时，请选择报告内容日期，而不是报告提交日期
		<br/>*上传文件格式为word文档
		</p>
		<form action="/scqz/index.html" method="post"
			enctype="multipart/form-data" onsubmit="return check()">
			<label>报告类型（必填）</label> <select name="reporttype">
				<option value="MR" selected="selected">月报</option>
				<option value="AR">年报</option>
			</select> <br /> <label>选择台站（必填）</label> <select name="stationid">
				<option value="51_四川">51四川</option>
				<option value="51001_成都">51001成都</option>
				<option value="51002_泸州地震台">51002泸州地震台</option>
				<option value="51003_松潘">51003松潘</option>
				<option value="51004_仁和">51004仁和</option>
				<option value="51005_南山">51005南山</option>
				<option value="51006_红格">51006红格</option>
				<option value="51007_西昌地震台">51007西昌地震台</option>
				<option value="51008_西昌太和">51008西昌太和</option>
				<option value="51009_小庙台">51009小庙台</option>
				<option value="51010_姑咱地震台">51010姑咱地震台</option>
				<option value="51011_姑咱水化">51011姑咱水化</option>
				<option value="51012_甘孜地震台">51012甘孜地震台</option>
				<option value="51013_炉霍虾拉沱">51013炉霍虾拉沱</option>
				<option value="51014_康定地震台">51014康定地震台</option>
				<option value="51015_道孚地震台">51015道孚地震台</option>
				<option value="51016_巴塘">51016巴塘</option>
				<option value="51017_乡城地震台">51017乡城地震台</option>
				<option value="51019_雅安">51019雅安</option>
				<option value="51020_江油">51020江油</option>
				<option value="51022_冕宁地震台">51022冕宁地震台</option>
				<option value="51023_昭觉地震台">51023昭觉地震台</option>
				<option value="51025_盐源地震台">51025盐源地震台</option>
				<option value="51026_松潘川主寺">51026松潘川主寺</option>
				<option value="51027_汶川">51027汶川</option>
				<option value="51028_茂县">51028茂县</option>
				<option value="51033_理县地震台">51033理县地震台</option>
				<option value="51042_什邡金河地震台">51042什邡金河地震台</option>
				<option value="51045_石棉县防震减灾局">51045石棉县防震减灾局</option>
				<option value="51047_马边">51047马边</option>
				<option value="51048_八一四地震台">51048八一四地震台</option>
				<option value="51049_峨眉交大台">51049峨眉交大台</option>
				<option value="51053_马兰山地震台">51053马兰山地震台</option>
				<option value="51054_攀枝花乌龟井">51054攀枝花乌龟井</option>
				<option value="51056_甘孜川15井">51056甘孜川15井</option>
				<option value="51057_小金川07井">51057小金川07井</option>
				<option value="51058_安县川09井">51058安县川09井</option>
				<option value="51059_江油川10井">51059江油川10井</option>
				<option value="51060_德阳">51060德阳</option>
				<option value="51061_蒲江川11井">51061蒲江川11井</option>
				<option value="51062_邛崃">51062邛崃</option>
				<option value="51063_石棉川02井">51063石棉川02井</option>
				<option value="51064_石棉川20井">51064石棉川20井</option>
				<option value="51065_西昌川03井">51065西昌川03井</option>
				<option value="51066_会理川06井">51066会理川06井</option>
				<option value="51067_会理地震台">51067会理地震台</option>
				<option value="51068_攀枝花川05井">51068攀枝花川05井</option>
				<option value="51069_南溪">51069南溪</option>
				<option value="51070_泸州川13井">51070泸州川13井</option>
				<option value="51071_理塘川51井">51071理塘川51井</option>
				<option value="51072_乡城52泉">51072乡城52泉</option>
				<option value="51073_道孚53泉">51073道孚53泉</option>
				<option value="51074_道孚54泉">51074道孚54泉</option>
				<option value="51075_康定二道桥55泉">51075康定二道桥55泉</option>
				<option value="51076_康定龙头沟57泉">51076康定龙头沟57泉</option>
				<option value="51077_巴塘305K58泉">51077巴塘305K58泉</option>
				<option value="51078_昭觉竹核61泉">51078昭觉竹核61泉</option>
				<option value="51079_泸定63泉">51079泸定63泉</option>
				<option value="51105_巴中">51105巴中</option>
				<option value="51163_攀枝花地龙井">51163攀枝花地龙井</option>
				<option value="51222_姑咱核桃湾">51222姑咱核桃湾</option>
				<option value="51224_崇州">51224崇州</option>
				<option value="51225_天全">51225天全</option>
				<option value="51303_松潘泉点">51303松潘泉点</option>
				<option value="51304_金河地震台">51304金河地震台</option>
				<option value="51306_泸沽湖地震台">51306泸沽湖地震台</option>
				<option value="51310_石门坎">51310石门坎</option>
				<option value="51311_木里磁通门点">51311木里磁通门点</option>
				<option value="51312_平地磁通门点">51312平地磁通门点</option>
				<option value="51313_会理磁通门点">51313会理磁通门点</option>
				<option value="51314_卫城磁通门点">51314卫城磁通门点</option>
				<option value="51316_宁南松新">51316宁南松新</option>
				<option value="51317_美姑磁通门点">51317美姑磁通门点</option>
				<option value="51318_昭觉磁通门测点">51318昭觉磁通门测点</option>
				<option value="51321_姑咱二道桥">51321姑咱二道桥</option>
				<option value="51322_姑咱龙头沟">51322姑咱龙头沟</option>
				<option value="51325_泸沽川23井">51325泸沽川23井</option>
				<option value="51330_普格川65泉">51330普格川65泉</option>
				<option value="51332_西昌川32井">51332西昌川32井</option>
				<option value="51351_自贡">51351自贡</option>
			</select> <br />
			
			<%
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			%>
			<lable>选择日期（必填）</lable>
			<input type=text name="date" onClick="WdatePicker()" value="<%out.print(formatter.format(new Date())); %>"/> 
			<br /> 
			<label>选择文件（必填）</label>
			<input type="file" name="file" id="fileUpload"/>
			
			 <br />

			<lable>上传人员（必填）</lable>
			<input type=text name="upname" value=" " id="nameUpload"/> <br /> <input type="submit"
				value="提交" />

		</form>




	</div>
</body>
</html>