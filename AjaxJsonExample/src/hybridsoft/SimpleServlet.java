package hybridsoft;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleServlet  extends HttpServlet 
{
	
@Override
protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
		throws ServletException, IOException {
	
	String name=arg0.getParameter("cmpname");
	System.out.println("servlet called"+name);
	PrintWriter pw=arg1.getWriter();
	pw.write("respons from servlet");
}	
	

}
