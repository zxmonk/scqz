<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@
	page import="java.sql.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>




<%@ include file="/includeFile/header.jsp"%>

<div id="main">

	<%
		String result = ""; // 查询结果字符串
		String sql = "SELECT user_id, TRUNC (logon_day) logon_day, SUM (elapsed_minutes) total_time  FROM sys.stats$user_log   GROUP BY user_id, TRUNC (logon_day) ORDER BY 2";
		String url = "jdbc:oracle:thin:@10.51.0.97:1521:PDBQZ";
		String username = "QZDATA"; // 用户名
		String password = "87014870"; //密码
		Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		Connection conn = DriverManager.getConnection(url, username,
				password);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			result += "\n" + rs.getString(1) + " " + rs.getString(2) + " "
					+ rs.getString(3) + "<BR>";
		}
		rs.close(); // 关闭结果集
		stmt.close(); // 关闭执行语句对象
		conn.close(); // 关闭与数据库的连接
	%>
	<%=result%>
</div>
<%@ include file="/includeFile/footer.jsp"%>