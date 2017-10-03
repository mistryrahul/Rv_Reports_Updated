package completeDebt;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Report_10_Main;
import controller.Report_5_Main;
import model.Avg_ret_Model;
import model.Report_5_Model;
import model.nav_hist;
import model.nav_report_3_stable;

public class Report_5_Main_Runner 
{
   
	public String Calculate_Report_5(String Fund_Type) 
	{
		
		int db_flag=0;
		
		
	try
	{
		SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
		Session ssn = sessionfactry.openSession();
		ssn.beginTransaction();
											
											Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
											criteria_1.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
											criteria_1.add(Restrictions.eq("key.Fund_Type", Fund_Type));
									 		criteria_1.addOrder(Order.asc("key.scheme_code"));
											
									 		ArrayList<Long> scheme_code_list = (ArrayList<Long>) criteria_1.list();		
//		ArrayList<Long> scheme_code_list = new ArrayList<Long>();
//		scheme_code_list.add((long)7615);
		
		
//		ArrayList<Long> scheme_code_list = new ArrayList<Long>();
//		scheme_code_list.add((long) 461);
//		scheme_code_list.add((long) 2090);
		
 		String col_lst[] ={"1_year","1_year_1","1_year_2","1_year_3","1_year_4","1_year_1_plus"};

 		java.util.Date from_dt_temp=null;
 		java.util.Date currDt_tmp=null;
 		java.util.Date currDt_tmp_1=null;
 		java.util.Date currDt_tmp_2=null;
 		java.util.Date currDt_tmp_3=null;
 		java.util.Date currDt_tmp_4=null;
 		
 		
 		
 		nav_hist Prev_Tmp_Obj = null;       // temp object for storing previous values
 		nav_hist Prev_Tmp_Obj_1 = null;   
 		nav_hist Prev_Tmp_Obj_2 = null;
 		nav_hist Prev_Tmp_Obj_3 = null;
 		nav_hist Prev_Tmp_Obj_4 = null;
 		nav_hist Prev_Tmp_Obj_5 = null;
 		
 		Report_5_Model rm5 = null;
 		int rec_exist_flag=0;
		    
 		       for(long sc : scheme_code_list)
 		       {
 		    	     Criteria criteria_12 = ssn.createCriteria( nav_report_3_stable.class );
 		 		     criteria_12.setProjection( Projections.distinct(Projections.property("nav_from_date")));
 		 		     criteria_12.add(Restrictions.eq("Fund_Type",Fund_Type));
 		 		     criteria_12.add(Restrictions.eq("scheme_Code",sc));
 		  		     criteria_12.addOrder(Order.asc("nav_from_date"));
 		  		      
 		  		     ArrayList<java.util.Date> date_list = (ArrayList<java.util.Date>) criteria_12.list(); 
 		  		     
// 		    	  ArrayList<java.util.Date> date_list = new ArrayList<java.util.Date>();
// 		    	  
// 		    	  System.out.println("DATe-->"+new java.util.Date(103, 05, 30));
// 		    	  
// 		    	  date_list.add(new java.util.Date(103, 02, 28));
 		    	   
 		    	   
 		    	  
 		  		         for(java.util.Date dt : date_list)
 		  		         {
 		  		        	  ArrayList<nav_hist> qtr_avg_list = (ArrayList<nav_hist>) ssn
 		  		        			                            .createCriteria(nav_hist.class)
 		  		        			                            .add(Restrictions.eq("key.schemecode", sc))
 		  		        			                            .add(Restrictions.eq("key.navdate", dt)).list();
 		  		        	  
 		  		        	Prev_Tmp_Obj = qtr_avg_list.get(0); // temporarily storing the from date objects
 		  		        	
 		  		        	from_dt_temp=qtr_avg_list.get(0).getKey().getNavdate();
 		  		        	rm5 = new Report_5_Model();
 		  		        	
 		  		        	rm5.setFund_Type(Fund_Type);
 		  		       
// 		  		         System.out.println("FROM DATE-->"+from_dt_temp); 		  		        
 		  		        	
 		  		     	if( dt.getMonth()==2 || dt.getMonth()==1)
 		  				{
// 		  					ob_ts.setComent("Qtr_1_"+( dt.getYear()-100));
 		  		     		
 		  		     		rm5.setDay_comment("Qtr_1_"+( dt.getYear()-100));
 		  		     		
// 		  					ob_tmp.setComment("Q1_"+( Ob2.getNav_date().getYear()-100));	
 		  				}
 		  				else if(dt.getMonth()==4 || dt.getMonth()==5) 
// 		  					if(Ob2.getNav_date().getMonth()==5 || Ob2.getNav_date().getMonth()==4 || Ob2.getNav_date().getMonth()==6)
 		  				{
// 		  					ob_tmp.setComment("Q2_"+( Ob2.getNav_date().getYear()-100));
// 		  					ob_ts.setComent("Qtr_2_"+( dt.getYear()-100));
 		  					rm5.setDay_comment("Qtr_2_"+( dt.getYear()-100));
 		  				}
 		  				else if(dt.getMonth()==8 || dt.getMonth()==7)
// 		  				else if(Ob2.getNav_date().getMonth()==8 || Ob2.getNav_date().getMonth()==7 || Ob2.getNav_date().getMonth()==9)
 		  				{
// 		  					ob_tmp.setComment("Q3_"+( Ob2.getNav_date().getYear()-100));
// 		  					ob_ts.setComent("Qtr_3_"+( dt.getYear()-100));
 		  					rm5.setDay_comment("Qtr_3_"+( dt.getYear()-100));
 		  				}
 		  				else if(dt.getMonth()==11 || dt.getMonth()==0)
// 		  				else if(Ob2.getNav_date().getMonth()==11 || Ob2.getNav_date().getMonth()==10 || Ob2.getNav_date().getMonth()==12)
 		  				{
// 		  					ob_tmp.setComment("Q4_"+( Ob2.getNav_date().getYear()-100));
// 		  					ob_ts.setComent("Qtr_4_"+( dt.getYear()-100));
 		  					rm5.setDay_comment("Qtr_4_"+( dt.getYear()-100));
 		  				}
 		  		        	 		  		        	
 		  		     Calendar cal = Calendar.getInstance();
 		  		        	
 		  		        	
 		  		        	rm5.setDay(from_dt_temp);
 		  		        	
 		  		        	rm5.setScheme_code(sc);
 		  		        	
 		  		        	          for(String cl : col_lst)
 		  		        	          {
 		  		        	        	  
 		  		        	        	  		  		        	        	 
 		  		        	        	  
 		  		        	        	    if(cl.equals("1_year") || cl=="1_year")
 		  		        	        	     {

 		  		        	        	    	 		  		        	        	    	
 		  		        	        	    	Prev_Tmp_Obj_1=null;
 		  		        	        	    	Prev_Tmp_Obj_2=null;
 		  		        	        	    	Prev_Tmp_Obj_3=null;
 		  		        	        	    	Prev_Tmp_Obj_4=null;
 		  		        	        	    
 		  		        	        	    	cal.setTime(from_dt_temp);
 		  		        	        	        cal.add(Calendar.YEAR,-1);
 		  		        	        	        java.util.Date ddd = cal.getTime();
 		  		        	    	      
		 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
		 		  		        	    	      {
		 		  		        	    	    	   ddd.setDate(31);
		 		  		        	    	      }
		 		  		        	    	      else
		 		  		        	    	      {
		 		  		        	    	    	   ddd.setDate(30);
		 		  		        	    	      }
 		  		        	        	    			  		        	        	    	
 		  	                                     ArrayList<nav_hist> prob_date_lst=  Report_5_Main.get_list_of_dates_db(ddd,sc); 
		 		  		        	    	     
 		  	                                   
 		  		        	        	    	if(prob_date_lst.size()>=1)
 		  		        	        	    	{ 		  		        	        	    		 
// 		  		        	        	    		 	 		  		        	        	    	
 		  		        	        	    	 double res = (( ( Prev_Tmp_Obj.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs() )/ prob_date_lst.get(0).getAdjnavrs() )*100);
 		  		        	        	    		
 		  		        	        	    		  rm5.setYear_1(res);
 		  		        	        	    		  
 	 		  		        	        	    	 Prev_Tmp_Obj_1 = prob_date_lst.get(0); 	
 	 		  		        	        	    	 
// 	 		  		            	        	    	 System.out.println("YEAR-1"+Prev_Tmp_Obj_1.getNav_date());
 		  		        	        	    	}
 		  		        	        	
 		  		        	        	    	
 		  		        	        	     }
 		  		        	        	    if(cl.equals("1_year_1") || cl=="1_year_1")
		  		        	        	     {
 		  		        	        	    	if(Prev_Tmp_Obj_1!=null)
 		  		        	        	    	{
 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_1.getKey().getNavdate());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst=  Report_5_Main.get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
 		  		        	        	    		
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
// 	 		  	                                    	double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_1.getAdjnavrs() )/Prev_Tmp_Obj_1.getAdjnavrs() );
 	 		  	                                      
 	 		  	                                    	double res =( ( (Prev_Tmp_Obj_1.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs())/prob_date_lst.get(0).getAdjnavrs())*100);	 
 	 		  	                                    	 
 	 		  	                                        rm5.setYear_1_1(res);
 	 		  	                                       
 	 		  	                                        Prev_Tmp_Obj_2 = prob_date_lst.get(0);
 	 		  	                                        
// 	 		  	                                         System.out.println("YEAR-1_1"+Prev_Tmp_Obj_2.getNav_date());
 	 		  	                                     }
 		  		        	        	    
 		  		        	        	    		
 		  		        	        	    	}
 		  		        	        	    	
		  		        	        	    	
		  		        	        	     }
 		  		        	        	    if(cl.equals("1_year_2") || cl=="1_year_2")
	  		        	        	         {
 		  		        	        	    	if(Prev_Tmp_Obj_2!=null)
 		  		        	        	    	{
// 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_2.getKey().getNavdate());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst=  Report_5_Main.get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
 		  		        	        	    		
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
// 	 		  	                                    	double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_2.getAdjnavrs() )/Prev_Tmp_Obj_2.getAdjnavrs() );
 	 		  	                                    	
 	 		  	                                    	double res = (( (Prev_Tmp_Obj_2.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs())/prob_date_lst.get(0).getAdjnavrs())*100);
 	 		  	                                       rm5.setYear_1_2(res);
 	 		  	                                       
 	 		  	                                       Prev_Tmp_Obj_3 = prob_date_lst.get(0);
 	 		  	                                       
// 	 		  	                                        System.out.println("YEAR-1_2"+Prev_Tmp_Obj_3.getNav_date());
 	 		  	                                     }
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    	}
	  		        	        	         }
 		  		        	        	    if(cl.equals("1_year_3") || cl=="1_year_3")
	  		        	        	         {
 		  		        	        	    	if(Prev_Tmp_Obj_3!=null)
 		  		        	        	    	{
 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_3.getKey().getNavdate());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst= Report_5_Main.get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
 		  		        	        	    		
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
 	 		  	                                    //double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_3.getAdjnavrs() )/Prev_Tmp_Obj_3.getAdjnavrs() );
 	 		  	                                   
 	 		  	                                    	double res = (( (Prev_Tmp_Obj_3.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs())/prob_date_lst.get(0).getAdjnavrs())*100); 	 
 	 		  	                                    	 
 	 		  	                                        rm5.setYear_1_3(res);
 	 		  	                                       
 	 		  	                                        Prev_Tmp_Obj_4 = prob_date_lst.get(0);
 	 		  	                                  
// 	 		  	                                        System.out.println("YEAR-1-3--->>>>"+Prev_Tmp_Obj_4.getNav_date());
 	 		  	                                        
 	 		  	                                        
 	 		  	                                        
// 	 		  	                                       System.out.println("<<<<<<<<<<<---Year-1-3-->>>>>>>>>>>>>>>");
//													
//	 		  	                                       System.out.println("Return Calculated--- Successfully");
//	 		  	                                       System.out.println("Date---------->"+Prev_Tmp_Obj_3.getNav_date());
//	 		  	                                       System.out.println("Prev_tewmp_Obj-->>"+Prev_Tmp_Obj_3.getAdjnavrs());
//	 		  	                                       System.out.println("Probable Date List-->"+prob_date_lst.get(0).getAdjnavrs());
//															
//	 		  	                                       
//	 		  	                                       
//	 		  	                                       System.out.println("Return-->"+res);
//	 		  	                                       
//	 		  	                                       System.out.println("<<<<<<<<<<<--END YEAR-1-3--->>>>>>>>>>>>>>>");
 	 		  	                                        
 	 		  	                                     }
 		  		        	        	    		
 		  		        	        	    		
 		  		        	        	    	}
	  		        	        	         }
 		  		        	        	    if(cl.equals("1_year_4") || cl=="1_year_4")
	  		        	        	         {
 		  		        	        	    	
 		  		        	        	    	 		  		        	        	    	
 		  		        	        	    	if(Prev_Tmp_Obj_4!=null)
 		  		        	        	    	{
// 		  		        	        	    		 		  		        	        	    		
 		  		        	        	    		cal.setTime(Prev_Tmp_Obj_4.getKey().getNavdate());
 	 		  		        	        	        cal.add(Calendar.YEAR,-1);
 	 		  		        	        	        java.util.Date ddd = cal.getTime();
 	 		  		        	    	      
// 	 		  		        	        	        System.out.println("DATE - ! DATE-->"+ddd);
 	 		  		        	        	        
 	 		  		        	        	        
 			 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(31);
 			 		  		        	    	      }
 			 		  		        	    	      else
 			 		  		        	    	      {
 			 		  		        	    	    	   ddd.setDate(30);
 			 		  		        	    	      }
 			 		  		        	    	      
 			 		  		        	    	      	 		  		        	        	    			  		        	        	    	
 	 		  	                                     ArrayList<nav_hist> prob_date_lst=  Report_5_Main.get_list_of_dates_db(ddd,sc); 
 		  		        	        	    		 
// 	 		  	                                      System.out.println("For Year-4 CCalculation");
// 		  		        	        	    		  System.out.println("Probable List-->>"+prob_date_lst.size());
// 		  		        	        	    		  System.out.println("List FIRST DATA--"+prob_date_lst.get(0).getNav_date());
 	 		  	                                     
 	 		  	                                     if(prob_date_lst.size()>=1 )
 	 		  	                                     {
 	 		  	                                    	 
 	 		  	                                   
// 	 		  	                                   	double res = ( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj_4.getAdjnavrs() )/Prev_Tmp_Obj_4.getAdjnavrs() );
 	 		  	                                       double res = (( ( Prev_Tmp_Obj_4.getAdjnavrs() - prob_date_lst.get(0).getAdjnavrs() ) /prob_date_lst.get(0).getAdjnavrs())*100); 	
 	 		  	                                       
 	 		  	                                       rm5.setYear_1_4(res);
 	 		  	                                       
 	 		  	                                       Prev_Tmp_Obj_5 = prob_date_lst.get(0);
 	 		  	                                       
// 	 		  	                                       System.out.println("<<<<<<<<<<<--START YEAR-1-4--->>>>>>>>>>>>>>>");
//															
// 	 		  	                                       System.out.println("Return Calculated--- Successfully");
// 	 		  	                                       
// 	 		  	                                       System.out.println("Prev_tewmp_Obj-->>"+Prev_Tmp_Obj_4.getAdjnavrs());
// 	 		  	                                       System.out.println("Probable Date List-->"+prob_date_lst.get(0).getAdjnavrs());
//															
// 	 		  	                                       
// 	 		  	                                       
// 	 		  	                                       System.out.println("Return-->"+res);
// 	 		  	                                       
// 	 		  	                                       System.out.println("<<<<<<<<<<<-- END Year-1-4 --->>>>>>>>>>>>>>>");
 	 		  	                                       
 	 		  	                                       
 	 		  	                                     }	
 	 		  	                                     
 	 		  	                                    
 	 		  	                               
 		  		        	        	    	}
	  		        	        	         }
 		  		        	        	    
 		  		        	               	 if(cl.equals("1_year_1_plus") || cl=="1_year_1_plus")
		  		        	        	     {
//		  		        	        	    	
 		  		        	               		 
 		  		        	                	cal.setTime(from_dt_temp);
		  		        	        	        cal.add(Calendar.YEAR,1);
		  		        	        	        java.util.Date ddd = cal.getTime();
		  		        	    	      
	 		  		        	    	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
	 		  		        	    	      {
	 		  		        	    	    	   ddd.setDate(31);
	 		  		        	    	      }
	 		  		        	    	      else
	 		  		        	    	      {
	 		  		        	    	    	   ddd.setDate(30);
	 		  		        	    	      }
		  		        	        	    			  		        	        	    	
		  	                                     ArrayList<nav_hist> prob_date_lst=  Report_5_Main.get_list_of_dates_db(ddd,sc); 
	 		  		        	    	         
		  	                                   
		  		        	        	    	if(prob_date_lst.size()>=1)
		  		        	        	    	{ 		  		        	        	    		 
//		  		        	        	    		 currDt_tmp=prob_date_lst.get(0).getNav_date();
	 		  		        	        	   	// prob_date_lst.get(0).getAdjnavrs(); //Adjusted NAVRs
		  		        	        	
		  		        	        	   double res = (( ( prob_date_lst.get(0).getAdjnavrs()-Prev_Tmp_Obj.getAdjnavrs() )/Prev_Tmp_Obj.getAdjnavrs() )*100);
		  		        	        	    		 
		  		        	        	    		 
		  		        	        	    		 
	 		  		        	        	    	 rm5.setYear_1_plus(res);
//	 		  		        	        	    	 Prev_Tmp_Obj_1 = prob_date_lst.get(0); 	 	 		  		        	        	    	 	 		  		        	        	    	 
	 		  		        	        	    	 
		  		        	        	    	} 
		  		        	        	    			  		        	        	    			  		        	        	    			  		        	        	    	
		  		        	        	     }
 		  		        	          }
 		  		        	          
 		  		        	      
 		  		        	    	ssn.save(rm5);
		  		        	          db_flag++;
 		  		        	      
 		  		        	          
 		  		        	          

 		  		  	        	 if(db_flag%200==0)
 		  		  	        	 {
 		  		  	        		 ssn.flush();
 		  		  	        		 ssn.clear();
 		  		  	        	     ssn.getTransaction().commit();
 		  		  	        		 ssn.beginTransaction();
 		  		  	        		 db_flag=0;
 		  		  	        	 }
 		  		        	          
 		  		        	  
 		  		        	  
 		  		        	
 		  		        	
 		  		         }
 		  		     
 		  		      
 		       }
 		       ssn.getTransaction().commit();
 		       ssn.close();
		      System.out.println("<<--- Report Complete --->>");
	     	
		      Report_5_Main.GENERATE_RANK(Fund_Type);
	}
	catch (Exception e) {
		
		return e.getMessage();
	}
   	      	
   	      	return "success";

	}
	
}
