<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ include file="/includeFile/header.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#checkAll").click(function() {
			$('input[name="subBox"]').attr("checked", this.checked);
		});
		var $subBox = $("input[name='subBox']");
		$subBox
				.click(function() {
					$("#checkAll")
							.attr(
									"checked",
									$subBox.length == $("input[name='subBox']:checked").length ? true
											: false);
				});
	});

	function toEx() {
		var ex = prompt("请输入密码");

		if (ex == "Root1234") {
			//这里执行输入密码正确的操作
			window.location.href = "/scqz/review/excel_upload.jsp";
			//比如跳转页面啊，等

		} else {
			//这里执行输入密码错误的操作

		}
	}
</script>
<div id="main">
	<h1>前兆台网运行质量</h1>
	<input type="button" value="评价提交界面" onclick="toEx();" />

	<p class="tag">本页面提供前兆运行质量查询功能</p>
	<p class="tag2">*点击查询结果的左侧方框可选择下载打包的文件</p>
	<%
		String reviewType = null;
		String dateStartString = null;
		String dateEndString = null;
		reviewType = (String) request.getSession().getAttribute(
				"reviewtype");

		dateStartString = (String) request.getSession().getAttribute(
				"dateStartString");
		dateEndString = (String) request.getSession().getAttribute(
				"dateEndString");
	%>

	<form action="/scqz/review/ExcelFileRead" method="post">
		<label>评比类型</label> <select id="sel" name="reviewtype">
			<option value="MR"
				<%if (reviewType != null)
				if (reviewType.equals("MR"))
					out.print("selected=\"selected\"");%>>月评</option>
			<option value="AR"
				<%if (reviewType != null)
				if (reviewType.equals("AR"))
					out.print("selected=\"selected\"");%>>年评</option>
		</select> <br />
		<%-- <label>选择台站</label>
		<select name="stationid">
			<%
				StationsDAO dao = new StationsDAO();
				dao.getSession().beginTransaction();
				List<Stations> result = dao.findAll();
				for (Stations o : result) {
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

		</select> <br /> --%>



		<%
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		%>


		<label> 起始日期</label> <input type=text name="date1"
			onClick="WdatePicker()"
			value="<%if (dateStartString != null)
				out.print(dateStartString);
			else
				out.print(formatter.format(new Date()));%>" />
		<br /> <label>结束日期</label> <input type=text name="date2"
			onClick="WdatePicker()"
			value="<%if (dateEndString != null)
				out.print(dateEndString);
			else
				out.print(formatter.format(new Date()));%>" />
		<br /> <input type="submit" value="提交" />
	</form>
	<br /> <br />

	<%
		if (reviewType == null) {

		} else {

			if (reviewType.equals("MR")) {

				try {
					List<ReviewMonthlyFile> result1 = (List<ReviewMonthlyFile>) request
							.getSession().getAttribute("result1");
					if (result1.isEmpty()) {
						out.println("<p>" + "月评" + dateStartString + " ~ "
								+ dateEndString + " 查询结果为空</p>");
					} else {

						out.println("<form action=\"/scqz/review/ExcelFileDownload\" method=\"post\">");
						out.println("<div id=\"table_b\">");
						out.println("<input id=\"checkAll\" type=\"checkbox\">全选</input>");

						out.println("<table>");
						out.println("<tr><td></td>"
								+ "<td><strong>文件名</strong></td>"

								+ "<td><strong>报告日期（YYYY-MM）</strong></td>"

								+ "</tr>");
						int nn = 1;
						for (ReviewMonthlyFile o : result1) {

							nn = nn + 1;
							if (nn % 2 == 0) {
								out.println("<tr class=\"tr1\"><td><input name=\"subBox\" type=\"checkbox\" value=\""
										+ o.getFileName()
										+ "\"/></td><td>"
										+ o.getFileName()
										+ "</td><td>"
										+ o.getDataDate().toString()
												.substring(0, 7)
										+ "</td><td>" + "</tr>");
							} else {
								out.println("<tr><td><input name=\"subBox\" type=\"checkbox\" value=\""
										+ o.getFileName()
										+ "\"/></td><td>"
										+ o.getFileName()
										+ "</td><td>"
										+ o.getDataDate().toString()
												.substring(0, 7)
										+ "</td><td>" + "</tr>");
							}

						}

						nn = 0;
						out.println("</table>");
						out.println("</div>");
						out.println("<input type=\"submit\" value=\"下载\" ></input>");
						out.println("</form>");
					}

				} catch (Exception ex) {

					System.out.println(ex.toString());
				} finally {

				}
			}

			if (reviewType.equals("AR")) {

				try {
					List<ReviewAnnualFile> result1 = (List<ReviewAnnualFile>) request
							.getSession().getAttribute("result1");
					if (result1.isEmpty()) {
						out.println("<p>" + "年评" + dateStartString + " ~ "
								+ dateEndString + " 查询结果为空</p>");
					} else {

						out.println("<form action=\"/scqz/review/ExcelFileDownload\" method=\"post\">");
						out.println("<div>");
						out.println("<input id=\"checkAll\" type=\"checkbox\">全选</input>");

						out.println("<table class=\"table_b\" >");
						out.println("<tr><td></td>"
								+ "<td><strong>文件名</strong></td>"

								+ "<td><strong>报告日期（YYYY）</strong></td>"

								+ "</tr>");

						int nn = 1;
						for (ReviewAnnualFile o : result1) {

							nn = nn + 1;
							if (nn % 2 == 0) {
								out.println("<tr class=\"tr1\"><td ><input name=\"subBox\" type=\"checkbox\" value=\""
										+ o.getFileName()
										+ "\"/></td><td>"
										+ o.getFileName()
										+ "</td><td>"
										+ o.getDataDate().toString()
												.substring(0, 4)
										+ "</td><td>" + "</tr>");
							} else {
								out.println("<tr><td><input name=\"subBox\" type=\"checkbox\" value=\""
										+ o.getFileName()
										+ "\"/></td><td>"
										+ o.getFileName()
										+ "</td><td>"
										+ o.getDataDate().toString()
												.substring(0, 4)
										+ "</td><td>" + "</tr>");
							}

						}
						out.println("</table>");
						out.println("</div>");
						out.println("<input type=\"submit\" value=\"下载\" ></input>");
						out.println("</form>");

					}
				} catch (Exception ex) {

					System.out.println(ex.toString());
				} finally {

				}

			}
		}
	%>

</div>
<%@ include file="/includeFile/footer.jsp"%>
