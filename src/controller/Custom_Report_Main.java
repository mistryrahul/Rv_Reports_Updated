package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import debt_Model.Credit_rating_sum_groups;
import model.Custom_Report;
import model.nav_hist;
import model.nav_report_3_stable;
import sessionFactory.HIbernateSession;

public class Custom_Report_Main {

	public static void main(String[] args) 
	{
	      
	     Session ssn=null;
	     Custom_Report obj=null;
	     try
	     {
	    	 ssn = HIbernateSession.getSessionFactory().openSession(); 
			 ssn.beginTransaction();
			 
//				Criteria criteria_1 = ssn.createCriteria( nav_report_3_stable.class );
//				criteria_1.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
//				criteria_1.add(Restrictions.eq("key.Fund_Type", "Custom_Report"));
//			 	criteria_1.addOrder(org.hibernate.criterion.Order.asc("key.scheme_code"));
					
			 	ArrayList<nav_report_3_stable> scheme_code_lst_lng = (ArrayList<nav_report_3_stable>) ssn.createQuery("from nav_report_final where Fund_Type='Custom_Report' order by scheme_code,nav_from_date").list();
			  
			 	long schemecode=0;
			 	int counter=0;
			 	Date nav_from_date=null;
			 	 
			    	  for( nav_report_3_stable x : scheme_code_lst_lng)
			    	  {
			    		   if(counter==0)
			    		   {
			    			   schemecode= x.getScheme_Code();
			    			   nav_from_date = x.getNav_from_date();
			    			   
			    			     obj = new Custom_Report();
			    			    
				    		    obj.setScheme_Code(x.getScheme_Code()); 
				    		    obj.setNav_date(x.getNav_date());
				    		    obj.setNav_from_date(x.getNav_from_date());
				    		    obj.setComment("------");    
				    		    
				    		    if(Integer.parseInt(x.getComment()) == -36)
				    		    {
				    		    	obj.setYear_3(x.getNav_value());				    		    	
				    		    }
				    		    else if(Integer.parseInt(x.getComment())== -60)
				    		    {
				    		    	obj.setYear_5(x.getNav_value());				    		    	
				    		    }
				    		    else if(Integer.parseInt(x.getComment())== -84)
				    		    {
				    		    	obj.setYear_7(x.getNav_value());					    		    	
				    		    }
				    		    else if(Integer.parseInt(x.getComment())== -120)
				    		    {
				    		    	obj.setYear_10(x.getNav_value());				    		    	
				    		    }
				    		    
				    		    counter++;
				    		    
			    		   }
			    		   else
			    		   {
			    			    
			    			   
//			    			   System.exit(0);
			    			   
			    			   
			    			   
			    			       if (schemecode==x.getScheme_Code() && nav_from_date.equals(x.getNav_from_date()))
			    			       {    
			    			    	   
//			    			    	   System.out.println("============IN THE EQUAL CASE=========");
			    			           
			    			    	    
			    			    	   System.out.println(x.getComment());
			    			    	       
			    			    	   
			    			    	   if(Integer.parseInt(x.getComment()) == -36)
						    		    {
						    		    	obj.setYear_3(x.getNav_value());
						    		    	
						    		    }
						    		    else if(Integer.parseInt(x.getComment())== -60)
						    		    {
						    		    	obj.setYear_5(x.getNav_value());
						    		    	
						    		    }
						    		    else if(Integer.parseInt(x.getComment())== -84)
						    		    {
						    		    	obj.setYear_7(x.getNav_value());	
						    		    	
						    		    }
						    		    else if(Integer.parseInt(x.getComment())== -120)
						    		    {
						    		    	obj.setYear_10(x.getNav_value());
						    		    	
						    		    }
			    			    	   
			    			    	   
//			    			    	   System.exit(0);
			    			       }
			    			       else
			    			       {
			    			    	   ssn.save(obj);    
//			    			    	   System.exit(0);
			    			    	   
			    			    	   
			    			    	   ssn.flush();
			 					       ssn.clear();
			 					       ssn.getTransaction().commit();
			 					       ssn.beginTransaction();
			    			    	   			 					       			    			    	   
			    			    	    schemecode = x.getScheme_Code();
			    			    	    nav_from_date = x.getNav_from_date();
					    			   
					    			    obj = new Custom_Report();
					    			    
						    		    obj.setScheme_Code(x.getScheme_Code()); 
						    		    obj.setNav_date(x.getNav_date());
						    		    obj.setNav_from_date(x.getNav_from_date());
						    		    obj.setComment("-==-=-=");   
						    		    
						    		    if(Integer.parseInt(x.getComment()) == -36)
						    		    {
						    		    	obj.setYear_3(x.getNav_value());						    		    	
						    		    }
						    		    else if(Integer.parseInt(x.getComment())== -60)
						    		    {
						    		    	obj.setYear_5(x.getNav_value());						    		    	
						    		    }
						    		    else if(Integer.parseInt(x.getComment())== -84)
						    		    {
						    		    	obj.setYear_7(x.getNav_value());	
						    		    	
						    		    }
						    		    else if(Integer.parseInt(x.getComment())== -120)
						    		    {
						    		    	obj.setYear_10(x.getNav_value());
						    		    	
						    		    }
			    			    	   
			    			       }
			    			       counter++;
			    		   }
			    		   
			    		   
			    		  
			    		  
			    	  }
			    	  
			    	  ssn.save(obj);
			    	  ssn.getTransaction().commit();
		 
	     }
	     catch (Exception e) 
	     {
			e.printStackTrace();
		 }
	     finally
	     {
//	           	 ssn.save(obj);
	           	 ssn.close();
	     }
		 

	}

}
