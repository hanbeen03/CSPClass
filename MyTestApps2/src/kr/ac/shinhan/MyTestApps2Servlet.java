package kr.ac.shinhan;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MyTestApps2Servlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("오늘의 날짜 : " + new Date());
		resp.getWriter().println("마당발 APP : 저희 어플리케이션은 자칫 뜸해질 수 있는 다른 사람과의 연락으로 소홀해진 인간관계를 개선할 목적으로 계획되었습니다.");
	}
}
