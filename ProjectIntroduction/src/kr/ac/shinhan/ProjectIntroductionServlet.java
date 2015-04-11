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
		
		resp.getWriter().println("�̸� : " + name + "</br>");
		resp.getWriter().println("�й� : " + hakbun + "</br>");
		resp.getWriter().println("��ȭ��ȣ : " + phoneNumber + "</br>");
		resp.getWriter().println("�����ּ� : " + email + "</br>");
		resp.getWriter().println("īī���� ���̵� : " + kakaoId + "</br>");
		if(teamLeader == null)
			resp.getWriter().println("���� �ƴ�" + "</br>");
		else
			resp.getWriter().println("���� ����" + "</br>");
		resp.getWriter().println("GitHub ID : " + hubId + "</br>");
		resp.getWriter().println("" + "</br>");
		resp.getWriter().println("�� ��� �Ǿ����ϴ�." + "</br>");
		
		resp.getWriter().println("</body></html>");
		
		resp.getWriter().println("<td>" + "<a href='index.html'>" + "���ư���" + "</a>" + "</td>");
		
	}
}
