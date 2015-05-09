package kr.ac.shinhan;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@SuppressWarnings("serial")
public class ChangeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		String text = "text";
		String name2 = "name";
		String hakbun = "hakbun";
		String phoneNumber = "phoneNumber";
		String email = "email";
		String kakaoId = "kakaoId";
		String checkbox = "checkbox";
		String teamLeader = "teamLeader";
		String hubId = "hubId";
		String submit = "submit";
		String first = "index.html"; 
		
		
		String name = req.getParameter("name");
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		Query  qry = pm.newQuery(TeamMember.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");
		//@SuppressWarnings("unchecked")
		List<TeamMember> memberList =  (List<TeamMember>) qry.execute(name);
		
		//resp.getWriter().println(name);
		
		TeamMember m = memberList.get(0);
		
		
		resp.getWriter().println("<html><body>");
		
		
		//resp.getWriter().println(teamLeader);
		resp.getWriter().println("<table border ='1'>");
		resp.getWriter().println("<form method='get' action='/approveservlet'>");
		
		
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "이름" + "</td>"); resp.getWriter().println("<td>" + "<input type=" + text + " value=" + m.getName() + " name=" + name2 + ">" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "학번" + "</td>"); resp.getWriter().println("<td>" + "<input type=" + text + " value=" + m.getHakbun() + " name=" + hakbun + ">" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "전화번호" + "</td>"); resp.getWriter().println("<td>" + "<input type=" + text + " value=" + m.getPhoneNumber() + " name=" + phoneNumber + ">" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "메일주소" + "</td>"); resp.getWriter().println("<td>" + "<input type=" + text + " value=" + m.getEmail() + " name=" + email + ">" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "카카오톡 아이디" + "</td>"); resp.getWriter().println("<td>" + "<input type=" + text + " value=" + m.getKakaoId() + " name=" + kakaoId + ">" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "팀장 여부" + "</td>"); resp.getWriter().println("<td>" + "<input type=" + checkbox + " value=" + m.getTeamLeader() + " name=" + teamLeader + ">" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "GitHub ID" + "</td>"); resp.getWriter().println("<td>" + "<input type=" + text + " value=" + m.getHubId() + " name=" + hubId + ">" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</table>");
		
		
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "<a href='/approveservlet?key=" + m.getKey() + "&name='name'" + "'>" + "수정/변경" + "</a>"  + "</td>");
		resp.getWriter().println("</tr>");
		
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>" + "<a href=" + first + ">" + "처음으로" + "</a>" + "</td>");
		resp.getWriter().println("</tr>");
		resp.getWriter().println("</form>");
		
		resp.getWriter().println("</body></html>");
		
		
		
		
	}
}
