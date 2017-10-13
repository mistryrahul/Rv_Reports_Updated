package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import model.Avg_ret_Model;
import model.Standard_Dev;
import model.composite_pk_Sd;
import model.nav_hist;
import model.nav_report_3_Addition;
import sessionFactory.HIbernateSession;

public class Nav_Rep_3_Sdev_Main 
{
   
	public static void main(String ...args)
	{
		Session ssn=null;
		
//		String Fund_Type="EQUITY_LARGE_CAP_NEW_31.03.2017";  // has to be passed
		
		String Fund_Type="EQUITY_ELSS_NEW_30.06.2017";  // has to be passed
		
//		String Fund_Type="EQUITY_MULTI_CAP_NEW_31.12.2016";
//		String Fund_Type="EQUITY_MID_SMALL_CAP_NEW_31.12.2016";
		try
		{
			 ssn = HIbernateSession.getSessionFactory().openSession(); 
			 ssn.beginTransaction();
			 
			
			 ArrayList<Long> sch_cd_lst = (ArrayList<Long>) ssn.createQuery("select distinct(key.scheme_code) from avg_return where key.Fund_Type='"+Fund_Type+"'").list();
				 
			 
//			     ArrayList<Long> sch_cd_lst = new ArrayList<Long>();
//				 long c_o_p = 957;
//				 sch_cd_lst.add(c_o_p);
			 		 
		  for(Long sc_cd : sch_cd_lst)
		  {
			  
			  ArrayList<Date> dt_lst =  (ArrayList<Date>) ssn.createQuery("select max(key.navdate) from navhistfull_adjnavs where key.schemecode=? group by Year(key.navdate),Month(key.navdate)").setLong(0,sc_cd).list();
				
//			  System.out.println("\n\n-----Reverse------");
			  Date new_dd=null;
			  Date old_dd=null;
			  
			  for(Date dd : dt_lst)
			  {  

				if(dd.getDate()<21)
				  {
					  new_dd=null;
					  old_dd=null;
					  continue;
				  }
				 
				 
					
				 if(old_dd!=null)
				 {
					 new_dd=dd;
				       
					  
//					 ArrayList<Long> ret_1mnth = (ArrayList<Long>) ssn.createSQLQuery("select (((tmp1.adjnavrs-tmp2.adjnavrs)/tmp2.adjnavrs)*100) from navhistfull_adjnavs tmp1 join (select * from navhistfull_adjnavs where key.navdate=? and key.schemecode=?)tmp2 on tmp2.key.schemecode=tmp1.key.schemecode where tmp1.key.schemecode=? and tmp1.key.navdate=?").setDate(0, old_dd).setLong(1,sch_cd).setLong(2,sch_cd).setDate(3, new_dd).list();
					 
					  List<Object[]> result = (List<Object[]>) ssn.createSQLQuery("select (((tmp1.adjnavrs - tmp2.adjnavrs)/tmp2.adjnavrs)*100) from navhistfull_adjnavs tmp1 join (select * from navhistfull_adjnavs where navdate=? and schemecode=?)tmp2 on tmp2.schemecode=tmp1.schemecode where tmp1.schemecode=? and tmp1.navdate=?").setDate(0, old_dd).setLong(1,sc_cd).setLong(2,sc_cd).setDate(3, new_dd).list();
					 
						for(int i=0;i<result.size();i++)
						{
//							Object[] data = result.get(i);
							
//							System.out.println(old_dd+"\t"+new_dd+"\t"+result.get(i));
							Object data = result.get(i);
							
							double tmp_val = (double) data;
							
							nav_report_3_Addition obj = new nav_report_3_Addition();
							
							obj.setScheme_Code(sc_cd);
							obj.setNav_from_date(old_dd);
							obj.setNav_date(new_dd);
							obj.setNav_value(tmp_val);	
							obj.setFund_Type(Fund_Type);
							ssn.save(obj);
							
							 
							
						}	
//					 System.out.println(old_dd+"\t"+new_dd+"\t"+ret_1mnth.get(0)); 
					 
					 
					 old_dd=null;
					 
				 }
				
				 old_dd = dd; 
				  
				   
			  }
			  			  
			  
			  ssn.getTransaction().commit();
			  ssn.beginTransaction();
			  ssn.flush();
			  ssn.clear();
			  
			  double Sdev_Res12=0;
			  double Sdev_Res24=0;
			  double Sdev_Res36=0;
			  
			  double Sdev_Res12_fl=0;
			  double Sdev_Res24_fl=0;
			  double Sdev_Res36_fl=0;
			  
			  
			 
			  int jk=0;
			  
			  DescriptiveStatistics stats_12 = new DescriptiveStatistics();
			  DescriptiveStatistics stats_24 = new DescriptiveStatistics();
			  DescriptiveStatistics stats_36 = new DescriptiveStatistics(); 
			  
			  ArrayList<Date> distinct_date_lst = (ArrayList<Date>) ssn.createQuery("select distinct(nav_date) from nav_report_Sdev where Fund_Type=? and scheme_code=? order by nav_date desc").setString(0,Fund_Type).setLong(1,sc_cd).list();
			  
			   for(Date dte : distinct_date_lst)
			   {
				            
				       stats_12 = new DescriptiveStatistics();
					   stats_24 = new DescriptiveStatistics();
					   stats_36 = new DescriptiveStatistics(); 
				   
						   ArrayList<nav_report_3_Addition> nr3 =  (ArrayList<nav_report_3_Addition>) ssn.createQuery( "from nav_report_Sdev where Fund_Type='"+Fund_Type+"' and scheme_code="+sc_cd+" and nav_date <=? order by nav_date desc").setDate(0,dte).list();
							  
						   
						   jk=1;
							  
							  
							  Sdev_Res12=0;
							  Sdev_Res24=0;
							  Sdev_Res36=0;
							  
							  Sdev_Res12_fl=0;
							  Sdev_Res24_fl=0;
							  Sdev_Res36_fl=0;
							  
							  for(nav_report_3_Addition bb : nr3 )
							  {
								  
								  if(jk<=12)
								  {
									  stats_12.addValue(bb.getNav_value());  
								  }
								  
								  if(jk<=24)
								  {
									  stats_24.addValue(bb.getNav_value());  
								  }
								  
								  if(jk<=36)
								  {
									  stats_36.addValue(bb.getNav_value());  
								  }
								  
								  if(jk>36)
								  {
									  
									  Sdev_Res12= stats_12.getStandardDeviation(); 
									  Sdev_Res12_fl = Sdev_Res12 * Math.sqrt(12);
									  
									  Sdev_Res24 = stats_24.getStandardDeviation(); 
									  Sdev_Res24_fl = Sdev_Res24 * Math.sqrt(12);
									  
									  Sdev_Res36= stats_36.getStandardDeviation(); 
									  Sdev_Res36_fl = Sdev_Res36 * Math.sqrt(12);
									  
									  Save_To_Db_Standard_Deviation(ssn,sc_cd,Fund_Type,12,Sdev_Res12_fl,dte);
									  Save_To_Db_Standard_Deviation(ssn,sc_cd,Fund_Type,24,Sdev_Res24_fl,dte);
									  Save_To_Db_Standard_Deviation(ssn,sc_cd,Fund_Type,36,Sdev_Res36_fl,dte);
								
									  
									  
									  break;
								  }
								  
								  jk++;
								  
							  }
							  
							 
							  
//							  Sdev_Res12= stats_12.getStandardDeviation(); 
//							  Sdev_Res12_fl = Sdev_Res12 * Math.sqrt(12);
//							  
//							  Sdev_Res24 = stats_24.getStandardDeviation(); 
//							  Sdev_Res24_fl = Sdev_Res24 * Math.sqrt(12);
//							  
//							  Sdev_Res36= stats_36.getStandardDeviation(); 
//							  Sdev_Res36_fl = Sdev_Res36 * Math.sqrt(12);
//							  
//							  Save_To_Db_Standard_Deviation(ssn,sc_cd,Fund_Type,12,Sdev_Res12_fl,dte);
//							  Save_To_Db_Standard_Deviation(ssn,sc_cd,Fund_Type,24,Sdev_Res24_fl,dte);
//							  Save_To_Db_Standard_Deviation(ssn,sc_cd,Fund_Type,36,Sdev_Res36_fl,dte);
							 
							 
			   }
			  
			  ssn.getTransaction().commit();
			  ssn.beginTransaction();
			  ssn.flush();
			  ssn.clear();
//		  
			  
		  }
		 
 			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		finally
		{
			ssn.getTransaction().commit();
			ssn.close();
//			System.out.println("from date-->>"+s_dt+" upto date-->>"+upt_dt);
			System.out.println("<-------COmplete_Report------------>>");
		}
		
		
		
		
	}

	public static void Save_To_Db_Standard_Deviation(Session ssn ,long sch_cd, String fund_Type, int i, double sdev_Res,Date dte) 
	{
	    
		  Standard_Dev sd_ob;
		  composite_pk_Sd c_p_sd;
		  sd_ob = new Standard_Dev();
		  c_p_sd = new composite_pk_Sd();
		  c_p_sd.setDate(dte);
		  c_p_sd.setFund_Type(fund_Type);
		  c_p_sd.setScheme_code(sch_cd);
		  c_p_sd.setSd_day(i);
		  sd_ob.setKey(c_p_sd);
		  
		  
		  
		  sd_ob.setStandard_deviation(sdev_Res);
		  
		  ssn.save(sd_ob);
	}
}
