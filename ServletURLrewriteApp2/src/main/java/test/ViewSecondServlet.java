package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewSecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req,HttpServletResponse res)
	  throws ServletException,IOException {
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		pw.println("Book Details...<br>");
		pw.println("BookCode : "+req.getParameter("bcode"));
	}

}
