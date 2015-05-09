package kr.ac.shinhan;

import java.io.IOException;
//import java.util.Calendar;
import java.util.Date;
//import java.util.GregorianCalendar;
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
public class LoginServlet extends HttpServlet{
	@SuppressWarnings({ "unchecked", "deprecation" })
	public void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		String id = req.getParameter("id");
		String password = req.getParameter("password");
		String remember = req.getParameter("remember");
		boolean success = false;
		String uuid = UUID.randomUUID().toString();
		
		MyPersistenceManager.getManager();
		
		Query qry = MyPersistenceManager.getManager().newQuery(UserAccount.class);
		
		qry.setFilter("userId == idParam");
		qry.declareParameters("String idParam");
		
		List<UserAccount> userAccount = (List<UserAccount>) qry.execute(id);
		
		if(userAccount.size() == 0)
		{
			success = false;
		}
		
		else if (userAccount.get(0).getPassword().equals(password))
		{
			success = true;
		}
		
		else
		{
			success = false;
		}
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		
		if(!success)
		{
			resp.getWriter().println("Fail to login");
			resp.getWriter().println("<a href='login.html'>Login Again</a>");
		}
		if(success)
		{
			HttpSession session = req.getSession();
			session.setAttribute("id", id);
			
			if(remember != null) {
				Cookie cookie = new Cookie("token", uuid);
				cookie.setMaxAge(30*60*2*24*30);
				resp.addCookie(cookie);
				
				Date date = new Date();
				
				//Calendar cal = new GregorianCalendar();
				
				//String now = cal.getTime().toString();
				
				date.setDate(date.getDay() + 26);
				
				UserLoginToken ult = new UserLoginToken(uuid, id, date.toString());
				PersistenceManager pm = MyPersistenceManager.getManager();
				pm.makePersistent(ult);
			}
			
			resp.sendRedirect("index.html");
		}
		
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
	}

}
