package servlet.review;

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

import dao.*;
@MultipartConfig
@WebServlet(name = "ExcelFileUpload", urlPatterns = { "/review/ExcelFileUpload" })
public class ExcelFileUploadServlet extends HttpServlet {
	
	
	private String fileNameExtractorRegex = "filename=\".+\"";
	/**
	 * Constructor of the object.
	 */
	public ExcelFileUploadServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
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
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
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
		/*out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");*/
		
		
		try {
			
			Part p = request.getPart("file");
			InputStream is = null;
			String reviewType = request.getParameter("reviewtype");
			String dateString = request.getParameter("date");
			

			is = p.getInputStream();
			int i = is.available();
			byte[] b = new byte[i];
			is.read(b);
			
			if (!reviewType.isEmpty() && reviewType.equals("MR")) {
				
				ReviewMonthlyFileDAO dao = new ReviewMonthlyFileDAO();
				Transaction trans = dao.getSession().beginTransaction();
				
				ReviewMonthlyFile bean = new ReviewMonthlyFile();
				ReviewMonthlyFile result = null;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
				Date date = sdf.parse(dateString);
				String dateStringSub = dateString.substring(0, 4)
						+ dateString.substring(5, 7);
				//out.print(dateStringSub);
				String fileNameString = reviewType + dateStringSub;
				
				result = dao.findById(fileNameString);
				
				if(result == null){
					bean.setDataDate(date);
					bean.setFileBlob(b);
					bean.setFileName(fileNameString);
					dao.save(bean);
					trans.commit();
					dao.getSession().close();
				}else{
					result.setFileBlob(b);
					dao.getSession().flush();
					trans.commit();
					dao.getSession().close();
				}
				
				
			}else{
				
				ReviewAnnualFileDAO dao = new ReviewAnnualFileDAO();
				Transaction trans = dao.getSession().beginTransaction();
				
				ReviewAnnualFile bean = new ReviewAnnualFile();
				ReviewAnnualFile result = null;
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
				Date date = sdf.parse(dateString);
				String dateStringSub = dateString.substring(0, 4);
				//out.print(dateStringSub);
				String fileNameString = reviewType + dateStringSub;
				
				result = dao.findById(fileNameString);
				
				if(result == null){
					bean.setDataDate(date);
					bean.setFileBlob(b);
					bean.setFileName(fileNameString);
					dao.save(bean);
					trans.commit();
					dao.getSession().close();
				}else{
					result.setFileBlob(b);
					dao.getSession().flush();
					trans.commit();
					dao.getSession().close();
				}
				
			}
			
		}catch (Exception ex) {
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
	 * @throws ServletException if an error occurs
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
			// System.out.println(fileName);
			fileName = fileName.substring(10, fileName.length() - 1);
			// System.out.println(fileName);
		}
		return fileName;
	}
	

}
