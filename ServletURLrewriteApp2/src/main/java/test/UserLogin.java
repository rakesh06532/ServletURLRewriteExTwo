package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

@SuppressWarnings("serial")
@WebServlet("/log")
public class UserLogin extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
	
		String fname=new LoginDAO().login(req);
		if(fname==null) {
			pw.println("Invalid Login Details...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else {
			pw.println("Welcome User: "+fname+"<br>");
			Cookie ck=new Cookie("fname",fname);//Cookie Object created
			res.addCookie(ck);//Cookie Object added
			//pw.println(ck.getValue());
			ArrayList<BookBean> al=new ViewDAO().view();
			if(al.size()==0) {
				pw.println("Book Details not available...<br>");
			}
			else {
			Iterator<BookBean> it=al.iterator();
			while(it.hasNext()) {
			BookBean bb=(BookBean)it.next();
		    pw.println("<a href='view?bcode="+bb.getBCode()+"'>ViewTotalBookCode</a><br>");
		    pw.println("<a href='logout'>Logout</a>");
			}
			}
		}
	}
	

}
