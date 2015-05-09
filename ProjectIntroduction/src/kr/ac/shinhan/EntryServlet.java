package kr.ac.shinhan;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class EntryServlet extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		String id = null;
		boolean noToken = true;
		String uuid = UUID.randomUUID().toString();
		
		Cookie[] cookieList = req.getCookies();
		
		if(cookieList.length == 0) {
			resp.getWriter().println(cookieList.length);
		}
		
		for(Cookie c : cookieList) {
			if(c.getName().equals("token")) {
				
				PersistenceManager pm = MyPersistenceManager.getManager();
				Query qry = pm.newQuery(UserLoginToken.class);
				@SuppressWarnings("unchecked")
				List<UserLoginToken> userList = (List<UserLoginToken>) qry.execute();
				
				
				for(UserLoginToken tm : userList) {
					if(tm.getToken().equals(c.getValue())) {
						id = tm.getUserAccount();
					
						Date now = new Date();
						if(now.toString().compareTo(tm.getExpireDate()) < 0)
						{
							noToken = false;
							
							c.setValue(uuid);
							tm.setToken(uuid);
							
							HttpSession session = req.getSession();
							session.setAttribute("id", id);
						}

					}
				}
			}
		}
		
		if(noToken) {
			resp.sendRedirect("login.html");
		} else {
			resp.sendRedirect("index.html");
		}
	}
}
