package kr.ac.shinhan;

import java.io.IOException;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class SignUpServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException { 
		String id = req.getParameter("id"); 
		String name = req.getParameter("name"); 
		String password = req.getParameter("password"); 
		boolean success = false;
		
		PersistenceManager pm = MyPersistenceManager.getManager();
		Query qry = pm.newQuery(UserAccount.class);
		@SuppressWarnings("unchecked")
		List<UserAccount> userList = (List<UserAccount>) qry.execute();
		
		
		for(UserAccount tm : userList) {
			if(tm.getUserId().equals(id)) {

				success = false;

			} else {
				
				success = true;
				

			}
		}
		
		if(success == false) {
			resp.getWriter().println("ID Already Exists ...");
			resp.getWriter().println("<a href='signup.html'>SignUp Again</a>");
		} else {
			UserAccount ua = new UserAccount(id,password,name); 
			 
			MyPersistenceManager.getManager().makePersistent(ua); 
		 		 
			resp.sendRedirect("login.html");
		}
 
		
	
		 
	} 

}
