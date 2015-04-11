package kr.ac.shinhan;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class ProjectIntroductionServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String hakbun = req.getParameter("hakbun");
		String phoneNumber = req.getParameter("phoneNumber");
		String email = req.getParameter("email");
		String kakaoId = req.getParameter("kakaoId");
		String teamLeader = req.getParameter("teamLeader");
		String hubId = req.getParameter("hubId");
		
		
		TeamMember tm = new TeamMember(name, hakbun, phoneNumber, email, kakaoId, teamLeader, hubId);
		PersistenceManager pm = MyPersistenceManager.getManager();
		pm.makePersistent(tm);
		
		
		resp.getWriter().println("<html><body>");
		
		//resp.getWriter().println(teamLeader);
		
		resp.getWriter().println("이름 : " + name + "</br>");
		resp.getWriter().println("학번 : " + hakbun + "</br>");
		resp.getWriter().println("전화번호 : " + phoneNumber + "</br>");
		resp.getWriter().println("메일주소 : " + email + "</br>");
		resp.getWriter().println("카카오톡 아이디 : " + kakaoId + "</br>");
		if(teamLeader == null)
			resp.getWriter().println("팀장 아님" + "</br>");
		else
			resp.getWriter().println("팀장 맞음" + "</br>");
		resp.getWriter().println("GitHub ID : " + hubId + "</br>");
		resp.getWriter().println("" + "</br>");
		resp.getWriter().println("이 등록 되었습니다." + "</br>");
		
		resp.getWriter().println("</body></html>");
		
		resp.getWriter().println("<td>" + "<a href='index.html'>" + "돌아가기" + "</a>" + "</td>");
		
	}
}
