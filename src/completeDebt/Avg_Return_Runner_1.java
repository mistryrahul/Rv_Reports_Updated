package completeDebt;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Query;
import org.hibernate.Session;

import controller.Avg_return_Main;
import model.Scheme_Detail;
import model.nav_hist;
import sessionFactory.HIbernateSession;

public class Avg_Return_Runner_1 
{
   
	public static String Calculate_Avg_Return(String Fund_Type , String scheme_code_list_path  ) 
	{

//    	Calculate_Rank("EQUITY_ELSS");
		
//		String Fund_Type="";
		List<nav_hist> nav_hst_lst;
        int qtr_chker=0;
        int date_loop_flag=0;
        List<java.util.Date> dt_lst=null;
        
        ArrayList<java.util.Date> date_holder =new ArrayList<java.util.Date>();;
        
        int rec_found_flag=0;  // default value 0
		ArrayList<nav_hist> tmp_dt_lst=null;
			
		Session ssn=null;
	    int i=0;
	    
	    nav_hist tmp_obj_met=null;
	    java.util.Date date_tmp=null;
	    java.util.Date date_tmp_2=null;
	    java.util.Date ddd=null;
	 try
	 {
		    //  ***** SELECT THE TYPE OF FUND  ***** 
//		     Fund_Type="EQUITY_ELSS";  // has to be passed
//		     Fund_Type="EQUITY_LARGE_CAP_NEW_31.03.2017";  // has to be passed
//		     Fund_Type="EQUITY_MULTI_CAP_NEW_31.05.2017";  // has to be passed
//		     Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.06.2017";  // has to be passed
		    
//		      Fund_Type="Test";
		 
		  
//		     Fund_Type="EQUITY_ELSS_NEW_30.06.2017";  // has to be passed
		     
//		     Fund_Type="EQUITY_LARGE_CAP_NEW_31.05.2017"; // This field is mandatory
		     
		  	List<Long> oo = new ArrayList<Long>();
		  	
		  	List<Long> temp_schem_code = new ArrayList<Long>();
		  			  	
//		  	LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_code_list_EQUITY_ELSS_2017.txt"), "UTF-8");		  			  			 
//		  	LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/EQUITY_ELSS_LIST_31_may_17.txt"), "UTF-8");
		  	LineIterator it_s = FileUtils.lineIterator(new File(scheme_code_list_path), "UTF-8");
		  	
		  	
		  	   
	 while (it_s.hasNext()) // if the file has lines 
   	            {
		               temp_schem_code.add(Long.parseLong(it_s.nextLine()));
   	            }		
		  	
	 
	  System.out.println("File loaded Successfullyy-----");
		  	
	  
	 	        
	  ssn = HIbernateSession.getSessionFactory().openSession(); 
      ssn.beginTransaction();
		 
  
	
//	  ArrayList<nav_hist> nav_hist_lst = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where ");
      
      
	  
//	  System.out.println(oo.get(0));
        
	  //NEW ADDED
	  // OMITING SCHEME_CODE WHICH ARE CLOSE ENDED
	  
      
	  for(int indx=0;indx<temp_schem_code.size();indx++)
	  {
		  ArrayList<Scheme_Detail> schm_dtl = (ArrayList<Scheme_Detail>) ssn.createQuery("from scheme_details_fulls where schemecode=? and type_code!=2 and plan!=5").setLong(0, temp_schem_code.get(indx)).list();
		    
		    if(schm_dtl.size()==0)
		    {
//		    	oo.remove(indx);
		    }
		    else
		    {
		    	oo.add(temp_schem_code.get(indx));
		    }
		   
	  }
	  
	  	
//	  	oo.add((Long.parseLong("0")));
//	  System.out.println("SIZE OF THE LIST--->>>"+oo.size());
	  	  	  
	  if(oo.size()==0)
	  {
		  System.out.println("NO DATA LEFT TO EXECUTE:---------------");
		  System.out.println("EXIT");
		  System.exit(0);
	  }
		  	
		  	 Calendar cal = Calendar.getInstance();	  	 
//	  	long ob =15;	  	
	    for(long ob : oo)
		     	{
//	    	       System.out.println("Scheme COde-->>"+ob);
	     dt_lst=null;       
    	 dt_lst = Avg_return_Main.getDates(ob,ssn,null); //Starting DAte
    	 
    	 date_loop_flag=0; 	       
	    	       
					    	if(dt_lst==null)
					        {
					       	   System.out.println("No record Exist in NAv_Hist of Scheme COde-->"+ob);
					       	   continue;
					        }       
	    	         date_tmp = dt_lst.get(0);
			  		
	    	         while(date_loop_flag==0)
			  		  {	 
	    	        	     	    
	    	        	 System.out.println("<< Loop.....>>");
	    	        	 
				  		  cal.setTime(date_tmp);
//					      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
					      cal.add(Calendar.MONTH,3);
					      ddd = cal.getTime();
					      
					      qtr_chker=1;
					      date_holder.clear();
					      rec_found_flag=0;
					      
					      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
					      {
					    	   ddd.setDate(31);
					      }
					      else
					      {
					    	   ddd.setDate(30);
					      }
					      				// set limit to the latest Quarter 	     
					      if(ddd.compareTo(new Date(118,02,31))==1) //set upper date limit
					      {
					    	  date_loop_flag=1;
					      }
					      					        
				  		   nav_hst_lst = Avg_return_Main.get_list_of_dates_db(ddd, (int) ob, ssn);
				  		      
				  		  if(nav_hst_lst.size()==0)
				  		     {
//				  		    	 break;   /// new added code for missing data ////-------added on 13-08-2016-----
				  			    date_tmp=date_tmp;
				  			    
				  			    
				  			    tmp_obj_met = Avg_return_Main.Fill_Blanks(ddd,ob,date_tmp,nav_hst_lst,ssn);				                
				                    if(tmp_obj_met==null)
				                    {
				                    	//call a method 
				                    	Avg_return_Main.Save_Last_Quarter_Value(date_tmp,ddd,ob,Fund_Type,ssn);				                    	
				                    	break;
				                    }
				                    else
				                    {
//				                    	date_tmp = tmp_obj_met.getNav_date();
				                    	nav_hst_lst.add(tmp_obj_met);  
				                    }				                    				                 
//				                  System.out.println("DAte TEmp--->>"+date_tmp);
//				                  System.out.println("nav_hist List SIZE--->>"+nav_hst_lst.size());				                  
				  		     }
				  		      
//			  		        System.out.println("<<<<<<<------START----->>>>>>>>>");
//				  		    System.out.println("Query Checker Flag--->>"+qtr_chker);
//				  		    System.out.println("Record Found Flag-->>"+rec_found_flag);
//				  		    System.out.println("Date Temp--->>"+date_tmp);
//				  		    System.out.println("List Object NAV--->>"+nav_hst_lst.get(0).getNavrs());
//				  		    System.out.println("List Object scheme_code--->>"+nav_hst_lst.get(0).getScheme_code());
//				  		    System.out.println("Scheme_COde-->>"+ob);
//				  		    System.out.println("<<<<<<<-------END---->>>>>>>>>");
				  		    
				  		Avg_return_Main.Calculate_Save_Nav(date_tmp,nav_hst_lst.get(0), (int) ob ,Fund_Type,ssn);
				  		    
//				  		    Setting the date to 30th or 31st of the month. as wee need date from quarter
				  		    if( nav_hst_lst.get(0).getKey().getNavdate().getMonth()==0 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==2 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==4 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==6 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==7 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==9 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==11)
				  		    {
				  		    	date_tmp=nav_hst_lst.get(0).getKey().getNavdate();
				  		    	date_tmp.setDate(31);
				  		    	tmp_dt_lst = Avg_return_Main.get_list_of_dates_db(date_tmp, (int) ob,ssn);
				  		    	date_tmp=tmp_dt_lst.get(0).getKey().getNavdate();
//				  		    	System.out.println("Scheme COde-->>"+ob+"DATE SET IF-->>"+date_tmp);				  		    	
				  		    }
				  		    else
				  		    {
//				  		    	System.out.println("Month-->>"+nav_hst_lst.get(0).getNav_date().getMonth());
				  		    	date_tmp=nav_hst_lst.get(0).getKey().getNavdate();
				  		    	date_tmp.setDate(30);
				  		    	tmp_dt_lst = Avg_return_Main.get_list_of_dates_db(date_tmp, (int) ob,ssn);
				  		    	date_tmp=tmp_dt_lst.get(0).getKey().getNavdate();
//				  		    	System.out.println("Scheme Code-->"+ob+"DATE SET ELSE-->>"+date_tmp);
				  		    }						    	
			  		  }

		  	    }	    		  	
//		  	ssn.close();		  	
		  	System.out.println("<---- NAV Return Complete ---->");
		  	System.out.println("<-----Calculating Rank of Each Quarter----->");
		  	
		  	Avg_return_Main.Calculate_Rank(Fund_Type);
		  	
		  	System.out.println("<----- Rank Calculation Complete----->");
		  	System.out.println("<-=-=-=-=-=-=-==-Average Reuturn Completed-=-=-=-=-=-=->");
	  	
	 }
	 catch(Exception e)
	 {   
		 
		 e.printStackTrace();
		 return e.getMessage();
	 }
	 return "success";
	}
	
	
}
