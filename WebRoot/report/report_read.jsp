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
</script> 

	<div id="main">
		<h1>前兆台网运行报告查询</h1>
		<a title="点击进入报告提交页面" href="/scqz/report/report_up.jsp">报告提交</a>
		<p class="tag">本页面提供前兆运行月报和前兆运行年报的查询服务，点击上方的“报告提交”进入提交报告页面</p>
		<p class="tag2">
		*点击查询结果的左侧方框可选择下载打包的报告文件
		</p>
		<%
			String reportType = null;

			String dateStartString = null;
			String dateEndString = null;
			String stationId = null;
			String stationName = null;
			reportType = (String) request.getSession().getAttribute(
					"reporttype");
			dateStartString = (String) request.getSession().getAttribute(
					"dateStartString");
			dateEndString = (String) request.getSession().getAttribute(
					"dateEndString");
			stationName = (String) request.getSession().getAttribute(
					"stationName");

			stationId = (String) request.getSession().getAttribute("stationId");
		%>

		<form action="/scqz/report/ReportRead" method="post">
			<label>报告类型（必填）</label> <select id="sel" name="reporttype">

				<option value="MR"
					<%if (reportType != null)
				if (reportType.equals("MR"))
					out.print("selected=\"selected\"");%>>月报</option>
				<option value="AR"
					<%if (reportType != null)
				if (reportType.equals("AR"))
					out.print("selected=\"selected\"");%>>年报</option>
			</select><br /> <label>选择台站（必填）</label> <select name="stationid">
				<option
					<%if (stationId != null)
				if (stationId.equals("51"))
					out.print(" selected=\"selected\" ");%>
					value="51_四川">51四川</option>
				<option
					<%if (stationId != null)
				if (stationId.equals("51001"))
					out.print(" selected=\"selected\" ");%>
					value="51001_成都">51001成都</option>
				<option value="51002_泸州地震台"
					<%if (stationId != null)
				if (stationId.equals("51002"))
					out.print(" selected=\"selected\" ");%>>51002泸州地震台</option>
				<option value="51003_松潘"
					<%if (stationId != null)
				if (stationId.equals("51003"))
					out.print(" selected=\"selected\" ");%>>51003松潘</option>
				<option value="51004_仁和"
					<%if (stationId != null)
				if (stationId.equals("51004"))
					out.print(" selected=\"selected\" ");%>>51004仁和</option>
				<option value="51005_南山"
					<%if (stationId != null)
				if (stationId.equals("51005"))
					out.print(" selected=\"selected\" ");%>>51005南山</option>
				<option value="51006_红格"
					<%if (stationId != null)
				if (stationId.equals("51006"))
					out.print(" selected=\"selected\" ");%>>51006红格</option>
				<option value="51007_西昌地震台"
					<%if (stationId != null)
				if (stationId.equals("51007"))
					out.print(" selected=\"selected\" ");%>>51007西昌地震台</option>
				<option value="51008_西昌太和"
					<%if (stationId != null)
				if (stationId.equals("51008"))
					out.print(" selected=\"selected\" ");%>>51008西昌太和</option>
				<option value="51009_小庙台"
					<%if (stationId != null)
				if (stationId.equals("51009"))
					out.print(" selected=\"selected\" ");%>>51009小庙台</option>
				<option value="51010_姑咱地震台"
					<%if (stationId != null)
				if (stationId.equals("51010"))
					out.print(" selected=\"selected\" ");%>>51010姑咱地震台</option>
				<option value="51011_姑咱水化"
					<%if (stationId != null)
				if (stationId.equals("51011"))
					out.print(" selected=\"selected\" ");%>>51011姑咱水化</option>
				<option value="51012_甘孜地震台"
					<%if (stationId != null)
				if (stationId.equals("51012"))
					out.print(" selected=\"selected\" ");%>>51012甘孜地震台</option>
				<option value="51013_炉霍虾拉沱"
					<%if (stationId != null)
				if (stationId.equals("51013"))
					out.print(" selected=\"selected\" ");%>>51013炉霍虾拉沱</option>
				<option value="51014_康定地震台"
					<%if (stationId != null)
				if (stationId.equals("51014"))
					out.print(" selected=\"selected\" ");%>>51014康定地震台</option>
				<option value="51015_道孚地震台"
					<%if (stationId != null)
				if (stationId.equals("51015"))
					out.print(" selected=\"selected\" ");%>>51015道孚地震台</option>
				<option value="51016_巴塘"
					<%if (stationId != null)
				if (stationId.equals("51016"))
					out.print(" selected=\"selected\" ");%>>51016巴塘</option>
				<option value="51017_乡城地震台"
					<%if (stationId != null)
				if (stationId.equals("51017"))
					out.print(" selected=\"selected\" ");%>>51017乡城地震台</option>
				<option value="51019_雅安"
					<%if (stationId != null)
				if (stationId.equals("51019"))
					out.print(" selected=\"selected\" ");%>>51019雅安</option>
				<option value="51020_江油"
					<%if (stationId != null)
				if (stationId.equals("51020"))
					out.print(" selected=\"selected\" ");%>>51020江油</option>
				<option value="51022_冕宁地震台"
					<%if (stationId != null)
				if (stationId.equals("51022"))
					out.print(" selected=\"selected\" ");%>>51022冕宁地震台</option>
				<option value="51023_昭觉地震台"
					<%if (stationId != null)
				if (stationId.equals("51023"))
					out.print(" selected=\"selected\" ");%>>51023昭觉地震台</option>
				<option value="51025_盐源地震台"
					<%if (stationId != null)
				if (stationId.equals("51025"))
					out.print(" selected=\"selected\" ");%>>51025盐源地震台</option>
				<option value="51026_松潘川主寺"
					<%if (stationId != null)
				if (stationId.equals("51026"))
					out.print(" selected=\"selected\" ");%>>51026松潘川主寺</option>
				<option value="51027_汶川"
					<%if (stationId != null)
				if (stationId.equals("51027"))
					out.print(" selected=\"selected\" ");%>>51027汶川</option>
				<option value="51028_茂县"
					<%if (stationId != null)
				if (stationId.equals("51028"))
					out.print(" selected=\"selected\" ");%>>51028茂县</option>
				<option value="51033_理县地震台"
					<%if (stationId != null)
				if (stationId.equals("51033"))
					out.print(" selected=\"selected\" ");%>>51033理县地震台</option>
				<option value="51042_什邡金河地震台"
					<%if (stationId != null)
				if (stationId.equals("51042"))
					out.print(" selected=\"selected\" ");%>>51042什邡金河地震台</option>
				<option value="51045_石棉县防震减灾局"
					<%if (stationId != null)
				if (stationId.equals("51045"))
					out.print(" selected=\"selected\" ");%>>51045石棉县防震减灾局</option>
				<option value="51047_马边"
					<%if (stationId != null)
				if (stationId.equals("51047"))
					out.print(" selected=\"selected\" ");%>>51047马边</option>
				<option value="51048_八一四地震台"
					<%if (stationId != null)
				if (stationId.equals("51048"))
					out.print(" selected=\"selected\" ");%>>51048八一四地震台</option>
				<option value="51049_峨眉交大台"
					<%if (stationId != null)
				if (stationId.equals("51049"))
					out.print(" selected=\"selected\" ");%>>51049峨眉交大台</option>
				<option value="51053_马兰山地震台"
					<%if (stationId != null)
				if (stationId.equals("51053"))
					out.print(" selected=\"selected\" ");%>>51053马兰山地震台</option>
				<option value="51054_攀枝花乌龟井"
					<%if (stationId != null)
				if (stationId.equals("51054"))
					out.print(" selected=\"selected\" ");%>>51054攀枝花乌龟井</option>
				<option value="51056_甘孜川15井"
					<%if (stationId != null)
				if (stationId.equals("51056"))
					out.print(" selected=\"selected\" ");%>>51056甘孜川15井</option>
				<option value="51057_小金川07井"
					<%if (stationId != null)
				if (stationId.equals("51057"))
					out.print(" selected=\"selected\" ");%>>51057小金川07井</option>
				<option value="51058_安县川09井"
					<%if (stationId != null)
				if (stationId.equals("51058"))
					out.print(" selected=\"selected\" ");%>>51058安县川09井</option>
				<option value="51059_江油川10井"
					<%if (stationId != null)
				if (stationId.equals("51059"))
					out.print(" selected=\"selected\" ");%>>51059江油川10井</option>
				<option value="51060_德阳"
					<%if (stationId != null)
				if (stationId.equals("51060"))
					out.print(" selected=\"selected\" ");%>>51060德阳</option>
				<option value="51061_蒲江川11井"
					<%if (stationId != null)
				if (stationId.equals("51061"))
					out.print(" selected=\"selected\" ");%>>51061蒲江川11井</option>
				<option value="51062_邛崃"
					<%if (stationId != null)
				if (stationId.equals("51062"))
					out.print(" selected=\"selected\" ");%>>51062邛崃</option>
				<option value="51063_石棉川02井"
					<%if (stationId != null)
				if (stationId.equals("51063"))
					out.print(" selected=\"selected\" ");%>>51063石棉川02井</option>
				<option value="51064_石棉川20井"
					<%if (stationId != null)
				if (stationId.equals("51064"))
					out.print(" selected=\"selected\" ");%>>51064石棉川20井</option>
				<option value="51065_西昌川03井"
					<%if (stationId != null)
				if (stationId.equals("51065"))
					out.print(" selected=\"selected\" ");%>>51065西昌川03井</option>
				<option value="51066_会理川06井"
					<%if (stationId != null)
				if (stationId.equals("51066"))
					out.print(" selected=\"selected\" ");%>>51066会理川06井</option>
				<option value="51067_会理地震台"
					<%if (stationId != null)
				if (stationId.equals("51067"))
					out.print(" selected=\"selected\" ");%>>51067会理地震台</option>
				<option value="51068_攀枝花川05井"
					<%if (stationId != null)
				if (stationId.equals("51068"))
					out.print(" selected=\"selected\" ");%>>51068攀枝花川05井</option>
				<option value="51069_南溪"
					<%if (stationId != null)
				if (stationId.equals("51069"))
					out.print(" selected=\"selected\" ");%>>51069南溪</option>
				<option value="51070_泸州川13井"
					<%if (stationId != null)
				if (stationId.equals("51070"))
					out.print(" selected=\"selected\" ");%>>51070泸州川13井</option>
				<option value="51071_理塘川51井"
					<%if (stationId != null)
				if (stationId.equals("51071"))
					out.print(" selected=\"selected\" ");%>>51071理塘川51井</option>
				<option value="51072_乡城52泉"
					<%if (stationId != null)
				if (stationId.equals("51072"))
					out.print(" selected=\"selected\" ");%>>51072乡城52泉</option>
				<option value="51073_道孚53泉"
					<%if (stationId != null)
				if (stationId.equals("51073"))
					out.print(" selected=\"selected\" ");%>>51073道孚53泉</option>
				<option value="51074_道孚54泉"
					<%if (stationId != null)
				if (stationId.equals("51074"))
					out.print(" selected=\"selected\" ");%>>51074道孚54泉</option>
				<option value="51075_康定二道桥55泉"
					<%if (stationId != null)
				if (stationId.equals("51075"))
					out.print(" selected=\"selected\" ");%>>51075康定二道桥55泉</option>
				<option value="51076_康定龙头沟57泉"
					<%if (stationId != null)
				if (stationId.equals("51076"))
					out.print(" selected=\"selected\" ");%>>51076康定龙头沟57泉</option>
				<option value="51077_巴塘305K58泉"
					<%if (stationId != null)
				if (stationId.equals("51077"))
					out.print(" selected=\"selected\" ");%>>51077巴塘305K58泉</option>
				<option value="51078_昭觉竹核61泉"
					<%if (stationId != null)
				if (stationId.equals("51078"))
					out.print(" selected=\"selected\" ");%>>51078昭觉竹核61泉</option>
				<option value="51079_泸定63泉"
					<%if (stationId != null)
				if (stationId.equals("51079"))
					out.print(" selected=\"selected\" ");%>>51079泸定63泉</option>
				<option value="51105_巴中"
					<%if (stationId != null)
				if (stationId.equals("51105"))
					out.print(" selected=\"selected\" ");%>>51105巴中</option>
				<option value="51163_攀枝花地龙井"
					<%if (stationId != null)
				if (stationId.equals("51163"))
					out.print(" selected=\"selected\" ");%>>51163攀枝花地龙井</option>
				<option value="51222_姑咱核桃湾"
					<%if (stationId != null)
				if (stationId.equals("51222"))
					out.print(" selected=\"selected\" ");%>>51222姑咱核桃湾</option>
				<option value="51224_崇州"
					<%if (stationId != null)
				if (stationId.equals("51224"))
					out.print(" selected=\"selected\" ");%>>51224崇州</option>
				<option value="51225_天全"
					<%if (stationId != null)
				if (stationId.equals("51225"))
					out.print(" selected=\"selected\" ");%>>51225天全</option>
				<option value="51303_松潘泉点"
					<%if (stationId != null)
				if (stationId.equals("51303"))
					out.print(" selected=\"selected\" ");%>>51303松潘泉点</option>
				<option value="51304_金河地震台"
					<%if (stationId != null)
				if (stationId.equals("51304"))
					out.print(" selected=\"selected\" ");%>>51304金河地震台</option>
				<option value="51306_泸沽湖地震台"
					<%if (stationId != null)
				if (stationId.equals("51306"))
					out.print(" selected=\"selected\" ");%>>51306泸沽湖地震台</option>
				<option value="51310_石门坎"
					<%if (stationId != null)
				if (stationId.equals("51310"))
					out.print(" selected=\"selected\" ");%>>51310石门坎</option>
				<option value="51311_木里磁通门点"
					<%if (stationId != null)
				if (stationId.equals("51311"))
					out.print(" selected=\"selected\" ");%>>51311木里磁通门点</option>
				<option value="51312_平地磁通门点"
					<%if (stationId != null)
				if (stationId.equals("51312"))
					out.print(" selected=\"selected\" ");%>>51312平地磁通门点</option>
				<option value="51313_会理磁通门点"
					<%if (stationId != null)
				if (stationId.equals("51313"))
					out.print(" selected=\"selected\" ");%>>51313会理磁通门点</option>
				<option value="51314_卫城磁通门点"
					<%if (stationId != null)
				if (stationId.equals("51314"))
					out.print(" selected=\"selected\" ");%>>51314卫城磁通门点</option>
				<option value="51316_宁南松新"
					<%if (stationId != null)
				if (stationId.equals("51316"))
					out.print(" selected=\"selected\" ");%>>51316宁南松新</option>
				<option value="51317_美姑磁通门点"
					<%if (stationId != null)
				if (stationId.equals("51317"))
					out.print(" selected=\"selected\" ");%>>51317美姑磁通门点</option>
				<option value="51318_昭觉磁通门测点"
					<%if (stationId != null)
				if (stationId.equals("51318"))
					out.print(" selected=\"selected\" ");%>>51318昭觉磁通门测点</option>
				<option value="51321_姑咱二道桥"
					<%if (stationId != null)
				if (stationId.equals("51321"))
					out.print(" selected=\"selected\" ");%>>51321姑咱二道桥</option>
				<option value="51322_姑咱龙头沟"
					<%if (stationId != null)
				if (stationId.equals("51322"))
					out.print(" selected=\"selected\" ");%>>51322姑咱龙头沟</option>
				<option value="51325_泸沽川23井"
					<%if (stationId != null)
				if (stationId.equals("51325"))
					out.print(" selected=\"selected\" ");%>>51325泸沽川23井</option>
				<option value="51330_普格川65泉"
					<%if (stationId != null)
				if (stationId.equals("51330"))
					out.print(" selected=\"selected\" ");%>>51330普格川65泉</option>
				<option value="51332_西昌川32井"
					<%if (stationId != null)
				if (stationId.equals("51332"))
					out.print(" selected=\"selected\" ");%>>51332西昌川32井</option>
				<option value="51351_自贡"
					<%if (stationId != null)
				if (stationId.equals("51351"))
					out.print(" selected=\"selected\" ");%>>51351自贡</option>
			</select> <br />

			<%
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			%>
			<label>起始日期（必填）</label> <input type=text name="date1"
				onClick="WdatePicker()"
				value="<%if (dateStartString != null)
				out.print(dateStartString);
			else
				out.print(formatter.format(new Date()));%>" />
			<br /> <label>结束日期（必填）</label> <input type=text name="date2"
				onClick="WdatePicker()"
				value="<%if (dateEndString != null)
				out.print(dateEndString);
			else
				out.print(formatter.format(new Date()));%>" />
			<br /> <input type="submit" value="提交" />
		</form>
		<br />
		<br />
		
		<%
			if (reportType == null) {

			} else {

				if (reportType.equals("MR")) {
					try {
						List<ReportMonthly> result = (List<ReportMonthly>) request
								.getSession().getAttribute("result");
						if (result.isEmpty()) {
							out.println("<p><" + stationId + ">" + stationName
									+ " 月报(" + dateStartString + " ~ "
									+ dateEndString + ") 查询结果为空</p>");
						} else {

							out.println("<form action=\"/scqz/report/ReportDownload\" method=\"post\">");
							out.println("<div>");
							out.println("<input id=\"checkAll\" type=\"checkbox\">全选</input>");

							out.println("<table width=\"800\" >");
							out.println("<tr><td></td>"
									+ "<td><strong>台站</strong></td>"
									+ "<td><strong>文件名</strong></td>"
									+ "<td><strong>提交人</strong></td>"
									+ "<td><strong>报告日期（YYYY-MM）</strong></td>"
									+ "<td><strong>提交日期（YYYY-MM-DD）</strong></td>"

									+ "</tr>");
							for (ReportMonthly o : result) {
								out.println("<tr><td><input name=\"subBox\" type=\"checkbox\" value=\""
										+ o.getRmFilename()
										+ "\"/></td><td>"
										+ o.getRmStationname()
										+ "</td><td>"
										+ o.getRmFilename()
										+ "</td><td>"
										+ o.getSubmitter()
										+ "</td><td>"
										+ o.getDateDate().toString()
												.substring(0, 7)
										+ "</td><td>"
										+ o.getDateEntered().toString()
										+ "</td><td>"

										+ "</tr>");

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

				if (reportType.equals("AR")) {
					try {
						List<ReportYear> result = (List<ReportYear>) request
								.getSession().getAttribute("result");
						if (result.isEmpty()) {
							out.println("<p>" + stationId + stationName + "年报 "
									+ dateStartString + " ~ " + dateEndString
									+ " 查询结果为空</p>");
						} else {

							out.println("<form action=\"/scqz/report/ReportDownload\" method=\"post\">");
							out.println("<div>");
							out.println("<input id=\"checkAll\" type=\"checkbox\">全选</input>");
							out.println("<table width=\"700\" >");
							out.println("<tr><td></td>"
									+ "<td><strong>台站</strong></td>"
									+ "<td><strong>文件名</strong></td>"
									+ "<td><strong>提交人</strong></td>"
									+ "<td><strong>报告日期（YYYY）</strong></td>"
									+ "<td><strong>提交日期（YYYY-MM-DD）</strong></td>"

									+ "</tr>");
							for (ReportYear o : result) {
								out.println("<tr><td><input name=\"subBox\" type=\"checkbox\" value=\""
										+ o.getRyFilename()
										+ "\"/></td><td>"
										+ o.getRyStationname()
										+ "</td><td>"
										+ o.getRyFilename()
										+ "</td><td>"
										+ o.getSubmitter()
										+ "</td><td>"
										+ o.getDateDate().toString()
												.substring(0, 4)
										+ "</td><td>"
										+ o.getDateEntered().toString()
										+ "</td><td>"

										+ "</tr>");

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




	
<%@ include file="/includeFile/footer.jsp"%> 