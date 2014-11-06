package servlet.report;

import java.io.File;
import java.io.FileOutputStream;
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

import org.hibernate.Transaction;

import dao.ReportMonthly;
import dao.ReportMonthlyDAO;

@WebServlet(name = "MonthlyReport", urlPatterns = { "/report/MonthlyReport" })
@MultipartConfig
public class MonthlyReportServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileNameExtractorRegex = "filename=\".+\"";
	/**
	 * Constructor of the object.
	 */
	public MonthlyReportServlet() {
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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("<br/>");

		//out.println(request.getParameter("stationid"));
		//out.println(request.getParameter("date"));

		try {
			String path = getServletContext().getRealPath("/upload");
			Part p = request.getPart("file");
			String fname = getFileName(p);
			InputStream is = null;
			FileOutputStream os = null;

			File f = new File(path + File.separatorChar + fname);
			//out.println(path + File.separatorChar + fname);
			is = p.getInputStream();
			// FileWriter fw = new FileWriter(f);
			int i = is.available();
			byte[] b = new byte[i];
			is.read(b);
			//os = new FileOutputStream(f);
			//os.write(b);
			//os.close();
			
			ReportMonthlyDAO dao = new ReportMonthlyDAO();
			Transaction trans = dao.getSession().beginTransaction();
			
			ReportMonthly bean = new ReportMonthly();
			
			System.out.println(request.getParameter("stationid"));
			String[] stations = request.getParameter("stationid").split("_");
			String stationId = stations[0];
			String stationName = stations[1];
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = request.getParameter("date");
			Date date = sdf.parse(dateString);
			String dateStringSub = dateString.substring(0, 4)+dateString.substring(5, 7);
			//out.println(dateStringSub);
			bean.setRmFile(b);
			bean.setRmStationid(stationId);
			bean.setRmStationname(stationName);
			bean.setDateDate(date);
			bean.setRmFilename(stationId+"MR"+dateStringSub);
			dao.save(bean);
			trans.commit();
			dao.getSession().close();
			

			// p.write(fname);
			//out.println(p.getContentType());
			//out.println(fname);
			// out.println(request.getContextPath());
			// out.println(getServletContext().getRealPath("/"));
			//request.getSession().setAttribute("fname", "upload/" + fname);
			//response.sendRedirect(request.getContextPath()+ "/test/showphoto.jsp");
		} catch (Exception ex) {
			System.out.println(ex.toString());
		} finally {

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

	public String getFileName(Part part) {

		String contentDesc = part.getHeader("content-disposition");
		System.out.println(contentDesc);
		String fileName = null;
		Pattern pattern = Pattern.compile(fileNameExtractorRegex);
		Matcher matcher = pattern.matcher(contentDesc);
		if (matcher.find()) {
			fileName = matcher.group();
			System.out.println(fileName);
			fileName = fileName.substring(10, fileName.length() - 1);
			System.out.println(fileName);
		}
		return fileName;
	}

}
