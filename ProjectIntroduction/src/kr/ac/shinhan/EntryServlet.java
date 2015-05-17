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
		/*Cookie[] cookie = req.getCookies();
		
		if(cookie == null)
		{
			resp.sendRedirect("login.html");
		}
		else
		{
			String token = "";
			for(Cookie c : cookie)
			{
				if(c.getName().equals("login_token"));
				{
					token = c.getValue();
				}
			}
			
			PersistenceManager manager = MyPersistenceManager.getManager();
			Query q = manager.newQuery(UserLoginToken.class);
			q.setFilter("token == tokenParam");
			q.declareParameters("String tokenParam");
			List<UserLoginToken> tokenList = (List<UserLoginToken>) q.execute(token);
			
			if(tokenList.size() == 0 || token.equals(""))
			{
				resp.sendRedirect("login.html");
			}
			else
			{
			UserLoginToken ult = tokenList.get(0);
			String expDate = ult.getExpireDate();
			String today = new Date().toString();
			if(expDate.compareTo(today) > 0 )
			{
				HttpSession session = req.getSession();
				session.setAttribute("id", ult.getUserAccount());
				resp.sendRedirect("index.html");
			
				//token change
				String newToken = UUID.randomUUID().toString();
				Cookie c = new Cookie("login_token", newToken);
				c.setMaxAge(60*60*24*30);
				resp.addCookie(c);  //쿠키 유효기간 설정과 새로운 쿠키 업데이트...
				
				ult.setToken(newToken);
				manager.makePersistent(ult); //토큰바꾼것 업데이트...
			}
			else
				resp.sendRedirect("login.html");
			}
		}*/
		
		
		
		
		
		String id = null;
		boolean noToken = true;
		String uuid = UUID.randomUUID().toString();
		
		Cookie[] cookieList = req.getCookies();
		
		/*if(cookieList.length == 0) {
			resp.getWriter().println(cookieList.length);
		}*/
		
		if(req.getCookies() == null)
		{
			resp.sendRedirect("login.html");
		}
		else
		{
			cookieList = req.getCookies();
			
			for(Cookie c : cookieList) {
				if(c.getName().equals("token")) {
					
					PersistenceManager pm = MyPersistenceManager.getManager();
					Query qry = pm.newQuery(UserLoginToken.class);
					@SuppressWarnings("unchecked")
					List<UserLoginToken> userList = (List<UserLoginToken>) qry.execute();
					
					
					for(UserLoginToken tm : userList) {
						if(tm.getToken().equals(c.getValue())) {
							id = tm.getUserAccount();
						
							String now = new Date().toString();
							String expDate = tm.getExpireDate();
							//Date expired = new Date(tm.getExpireDate());
							
							if(expDate.compareTo(now) > 0 )
							{
								noToken = false;
								
								//c.setValue(uuid);
								Cookie c2 = new Cookie("token", uuid);
								c2.setMaxAge(60*60*24*30);
								resp.addCookie(c2);
								
								
								tm.setToken(uuid);  //업데이트를 해줘야한다...
								pm.makePersistent(tm);
								
								HttpSession session = req.getSession();
								session.setAttribute("id", id);
							}

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
