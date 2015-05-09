package kr.ac.shinhan;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApproveServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		
		Long key = Long.parseLong(req.getParameter("key"));
		String name = req.getParameter("name");
		String hakbun = req.getParameter("hakbun");
		String phoneNumber = req.getParameter("phoneNumber");
		String email = req.getParameter("email");
		String kakaoId = req.getParameter("kakaoId");
		String teamLeader = req.getParameter("teamLeader");
		String hubId = req.getParameter("hubId");
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		TeamMember object = pm.getObjectById(TeamMember.class,key);
		object.setName(name);
		object.setHakbun(hakbun);
		object.setPhoneNumber(phoneNumber);
		object.setEmail(email);
		object.setKakaoId(kakaoId);
		object.setTeamLeader(teamLeader);
		object.setHubId(hubId);
		
		//pm.close();
		
		resp.getWriter().println("<td>" + "<a href='index.html'>" + "돌아가기" + "</a>" + "</td>");
		
	}
}
