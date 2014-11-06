<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript" type="text/javascript"
	src="/scqz/My97DatePicker/WdatePicker.js">
	
	
	function toEx(){
   	   var ex = prompt("请输入密码");

   	   if(ex == "Root123"){
   	         //这里执行输入密码正确的操作
			
            //比如跳转页面啊，等

   	   }else{
            //这里执行输入密码错误的操作
            window.location.href="/scqz/review/excel_upload.jsp";
            alert("密码错误！");
   	   }
	
    }
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="/scqz/review/ExcelFileUpload" method="post"
		enctype="multipart/form-data">
		<label>评比类型</label> <select name="reviewtype">
			<option value="MR" selected="selected">月评</option>
			<option value="AR">年评</option>
		</select> <br />
		<lable>选择日期</lable>
		<input type=text name="date" onClick="WdatePicker()" /> <br /> <label>选择文件</label>
		<input type="file" name="file" /> <br /> <input type="submit"
			value="submit" onclick="toEx();"/>
	</form>
</body>
</html>