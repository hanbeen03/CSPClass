package kr.ac.shinhan;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class RetrieveMemberServlet extends HttpServlet {
		public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException { 
			
			
		String url = "/changeservlet";
		String url_2 = "/removeservlet";
		String id;
			
		PersistenceManager pm = MyPersistenceManager.getManager();
		Query  qry = pm.newQuery(TeamMember.class);
		//@SuppressWarnings("unchecked")
		@SuppressWarnings("unchecked")
		List<TeamMember> memberList = (List<TeamMember>) qry.execute();
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		//resp.getWriter().println("aaaaa");
		resp.getWriter().println("<table border ='1'>");
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
			resp.getWriter().println("No session Available ...");
		} else {
			id = (String) session.getAttribute("id");
			
			resp.getWriter().println(id + "님 환영합니다.");
		}
		
		for(TeamMember tm : memberList)
		{
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td>" + "<a href=" + url + "?name=" +tm.getName() + ">" + tm.getName() + "</a>" + "</td>" +"<td>" + tm.getHakbun() + "</td>"
					+"<td>" + tm.getPhoneNumber() + "</td>" +"<td>" + tm.getEmail() + "</td>"
					+"<td>" + tm.getKakaoId() + "</td>" +"<td>" + tm.getTeamLeader() + "</td>"
					+"<td>" + tm.getHubId() + "</td>" + "<td>" + "<a href=" + url_2 + "?key=" + tm.getKey() + ">" + "삭제" + "</td>");
			
			
			resp.getWriter().println("</tr>");
		}
		
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}
