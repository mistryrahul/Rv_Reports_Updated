package completeDebt;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import controller.Report_10_Main;
import model.Avg_ret_Model;
import model.Nav_report_temp_1;
import model.Report_10_Model;
import model.Report_6_pk;
import model.nav_hist;
import sessionFactory.HIbernateSession;

public class Report_10_Runner 
{
public String Calculate_report_10(String Fund_Type) 
{
		
//		String Fund_Type;
		java.util.Date temp_dt=null;
		Report_10_Model rtm = null;
		Report_6_pk pk_6 =null;
		nav_hist current_nav_obj=null;
		long temp_50_id=0;
		long temp_200_id=0;
		
		double last_50_days_avg_nav=0;
		double last_50_days_total=0;
		double last_200_days_avg_nav=0;
		double last_200_days_total=0;
		double last_50_days_avg_prcnt=0;
		double last_200_days_avg_prcnt=0;
		double total_avg_50_200_days=0;
		
		int no_of_obs_50=0;
		int no_of_obs_200=0;
		int db_save=0;
//		java.util.Date dd_50=null;
//		java.util.Date dd_200=null;		
//		 Calendar cal_1 = Calendar.getInstance();
//		 Calendar cal_2 = Calendar.getInstance();
		 
		   try
		   {
			   
			   Session ssn = HIbernateSession.getSessionFactory().openSession(); 
			   ssn.beginTransaction();		
			    
//			   ArrayList<Custom_Merged_Report_W_Rank> quarter_list = (ArrayList<Custom_Merged_Report_W_Rank>) ssn.createQuery("from Custom_Merged_Report_W_Rank order by scheme_code").list();
              
			   ArrayList<Avg_ret_Model> quarter_list = (ArrayList<Avg_ret_Model>) ssn.createQuery("from avg_return where key.Fund_Type='"+Fund_Type+"'order by scheme_code").list();
			   
			   
			   
//			     for(Custom_Merged_Report_W_Rank cmrwr : quarter_list)
			    for(Avg_ret_Model cmrwr : quarter_list)
			     {
//			    	 temp_dt
			    	   rtm = new Report_10_Model();
					   pk_6 =new Report_6_pk();
					   
					   pk_6.setFrom_date(cmrwr.getKey().getStart_dt());
					   pk_6.setScheme_code(cmrwr.getKey().getScheme_code());
					   pk_6.setFund_Type(Fund_Type);
					   
					   rtm.setKey(pk_6);
					   
					   last_200_days_total=0;
					   last_50_days_total=0;
					   no_of_obs_50=0;
					   no_of_obs_200=0;
					   
			    	  ArrayList<nav_hist> dt_lst  = Report_10_Main.get_list_of_dates_db(cmrwr.getKey().getStart_dt(),(int) cmrwr.getKey().getScheme_code()); 	 
			    	  
			    	  current_nav_obj=dt_lst.get(0);
			    	  
			    	  rtm.setCurrent_nav(current_nav_obj.getAdjnavrs());
			    	  
//			    	  temp_50_id = (current_nav_obj.getId()-50);
			    	  
			    	  			    	  
//			    	  ArrayList<nav_hist> dt_lst_last_50_days  = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where id<="+current_nav_obj.getId()+" and scheme_code="+current_nav_obj.getScheme_code()+" order by id desc").setMaxResults(50).list();
//			    	  ArrayList<nav_hist> dt_lst_last_50_days  = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where id>="+temp_50_id+" and id<"+current_nav_obj.getId()+" and scheme_code="+current_nav_obj.getScheme_code()).list();
			    	  
			    	  
			    	  ArrayList<nav_hist> dt_lst_last_50_days  = (ArrayList<nav_hist>) ssn.createQuery("from navhistfull_adjnavs where key.navdate<=? and key.schemecode=? order by key.navdate desc").setDate(0,current_nav_obj.getKey().getNavdate()).setLong(1,current_nav_obj.getKey().getSchemecode()).setMaxResults(50).list();
			    	  
			    	  
			    	  if(dt_lst_last_50_days.size()==50)
			    	  {

				    	  for(nav_hist nh : dt_lst_last_50_days)
				    	  {
				    		  last_50_days_total=last_50_days_total + nh.getAdjnavrs();
				    		  no_of_obs_50++;
				    	  }
				    	  
				    	  last_50_days_avg_nav = (last_50_days_total/50);
				    	  last_50_days_avg_prcnt = (((current_nav_obj.getAdjnavrs() - last_50_days_avg_nav)/last_50_days_avg_nav)*100);
				    	  
				    	  rtm.setLast_50_days_avg(last_50_days_avg_nav);
				    	  rtm.setLast_50_day_return(last_50_days_avg_prcnt);
			    	  }
			    	  
			    	  
			    	  
			    	  
//			    	  temp_200_id = (current_nav_obj.getId()-200);
			    	  
//			    	  ArrayList<nav_hist> dt_lst_last_200_days  = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where id>="+temp_200_id+" and id<"+current_nav_obj.getId()+" and scheme_code="+current_nav_obj.getScheme_code()).list();
//			    	  ArrayList<nav_hist> dt_lst_last_200_days  = (ArrayList<nav_hist>) ssn.createQuery("from nav_hist_full where id<="+current_nav_obj.getId()+" and scheme_code="+current_nav_obj.getScheme_code()+" order by id desc").setMaxResults(200).list();
			    	  
			    	  ArrayList<nav_hist> dt_lst_last_200_days  = (ArrayList<nav_hist>) ssn.createQuery("from navhistfull_adjnavs where key.navdate<=? and key.schemecode=? order by key.navdate desc").setDate(0,current_nav_obj.getKey().getNavdate()).setLong(1,current_nav_obj.getKey().getSchemecode()).setMaxResults(200).list();
			    	  
			    	   if(dt_lst_last_200_days.size()==200)
			    	   {
			    		   for(nav_hist nh : dt_lst_last_200_days)
					    	  {
					    		  last_200_days_total=last_200_days_total + nh.getAdjnavrs();
					    		  no_of_obs_200++;
					    	  }
					    	  
					    	  last_200_days_avg_nav = (last_200_days_total/200);
					    	  last_200_days_avg_prcnt = (((current_nav_obj.getAdjnavrs() - last_200_days_avg_nav)/last_200_days_avg_nav)*100);
					    	  
					    	  rtm.setLast_200_days_avg(last_200_days_avg_nav);
					    	  rtm.setLast_200_day_return(last_200_days_avg_prcnt);
					    	  
					    	  total_avg_50_200_days = (((last_50_days_avg_nav - last_200_days_avg_nav)/ last_200_days_avg_nav)*100);
					    	  rtm.setAvg_return_50_minus_200(total_avg_50_200_days);	 
					    	  
			    	   }
				      
			    	   
			    	   Query q33 =  ssn.createQuery("from nav_report_temp_1 where key.scheme_code=? and key.date_ori=? and key.Fund_Type='"+Fund_Type+"'").setLong(0, current_nav_obj.getKey().getSchemecode()).setDate(1,current_nav_obj.getKey().getNavdate());
						 
						 
						 ArrayList<Nav_report_temp_1> nav_rem_tmp_lst = (ArrayList<Nav_report_temp_1>) q33.list();
						 
						  if(nav_rem_tmp_lst.size()>0)
						  {
						       rtm.setForward_12_months(nav_rem_tmp_lst.get(0).getRet_mnth_12_forwd());
						       
						       rtm.setForward_9_months(nav_rem_tmp_lst.get(0).getRet_mnth_9_forwd());
						       
						  }			    	  			    	     			    	  			    	  
			    	  ssn.save(rtm);
			    	  db_save++;
			    	  
			    	  if(db_save%5==0)
	   		 		    {  	ssn.getTransaction().commit();
	   		 		        ssn.beginTransaction();
	   		 		        ssn.flush();
					        ssn.clear();
	   		 		    	db_save=0;
	   		 		    }
			    	  
			    	  
			    	 
			     }
			     
			     
			     
			     ssn.getTransaction().commit();
			     ssn.close();
			     
			     System.out.println("<------Report Complete---->");
			   
		
			   
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
			   return e.getMessage();
		   }
		
		
		return "success";

	}
}
