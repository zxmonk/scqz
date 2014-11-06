<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ page import="dao.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="/scqz/report/MonthlyReport" method="post"
		enctype="multipart/form-data">
		<lable>选择台站</lable>
		<select name="stationid">
			<%
				StationsDAO dao = new StationsDAO();
				dao.getSession().beginTransaction();
				List<Stations> result = dao.findAll();
				//List<Stations> result = (List<Stations>) request
				//		.getAttribute("result");
				for (Stations o : result) {
					//out.println("<br/>");
					//out.println(o.getStationid()+" "+o.getStaionname());
					if (o.getStationid().equals("51")) {
						out.println("<option selected=\"selected\" value=\""
								+ o.getStationid() + "_" + o.getStaionname()
								+ "\">" + o.getStationid() + o.getStaionname()
								+ "</option>");
					} else {
						out.println("<option value=\"" + o.getStationid() + "_"
								+ o.getStaionname() + "\">" + o.getStationid()
								+ o.getStaionname() + "</option>");
					}

				}
			%>


		</select> <br />
		<lable>选择日期</lable>
		<input type=text name="date" onClick="WdatePicker()" /> <br /> <label>选择文件</label><input
			type="file" name="file" /> <br /> <input type="submit" value="submit" />

	</form>
</body>
</html>