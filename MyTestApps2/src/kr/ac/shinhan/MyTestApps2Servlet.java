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
		resp.getWriter().println("������ ��¥ : " + new Date());
		resp.getWriter().println("����� APP : ���� ���ø����̼��� ��ĩ ������ �� �ִ� �ٸ� ������� �������� ��Ȧ���� �ΰ����踦 ������ �������� ��ȹ�Ǿ����ϴ�.");
	}
}
