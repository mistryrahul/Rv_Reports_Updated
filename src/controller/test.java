package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import debt_Model.Avg_maturity;
import debt_Model.Credit_rating_sum_groups;
import model.Avg_ret_Model;
import model.Report_6_pk;
import model.Report_Merged_5_6_8_Model;
import model.Scheme_Detail;
import model.nav_hist;
import model.nav_report_3_Addition;
import sessionFactory.HIbernateSession;

public class test 
{
    public static void main(String... args) throws ParseException
    {
//    	String datetime="2016-12-31"; 
    	
      
//    	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");//dd/MM/yyyy
    	Date Date_As_On_Report= new Date(117,06,31);
    	
//        String strDate = sdfDate.format(Date_As_On_Report);
    	
        String dd_1 = new SimpleDateFormat("yyyy-MM-dd").format(Date_As_On_Report);
        
        System.out.println("Date--->>>"+dd_1);
    	
//    	 Calendar cal = Calendar.getInstance();
//	      cal.setTime(new Date(116, 11, 31));
//	      java.util.Date dd1 = cal.getTime();
//	     
//	      System.out.println(dd1);
//	      
//		    	  cal.add(Calendar.DATE,-40);
//		    
//	      java.util.Date ddd = cal.getTime();
	  
    	
//    	java.util.Date date_of_report= new Date(116, 11, 31); 
//    	
//    	System.out.println("date---->>>"+date_of_report);
    	
    	
//	      System.out.println(ddd);
//	      System.out.println();

	      
//	      Calendar cal = Calendar.getInstance();
//	      cal.setTime(new Date(15, 3, 12));
//		  cal.add(Calendar.DATE,-40);
//	      java.util.Date ddd = cal.getTime();	
//	      
	      
//	      Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//		  ssn.beginTransaction();		
//		  
//		  double Sdev_Res12=0;
//		  double Sdev_Res24=0;
//		  double Sdev_Res36=0;
//		  
//		  double Sdev_Res12_fl=0;
//		  double Sdev_Res24_fl=0;
//		  double Sdev_Res36_fl=0;
//		  
//		  DescriptiveStatistics stats_12 = new DescriptiveStatistics();
//		  DescriptiveStatistics stats_24 = new DescriptiveStatistics();
//		  DescriptiveStatistics stats_36 = new DescriptiveStatistics();
//		 
//		  int jk=0;
//		  
//		  ArrayList<Date> distinct_date_lst = (ArrayList<Date>) ssn.createQuery("select distinct(nav_date) from nav_report_Sdev where Fund_Type=? and scheme_code=? and nav_date<'2016-12-31' order by nav_date desc").setString(0,"EQUITY_ELSS_NEW_31.03.2017").setLong(1,957).list();
//		  
//		   for(Date dte : distinct_date_lst)
//		   {
//					   ArrayList<nav_report_3_Addition> nr3 =  (ArrayList<nav_report_3_Addition>) ssn.createQuery( "from nav_report_Sdev where Fund_Type='"+"EQUITY_ELSS_NEW_31.03.2017"+"' and scheme_code="+"957"+" and nav_date <=? order by nav_date desc").setDate(0,dte).list();
//						  jk=1;
//						  
//						  
//						  Sdev_Res12=0;
//						  Sdev_Res24=0;
//						  Sdev_Res36=0;
//						  
//						  Sdev_Res12_fl=0;
//						  Sdev_Res24_fl=0;
//						  Sdev_Res36_fl=0;
//						  
//						  for(nav_report_3_Addition bb : nr3 )
//						  {
//							  
//							  if(jk<=12)
//							  {
//								  stats_12.addValue(bb.getNav_value());  
//							  }
//							  
//							  if(jk<=24)
//							  {
//								  stats_24.addValue(bb.getNav_value());  
//							  }
//							  
//							  if(jk<=36)
//							  {
//								  stats_36.addValue(bb.getNav_value());  
//							  }
//							  
//							  if(jk>36)
//							  {
//								  
//								  Sdev_Res12= stats_12.getStandardDeviation(); 
//								  Sdev_Res12_fl = Sdev_Res12 * Math.sqrt(12);
//								  
//								  Sdev_Res24 = stats_24.getStandardDeviation(); 
//								  Sdev_Res24_fl = Sdev_Res24 * Math.sqrt(12);
//								  
//								  Sdev_Res36= stats_36.getStandardDeviation(); 
//								  Sdev_Res36_fl = Sdev_Res36 * Math.sqrt(12);
//								  
//								  System.out.println("Date -->> "+dte+" <<---- ");
//								  
//								  System.out.println("Sdev-12-Month->>"+Sdev_Res12);
//								  System.out.println("Sdev-12-Month-COmposite->>"+Sdev_Res12_fl);
//								  
//								  System.out.println("Sdev-24-Month->>"+Sdev_Res24);
//								  System.out.println("Sdev-24-Month-COmposite->>"+Sdev_Res24_fl);
//								  
//								  
//								  System.out.println("Sdev-36-Month->>"+Sdev_Res36);
//								  System.out.println("Sdev-36-Month-COmposite->>"+Sdev_Res36_fl);
//								  
//								  System.out.println("<--------   END -------->");
//								  
//								  break;
//							  }
//							  
//							  jk++;
//							  
//						  }
//		   }
		  
	      
//		  String Fund_Type="EQUITY_ELSS_NEW_31.12.2016";
//    	
		  
//		  String hql_mn="from avg_return where key.Fund_Type='"+Fund_Type+"' order by scheme_code";
////			 String hql_mn="from avg_return where start_dt>='2003-06-30' and start_dt<='2015-03-31' order by scheme_code";
//			 Query q1 = ssn.createQuery(hql_mn);
//			 
////			 Query q1 = ssn.createQuery(hql_mn)
//					 
//			 ArrayList<Avg_ret_Model> avg_ret_main_list = (ArrayList<Avg_ret_Model>) q1.list();
//			 
//			 Report_Merged_5_6_8_Model rm568 = null;
//			 Report_6_pk pk=null;
//			    
//				   for(Avg_ret_Model arm : avg_ret_main_list)
//				   {
//					   if(arm.getKey().getScheme_code()==2153)
//					   {
//						   System.out.println(arm.getKey().getScheme_code()+" "+arm.getKey().getStart_dt());	   
//					   }
//				     
//				   }
		  
		  
		  
		  
//	      List<Object[]> result= ssn.createSQLQuery("SELECT mf.`invdate` , round(mf.`holdpercentage`,2) as holdpercentage, mf.aum FROM `mf_portfolios` mf join scheme_classifications sc on sc.primary_fd_code = mf.schemecode WHERE sc.`schemecode` = ? AND mf.asect_code =1 AND DATE_FORMAT( mf.`invdate` , '%Y-%m-%d' ) =  date_format((select max(date_format(invdate,'%Y-%m-%d')) as invdate from mf_portfolios  where schemecode = (select primary_fd_code from scheme_classifications where schemecode = ?) and invdate<=?),'%Y-%m-%d') ORDER BY mf.`holdpercentage` DESC").setLong(0,1495).setLong(1,1495).setDate(2,dd1).list();
//	      
//	      System.out.println("Size--->>"+result.size());
//
//				for(int i=0;i<result.size();i++)
//				{
//					Object[] data = result.get(i);
//					
//					System.out.println("---Start--");
//					System.out.println(data[0]);
//					System.out.println(data[1]);
//					System.out.println(data[2]);
////					System.out.println(data[3]);
////					System.out.println(data[4]);
//					System.out.println("---End--");
//				}
		  
		  
//		  List<Object[]> result= ssn.createSQLQuery("select * from credit_rating_sum_groups where classification like '%Liquid%' order by schemecode").list(); 
//		  System.out.println("SIZE--->>"+result.size());
//		  
//		  
//		  String classification,rupeevest_group;
//		  double holdpercentage;
//		  Date invdate;
//		  long schemecode;
//		  
//		  
//		  for(int i=0;i<result.size();i++)
//				{
//					Object[] data = result.get(i);
//					System.out.println("---Start--");
//					
//					schemecode = new Long(data[0].toString());
//					System.out.println(schemecode);
//					
//					classification = data[1].toString();
//					System.out.println(classification);
//					
//					invdate = (Date) data[2];
//					System.out.println(invdate);
//					
//					holdpercentage = Double.valueOf(data[3].toString());
//					System.out.println(holdpercentage);
//					
//					rupeevest_group= data[4].toString();
//					System.out.println(rupeevest_group);
//				
//					
//					
//					System.out.println("-----END----");
//					
//                  }
		  
//		  List<Object[]> result= ssn.createSQLQuery("select bir.date,im.indexname , bir.yrret_1 , bir.yrret_3 from index_msts im left join scheme_indices si on im.indexcode = si.indexcode left join bm_indices_res bir on bir.index_code= im.indexcode and bir.date <='2016-12-31' where si.schemecode=23 order by bir.date desc limit 1").list();
//		    
//		  for(int i=0;i<result.size();i++)
//				{
//					Object[] data = result.get(i);
//					System.out.println("---Start--");
//					
//					System.out.println( data[0]);
//					System.out.println( data[1]);
//					System.out.println( data[2]);
//					System.out.println( data[3]);
//					
//					System.out.println("-----END----");
//					
//                }
		  
//		  ArrayList<Scheme_Detail> scheme_code_lst = (ArrayList<Scheme_Detail>) ssn.createSQLQuery("select sdf.* from scheme_details_fulls sdf join scheme_classifications sc on sc.schemecode= sdf.schemecode where sc.classification like '%ETF%' order by sdf.schemecode").addEntity(Scheme_Detail.class).list();
//		  
//		  for( Scheme_Detail bb : scheme_code_lst)
//		  {
//			  
//		  }
		  
//		  ArrayList<Avg_maturity> scheme_code_lst = (ArrayList<Avg_maturity>) ssn.createSQLQuery("SELECT schemecode,round(if(avg_mat_days='days',avg_mat_num/365, if(avg_mat_days='months',avg_mat_num/12, avg_mat_num)),2) as avg_maturity,round(if(mod_dur_days='days',mod_dur_num/365, if(mod_dur_days='months',mod_dur_num/12, mod_dur_num)),2) as modified_duration, ytm,date FROM avg_maturities where  schemecode = (select primary_fd_code from scheme_classifications where schemecode=?) AND date<=(select max(date) from avg_maturities where schemecode=(select primary_fd_code from scheme_classifications where schemecode=?)) having modified_duration is not null order by date desc limit 1").list();
//		  
//		  for(Avg_maturity ob : scheme_code_lst)
//		  {
//			  
//		  }
		 
//		  int mn12=-12;
//		  int mn36=-36;
//		  
//		  double cc = calculate_return(mn12,date_of_report,ssn);
//		  double bc = calculate_return(mn36,date_of_report,ssn);
//		  
//		  System.out.println("Date-->>"+date_of_report);
//		  
//		  System.out.println("12 months Return-->>"+cc);
//		  System.out.println("36 months Return-->>"+bc);
//		  ssn.close();
		  
//		    int tmp_size=41, top_grp_1=0,top_grp_2=0,top_grp_3=0,top_grp_4=0,top_grp_5=0;
//		  
//		    top_grp_1=(int) Math.round(tmp_size*.10);
//	        top_grp_2=(int) Math.round(tmp_size*.25);
//	        top_grp_3=(int) Math.round(tmp_size*.30);
//	        top_grp_4=(int) Math.round(tmp_size*.25);
//	        top_grp_5=(int) Math.round(tmp_size*.10);
//		  
//	        System.out.println(top_grp_1);
//	        System.out.println(top_grp_2);
//	        System.out.println(top_grp_3);
//	        System.out.println(top_grp_4);
//	        System.out.println(top_grp_5);
		  
		  
//		  double ret_36_mnths=7.567749877649405;
//		  double ans_1,ans_2,ans_3,fin_res; 
//		  ans_1= ((ret_36_mnths/100) +1);
//// 		 ans_2= (0.333333333);
//		  ans_2= 1;
// 		 ans_3 = Math.pow(ans_1 ,ans_2);
// 		 fin_res = ( ans_3 -1 )*100;
// 		 
// 		System.out.println(Math.round((fin_res*100)/100D));
// 		System.out.println(fin_res);
// 		
		  
}
    
