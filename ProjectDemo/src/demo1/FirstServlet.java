package demo1;

import java.io.IOException;  
import java.io.PrintWriter;  
  
import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  

public class FirstServlet extends HttpServlet {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
boolean flag;
LoginDao loginDao;
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		loginDao=new LoginDao();
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		          
		    String n=request.getParameter("username");  
		    String p=request.getParameter("userpass");  
		          System.out.println("testing...");
		    flag=loginDao.validate(n, p);
		          if(flag){  
		    	System.out.println("validated.");
		        RequestDispatcher rd=request.getRequestDispatcher("second");  
		        rd.forward(request,response);  
		    }  
		    else{  
		    	System.out.println("invalid");
		        out.print("Sorry username or password error");  
		        RequestDispatcher rd=request.getRequestDispatcher("form.html");  
		        rd.include(request,response);  
		    }  
		          
		    out.close();  
		    }  
		
	}


