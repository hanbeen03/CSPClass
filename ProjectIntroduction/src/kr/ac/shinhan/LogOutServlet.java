package kr.ac.shinhan;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		Cookie[] cookielist = req.getCookies();
		for(Cookie c : cookielist)
		{
			PersistenceManager pm = MyPersistenceManager.getManager();
			Query qry = pm.newQuery(UserLoginToken.class);
			List<UserLoginToken> userList = (List<UserLoginToken>) qry.execute();
			
			for(UserLoginToken tm : userList) {
				if(tm.getToken().equals(c.getValue())) {
					pm.deletePersistent(tm);
				}
			}
		}
		
		for(Cookie c : cookielist)
		{
			if(c.getName().equals("token"))
			{
				c.setMaxAge(0);
				resp.addCookie(c);
			}
		}
		
		resp.sendRedirect("login.html");
	}
}
