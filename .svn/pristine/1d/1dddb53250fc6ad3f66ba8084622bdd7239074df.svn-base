package servlet.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet(name="upload",urlPatterns={"/test/upload"})

@MultipartConfig

public class UploadServlet extends HttpServlet {
	
	
	private String fileNameExtractorRegex = "filename=\".+\"";
	/**
	 * Constructor of the object.
	 */
	public UploadServlet() {
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
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("<br/>");
		try{
			String path = getServletContext().getRealPath("/upload");
			Part p = request.getPart("file");
			String fname = getFileName(p);
			InputStream is =null;
			FileOutputStream os =null;
			
			File f = new File(path+File.separatorChar+fname);
			out.println(path+File.separatorChar+fname);
			is = p.getInputStream();
			//FileWriter fw = new FileWriter(f);
			int i = is.available();
			byte[] b= new byte[i];
			is.read(b);
			os = new FileOutputStream(f);
			os.write(b);
			os.close();
			
			//p.write(fname);
			out.println(p.getContentType());
			out.println(fname);
			//out.println(request.getContextPath());
			//out.println(getServletContext().getRealPath("/"));
			request.getSession().setAttribute("fname", "upload/"+fname);
			response.sendRedirect(request.getContextPath()+"/test/showphoto.jsp");
		}
		catch(Exception ex){
			System.out.println(ex.toString());
		}
		finally{
			
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
	
	
	public String getFileName(Part part){
		
		String contentDesc = part.getHeader("content-disposition");  
		System.out.println(contentDesc);
        String fileName = null;  
        Pattern pattern = Pattern.compile(fileNameExtractorRegex);  
        Matcher matcher = pattern.matcher(contentDesc);  
        if(matcher.find()){  
            fileName = matcher.group();  
            System.out.println(fileName);
            fileName = fileName.substring(10, fileName.length()-1);
            System.out.println(fileName);
        }  
        return fileName;
	}
	

}
