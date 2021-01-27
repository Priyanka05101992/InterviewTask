package com.javatpoint.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.bean.Policy;

public class PolicyDao
{
	public static Connection getConnetion() throws SQLException
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/insurance","root",""); 

		} catch (Exception e) 
		{
			
			System.out.println(e);
		} 

		return con;
		
	}
	public static int save(Policy p){  
	    int status=0;  
	    try{  
	        Connection con=getConnetion();  
	        PreparedStatement ps=con.prepareStatement(  
	"insert into policy(policyname,customerid,customername,insuredname,dob,emailaddress,mobilenumber"
	+ "premiummode,policystatus,customerpannumber,policyissuancedate,contactnumber"
	+ "last_updated,emaiaddresslast_updated,bankaccountnumber,whatsapp_opt_in_status,reinvestapplication,oustandingpayout"
	+ "unclaimedamount,neftregister,lastpremiumpaid,productid,password) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");  
	        ps.setInt(1,p.getPolicynumber());
	        ps.setInt(2, p.getCustomerid()); 
	        ps.setString(3,p.getCustomername());
	        ps.setString(4,p.getInsuredname());
	        ps.setString(5,p.getDob());
	        ps.setString(6,p.getEmailaddress());
	        ps.setString(7,p.getMobilenumber());
	        ps.setString(8,p.getPremiummode());
	        ps.setString(9,p.getPolicystatus());
	        ps.setString(10,p.getCustomerpannumber());
	        ps.setString(11,p.getPolicyissuancedate());
	        ps.setString(12,p.getContactnumber());
	        ps.setString(13,p.getLast_updated());
	        ps.setString(14,p.getEmaiaddresslast_updated());
            ps.setString(15,p.getBankaccountnumber());
	        ps.setString(16,p.getWhatsapp_opt_in_status());
	        ps.setString(17,p.getProductname());
	        ps.setString(18,p.getReinvestapplication());
	        ps.setString(19,p.getOustandingpayout());
	        ps.setString(20,p.getUnclaimedamount());
	        ps.setString(21,p.getNeftregister());
	        ps.setString(22,p.getLastpremiumpaid());
	        ps.setInt(23,p.getProductid());
	        ps.setString(24,p.getPassword());
          status=ps.executeUpdate();  
	    }catch(Exception e)
	    {
	    	System.out.println(e);
	    }  
	    return status;  
	}  
	public static int update(Policy p)
	{  
	    int status=0;  
	    try
	    {  
	        Connection con=PolicyDao.getConnetion();  
	        PreparedStatement ps=con.prepareStatement(
	        		"update policy set mobilenumber=?,emailaddress=?,customerpannumber=?");

	        ps.setString(1,p.getEmailaddress());
	        ps.setString(2,p.getMobilenumber());
	        ps.setString(3,p.getCustomerpannumber());
	        
	        
            status=ps.executeUpdate();  
            con.close();
   }catch(Exception e)
	    {
	   System.out.println(e);
	    }
		return status;
	}


	
	
	public static List<Policy> getAllRecords(){  
	    List<Policy> list=new ArrayList<Policy>();  
	      
	    try{  
	        Connection con=getConnetion();  
	        PreparedStatement ps=con.prepareStatement("select * from policy");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next())
	        {  
	        	Policy p=new Policy();  
	        	p.setPolicynumber(rs.getInt(1));
	        	p.setCustomerid(rs.getInt(2));
	            p.setCustomername(rs.getString(3));
	            p.setInsuredname(rs.getString(4));
	            p.setDob(rs.getString(5));
	            p.setEmailaddress(rs.getString(6));
	            p.setMobilenumber(rs.getString(7));
	            p.setPremiummode(rs.getString(8));
	            p.setPolicystatus(rs.getString(9));
	            p.setCustomerpannumber(rs.getString(10));
	            p.setPolicyissuancedate(rs.getString(11));
	            p.setContactnumber(rs.getString(12));
	            p.setLast_updated(rs.getString(13));
	            p.setEmaiaddresslast_updated(rs.getString(14));
	            p.setBankaccountnumber(rs.getString(15));
	            p.setWhatsapp_opt_in_status(rs.getString(16));
	            p.setProductname(rs.getString(17));
	            p.setReinvestapplication(rs.getString(18));
	            p.setOustandingpayout(rs.getString(19));
	            p.setUnclaimedamount(rs.getString(20));
	            p.setNeftregister(rs.getString(21));
	            p.setLastpremiumpaid(rs.getString(22));
	            p.setProductid(rs.getInt(23));
	            p.setPassword(rs.getString(24));
	            list.add(p);
}
	        con.close();
	    }catch(Exception e)
	    {
	    	System.out.println(e);
	    }
	    return list;
	}
}