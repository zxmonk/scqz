package servlet.report;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;

import dao.ReportMonthly;
import dao.ReportMonthlyDAO;
import dao.ReportYear;
import dao.ReportYearDAO;

@WebServlet(name = "ReportRead", urlPatterns = { "/report/ReportRead" })
@MultipartConfig
public class ReportReadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReportReadServlet() {
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
		 * out.println(request.getParameter("reporttype"));
		 * out.println(request.getParameter("date1"));
		 * out.println(request.getParameter("date2"));
		 */

		try {

			String reportType = request.getParameter("reporttype");
			String[] stations = request.getParameter("stationid").split("_");
			String stationId = stations[0];
			String stationName = stations[1];

			if (!reportType.isEmpty() && reportType.equals("MR")) {
				
				request.getSession().removeAttribute("result");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				String dateStartString = request.getParameter("date1");
				Date dateStart = sdf.parse(dateStartString);
				String dateEndString = request.getParameter("date2");
				Date dateEnd = sdf.parse(dateEndString);

				ReportMonthlyDAO dao = new ReportMonthlyDAO();
				Transaction trans = dao.getSession().beginTransaction();
				
				List<ReportMonthly> result = null;

				result = dao.findbyDateDateRange(stationId, dateStart, dateEnd);
				trans.commit();
				dao.getSession().close();
				
				
				request.getSession().setAttribute("reporttype", reportType);
				request.getSession().setAttribute("result", result);
				request.getSession().setAttribute("dateStartString",dateStartString);
				request.getSession().setAttribute("dateEndString",dateEndString);
				request.getSession().setAttribute("stationId",stationId);
				request.getSession().setAttribute("stationName",stationName);
				
				response.sendRedirect("/scqz/report/report_read.jsp");

			} else {
				
				request.getSession().removeAttribute("result");
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				String dateStartString = request.getParameter("date1");
				Date dateStart = sdf.parse(dateStartString);
				String dateEndString = request.getParameter("date2");
				Date dateEnd = sdf.parse(dateEndString);
				
				ReportYearDAO dao = new ReportYearDAO();
				Transaction trans = dao.getSession().beginTransaction();
				
				List<ReportYear> result = null;
				
				result = dao.findbyDateDateRange(stationId, dateStart, dateEnd);
				trans.commit();
				dao.getSession().close();
				
				
				request.getSession().setAttribute("reporttype", reportType);
				request.getSession().setAttribute("result", result);
				request.getSession().setAttribute("dateStartString",dateStartString);
				request.getSession().setAttribute("dateEndString",dateEndString);
				request.getSession().setAttribute("stationId",stationId);
				request.getSession().setAttribute("stationName",stationName);
				
				response.sendRedirect("/scqz/report/report_read.jsp");
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
