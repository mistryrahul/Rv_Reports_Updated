package controller;

import java.sql.Connection;
import java.sql.SQLException;
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
import org.hibernate.jdbc.Work;
import org.hibernate.transform.Transformers;

import com.mysql.jdbc.Statement;

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
	      System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-==-==-=-=-==-=-=-=-=-=-=-=");
	      Session ssn = HIbernateSession.getSessionFactory().openSession(); 
		  ssn.beginTransaction();		
		  String Fund_Type;
		  Fund_Type="EQUITY_ELSS_NEW_31.03.2018";
		  
//		  String sql = "insert into Custom_Merged_Report_W_Rank(from_date,scheme_code,quarter,Scheme_Name,backward_3,backward_6,backward_12,backward_18,backward_24,backward_30,backward_36,backward_42,backward_48,backward_54,backward_60,forwar_9_mnths,forwar_12_mnths ,forwar_18_mnths ,forwar_36_mnths,last_4_neg_avg_cat_ret_otb ,last_4_pos_avg_cat_ret_otb,last_8_neg_avg_cat_ret_otb,last_8_pos_avg_cat_ret_otb ,last_12_neg_avg_cat_ret_otb ,last_12_pos_avg_cat_ret_otb ,last_16_neg_avg_cat_ret_otb ,last_16_pos_avg_cat_ret_otb ,last_20_neg_avg_cat_ret_otb ,last_20_pos_avg_cat_ret_otb ,last_4_neg_act_ret_sum,last_8_neg_act_ret_sum,last_12_neg_act_ret_sum,last_16_neg_act_ret_sum,last_20_neg_act_ret_sum,last_4_pos_act_ret_sum,last_8_pos_act_ret_sum,last_12_pos_act_ret_sum,last_16_pos_act_ret_sum,last_20_pos_act_ret_sum,cri,no_of_stock,year_1,year_1_1 ,year_1_2 ,year_1_3 ,year_1_4 ,max_Drawdown_year_1,max_Drawdown_year_2,max_Drawdown_year_3,max_Drawdown_year_4,max_Drawdown_year_5,avg_return_50_minus_200,last_200_day_return,ex_ratio,sc_aum,Fund_Type,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum) select from_date, scheme_code, quarter,Scheme_Name, backward_3, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36,backward_42,backward_48, backward_54, backward_60 , forwar_9_mnths, forwar_12_mnths , forwar_18_mnths , forwar_36_mnths , last_4_neg_avg_cat_ret_otb , last_4_pos_avg_cat_ret_otb,  last_8_neg_avg_cat_ret_otb,  last_8_pos_avg_cat_ret_otb , last_12_neg_avg_cat_ret_otb , last_12_pos_avg_cat_ret_otb , last_16_neg_avg_cat_ret_otb , last_16_pos_avg_cat_ret_otb ,  last_20_neg_avg_cat_ret_otb , last_20_pos_avg_cat_ret_otb , last_4_neg_act_ret_sum, last_8_neg_act_ret_sum, last_12_neg_act_ret_sum, last_16_neg_act_ret_sum, last_20_neg_act_ret_sum, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, cri, no_of_stock,  year_1, year_1_1 , year_1_2 , year_1_3 , year_1_4 , max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return,  ex_ratio, sc_aum, Fund_Type ,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum from Report_Merged_5_6_8_Model where backward_60!=0 and Fund_Type='"+Fund_Type+"'";
//		  String test_sql ="select  \"from_date\", \"scheme_code\", \"quarter\", \"Scheme Name\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\",\"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\" UNION ALL select from_date, scheme_code, quarter, Scheme_Name, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='EQUITY_LARGE_CAP_NEW_30.09.2017_T2'into outfile'/var/lib/mysql-files/Equity_Large_Cap_Sep_2017.csv'  FIELDS TERMINATED BY ','   ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
		  String Output_File_Name="Elss_Report.csv";
		  String test_sql="select \"from_date\", \"scheme_code\", \"Scheme_Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"X22\", \"X23\", \"X24\", \"X25\", \"X26\", \"X27\", \"X28\", \"X29\", \"X30\", \"X31\", \"X32\", \"X33\", \"X34\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"R_X22\", \"R_X23\", \"R_X24\", \"R_X25\", \"R_X26\", \"R_X27\", \"R_X28\", \"R_X29\", \"F36\", \"R_F36\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select DATE_FORMAT(from_date,'%d-%m-%Y') as from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, Sdev_12_mnths, Sdev_24_mnths, Sdev_36_mnths, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, last_4_pos_nav_ret_value_sum, last_8_pos_nav_ret_value_sum, last_12_pos_nav_ret_value_sum, last_16_pos_nav_ret_value_sum, last_20_pos_nav_ret_value_sum, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, R_Sdev_12_mnths, R_Sdev_24_mnths, R_Sdev_36_mnths, R_last_4_pos_act_ret_sum, R_last_8_pos_act_ret_sum, R_last_12_pos_act_ret_sum, R_last_16_pos_act_ret_sum, R_last_20_pos_act_ret_sum, forwar_36_mnths, R_forwar_36_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
		
		  Query query = ssn.createSQLQuery(test_sql);
//		  int result = query.executeUpdate();
//		  query.list();
//		  ssn.getTransaction().commit();
		  
		  ssn.doWork(new Work() {			
			@Override
			public void execute(Connection conn) throws SQLException 
			{
				// TODO Auto-generated method stub
				Statement stmt = (Statement) conn.createStatement();
				stmt.executeQuery(test_sql);
				
			}
		});
		  
		  
		  ssn.close();
		  
		  System.out.println("<----Executed Properly----->");
		  
		  System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-==-==-=-=-==-=-=-=-=-=-=-=");
		  
//		  ssn.close();
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

