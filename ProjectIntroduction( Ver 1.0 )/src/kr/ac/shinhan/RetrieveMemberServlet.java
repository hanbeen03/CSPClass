package kr.ac.shinhan;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class RetrieveMemberServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException { 
			
			
		String url = "/changeservlet";
		String url_2 = "/removeservlet";
			
		PersistenceManager pm = MyPersistenceManager.getManager();
		Query  qry = pm.newQuery(TeamMember.class);
		//@SuppressWarnings("unchecked")
		List<TeamMember> memberList = (List<TeamMember>) qry.execute();
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		//resp.getWriter().println("aaaaa");
		resp.getWriter().println("<table border ='1'>");
		
		for(TeamMember tm : memberList)
		{
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td>" + "<a href=" + url + "?name=" +tm.getName() + ">" + tm.getName() + "</a>" + "</td>" +"<td>" + tm.getHakbun() + "</td>"
					+"<td>" + tm.getPhoneNumber() + "</td>" +"<td>" + tm.getEmail() + "</td>"
					+"<td>" + tm.getKakaoId() + "</td>" +"<td>" + tm.getTeamLeader() + "</td>"
					+"<td>" + tm.getHubId() + "</td>" + "<td>" + "<a href=" + url_2 + "?key=" + tm.getKey() + ">" + "ªË¡¶" + "</td>");
			
			
			resp.getWriter().println("</tr>");
		}
		
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}
