package servlet.review;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tools.zip.*;

import dao.*;

@WebServlet(name = "ExcelFileDownload", urlPatterns = { "/review/ExcelFileDownload" })
public class ExcelFileDownloadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ExcelFileDownloadServlet() {
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

		String[] fileNames = request.getParameterValues("subBox");
		String fileName = null;
		String fn = null;

		String reviewType = (String) request.getSession().getAttribute(
				"reviewtype");

		if (reviewType.equals("MR")) {

			ReviewMonthlyFile result = null;
			ReviewMonthlyFileDAO dao = new ReviewMonthlyFileDAO();
			dao.getSession().beginTransaction();
			ZipOutputStream zipOut = null;
			zipOut = new ZipOutputStream(new FileOutputStream(Save_Location
					+ ".zip"));

			for (int i = 0; i < fileNames.length; i++) {

				fileName = fileNames[i];
				result = dao.findById(fileName);
				fn = Save_Location + File.separatorChar + fileName + ".xls";
				zipOut.putNextEntry(new ZipEntry(fileName + ".xls"));
				zipOut.write(result.getFileBlob());
			}

			zipOut.flush();
			zipOut.close();

			dao.getSession().close();

			response.sendRedirect("/scqz/" + tmpDirName + ".zip");

		} else {

			ReviewAnnualFile result = null;
			ReviewAnnualFileDAO dao = new ReviewAnnualFileDAO();
			dao.getSession().beginTransaction();
			ZipOutputStream zipOut = null;
			zipOut = new ZipOutputStream(new FileOutputStream(Save_Location
					+ ".zip"));

			for (int i = 0; i < fileNames.length; i++) {

				fileName = fileNames[i];
				result = dao.findById(fileName);
				fn = Save_Location + File.separatorChar + fileName + ".xls";
				zipOut.putNextEntry(new ZipEntry(fileName + ".xls"));
				zipOut.write(result.getFileBlob());
			}

			zipOut.flush();
			zipOut.close();

			dao.getSession().close();

			response.sendRedirect("/scqz/" + tmpDirName + ".zip");

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

}
