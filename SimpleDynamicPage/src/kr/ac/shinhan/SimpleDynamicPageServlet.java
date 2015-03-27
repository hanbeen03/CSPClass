package kr.ac.shinhan;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SimpleDynamicPageServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		int sum=0;
		for(int i=0; i<=10; i++) {
			sum = sum + i;
		}
		
		resp.setContentType("text/plain");
		resp.getWriter().println("<html> <body> " + 
							"sum = " + sum + new Date() + "</body> </html>");
	}
}
