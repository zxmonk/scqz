package servlet.feedback;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebListener
// ��ʱ��ѯ�����ļ����е�ѹ���ļ���������µ��ļ��򡣡���
public class FeedbackServletContextListener implements ServletContextListener {

	public static final int LOOP_CYCLE = 1 * 60 * 1000; // �趨��ѯ����
	public static String filePath = "D:/mail_download";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		// Ӧ������ʱ����

		/*new javax.swing.Timer(LOOP_CYCLE, new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				try {
					System.out.println(new Date());
					File file = new File(filePath);
					for(String fileName:file.list()){
						System.out.println(fileName);
					}
					//��ȡ�ļ��������е��ļ�����������ձ�ɸѡ����
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}).start();*/
		
		

	}

	/**
	 * Destruction of the servlet. <br>
	 */

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
