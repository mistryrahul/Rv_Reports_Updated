package completeDebt;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Calma_Ratio_Main;
import model.Avg_ret_Model;
import model.Calma_Ratio_Model;
import model.Report_6_pk;
import model.nav_report_3_stable;
import sessionFactory.HIbernateSession;

public class Calmar_Ratio_Runner 
{
	
	public String Calculate_Calmar_Ratio(String Fund_Type) 
	{
	     int db_save=1;
//	     String Fund_Type;
	     	     
		Calendar cal = Calendar.getInstance(); 
		java.util.Date temp_date=null;
		int yr_incr=1; // year increment flag
		ArrayList<nav_report_3_stable>  nav_rep_lst_tmp = null;
		
		try
		{
		
		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
	    ssn.beginTransaction();		

	    String hql_nw=" from avg_return where start_dt>='2000-03-31' and key.Fund_Type='"+Fund_Type+"'";
// 		String hql_nw=" from avg_return where start_dt>='2003-06-30' and start_dt<='2015-03-31'";
 		
 		Query q_2 = ssn.createQuery(hql_nw);
 		
 		ArrayList<Avg_ret_Model> avg_ret_main_lst = (ArrayList<Avg_ret_Model>) q_2.list();
 		Calma_Ratio_Model crm=null;
 		Report_6_pk pk=null;	    	    
	    
	    
 		   for(Avg_ret_Model arm :avg_ret_main_lst)
 		   {
 			   
 			  yr_incr=1;
// 			   System.out.println("SCHEME_CODE--->>>"+arm.getKey().getScheme_code());
// 			  System.out.println("STARt DATE--->>>"+arm.getKey().getStart_dt());
 			   
 			  cal.setTime(arm.getKey().getStart_dt());
//		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
		     
 			  crm = new Calma_Ratio_Model();
 			  pk = new Report_6_pk();
 			  
 			  pk.setFrom_date(arm.getKey().getStart_dt());
 			  pk.setScheme_code(arm.getKey().getScheme_code());
 			  pk.setFund_Type(Fund_Type);
 			  
 			  crm.setKey(pk);
 			 java.util.Date dd=pk.getFrom_date();
// 			 System.out.println("dd is "+ dd);
// 			 System.out.println("date from pk is" + dd.getMonth());
// 			 System.out.println("year from pk is -->"+dd.getYear());
 			 if(dd.getMonth()==0 || dd.getMonth()==1 ||dd.getMonth()==2 )
 			 {
 				// System.out.println("Qtr_1_"+( dd.getYear()-100));
 				 crm.setComment("Qtr_1_"+( dd.getYear()-100));
 			 }
 			 else if(dd.getMonth()==3 || dd.getMonth()==4 ||dd.getMonth()==5 )
			 {
 				//System.out.println("Qtr_2_"+( dd.getYear()-100));
				 crm.setComment("Qtr_2_"+( dd.getYear()-100));
			 }
 			else if(dd.getMonth()==6 || dd.getMonth()==7 ||dd.getMonth()==8 )
			 {
 				//System.out.println("Qtr_3_"+( dd.getYear()-100));
				 crm.setComment("Qtr_3_"+( dd.getYear()-100));
			 }
 			else if(dd.getMonth()==9 || dd.getMonth()==10 ||dd.getMonth()==11 )
			 {
 				//System.out.println("Qtr_4_"+( dd.getYear()-100));
				 crm.setComment("Qtr_4_"+( dd.getYear()-100));
			 }
 			 
 			 
// 			 crm.setComment(arm.getComment());
 			  
 			  System.out.println("From Date-->>"+arm.getKey().getStart_dt());
 			  
 			 while(yr_incr<=5)
			  {
				  cal.setTime(arm.getKey().getStart_dt()); 
				  cal.add(Calendar.YEAR,-yr_incr);
			      temp_date = cal.getTime();	
			      System.out.println("date" + yr_incr);
			        Calma_Ratio_Main.GET_MAX_DRAW_DOWN(crm , yr_incr , temp_date, ssn); 
			        
			        Calma_Ratio_Main.GET_CAGR(crm , yr_incr , temp_date ,ssn);
 
			        Calma_Ratio_Main.GET_CALMA_RATIO(crm , yr_incr , temp_date);
			       
			    	       
			      
			     yr_incr++;
			  }

 			   Criteria criteria_11 = ssn.createCriteria( nav_report_3_stable.class );
 			   criteria_11.add(Restrictions.eq("nav_from_date", crm.getKey().getFrom_date()));  
 			  criteria_11.add(Restrictions.eq("Fund_Type",Fund_Type));
		       criteria_11.add(Restrictions.eq("scheme_Code",crm.getKey().getScheme_code()));
		       criteria_11.add(Restrictions.eq("comment","12"));
		           
		       nav_rep_lst_tmp = (ArrayList<nav_report_3_stable>) criteria_11.list();
				  
		        if(nav_rep_lst_tmp.size() > 0)
		          {
		        	   crm.setForward_12_mnth_ret(nav_rep_lst_tmp.get(0).getNav_value());   
		          }
 		 		 			  			 
 			  
// 			    crm.setFund_Type(Fund_Type);
 			    ssn.save(crm);
// 			    ssn.getTransaction().commit();
		        db_save++;
		        
		        
		       if(db_save%50==0)
		      {
		    	    
//		    	  ssn.getTransaction().commit();
//		    	  ssn.beginTransaction();
		    	  ssn.flush();
	  		      ssn.clear();
	  		     
	  		      db_save=1;
	  		      
	  		      System.out.println("Reseting Session...");
		      }
 			  
		     
 			   
 			   
 			 
 		   }
 		
 		      ssn.getTransaction().commit();
			  ssn.close();
			  
			  System.out.println("<<<<<---Report-Calmar Ratio Complete---->>>>>");
		}
		catch (Exception e) 
		{
		   return e.getMessage();	
		}
 	return "success";	         
	}
  
	
}
