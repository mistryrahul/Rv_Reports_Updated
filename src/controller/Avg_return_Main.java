package controller;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import model.Avg_ret_Model;
import model.Nav_hist_PK;
import model.Scheme_Detail;
import model.composite_pk_avg_re_model;
import model.nav_hist;
import sessionFactory.HIbernateSession;

public class Avg_return_Main 
{
//	public static List<java.util.Date> getDates(long s_code, Session ssn , java.util.Date next_qtr_dt) throws ParseException
//	{
//		List<java.util.Date> dd_final=null;
////		Session ssn=null;
////		ssn = HIbernateSession.getSessionFactory().openSession(); 
//	    
////		ssn.beginTransaction();
//	  	
//		if(next_qtr_dt==null)
//		{
//			Criteria criteria_1 = ssn.createCriteria(nav_hist.class );
//			criteria_1.setProjection( Projections.distinct(Projections.property("nav_date")));  		
//	  		criteria_1.add(Restrictions.eq("scheme_code",(int) s_code));
//	  		criteria_1.addOrder(Order.asc("nav_date"));
//	  		criteria_1.setMaxResults(1);
//	  		
//	  		List<java.util.Date> dd = criteria_1.list(); 
//	           
//	  		if(dd.size()==0)
//	  		{
//	  			dd_final=null;
//	  		}
//	  		else
//	  		{
//	  	  		java.util.Date ddd = dd.get(0);         		
//	  	  		
//			  	  if(ddd.getMonth()==0 || ddd.getMonth()==1 || ddd.getMonth()==2)
//			      {
//			    	   ddd.setDate(31);
//			    	   ddd.setMonth(2);
//			      }
//			  	  if(ddd.getMonth()==3 || ddd.getMonth()==4 || ddd.getMonth()==5)
//			      {
//			  	        ddd.setDate(30);
//			  	        ddd.setMonth(5);
//			      }
//			  	  if(ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==8)
//			      {
//			  	        ddd.setDate(30);
//			  	        ddd.setMonth(8);
//			      }
//			  	  if(ddd.getMonth()==9 || ddd.getMonth()==10 || ddd.getMonth()==11)
//			      {
//				        ddd.setDate(31);
//				        ddd.setMonth(11);
//			      }
////	        System.out.println("<<<<<<<<<------------>>>>>>>>>>>>");
////		  	  System.out.println("FInal Date Prepared-->>"+ddd);
////			  System.out.println("Scheme_code-->>"+s_code);	  
////			  System.out.println("<<<<<<<<<------------>>>>>>>>>>>>");
//			  
//			  
//			  
//			  	List<nav_hist> nv_dt_lst = get_list_of_dates_db(ddd, (int) s_code, ssn);		  	  
//		        
//			  	
////			  	   System.out.println("Got value @ Date-->>"+nv_dt_lst.get(0));
//			  	if(nv_dt_lst.size()==0)
//			  	{
//			  		dd_final=null;
//			  		
//			  	}
//			  	else
//			  	{
//			  		dd_final = new ArrayList<java.util.Date>();
//				  	
//				  	dd_final.add(nv_dt_lst.get(0).getNav_date());
//			  	}
//			  	
//			  	
//	  		}
//		}
//		else
//		{
//			Calendar cal = Calendar.getInstance();
//			 
//			ArrayList<Date> first_dt = (ArrayList<Date>) ssn.createQuery("select distinct(nav_date) from nav_hist_full where scheme_code='"+s_code+"'").list();
//			java.util.Date ddd = first_dt.get(0);
//	
//			if(ddd.getMonth()==0 || ddd.getMonth()==1 || ddd.getMonth()==2)
//		      {
//		    	   ddd.setDate(31);
//		    	   ddd.setMonth(2);
//		      }
//		  	  if(ddd.getMonth()==3 || ddd.getMonth()==4 || ddd.getMonth()==5)
//		      {
//		  	        ddd.setDate(30);
//		  	        ddd.setMonth(5);
//		      }
//		  	  if(ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==8)
//		      {
//		  	        ddd.setDate(30);
//		  	        ddd.setMonth(8);
//		      }
//		  	  if(ddd.getMonth()==9 || ddd.getMonth()==10 || ddd.getMonth()==11)
//		      {
//			        ddd.setDate(31);
//			        ddd.setMonth(11);
//		      }
//		  	  
//		  	  
//		  	  cal.setTime(ddd);
////		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
//		      cal.add(Calendar.MONTH,3);
//		      ddd = cal.getTime();
//		      
//		      
//		  	  
//		      dd_final = getDates(s_code,ssn,ddd);
//			
//		}
//		
//		
//		  
//  		
//  		
////  		ssn.close();
//  		
//  		ssn.getTransaction().commit();
//  		ssn.beginTransaction();
//  		
//  		return dd_final;
//  		
//	}
	
	
	public static List<java.util.Date> getDates(long s_code, Session ssn , java.util.Date next_qtr_dt) throws ParseException
	{
		List<java.util.Date> dd_final=null;
//		Session ssn=null;
//		ssn = HIbernateSession.getSessionFactory().openSession(); 
	    
//		ssn.beginTransaction();
	  	
		if(next_qtr_dt==null)
		{
			System.out.println("IN NULLL CASE");
			
			
			
			Long l = new Long(s_code);
			
			Criteria criteria_1 = ssn.createCriteria(nav_hist.class );
			criteria_1.setProjection( Projections.distinct(Projections.property("key.navdate")));  		
	  		criteria_1.add(Restrictions.eq("key.schemecode",l));
	  		criteria_1.addOrder(Order.asc("key.navdate"));
	  		criteria_1.setMaxResults(1);
//	  		"select distinct(nav_date) from navhistfull_adjnavs where "
	  		// NEW ADDED 
	  		List<java.util.Date> dd = criteria_1.list(); 
	           
	  		if(dd.size()==0)
	  		{
	  			
	  			System.out.println("COMING HERE IN THE no DTA LIST(==NULL)");
	  			dd_final=null;
	  			
	  		}
	  		else if(dd.size()>0)
	  		{
	  	  		java.util.Date ddd = dd.get(0);         		
	  	  		
			  	  if(ddd.getMonth()==0 || ddd.getMonth()==1 || ddd.getMonth()==2)
			      {
			    	   ddd.setDate(31);
			    	   ddd.setMonth(2);
			      }
			  	  if(ddd.getMonth()==3 || ddd.getMonth()==4 || ddd.getMonth()==5)
			      {
			  	        ddd.setDate(30);
			  	        ddd.setMonth(5);
			      }
			  	  if(ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==8)
			      {
			  	        ddd.setDate(30);
			  	        ddd.setMonth(8);
			      }
			  	  if(ddd.getMonth()==9 || ddd.getMonth()==10 || ddd.getMonth()==11)
			      {
				        ddd.setDate(31);
				        ddd.setMonth(11);
			      }
//	        System.out.println("<<<<<<<<<------------>>>>>>>>>>>>");
//		  	  System.out.println("FInal Date Prepared-->>"+ddd);
//			  System.out.println("Scheme_code-->>"+s_code);	  
//			  System.out.println("<<<<<<<<<------------>>>>>>>>>>>>");
			  
			  
			  
			  	List<nav_hist> nv_dt_lst = Avg_return_Main.get_list_of_dates_db(ddd, (int) s_code, ssn);		  	  
		        
			  	
//			  	   System.out.println("Got value @ Date-->>"+nv_dt_lst.get(0));
			  	if(nv_dt_lst.size()==0)
			  	{
			  		dd_final=null;
			  		
			  		
			  		ArrayList<Date> first_dt = (ArrayList<Date>) ssn.createQuery("select distinct(key.navdate) from navhistfull_adjnavs where key.schemecode='"+s_code+"'").list();
					java.util.Date ddd_1 = first_dt.get(0);
			
					if(ddd_1.getMonth()==0 || ddd_1.getMonth()==1 || ddd_1.getMonth()==2)
				      {
						ddd_1.setDate(31);
						ddd_1.setMonth(2);
				      }
				  	  if(ddd_1.getMonth()==3 || ddd_1.getMonth()==4 || ddd_1.getMonth()==5)
				      {
				  		ddd_1.setDate(30);
				  		ddd_1.setMonth(5);
				      }
				  	  if(ddd_1.getMonth()==6 || ddd_1.getMonth()==7 || ddd_1.getMonth()==8)
				      {
				  		ddd_1.setDate(30);
				  		ddd_1.setMonth(8);
				      }
				  	  if(ddd_1.getMonth()==9 || ddd_1.getMonth()==10 || ddd_1.getMonth()==11)
				      {
				  		ddd_1.setDate(31);
				  		ddd_1.setMonth(11);
				      }
		  			
		  			dd_final = getDates(s_code,ssn,ddd);
			  		
			  		
			  	}
			  	else
			  	{
			  		dd_final = new ArrayList<java.util.Date>();
				  	
				  	dd_final.add(nv_dt_lst.get(0).getKey().getNavdate());
				  	
				  	
			  	}
			  	
			  	
	  		}
		}
		else
		{
			Calendar cal = Calendar.getInstance();	  	  
		  	  
		  	  cal.setTime(next_qtr_dt);
//		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
		      cal.add(Calendar.MONTH,3);
		      Date ddd = cal.getTime();
		      
		      
		       
		  	List<nav_hist> nv_dt_lst = Avg_return_Main.get_list_of_dates_db(ddd, (int) s_code, ssn);		  	  
	        
		  	
//		  	   System.out.println("Got value @ Date-->>"+nv_dt_lst.get(0));
		  	if(nv_dt_lst.size()==0)
		  	{
		  		dd_final=null;
		  		
		  	}
		  	else
		  	{
		  		dd_final = new ArrayList<java.util.Date>();
			  	
			  	dd_final.add(nv_dt_lst.get(0).getKey().getNavdate());
		  	}
		      
		  	  
			
		}
		
		
		  
  		
  		
//  		ssn.close();
  		
  		ssn.getTransaction().commit();
  		ssn.beginTransaction();
  		
  		return dd_final;
  		
	}
	
	
	public static void Calculate_Rank(String fund_type) 
	{
		
	try
	  {
		Session ssn=null;
		int db_flag=0;
		ssn = HIbernateSession.getSessionFactory().openSession(); 
	  	ssn.beginTransaction();
	  	
//		Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
//		criteria_1.setProjection( Projections.distinct(Projections.property("comment")));
//		criteria_1.addOrder(Order.asc("end_dt"));
//		
		
	  	Query qq1 = ssn.createQuery("select distinct(comment) from avg_return where key.Fund_Type ='"+fund_type+"' order by end_dt");
		
//		System.out.println("select distinct(comment) from avg_return where key.Fund_Type ='"+fund_type+"' order by end_dt");
		
//		Criteria criteria_2 = ssn.createCriteria( nav_report_3_stable.class );
// 		criteria_2.setProjection( Projections.distinct(Projections.property("scheme_Code")));  		
//   		criteria_2.addOrder(Order.asc("scheme_Code"));
   		
   		ArrayList<String> comment_list = (ArrayList<String>) qq1.list();
   		
		double temp_nav_val=0;
		int temp_rank=0;
		int retval=0; // For Double compare
   		
   		
   			
   		        for(String cmnt : comment_list)
   		        {
   		        	
//   		        	System.out.println("<-----------------COMMENT----------------->");
//   		        	System.out.println(cmnt);
   		           double r=0;
   		           temp_nav_val=999;
   				   temp_rank=1;
   				
   		 		   String hql = "from avg_return where comment=:cmnt and key.Fund_Type ='"+fund_type+"' order by nav_val desc";            
   		 		   
   		 		   System.out.println(hql);
   		 		   
   		 		   Query q = ssn.createQuery(hql);
   		 		   q.setParameter("cmnt", cmnt);
   		 		   
   		 		   ArrayList<Avg_ret_Model> a_r_m =  (ArrayList<Avg_ret_Model>) q.list();
   		 		    
   		 		    for(Avg_ret_Model arm : a_r_m)
   		 		    {
   		 		    	
   		 		       retval = Double.compare(temp_nav_val,arm.getNav_val());
   		 		    
   		 		    	if(retval==0)
   		 		    	{
   		 		    	    arm.setRank(temp_rank-1);
   		 		    	    ssn.update(arm);
   		 		    	    db_flag++;
   		 		    	}
   		 		    	else
   		 		    	{   
   		 		    		arm.setRank(temp_rank);
   		 		    	    ssn.update(arm);
   		 		    	    db_flag++;  
   		 		    	}
   		 		    	
   		 		        temp_nav_val = arm.getNav_val();
   		 		        temp_rank++;
   		 		    }
   		 		    
   		 		    
   		 		    if(db_flag%1000==0)
   		 		    {
   		 		    	ssn.getTransaction().commit();
   		 		        ssn.beginTransaction();
   		 		        ssn.flush();
				        ssn.clear();	
   		 		        db_flag=0;
   		 		    }
   		 		    
   		        }
   			
	       
   		
   		   ssn.getTransaction().commit();
		   ssn.close();
		   System.out.println("<--------=Report COmplete=------->>");
		   
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
		
	}
	
	public static ArrayList<nav_hist> get_list_of_dates_db(java.util.Date day, int scheme_code, Session ssn) throws ParseException
	{
			  SimpleDateFormat formatter=null;
			  java.util.Date date_nav_chk_start=null;
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<nav_hist> lst = new ArrayList<nav_hist>();

			  ssn.getTransaction().commit();
			  ssn.beginTransaction();
			  //			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);
			  
			  Long l = new Long(scheme_code);
			  
			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
			 
			  Criteria criteria = ssn.createCriteria(nav_hist.class);
			  criteria.add(Restrictions.eq("key.schemecode",l)); 
			  criteria.add(Restrictions.between("key.navdate", date_nav_chk_end, day));
      		  criteria.addOrder(org.hibernate.criterion.Order.desc("key.navdate"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
			  ssn.getTransaction().commit();
//			  ssn.close();
			  ssn.beginTransaction();
		 return lst;
	}
	
	public static void Calculate_Save_Nav(java.util.Date d1 , nav_hist Ob2 , int sch_code , String fund_type,Session ssn)
	{
		
//		System.out.println("TO DATE-->>"+d1);
//		System.out.println("TO From DATE-->>"+d2);
		double val=0;
//		Session ssn=null;
		
//		ssn = HIbernateSession.getSessionFactory().openSession(); 
		
		if(ssn.getTransaction()==null)
		{
			ssn.beginTransaction();	
		}
		
		Long l = new Long(sch_code);
		nav_hist Ob1 = (nav_hist) ssn.createCriteria(nav_hist.class).add(Restrictions.eq("key.schemecode", l)).add(Restrictions.eq("key.navdate", d1 )).uniqueResult();  
		
		System.out.println("");
		
		
//		nav_hist Ob2 = (nav_hist) ssn.createCriteria(controller.nav_hist.class).add(Restrictions.eq("scheme_code", (int) sch_code)).add(Restrictions.eq("nav_date", d2 )).uniqueResult();
	    
		
//		double res = ((Ob1.getAdjnavrs() - Ob2.getAdjnavrs())/ Ob2.getAdjnavrs());
		
//		System.out.println("<<----------------in SAVE Method--------------->>");
//		System.out.println("if OBJ 1 NULL---"+(Ob1==null));
//		System.out.println("Ob1 Value--->>"+Ob1.getNav_date());
//		
//		
//		System.out.println("if OBJ 2 NULL---"+(Ob2==null));
//		System.out.println("Ob2 Value (DATE)--->>>"+Ob2.getNav_date());
//		
//		System.out.println("Scheme_COde----"+sch_code);
//		
//		System.out.println("<<----------------in SAVE Method END--------------->>");
		
		double res = (((Ob2.getAdjnavrs() - Ob1.getAdjnavrs()) / Ob1.getAdjnavrs())*100);
		
		
//		Avg_ret_Model tmp_ob = new Avg_ret_Model();
		
		composite_pk_avg_re_model ob_pk = new composite_pk_avg_re_model();
		ob_pk.setScheme_code(sch_code);
		ob_pk.setStart_dt(d1);
		ob_pk.setFund_Type(fund_type);
		
		Avg_ret_Model ob_tmp =new Avg_ret_Model();
		ob_tmp.setKey(ob_pk);
		ob_tmp.setNav_val(res);
		ob_tmp.setEnd_dt(Ob2.getKey().getNavdate());
		
		
		
		
		if((Ob1.getKey().getNavdate().getMonth()==00 || Ob1.getKey().getNavdate().getMonth()==11) && (Ob2.getKey().getNavdate().getMonth()==2 || Ob2.getKey().getNavdate().getMonth()==1))
		{
			ob_tmp.setComment("Q1_"+( Ob2.getKey().getNavdate().getYear()-100));	
		}
		else if((Ob1.getKey().getNavdate().getMonth()==02 || Ob1.getKey().getNavdate().getMonth()==03) && (Ob2.getKey().getNavdate().getMonth()==4 || Ob2.getKey().getNavdate().getMonth()==5)) 
//			if(Ob2.getNav_date().getMonth()==5 || Ob2.getNav_date().getMonth()==4 || Ob2.getNav_date().getMonth()==6)
		{
			ob_tmp.setComment("Q2_"+( Ob2.getKey().getNavdate().getYear()-100));	
		}
		else if((Ob1.getKey().getNavdate().getMonth()==06 || Ob1.getKey().getNavdate().getMonth()==05) && (Ob2.getKey().getNavdate().getMonth()==8 || Ob2.getKey().getNavdate().getMonth()==7))
//		else if(Ob2.getNav_date().getMonth()==8 || Ob2.getNav_date().getMonth()==7 || Ob2.getNav_date().getMonth()==9)
		{
			ob_tmp.setComment("Q3_"+( Ob2.getKey().getNavdate().getYear()-100));	
		}
		else if((Ob1.getKey().getNavdate().getMonth()==9 || Ob1.getKey().getNavdate().getMonth()==8) && (Ob2.getKey().getNavdate().getMonth()==11 || Ob2.getKey().getNavdate().getMonth()==0))
//		else if(Ob2.getNav_date().getMonth()==11 || Ob2.getNav_date().getMonth()==10 || Ob2.getNav_date().getMonth()==12)
		{
			ob_tmp.setComment("Q4_"+( Ob2.getKey().getNavdate().getYear()-100));	
		}
		else
		{
			
			if(Ob1.getKey().getNavdate().getMonth()==00 || Ob1.getKey().getNavdate().getMonth()==11)
			{
//				from_date.getYear()-99 
				ob_tmp.setComment("Q1_"+( Ob1.getKey().getNavdate().getYear()-99));	
			}
			else if(Ob1.getKey().getNavdate().getMonth()==02 || Ob1.getKey().getNavdate().getMonth()==03)
			{
				ob_tmp.setComment("Q2_"+( Ob1.getKey().getNavdate().getYear()-100));	
			}
			else if(Ob1.getKey().getNavdate().getMonth()==06 || Ob1.getKey().getNavdate().getMonth()==05)
			{
				ob_tmp.setComment("Q3_"+( Ob1.getKey().getNavdate().getYear()-100));
			}
			else if(Ob1.getKey().getNavdate().getMonth()==9 || Ob1.getKey().getNavdate().getMonth()==8)
			{
				ob_tmp.setComment("Q4_"+( Ob1.getKey().getNavdate().getYear()-99));	
			}
			else
			{   
				System.exit(0);	
			}
			
//			System.out.println("<---Unknown Quarter--->"); 
//			System.out.println("Date-->"+Ob2.getNav_date());
//			System.out.println("Date-->"+Ob2.getNav_date());
//			System.out.println(Ob2.getNav_date().getMonth());
			System.out.println("In Else Part---");
//			System.exit(0);
		}
		
		
		
	
		ssn.save(ob_tmp);
		ssn.getTransaction().commit();
//		ssn.close();
		ssn.beginTransaction();
		
		
		

	}
	
	
	public static void main(String[] args) 
	{

//    	Calculate_Rank("EQUITY_ELSS");
		
		String Fund_Type="";
		List<nav_hist> nav_hst_lst;
        int qtr_chker=0;
        int date_loop_flag=0;
        List<java.util.Date> dt_lst=null;
        
        ArrayList<java.util.Date> date_holder =new ArrayList<java.util.Date>();
        
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
		 
		  
		     Fund_Type="EQUITY_LARGE_CAP_NEW_30.09.2017";  // has to be passed
		     
//		     Fund_Type="EQUITY_LARGE_CAP_NEW_31.05.2017"; // This field is mandatory
		     
		  	List<Long> oo = new ArrayList<Long>();
		  	
		  	List<Long> temp_schem_code = new ArrayList<Long>();
		  			  	
//		  	LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_code_list_EQUITY_ELSS_2017.txt"), "UTF-8");
		  	
		  	
		 
		  	LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/Equity_Large_Cap_2017_Closed.txt"), "UTF-8");	
		  	
		  	   
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
	               // oo.remove(indx);
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
    	 dt_lst = getDates(ob,ssn,null); //Starting DAte
    	 
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
					      
					      
					      if(ddd.compareTo(new Date(117,06,31))==0) //set upper date limit
					      {
					    	  date_loop_flag=1;
					      }
					      
					        
				  		   nav_hst_lst = get_list_of_dates_db(ddd, (int) ob, ssn);
				  		      
				  		  if(nav_hst_lst.size()==0)
				  		     {
//				  		    	 break;   /// new added code for missing data ////-------added on 13-08-2016-----
				  			    date_tmp=date_tmp;
				  			    
				  			    
				  			    tmp_obj_met = Fill_Blanks(ddd,ob,date_tmp,nav_hst_lst,ssn);				                
				                    if(tmp_obj_met==null)
				                    {
				                    	//call a method 
				                    	Save_Last_Quarter_Value(date_tmp,ddd,ob,Fund_Type,ssn);				                    	
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
				  		    
				  		    Calculate_Save_Nav(date_tmp,nav_hst_lst.get(0), (int) ob ,Fund_Type,ssn);
				  		    
//				  		    Setting the date to 30th or 31st of the month. as wee need date from quarter
				  		    if( nav_hst_lst.get(0).getKey().getNavdate().getMonth()==0 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==2 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==4 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==6 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==7 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==9 || nav_hst_lst.get(0).getKey().getNavdate().getMonth()==11)
				  		    {
				  		    	date_tmp=nav_hst_lst.get(0).getKey().getNavdate();
				  		    	date_tmp.setDate(31);
				  		    	tmp_dt_lst = get_list_of_dates_db(date_tmp, (int) ob,ssn);
				  		    	date_tmp=tmp_dt_lst.get(0).getKey().getNavdate();
//				  		    	System.out.println("Scheme COde-->>"+ob+"DATE SET IF-->>"+date_tmp);
				  		    	
				  		    }
				  		    else
				  		    {
//				  		    	System.out.println("Month-->>"+nav_hst_lst.get(0).getNav_date().getMonth());
				  		    	date_tmp=nav_hst_lst.get(0).getKey().getNavdate();
				  		    	date_tmp.setDate(30);
				  		    	tmp_dt_lst = get_list_of_dates_db(date_tmp, (int) ob,ssn);
				  		    	date_tmp=tmp_dt_lst.get(0).getKey().getNavdate();
//				  		    	System.out.println("Scheme Code-->"+ob+"DATE SET ELSE-->>"+date_tmp);
				  		    }						    	
			  		  }

		  	    }
	    
		  	
//		  	ssn.close();
		  	
		  	System.out.println("<---- NAV Return Complete ---->");
		  	System.out.println("<-----Calculating Rank of Each Quarter----->");
		  	
		  	Calculate_Rank(Fund_Type);
		  	
		  	System.out.println("<----- Rank Calculation Complete----->");
	  	
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	}

	public static void Save_Last_Quarter_Value(Date from_date ,Date to_date, long scheme_code, String Fund_Type ,Session ssn) 
	{
	   
		composite_pk_avg_re_model ob_pk = new composite_pk_avg_re_model();
		ob_pk.setScheme_code(scheme_code);
		ob_pk.setStart_dt(from_date);
		ob_pk.setFund_Type(Fund_Type);
		
		Avg_ret_Model ob_tmp =new Avg_ret_Model();
		ob_tmp.setKey(ob_pk);
		ob_tmp.setNav_val(0.000);
		ob_tmp.setEnd_dt(to_date);
	   
		
		if((from_date.getMonth()==00 || from_date.getMonth()==11) && (to_date.getMonth()==2 || to_date.getMonth()==1))
		{
			ob_tmp.setComment("Q1_"+( to_date.getYear()-100));	
		}
		else if((from_date.getMonth()==02 || from_date.getMonth()==03) && (to_date.getMonth()==4 || to_date.getMonth()==5)) 
//			if(Ob2.getNav_date().getMonth()==5 || Ob2.getNav_date().getMonth()==4 || Ob2.getNav_date().getMonth()==6)
		{
			ob_tmp.setComment("Q2_"+( to_date.getYear()-100));	
		}
		else if((from_date.getMonth()==06 || from_date.getMonth()==05) && (to_date.getMonth()==8 || to_date.getMonth()==7))
//		else if(Ob2.getNav_date().getMonth()==8 || Ob2.getNav_date().getMonth()==7 || Ob2.getNav_date().getMonth()==9)
		{
			ob_tmp.setComment("Q3_"+( to_date.getYear()-100));	
		}
		else if((from_date.getMonth()==9 || from_date.getMonth()==8) && (to_date.getMonth()==11 || to_date.getMonth()==0))
//		else if(Ob2.getNav_date().getMonth()==11 || Ob2.getNav_date().getMonth()==10 || Ob2.getNav_date().getMonth()==12)
		{
			ob_tmp.setComment("Q4_"+( to_date.getYear()-100));	
		}
		else
		{
//			System.out.println("<---Unknown Quarter--->"); 
//			System.out.println("Date-->"+Ob2.getNav_date());
//			System.out.println("Date-->"+Ob2.getNav_date());
//			System.out.println(Ob2.getNav_date().getMonth());
			System.exit(0);
		}
		
		
		
		
		ssn.save(ob_tmp); 
		ssn.getTransaction().commit();
		ssn.beginTransaction();
		
	}


	public static nav_hist Fill_Blanks(Date ddd, long ob, Date date_tmp,
			List<nav_hist> nav_hst_lst, Session ssn) throws ParseException {
	       ArrayList<java.util.Date> date_holder = new ArrayList<Date>();
		   
//	       if(ssn.getTransaction().isActive()==false)
	       if(ssn.getTransaction()!=null)
	       {
//	    	   ssn.getTransaction();
	    	   ssn.beginTransaction();
	       }
	       
	       
	       int qtr_chker=1;
	       nav_hist  first_obj_hldr_tmp=null;
		   int frst_obj_hldr_flag=0;
		   nav_hist Nav_Hist_Temp_Obj = null;
		   long first_obj_id_hldr_tmp=0;
		   Date temp_Date_to_insert=null;
		   long temp_scheme_code_to_insert=0;
		   
		   
		   long new_id_nav_hist=0;
		   Calendar cal = Calendar.getInstance();
		   int rec_found_flag=0;
		   
		   nav_hist tmp_obj_ret=null;
		   
		   //		   Session ssn=null;
//		   ssn = HIbernateSession.getSessionFactory().openSession(); 
		 
//		   if(ssn.getTransaction()==null)
//		   {
//			   ssn.beginTransaction();   
//		   }
		   	   
	       date_holder.add(ddd);
	       
	       while(nav_hst_lst.size()<=0 && qtr_chker<5)
	       {
	    	  
	    	  cal.setTime(ddd);
//		      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
		      cal.add(Calendar.MONTH,3);
		      ddd = cal.getTime();
		      
		      								      
		      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
		      {
		    	   ddd.setDate(31);
		      }
		      else
		      {
		    	   ddd.setDate(30);
		      }
	    	   
	    	   System.out.println(":Prev Date +3 Months-->>"+ddd);
	    	   
	    	    nav_hst_lst = get_list_of_dates_db(ddd, (int) ob,ssn);
	    	    
	    	    if(nav_hst_lst.size()==0)
	    	    {
	    	    	date_holder.add(ddd);	
	    	    }
	    	    
	    	   
	    	     if(nav_hst_lst.size()>0)
	    	     {
//	    	    	       Query q111 = ssn.createQuery("select Max(id) from nav_hist_full");
//				           new_id_nav_hist=(long) q111.list().get(0);
								       
//				           System.out.println("New ID Generated--->>>"+(new_id_nav_hist+1));
								    	   
			    	       frst_obj_hldr_flag=0;
			    	   
			    	  
			    	   
					    	   for(java.util.Date dd : date_holder)
					    	     {
					    		   
					    		    
					    	    	 
					    		         Nav_Hist_Temp_Obj =new nav_hist();
					    		         Nav_hist_PK key_obj = new Nav_hist_PK(); 
					    		         key_obj.setNavdate(dd);
					    		         key_obj.setSchemecode(nav_hst_lst.get(0).getKey().getSchemecode());
					    		         
//					    		         temp_Date_to_insert = dd;
					    		         temp_scheme_code_to_insert = nav_hst_lst.get(0).getKey().getSchemecode();
					    		         
					    		         Nav_Hist_Temp_Obj.setKey(key_obj);
//						    	    	 Nav_Hist_Temp_Obj.setId(new_id_nav_hist+1);
						    	    	 Nav_Hist_Temp_Obj.setAdjnavrs(nav_hst_lst.get(0).getAdjnavrs());
//						    	    	 Nav_Hist_Temp_Obj.getKey().setNavdate(dd);
						    	    	 Nav_Hist_Temp_Obj.setNavrs(nav_hst_lst.get(0).getNavrs());
						    	    	 Nav_Hist_Temp_Obj.setRepurprice(nav_hst_lst.get(0).getRepurprice());
						    	    	 Nav_Hist_Temp_Obj.setSaleprice(nav_hst_lst.get(0).getSaleprice());
//						    	    	 Nav_Hist_Temp_Obj.getKey().setSchemecode(nav_hst_lst.get(0).getKey().getSchemecode());
									    	    	 
						    	         ssn.save(Nav_Hist_Temp_Obj);
								    	    	 
						    	    	 if(frst_obj_hldr_flag==0)
							    	    	 {
						    	    		     temp_Date_to_insert = dd;
//						    	    		     first_obj_id_hldr_tmp = Nav_Hist_Temp_Obj.getId();
						    	    		 
//						    	    		      System.out.println("Getting Id of new Object--->>>"+Nav_Hist_Temp_Obj.getId());
						    	    		      System.out.println("New Id Created:--->"); 
							    	    	  }
							    	    	 
							    	    	 frst_obj_hldr_flag++;
					    	      }
							    	     
			    	         rec_found_flag=1;
				    	     ssn.getTransaction().commit();
				    	     ssn.beginTransaction();
				    	     
				    	     System.out.println("<----Record Saved in NAV_HIST_FULL---->");
				    	     break;
				    	    
	    	     }
	    	    
	    	   
	    	   
	    	     if(rec_found_flag==0 && qtr_chker==4)
	    	     {
	    	    	 System.out.println("Breaking to new Scheme Code / End of scheme code in hist");
	    	    	 tmp_obj_ret=null;
	    	    	 return tmp_obj_ret;
	    	     }
	    	   
	    	   
	    	 qtr_chker++;   
	       }

	  
	          if(rec_found_flag==1)
	          {
	        	  
//	        	System.out.println("ID OF NEWLY CREATED OBJECT--->>"+first_obj_id_hldr_tmp); 
	        	  
 		         
	        	nav_hist tmp_obj = (nav_hist) ssn.createQuery("from navhistfull_adjnavs where key.schemecode="+temp_scheme_code_to_insert+" and key.navdate=?").setDate(0,temp_Date_to_insert).list().get(0);
	            nav_hst_lst.clear();
	            nav_hst_lst.add(tmp_obj);
	            date_tmp=tmp_obj.getKey().getNavdate();
	            
	            tmp_obj_ret = tmp_obj;
	            
	            System.out.println("NAV_LIST SIZ---->>"+nav_hst_lst.size());
	            
	          }
 
		        
		
//		ssn.close();
	    ssn.getTransaction().commit();
	    ssn.beginTransaction();
//	    ssn.flush();
//	    ssn.clear();
		
		return tmp_obj_ret;
		
	}
}
