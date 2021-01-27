package com.javatpoint.mypackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.bean.Policy;
import com.javatpoint.dao.PolicyDao;


@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='addemployees.html'>Add New Policydetails</a>");  
        out.println("<h1>User Policy List</h1>");  
        
        
        List<Policy> list=PolicyDao.getAllRecords();
        
        
        out.print("<table border='1' width='100%'");  
        
           out.print("<tr><th>Policynumber</th><th>Customerid</th><th>Customername</th><th>Insuredname</th><th>Dob</th>");
           out.print("<th>EmailAddress</th><th>MobileNumber</th><th>PremiumMode</th><th>PolicyStatus</th><th>CustomerPannumber</th>");
           out.print("<th>PolicyIssuanceDate</th><th>ContactNumber</th><th>Last_Updated</th><th>EmaiAddresslast_updated</th>");
           out.print(" <th>BankaccountNumber</th><th>Whatsapp_opt_in_status</th><th>Productname</th><th>Reinvestapplication</th>");
           out.print("<th>Unclaimedamount</th><th>Neftregister</th><th>Lastpremiumpaid</th><th>Productid</th><th>Password</th></tr>");
        
        
        
        for(Policy p:list)
        {
        	out.print("<tr><td>"+p.getPolicynumber()+"</td><td>"+p.getCustomerid()+"</td><td>"+p.getCustomername()+"</td><td>"
        			+p.getInsuredname()+"</td><td>"+p.getDob()+"</td><td>"+p.getEmailaddress()+"</td><td>"+p.getMobilenumber()
        			+"</td><td>"+p.getPremiummode()+"</td><td>"+p.getPolicystatus()+"</td><td>"+p.getCustomerpannumber()
        			+"</td><td>"+p.getPolicyissuancedate()+"</td><td>"+p.getContactnumber()+"</td><td>"+p.getLast_updated()
        			+"</td><td>"+p.getEmaiaddresslast_updated()+"</td><td>"+p.getBankaccountnumber()+"</td><td>"+p.getWhatsapp_opt_in_status()
        			+"</td><td>"+p.getProductname()+"</td><td>"+p.getReinvestapplication()+"</td><td>"+p.getUnclaimedamount()
        			+"</td><td>"+p.getNeftregister()+"</td><td>"+p.getLastpremiumpaid()+"</td><td>"+p.getProductid()
        			+"</td><td>"+p.getPassword()+"</td></tr>");
        }

        out.print("</table>");
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