    static double calculate_return(int months, Date dd ,Session ssn) throws ParseException
	{
//		 ArrayList<nav_hist> nav_hst_lst_mn = get_list_of_dates_db(crsg_obj.getKey().getInv_date(),crsg_obj.getKey().getScheme_code());
		 
		 double nav_ret=0;
		 long sc_cd=2;
		 Criteria criteria = ssn.createCriteria(model.nav_hist.class);
		 criteria.add(Restrictions.eq("key.schemecode",sc_cd));
		 criteria.add(Restrictions.eq("key.navdate",dd));
		 
		 ArrayList<nav_hist> nav_hst_lst_mn = (ArrayList<nav_hist>) criteria.list();
		 
		 
		 if(nav_hst_lst_mn.size()>0)
		 {
			 java.util.Date ddd=null;
			 
			 Calendar cal = Calendar.getInstance();
	    	 cal.setTime(dd);
	    	 cal.add(Calendar.MONTH,months);
		     ddd = cal.getTime();
	    	 
		     	     
		     ArrayList<nav_hist> nav_hst_lst = get_list_of_dates_db(ddd, 2);
		     
		     if(nav_hst_lst.size()>0)
		     {
		    	   if(months<0)
		    	   {
		    		   nav_ret = (((nav_hst_lst_mn.get(0).getAdjnavrs() - nav_hst_lst.get(0).getAdjnavrs())/nav_hst_lst.get(0).getAdjnavrs())*100);
		    	   }
		    	   else
		    	   {
		    		   nav_ret = ((( nav_hst_lst.get(0).getAdjnavrs() - nav_hst_lst_mn.get(0).getAdjnavrs() )/nav_hst_lst_mn.get(0).getAdjnavrs())*100);
		    	   }
		    	 
		    	 
		    	 
		     }
		     else
		     {
		    	return -99.99; 
		     }
		     
		 }
		 else
		 {
			 return -99.99;
		 }
	     
	     
	     
		return nav_ret;
	}
    
    static ArrayList<nav_hist> get_list_of_dates_db(java.util.Date day, long sc) throws ParseException
	{
			  SimpleDateFormat formatter=null;
			  java.util.Date date_nav_chk_start=null;
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<nav_hist> lst = new ArrayList<nav_hist>();
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);
			  
			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
			 
			  Criteria criteria = ssn.createCriteria(model.nav_hist.class);
			  criteria.add(Restrictions.eq("key.schemecode", sc)); 
			  criteria.add(Restrictions.between("key.navdate", date_nav_chk_end, day));
      		  criteria.addOrder(org.hibernate.criterion.Order.desc("key.navdate"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
		 return lst;
	}
	      
    	
    }

