package kr.ac.shinhan;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MyTeam extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
		resp.getWriter().println("ÆÀ¿ø¼Ò°³ : È«Àç¹Î(ÆÀÀå), ±èÀº¼ö(ÆÀ¿ø), ÀÌÇÑºó(ÆÀ¿ø)");
	}
}
