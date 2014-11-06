/*package servlet.review;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Transaction;

import dao.*;

@WebServlet(name = "ExcelUpload", urlPatterns = { "/review/ExcelUpload" })
@MultipartConfig
public class ExcelUPloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String fileNameExtractorRegex = "filename=\".+\"";

	*//**
	 * Constructor of the object.
	 *//*
	public ExcelUPloadServlet() {
		super();
	}

	*//**
	 * Destruction of the servlet. <br>
	 *//*
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	*//**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 *//*
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	*//**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 *//*
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		
		 * out.print("    This is "); out.print(this.getClass());
		 * out.println(", using the POST method");
		 

		try {
			
			
			Part p = request.getPart("file");
			InputStream is = null;
			is = p.getInputStream();

			Workbook wb = WorkbookFactory.create(is);
			Sheet sheet = wb.getSheetAt(0);

			String reviewType = request.getParameter("reviewtype");
			
			String pointId = null;
			String itemId = null;
			String stationId;
			double sequentialityRatio;
			double integrityRatio;

			if (!reviewType.isEmpty() && reviewType.equals("MR")) {
				ReviewMonthlyDAO dao = new ReviewMonthlyDAO();
				Transaction trans = dao.getSession().beginTransaction();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				String dateString = request.getParameter("date");
				Date date = sdf.parse(dateString);

				Row row = null;
				out.print(sheet.getLastRowNum());
				for (int i = 2; i <= sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					ReviewMonthly bean = new ReviewMonthly();
					ReviewMonthly result = null;

					

					stationId = String.valueOf((int) row.getCell(1)
							.getNumericCellValue());

					if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {

						pointId = String.valueOf((int) row.getCell(3)
								.getNumericCellValue());
					} else {
						pointId = row.getCell(3).getStringCellValue();
					}

					if (row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
						itemId = String.valueOf((int) row.getCell(8)
								.getNumericCellValue());
					} else {
						itemId = row.getCell(8).getStringCellValue();
					}
					
					if (row.getCell(9).getCellType() == Cell.CELL_TYPE_NUMERIC)
						sequentialityRatio = row.getCell(9)
								.getNumericCellValue();
					else
						sequentialityRatio = -1.0;

					if (row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC)
						integrityRatio = row.getCell(10)
								.getNumericCellValue();
					else
						integrityRatio =-1.0;

					String dataIndex = stationId + "0" + pointId + itemId
							+ dateString.replace("-", "").subSequence(0, 6);

					result = dao.findById(dataIndex);

					if (result == null) {

						bean.setDataDate(date);

						bean.setStationName(row.getCell(0).getStringCellValue());

						bean.setStationId(stationId);

						bean.setPointName(row.getCell(2).getStringCellValue());

						bean.setPointId(pointId);

						bean.setInstruName(row.getCell(4).getStringCellValue());

						bean.setInstruVersion(row.getCell(5)
								.getStringCellValue());

						bean.setObserveType(row.getCell(6).getStringCellValue());

						bean.setItemName(row.getCell(7).getStringCellValue());

						bean.setItemId(itemId);
						
						bean.setSequentialityRatio(sequentialityRatio);
						
						bean.setIntegrityRatio(integrityRatio);

						bean.setIspre(row.getCell(11).getStringCellValue());

						bean.setNotes(row.getCell(12).getStringCellValue());

						bean.setSubject(row.getCell(13).getStringCellValue());

						bean.setDataIndex2(dataIndex);
						
						dao.save(bean);
					}else{
						result.setSequentialityRatio(sequentialityRatio);
						
						result.setIntegrityRatio(integrityRatio);
						
						dao.getSession().flush();
					}

					

				}
				trans.commit();
				dao.getSession().close();
			}
			if (!reviewType.isEmpty() && reviewType.equals("AR")) {
				ReviewAnnualDAO dao = new ReviewAnnualDAO();
				Transaction trans = dao.getSession().beginTransaction();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				String dateString = request.getParameter("date");
				Date date = sdf.parse(dateString);

				Row row = null;
				out.print(sheet.getLastRowNum());
				for (int i = 2; i <= sheet.getLastRowNum(); i++) {
					row = sheet.getRow(i);
					ReviewAnnual bean = new ReviewAnnual();
					ReviewAnnual result = null;

					stationId = String.valueOf((int) row.getCell(1)
							.getNumericCellValue());

					if (row.getCell(3).getCellType() == Cell.CELL_TYPE_NUMERIC) {

						pointId = String.valueOf((int) row.getCell(3)
								.getNumericCellValue());
					} else {
						pointId = row.getCell(3).getStringCellValue();
					}

					if (row.getCell(8).getCellType() == Cell.CELL_TYPE_NUMERIC) {
						itemId = String.valueOf((int) row.getCell(8)
								.getNumericCellValue());
					} else {
						itemId = row.getCell(8).getStringCellValue();
					}
					
					if (row.getCell(9).getCellType() == Cell.CELL_TYPE_NUMERIC)
						sequentialityRatio = row.getCell(9)
								.getNumericCellValue();
					else
						sequentialityRatio = -1.0;

					if (row.getCell(10).getCellType() == Cell.CELL_TYPE_NUMERIC)
						integrityRatio = row.getCell(10)
								.getNumericCellValue();
					else
						integrityRatio =-1.0;

					String dataIndex = stationId + "0" + pointId + itemId
							+ dateString.replace("-", "").subSequence(0, 4);

					result = dao.findById(dataIndex);

					if (result == null) {

						bean.setDataDate(date);

						bean.setStationName(row.getCell(0).getStringCellValue());

						bean.setStationId(stationId);

						bean.setPointName(row.getCell(2).getStringCellValue());

						bean.setPointId(pointId);

						bean.setInstruName(row.getCell(4).getStringCellValue());

						bean.setInstruVersion(row.getCell(5)
								.getStringCellValue());

						bean.setObserveType(row.getCell(6).getStringCellValue());

						bean.setItemName(row.getCell(7).getStringCellValue());

						bean.setItemId(itemId);
						
						bean.setSequentialityRatio(sequentialityRatio);
						
						bean.setIntegrityRatio(integrityRatio);

						bean.setIspre(row.getCell(11).getStringCellValue());

						bean.setNotes(row.getCell(12).getStringCellValue());

						bean.setSubject(row.getCell(13).getStringCellValue());

						bean.setDataIndex2(dataIndex);
						
						dao.save(bean);
					}else{
						result.setSequentialityRatio(sequentialityRatio);
						
						result.setIntegrityRatio(integrityRatio);
						
						dao.getSession().flush();
					}

				}
				trans.commit();
				dao.getSession().close();
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {

		}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	*//**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 *//*
	public void init() throws ServletException {
		// Put your code here
	}

	public String getFileName(Part part) {

		String contentDesc = part.getHeader("content-disposition");
		System.out.println(contentDesc);
		String fileName = null;
		Pattern pattern = Pattern.compile(fileNameExtractorRegex);
		Matcher matcher = pattern.matcher(contentDesc);
		if (matcher.find()) {
			fileName = matcher.group();
			// System.out.println(fileName);
			fileName = fileName.substring(10, fileName.length() - 1);
			// System.out.println(fileName);
		}
		return fileName;
	}

}
*/