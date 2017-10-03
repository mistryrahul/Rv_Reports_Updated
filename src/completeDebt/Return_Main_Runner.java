package completeDebt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Return_main;
import model.Avg_ret_Model;
import model.nav_hist;
import model.nav_report_3_stable;
import sessionFactory.HIbernateSession;

public class Return_Main_Runner 
{
	public String Calculate_Return_Report(String Fund_Type, String date_list) 
	{
		  ArrayList<Long> scheme_code_lst_lng = new ArrayList<Long>();
		  ArrayList<String> scheme_code_lst = new ArrayList<String>();
		  ArrayList<String> date_lst = new ArrayList<String>();
		 
		  nav_hist tmp_obj=null;
		  Session ssn=null;
		  int ret_lst_mnths[] = {-3,-6,-12,-18,-24,-30,-36,-42,-48,-54,-60,9,12,18,24,36}; // list of month interval for which data need to be calculated
//		  int ret_lst_mnths[] = {-36,-60,-84,-120}; // list of month interval for which data need to be calculated
//		  int ret_lst_mnths[] = {-3}; // list of month interval for which data need to be calculated
		  int db_flag=1;
		  
	  	try
	  	{
	  		
	  		// EITHER YOU CAN PROVIDE SCHEME_CODE LIST (1) OR GET THAT FROM AVG_RETURN TABLE (2)
	  		
//	  		(1)
//	  	   LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_code_list_EQUITY_ELSS.txt"), "UTF-8");	
////	  	   LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_code_list.txt"), "UTF-8");	  	   
//	  	   
//	  	    while (it_s.hasNext()) // if the file has lines 
//   	            {
//		    	          scheme_code_lst.add(it_s.nextLine());
//   	            }
	  		
	  		 ssn = HIbernateSession.getSessionFactory().openSession(); 
			 ssn.beginTransaction();
	  		
//	  		(2)
										Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
										criteria_1.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
										criteria_1.add(Restrictions.eq("key.Fund_Type", Fund_Type));
									 	criteria_1.addOrder(org.hibernate.criterion.Order.asc("key.scheme_code"));
											
									 	scheme_code_lst_lng = (ArrayList<Long>) criteria_1.list();
			 
//			 scheme_code_lst_lng = new ArrayList<Long>();
//			 
//			 scheme_code_lst_lng.add((long)1110 );
//			 scheme_code_lst_lng.add((long)13017 );
//			 scheme_code_lst_lng.add((long)1482 );
//			 scheme_code_lst_lng.add((long)2660 );
//			 scheme_code_lst_lng.add((long)2321 );
			 
			 
//			 scheme_code_lst_lng = new ArrayList<Long>();
//			 scheme_code_lst_lng.add((long)7615);
		 	
		 	for(Long tmp : scheme_code_lst_lng)
		 	{
		 		scheme_code_lst.add(String.valueOf(tmp));
		 	}
		 	
		 	System.out.println("SCHEMCODE LIST CONVERTED:----->>");
		 				 
	  	    
//	  	   LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/date_list.txt"), "UTF-8");
		   LineIterator it = FileUtils.lineIterator(new File(date_list), "UTF-8");	
	  	 
	  	   
	  	   
//		  LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/custom_date_list.txt"), "UTF-8"); 
		  	 while(it.hasNext())
		     	{
			            	date_lst.add(it.nextLine());
		     	}		  	 		  
		  	
		  	for(String scheme_code : scheme_code_lst) //Travarsing SchemeCode List
		  	{
		  	   for(String day: date_lst)
		  	   {
		  		 ArrayList<nav_hist> list = Return_main.get_list_of_dates_db(day,Integer.parseInt(scheme_code));
		  		 
		  		 nav_report_3_stable obj;
		  		 
		  		 if(list.size()>1)
		  		 {
		  		   tmp_obj = list.get(0);
		  		   
		  		   for(int mnths : ret_lst_mnths)
		  		   {
		  			  if(mnths<0) // backward months
		  			  {
		  				List<nav_hist> mm = Return_main.get_list_of_dates_db(Return_main.get_date(day, mnths, "sub"),Integer.parseInt(scheme_code));
		  				if(mm.size() >= 1) 
		  				{
		  				   nav_hist b = mm.get(0);
		  				   
//		  				   System.out.println("Negetive--->"+mnths);
//		  				   System.out.println("Date--->"+b.getNav_date());
//		  				   System.out.println("Date--->"+b.getScheme_code());
		  				   
		  				   obj = new nav_report_3_stable();
		  				   double res = (((tmp_obj.getAdjnavrs() - b.getAdjnavrs())/ b.getAdjnavrs())*100); 
		  				   
//		  				   double res_1=0,res_2=0,final_res=0, temp_3,temp_4;
//		  				   
//		  				   res_1 = (1 + res/100);
////		  				     System.out.println("RES----->"+res_1);
//		  				     
////		  				     System.out.println("ABS-->>"+Math.abs(mnths));
//		  				     temp_4 = Math.abs(mnths);
//		  				     
//		  				     temp_3 = (12/temp_4) ;
////		  				   System.out.println("Temp-3----->"+temp_3);
//		  				     
//		  				   res_2 = Math.pow(res_1,temp_3) - 1;
//		  				   
////		  				     System.out.println("RES_2----->"+res_2);
//		  				   
//		  				     final_res = res_2 * 100 ;
////		  				    System.out.println("FINAL_RES----->"+res_2);
		  				   
		  				   obj.setComment(Integer.toString(mnths));
		  				   obj.setNav_date(b.getKey().getNavdate());
		  				   obj.setNav_from_date(tmp_obj.getKey().getNavdate());
		  				   
		  				   obj.setNav_value(res);
//		  				   obj.setNav_value(final_res);
		  				   
		  				   
		  				
		  				   
		  				   obj.setScheme_Code(Long.parseLong(scheme_code));
		  				   obj.setFund_Type(Fund_Type);
		  				   ssn.save(obj);
		  				   db_flag++;
		  				   
//		  				   System.out.println("Return-->"+res);
//		  				   System.out.println("Date-->"+obj.getNav_value());
//		  				   System.out.println("Comment-->"+obj.getComment());
		  				}
		  				
		  				
		  			  }
		  			  else if(mnths>0) // forward months
		  			  {
		  				List<nav_hist> mm = Return_main.get_list_of_dates_db(Return_main.get_date(day, mnths, "add"),Integer.parseInt(scheme_code));  
		  				
		  				if(mm.size() > 1)
		  				{
		  				   nav_hist b = mm.get(0);
		  				   
//		  				   System.out.println("Positive--->"+mnths);
//		  				   System.out.println("Date--->"+b.getNav_date());
//		  				   System.out.println("Date--->"+b.getScheme_code());
		  				   
		  				   obj = new nav_report_3_stable();
		  				   double res = (((b.getAdjnavrs() - tmp_obj.getAdjnavrs())/ tmp_obj.getAdjnavrs())*100);
		  				   
		  				  
		  				   
//		  				 double res_1=0,res_2=0,final_res=0, temp_3,temp_4;
//		  				   
//		  				   res_1 = (1 + res/100);
////		  				     System.out.println("RES----->"+res_1);
//		  				     
////		  				     System.out.println("ABS-->>"+Math.abs(mnths));
//		  				     temp_4 = Math.abs(mnths);
//		  				     
//		  				     temp_3 = (12/temp_4) ;
////		  				   System.out.println("Temp-3----->"+temp_3);
//		  				     
//		  				   res_2 = Math.pow(res_1,temp_3) - 1;
//		  				   
////		  				     System.out.println("RES_2----->"+res_2);
//		  				   
//		  				     final_res = res_2 * 100 ;
////		  				    System.out.println("FINAL_RES----->"+res_2);
		  				   
		  				   
		  				   
		  				   obj.setComment(Integer.toString(mnths));
		  				   obj.setNav_date(b.getKey().getNavdate());
		  				   obj.setNav_from_date(tmp_obj.getKey().getNavdate());
//		  				   
		  				   obj.setNav_value(res);
//		  				   obj.setNav_value(final_res);
		  				   
		  				   obj.setScheme_Code(Long.parseLong(scheme_code));
		  				   obj.setFund_Type(Fund_Type);
		  				   ssn.save(obj);
		  				   db_flag++;
		  				   
//		  				   System.out.println("Return-->"+res);
//		  				   System.out.println("Date-->"+obj.getNav_value());
//		  				   System.out.println("Comment-->"+obj.getComment());
		  				   
		  				   
		  				}
		  				
		  			  }
		  			  
		  			 if(db_flag%50==0)
			  		 {
			  		      
			  		      ssn.flush();
					      ssn.clear();
//					      ssn.getTransaction().commit();
//					      ssn.beginTransaction();
					      db_flag=1;
			  		 }
		  			    
		  		   }		  		      		  			    		  			 
		  		 }
		  		 else
		  		 {
		  			 continue;
		  		 }		  			  						  
			   }
		  		
		  	}		  		  	
//		  	ssn.getTransaction().commit();		  			  			    		   
	  	}
	  	catch(Exception e)
	  	{   
	  		System.out.println(""); 
	  		e.printStackTrace();
	  		
	  		return e.getMessage();
	  	}
	  	finally
	  	{
    		ssn.getTransaction().commit();
	  		ssn.close();
	  		System.out.println("<-- Complete -->");
	  	}
		
	 return "success";
	}
}
