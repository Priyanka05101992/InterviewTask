package com.javatpoint.mypackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javatpoint.bean.Policy;
import com.javatpoint.dao.PolicyDao;


@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        
        int policynumber=Integer.parseInt(request.getParameter("policynumber"));
        int customerid=Integer.parseInt(request.getParameter("customerid"));
        String customername=request.getParameter("customername");  
        String insuredname=request.getParameter("insuredname");     
        String dob=request.getParameter("dob");  
        String emailaddress=request.getParameter("emailaddress");  
        String mobilenumber=request.getParameter("mobilenumber");  
        String premiummode=request.getParameter("premiummode");       
        String policystatus=request.getParameter("policystatus");  
        String customerpannumber=request.getParameter("customerpannumber");  
        String policyissuancedate=request.getParameter("policyissuancedate");  
        String contactnumber=request.getParameter("contactnumber");  
        String last_updated=request.getParameter("last_updated");  
        String emaiaddresslast_updated=request.getParameter("emaiaddresslast_updated");  
        String bankaccountnumber=request.getParameter("bankaccountnumber");  
        String whatsapp_opt_in_status=request.getParameter("whatsapp_opt_in_status");  
        String productname=request.getParameter("productname");  
        String oustandingpayout=request.getParameter("oustandingpayout");  
        String unclaimedamount=request.getParameter("unclaimedamount");  
        String neftregister=request.getParameter("neftregister");  
        String lastpremiumpaid=request.getParameter("lastpremiumpaid"); 

        String password=request.getParameter("password");
        
        
        Policy p=new Policy();
        p.setPolicynumber(policynumber);
        p.setCustomerid(customerid);
        p.setCustomername(customername);
        p.setInsuredname(insuredname);
        p.setDob(dob);
        p.setEmailaddress(emailaddress);
        p.setMobilenumber(mobilenumber);
        p.setPremiummode(premiummode);
        p.setPolicystatus(policystatus);
        p.setCustomerpannumber(customerpannumber);
        p.setPolicyissuancedate(policyissuancedate);
        p.setContactnumber(contactnumber);
        p.setLast_updated(last_updated);
        p.setEmaiaddresslast_updated(emaiaddresslast_updated);
        p.setBankaccountnumber(bankaccountnumber);
        p.setWhatsapp_opt_in_status(whatsapp_opt_in_status);
        p.setProductname(productname);
        p.setOustandingpayout(oustandingpayout);
        p.setUnclaimedamount(unclaimedamount);
        p.setNeftregister(neftregister);
        p.setLastpremiumpaid(lastpremiumpaid);
       // p.setProductid(productid);
        p.setPassword(password);
        
        
        
        
        
        int status=PolicyDao.save(p);
        if(status>0)
        {
            out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("addemployees.html").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
          
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
