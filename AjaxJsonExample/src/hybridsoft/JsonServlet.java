package hybridsoft;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import com.google.gson.Gson;

public class JsonServlet  extends HttpServlet{
	
	protected void service(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException ,java.io.IOException {
	String country=request.getParameter("countryname");
	  Map<String, String> ind = new LinkedHashMap<String, String>();
	    ind.put("1", "New delhi");
	    ind.put("2", "Tamil Nadu");
	    ind.put("3", "Kerala");
	    ind.put("4", "Andhra Pradesh");
	    
	    Map<String, String> us = new LinkedHashMap<String, String>();
	    us.put("1", "Washington");
	    us.put("2", "California");
	    us.put("3", "Florida");
	    us.put("4", "New York");
	    
	    String json = null ;
	    if(country.equals("India")){
	     json= new Gson().toJson(ind);   
	    }
	    else if(country.equals("US")){
	     json=new Gson().toJson(us);  
	    }
	    
	    response.setContentType("application/json");
	     response.setCharacterEncoding("UTF-8");
	     response.getWriter().write(json);       
	 
	};

}
