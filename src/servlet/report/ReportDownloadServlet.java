package servlet.report;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import dao.ReportMonthly;
import dao.ReportMonthlyDAO;
import dao.ReportYear;
import dao.ReportYearDAO;

import org.apache.tools.zip.*;

@WebServlet(name = "ReportDownload", urlPatterns = { "/report/ReportDownload" })
public class ReportDownloadServlet extends HttpServlet {

	private String contentType = "application/x-msdownload";
	private String enc = "utf-8";
	private String fileRoot = "";

	/**
	 * Constructor of the object.
	 */
	public ReportDownloadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
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
	 */
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

		/*
		 * String tmpDirName = request.getSession().getId().toString();
		 * 
		 * String Save_Location = getServletContext().getRealPath("/") +
		 * tmpDirName + "/";
		 * 
		 * try { if (!(new java.io.File(Save_Location).isDirectory())) //
		 * 如果文件夹不存在 { new java.io.File(Save_Location).mkdir(); // 不存在 excel //
		 * 文件夹，则建立此文件夹 new java.io.File(Save_Location + "gmcc//").mkdir(); new
		 * java.io.File(Save_Location + "gmcc//").delete();// 创建excel文件夹下名为 //
		 * gmcc 的文件夹 } else // 存在excel文件夹，则直接建立此文件夹 { new
		 * java.io.File(Save_Location + "gmcc//").mkdir(); // 创建 excel //
		 * 文件夹下名为gmcc的文件夹 } } catch (Exception e) { e.printStackTrace(); //
		 * 创建文件夹失败
		 * 
		 * // 在链接中使用URLEncoder编码，传递中文参数。 //
		 * 接收页面可以使用getParameter()取得该参数，页面的charset=GB2312。 // String
		 * ErrName=java.net.URLEncoder.encode("文件夹不存在。创建文件夹出错！"); //
		 * response.sendRedirect("errorpage.jsp?error="+ErrName); //跳转到错误页面
		 * return; }
		 */

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
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
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		/*
		 * out.print("    This is "); out.print(this.getClass());
		 * out.println(", using the POST method");
		 */

		String tmpDirName = request.getSession().getId().toString();

		Date date1 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

		tmpDirName += sdf.format(date1);

		String Save_Location = getServletContext().getRealPath("/")
				+ tmpDirName;

		/*
		 * try { if (!(new java.io.File(Save_Location).isDirectory())) { new
		 * java.io.File(Save_Location).mkdir();
		 * 
		 * } } catch (Exception e) { e.printStackTrace(); return; }
		 */

		String[] fileNames = null;
		fileNames = request.getParameterValues("subBox");
		if (fileNames == null) {
			response.sendRedirect("/scqz/report/report_read.jsp");
		} else {
			String fileName = null;
			String fn = null;

			String reportType = (String) request.getSession().getAttribute(
					"reporttype");

			// out.println(reportType);

			if (reportType.equals("MR")) {

				ReportMonthly result = null;
				ReportMonthlyDAO dao = new ReportMonthlyDAO();
				dao.getSession().beginTransaction();

				ZipOutputStream zipOut = null;
				zipOut = new ZipOutputStream(new FileOutputStream(Save_Location
						+ ".zip"));

				for (int i = 0; i < fileNames.length; i++) {

					fileName = fileNames[i];
					result = dao.findById(fileName);
					fn = Save_Location + File.separatorChar + fileName + ".doc";
					zipOut.putNextEntry(new ZipEntry(fileName + ".doc"));
					// FileOutputStream os = new FileOutputStream(fn);
					// os.write(result.getRmFile());
					// os.close();
					// InputStream is = null;
					// is.read(result.getRmFile());
					zipOut.write(result.getRmFile());

				}

				zipOut.flush();
				zipOut.close();
				// response.reset();
				// response.setContentType(contentType);
				// response.addHeader("Content-Disposition",
				// "attachment; filename=\"" + tmpDirName+".zip" + "\"");

				dao.getSession().close();

				response.sendRedirect("/scqz/" + tmpDirName + ".zip");

			} else {

				ReportYear result = null;

				ReportYearDAO dao = new ReportYearDAO();
				dao.getSession().beginTransaction();

				ZipOutputStream zipOut = null;
				zipOut = new ZipOutputStream(new FileOutputStream(Save_Location
						+ ".zip"));

				for (int i = 0; i < fileNames.length; i++) {

					fileName = fileNames[i];
					result = dao.findById(fileName);
					fn = Save_Location + File.separatorChar + fileName + ".doc";
					zipOut.putNextEntry(new ZipEntry(fileName + ".doc"));
					zipOut.write(result.getRyFile());
				}

				zipOut.flush();
				zipOut.close();
				// response.reset();
				// response.setContentType(contentType);
				// response.addHeader("Content-Disposition",
				// "attachment; filename=\"" + tmpDirName+".zip" + "\"");

				dao.getSession().close();
				response.sendRedirect("/scqz/" + tmpDirName + ".zip");
			}
		}

		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	/*
	 * public void zip(String inputFileName, String zipFileName) throws
	 * Exception { System.out.println(zipFileName); zip(zipFileName, new
	 * File(inputFileName)); }
	 * 
	 * private void zip(String zipFileName, File inputFile) throws Exception {
	 * ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
	 * zipFileName)); zip(out, inputFile, ""); System.out.println("zip done");
	 * out.close(); }
	 * 
	 * private void zip(ZipOutputStream out, File f, String base) throws
	 * Exception { if (f.isDirectory()) { // 判断是否为目录 File[] fl = f.listFiles();
	 * out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/")); base =
	 * base.length() == 0 ? "" : base + "/"; for (int i = 0; i < fl.length; i++)
	 * { zip(out, fl[i], base + fl[i].getName()); } } else { // 压缩目录中的所有文件
	 * out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
	 * FileInputStream in = new FileInputStream(f); int b;
	 * System.out.println(base); while ((b = in.read()) != -1) { out.write(b); }
	 * in.close(); }
	 * 
	 * }
	 */

}
