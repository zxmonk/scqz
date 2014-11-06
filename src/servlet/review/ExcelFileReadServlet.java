package servlet.review;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import dao.*;

@WebServlet(name = "ExcelFileRead", urlPatterns = { "/review/ExcelFileRead" })
@MultipartConfig
public class ExcelFileReadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ExcelFileReadServlet() {
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

		response.setContentType("text/html;charset=UTF-8");
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

		try {
			String reviewType = request.getParameter("reviewtype");

			if (!reviewType.isEmpty() && reviewType.equals("MR")) {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				String dateStartString = request.getParameter("date1");
				Date dateStart = sdf.parse(dateStartString);
				String dateEndString = request.getParameter("date2");
				Date dateEnd = sdf.parse(dateEndString);
				
				ReviewMonthlyFileDAO dao = new ReviewMonthlyFileDAO();
				Transaction trans = dao.getSession().beginTransaction();
				List<ReviewMonthlyFile> result = null;
				
				result = dao.findbyDateDateRange(dateStart, dateEnd);
				dao.getSession().close();
				
				request.getSession().setAttribute("result", result);
				request.getSession().setAttribute("dateStartString",dateStartString);
				request.getSession().setAttribute("dateEndString",dateEndString);
				request.getSession().setAttribute("reviewtype", reviewType);
				response.sendRedirect("/scqz/review/excel_read.jsp");
				
			} else {
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				String dateStartString = request.getParameter("date1");
				Date dateStart = sdf.parse(dateStartString);
				String dateEndString = request.getParameter("date2");
				Date dateEnd = sdf.parse(dateEndString);
				
				ReviewAnnualFileDAO dao = new ReviewAnnualFileDAO();
				Transaction trans = dao.getSession().beginTransaction();
				List<ReviewAnnualFile> result = null;
				
				result = dao.findbyDateDateRange(dateStart, dateEnd);
				dao.getSession().close();
				
				request.getSession().setAttribute("result", result);
				request.getSession().setAttribute("dateStart",dateStart);
				request.getSession().setAttribute("dateEnd",dateEnd);
				request.getSession().setAttribute("reviewtype", reviewType);
				response.sendRedirect("/scqz/review/excel_read.jsp");
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
