package controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Query;
import org.hibernate.Session;

import model.Avg_ret_Model;
import model.Report_Merged_5_6_8_Model;
import model.RollingAvg_CompositeKey;
import model.RollingReturnAvgModel;
import sessionFactory.HIbernateSession;

public class RollingReturnAvg_Main {

	public static void main(String[] args) 
	{   
		String Fund_Type="EQUITY_ELSS_NEW_30.09.2017_Test";
		Session ssn = null;
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		
//	    Date dd= new Date(116, 5, 30);
//		System.out.println(GetActualDate(dd,1,1331));
		
		try
		{
		 
			ssn = HIbernateSession.getSessionFactory().openSession(); 
	    	ssn.beginTransaction();
	    	RollingReturnAvgModel obj = null;
	    	RollingAvg_CompositeKey obj_key = null;
	    	ArrayList<RollingReturnAvgModel> final_list = new ArrayList<RollingReturnAvgModel>();
	        
	    	
		    String hql_nw=" from Report_Merged_5_6_8_Model where key.Fund_Type='"+Fund_Type+"' and backward_60!=0";
	 		Query q_2 = ssn.createQuery(hql_nw);
 		    ArrayList<Report_Merged_5_6_8_Model> avg_ret_lst = (ArrayList<Report_Merged_5_6_8_Model>) q_2.list();
 		    
 		    for(Report_Merged_5_6_8_Model arm :  avg_ret_lst)
			 {  
// 		    	# For-One-Month
 		    	String start_date = GetActualDate(arm.getKey().getFrom_date(),1,arm.getKey().getScheme_code(), ssn);
// 		    						
 		    	double avg_1 = CalculateRollingAvg(start_date, format1.format(arm.getKey().getFrom_date())  ,arm.getKey().getScheme_code(),1,ssn);
 		    	
 		    	String start_date2 = GetActualDate(arm.getKey().getFrom_date(),3,arm.getKey().getScheme_code(), ssn);
 		    	double avg_3 = CalculateRollingAvg(start_date2, format1.format(arm.getKey().getFrom_date()),arm.getKey().getScheme_code(),3,ssn);
 		    	 
 		    	
 		    	obj = new RollingReturnAvgModel();
 		    	obj_key = new RollingAvg_CompositeKey();
 		    	
 		    	obj_key.setDay(arm.getKey().getFrom_date());
 		    	obj_key.setFund_Type(Fund_Type);
 		    	obj_key.setScheme_code(arm.getKey().getScheme_code());
 		    	
 		    	obj.setKey(obj_key);
                obj.setAvg_rol_yr_1(avg_1); 
                obj.setAvg_rol_yr_3(avg_3);
                 
                final_list.add(obj);
                
// 		    	System.out.println("------------------------------------------------");
//	 		    	 System.out.println("SchemeCode->"+arm.getKey().getScheme_code());
//	 		    	 System.out.println("Date->"+arm.getKey().getFrom_date());
// 		    	
// 		    	     System.out.println(avg_1);
// 		    	     System.out.println("-=-=-=-=-=-=");
// 		    	     System.out.println(avg_3);
// 		    	System.out.println("------------------------------------------------");
 		    	
 		    	   
 		    	
			 }
 		    
 		     
 		    
 		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			ssn.close();
		}
	}


//	System.out.println(cal.getTime());

	static double CalculateRollingAvg(String start_date,String upto_date,long schemecode,int year_value,Session ssn)
	{	
		double average=0.00;
		String sql="select (sum(return_"+year_value+"_Years)/count(*)) as Average ,schemecode from rolling_returns where schemecode="+schemecode+" and date>='"+start_date+"' and date<='"+upto_date+"'";
			List<Object[]> rows = ssn.createSQLQuery(sql).list();
					
					if(!rows.isEmpty())
					{
						for(Object[] row : rows)
						{
							System.out.println(row[0]);
//							date_output=row[1].toString();
							average=Double.valueOf(row[0].toString());
						}
					}
				     
		return average;
	}
	
	static String GetActualDate(Date date, int year_value, long schemecode, Session ssn)
	{   
		 
		 String date_output=null;
		 String date_1 =null;
		 String date_2 =null;
		 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		 Calendar cal = Calendar.getInstance();
    	 cal.setTime(date);
		 
		 Date req_date=null;
//		 Calendar cal = Calendar.getInstance();
//	     cal.setTime(date);
	     
//	     Date dd1 = cal.getTime();
	     if(year_value==1)
	     {
	    	 cal.add(Calendar.YEAR,-4);
	    	 date_1 = format1.format(cal.getTime());
	 
	    	 cal.add(Calendar.DATE,-7);
	 	 	 date_2 = format1.format(cal.getTime());
	     }
	     else if(year_value==3)
	     {
	    	 cal.add(Calendar.YEAR,-2);
	    	 date_1 = format1.format(cal.getTime());
	    	 
	    	 cal.add(Calendar.DATE,-7);
	 	 	 date_2 = format1.format(cal.getTime());
	     }
	 	
	    
		
		String sql = "select * from rolling_returns where schemecode="+schemecode+" and date>='"+date_2+"' and date<='"+date_1+"' order by date desc limit 1";
		List<Object[]> rows = ssn.createSQLQuery(sql).list();
		
		if(!rows.isEmpty())
		{
			for(Object[] row : rows)
			{
//				System.out.println(row[1]);
				date_output=row[1].toString();
			}
		}
		
        return date_output;		
	}
	
}
