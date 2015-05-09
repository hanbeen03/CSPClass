package kr.ac.shinhan;

import java.io.IOException;
//import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RemoveServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		
		Long key = Long.parseLong(req.getParameter("key"));
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		TeamMember m = pm.getObjectById(TeamMember.class,key);
		pm.deletePersistent(m); 

		//pm.close();
		
		resp.getWriter().println("<td>" + "<a href='index.html'>" + "돌아가기" + "</a>" + "</td>");
		
		
	}
}
