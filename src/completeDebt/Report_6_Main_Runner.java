package completeDebt;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import controller.Report_6_main;
import model.Avg_ret_Model;
import model.Report_6_Model;
import model.Report_6_pk;
import model.nav_report_3_stable;
import sessionFactory.HIbernateSession;

public class Report_6_Main_Runner 
{
	 
	public String Calculate_Report_6(String Fund_Type) 
	{
		 long temp_sc_cd=0;
		  try
		  {
			  
			   
			  Session ssn = HIbernateSession.getSessionFactory().openSession(); 
			    ssn.beginTransaction();	
			    int x=-2;
			    int last_4_qtr=0,last_8_qtr=0,last_12_qtr=0,last_16_qtr=0,last_20_qtr=0;
//			    String Fund_Type;
			    
			    
			    ArrayList<nav_report_3_stable>  nav_rep_lst_tmp = null;			    			    
//		        Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
//				criteria_1.setProjection( Projections.distinct(Projections.property("comment")));  		
//	     		criteria_1.addOrder(Order.asc("end_dt"));
//	     		
//		// 		criteria_1.add(Restrictions.eq("comment", cmnt));
//				
//	     		ArrayList<String> sortd_commnt_lst = null;
//		 		sortd_commnt_lst = (ArrayList<String>) criteria_1.list();
		 		
			                                        //  If required to done MANUALY for some scheme_Code 
													//		     ArrayList<Long> scheme_code_list_temp = new ArrayList<Long>();
													//		    
													//	         long[] schm_cd_lst = {23,407,447,489,716,748,758,903,905,931,933,942,950,1131,1273,1282,1283,1284,1331,1346,1348,1441,1464,1492,1608,1623,1849,1858,1956,1962,1973,2069,2090,2127,2129,2133,2171,2235,2271,2384,2390,2455,2461,2654,2669,2681,2711,2752,2782,2860,2896,3065,3247,3249,3281,3305,3317,3461,3581,3587,3626,3641,3644,4282,4457,4980,5153,6075,7329,7615,7747,7785,7841,7870,7874,8151,8217,8229,8250,8463,9078,9240,11889,12836,12860,12865,14493,14559,15557,16672,16706,21293,21769,24776,25378,25473,25995,26481,26778,27106,27775,28707,29082,29277,29359,29360,29424,29786,30021,30022,30395,30396,30397,31046,31353,31451,31571,31642,31837,32280,32348,32542,32658,33053,35321};
													//	         
													//	         for(long b : schm_cd_lst)
													//	         {
													//	        	 scheme_code_list_temp.add(b);
													//	         }
													//		    
													//	         String hql_nw=" from avg_return where key.Fund_Type='"+Fund_Type+"' and key.scheme_code IN:list";
//			                                        //           Query q_2 = ssn.createQuery(hql_nw).setParameterList("list", scheme_code_list_temp);
		 		
			    String hql_nw=" from avg_return where key.Fund_Type='"+Fund_Type+"'";
			    
//		 		String hql_nw=" from avg_return where start_dt<='2016-10-20'";	    
//			    String hql_nw=" from avg_return where start_dt='2010-03-31' and scheme_code=407";
			    
		 		
		 		Query q_2 = ssn.createQuery(hql_nw);
		 		
//		 		Criteria criteria_2 = ssn.createCriteria( Avg_ret_Model.class );
//		 		criteria_2.add(Restrictions.le("start_dt",  new Date(115,02,31)));
//		 		criteria_2.addOrder(Order.asc("scheme_code"));
//		 		ArrayList<Avg_ret_Model> avg_ret_lst = (ArrayList<Avg_ret_Model>) criteria_2.list();
		 		
		 		ArrayList<Avg_ret_Model> avg_ret_lst = (ArrayList<Avg_ret_Model>) q_2.list();
		 		
		 		
		 			for(Avg_ret_Model arm :  avg_ret_lst)
		 			{
		 				  Report_6_Model r6m = new Report_6_Model();
		 				  Report_6_pk pk = new Report_6_pk();
		 				  
		 				  pk.setScheme_code(arm.getKey().getScheme_code());
		 				  pk.setFrom_date(arm.getKey().getStart_dt());
		 				  pk.setFund_Type(Fund_Type);
		 				  
		 				  r6m.setKey(pk);
		 				  
		 				  
		 				  
		 				 if(arm.getKey().getStart_dt().getMonth()==0 || arm.getKey().getStart_dt().getMonth()==1 ||arm.getKey().getStart_dt().getMonth()==2 )
			 			 {
			 				// System.out.println("Qtr_1_"+( dd.getYear()-100));
			 				 r6m.setComment("Qtr_1_"+( arm.getKey().getStart_dt().getYear()-100));
			 			 }
			 			 else if(arm.getKey().getStart_dt().getMonth()==3 || arm.getKey().getStart_dt().getMonth()==4 || arm.getKey().getStart_dt().getMonth()==5 )
						 {
			 				//System.out.println("Qtr_2_"+( dd.getYear()-100));
							 r6m.setComment("Qtr_2_"+( arm.getKey().getStart_dt().getYear()-100));
						 }
			 			else if(arm.getKey().getStart_dt().getMonth()==6 || arm.getKey().getStart_dt().getMonth()==7 ||arm.getKey().getStart_dt().getMonth()==8 )
						 {
			 				//System.out.println("Qtr_3_"+( dd.getYear()-100));
							 r6m.setComment("Qtr_3_"+( arm.getKey().getStart_dt().getYear()-100));
						 }
			 			else if(arm.getKey().getStart_dt().getMonth()==9 || arm.getKey().getStart_dt().getMonth()==10 ||arm.getKey().getStart_dt().getMonth()==11 )
						 {
			 				//System.out.println("Qtr_4_"+( dd.getYear()-100));
							 r6m.setComment("Qtr_4_"+( arm.getKey().getStart_dt().getYear()-100));
						 }  				  
		 				  
//		 				  r6m.setComment(arm.getComment());
		 				  
//		 				  x = sortd_commnt_lst.indexOf(arm.getComment());
		 				 
//		 				  if(x!=-1)
//		 				  {
//		 					   if(x!=0)
//		 					   {
//		 						  last_4_qtr  = Quarter_index_calc(x,4);
//		 						  last_8_qtr  = Quarter_index_calc(x,8);
//		 						  last_12_qtr = Quarter_index_calc(x,12);
//		 						  last_16_qtr  = Quarter_index_calc(x,16);
//		 						  last_20_qtr  = Quarter_index_calc(x,20);
		 				          
		 				 temp_sc_cd = r6m.getKey().getScheme_code();
		 				          
		 				Report_6_main.Calculate_Save_Actual_Values(r6m,4,arm,ssn,Fund_Type);
		 				Report_6_main.Calculate_Save_Actual_Values(r6m,8,arm,ssn,Fund_Type);
		 				Report_6_main.Calculate_Save_Actual_Values(r6m,12,arm,ssn,Fund_Type);
		 				Report_6_main.Calculate_Save_Actual_Values(r6m,16,arm,ssn,Fund_Type);
		 				Report_6_main.Calculate_Save_Actual_Values(r6m,20,arm,ssn,Fund_Type);
		 						  
		 						 Criteria criteria_11 = ssn.createCriteria( nav_report_3_stable.class );
		 				         criteria_11.add(Restrictions.eq("nav_from_date", r6m.getKey().getFrom_date()));  
		 				         criteria_11.add(Restrictions.eq("scheme_Code",r6m.getKey().getScheme_code()));
		 				         criteria_11.add(Restrictions.eq("comment","12"));
		 				           
		 				         nav_rep_lst_tmp = (ArrayList<nav_report_3_stable>) criteria_11.list();
		 						  
		 				         if(nav_rep_lst_tmp.size() > 0)
		 				           {
		 				        	   r6m.setForward_12_mnth_ret(nav_rep_lst_tmp.get(0).getNav_value());   
		 				           }						  
		 						  
		 						  
		 				              
		 						     ssn.save(r6m);
		 						     					
		 						     
		  		  	        		 ssn.flush();
		  		  	        		 ssn.clear();
		  		  	        		 
		  		  	        	     ssn.getTransaction().commit();
		  		  	        		 ssn.beginTransaction();
//		 						  
//		 					   }
//		 					   
//		 					  
//		 					  
//		 				  }
		 				  
		 				  
		 				  
		 			}
		 		 
	 		   
		 		
	 		System.out.println("<<<<<<<--------Report 6 Complete---------->>>>>>>>>>>>");
			  
		  }
		  catch (Exception e) 
		  {			  
			 e.printStackTrace();
			 System.out.println("Error in scheme_code-->>"+temp_sc_cd);			 
			 return e.getMessage();
		  }
 		
 		
 		
 	return "success";	

	}
   
	
}
