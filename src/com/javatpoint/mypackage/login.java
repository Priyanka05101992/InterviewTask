package com.javatpoint.mypackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	    response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	          
	    
	    String name=request.getParameter("loginname");
	    String password=request.getParameter("password");  
	    out.print(" Welcome " +   name);
	    
	  
	          
	    if(password.equals("admin"))
	    		{  
	       RequestDispatcher rd=request.getRequestDispatcher("WelcomeServlet");  
	       rd.forward(request, response);
	    }  
	    else{  
	        out.print("  Sorry Password Error!!!!   ");  
	        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
	        rd.include(request, response);  
	        
	        

	        
	                      
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
