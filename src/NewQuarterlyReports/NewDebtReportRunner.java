package NewQuarterlyReports;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.Statement;

import New_Elss_Model.Composite_pk;
import controller.Rolling_Return_Main;
import debt_Model.Credit_rating_sum_groups;
import debt_Model.Debt_Report_1;
import debt_Model.Pk_generic;
import model.Debt_Report_New;
import model.ExpenceRatio;
import model.Report_6_pk;
import model.Rolling_Return;
import model.Scheme_Detail;
import model.nav_hist;
import sessionFactory.HIbernateSession;

public class NewDebtReportRunner {

//	private static ArrayList<String> schemecode_list_path_arr = new ArrayList<String>();
	private static ArrayList<String> fund_Type_arr = new ArrayList<String>();
	
	public static void generate_category()
	{
//     	 schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_LIQUID_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_ULTRA_SHORT_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_LOW_DURATION_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_SHORT_DURATION_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_MEDIUM_DURATION_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_MEDIUM_TO_LONG_DURATION_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_GILT_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_DYNAMIC_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_BANKING_PSU_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_CORPORATE_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/DEBT_CREDIT_RISK_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/HYBRID_DEBT_ORIENTED_BALANCED_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/HYBRID_DEBT_ORIENTED_CONSERVATIVE_JUNE_2018.txt");
         
     	 
//         fund_Type_arr.add("Debt : Liquid");
//         fund_Type_arr.add("Debt : Ultra Short Duration");
//         fund_Type_arr.add("Debt : Low Duration");
//         fund_Type_arr.add("Debt : Short Duration");
         fund_Type_arr.add("Debt : Medium Duration");
//         fund_Type_arr.add("Debt : Medium to Long Duration");
//         fund_Type_arr.add("Debt : Gilt");
//         fund_Type_arr.add("Debt : Dynamic Bond");
//         fund_Type_arr.add("Debt : Banking & PSU");
//         fund_Type_arr.add("Debt : Corporate Bond");
//         fund_Type_arr.add("Debt : Credit Risk");
//         fund_Type_arr.add("Hybrid : Debt Oriented (Balanced)");
//         fund_Type_arr.add("Hybrid : Debt Oriented (Conservative)");
//         fund_Type_arr.add("Debt_30.06.2018");
         
//		 String scheme_code_list_path="/home/rv/Desktop/files_to_upload/EQUITY_ELSS_MARCH_2018.TXT";
//		 String Fund_Type="Equity_Debt_Oriented";
		 
		 
	}
	
//	delete from rolling_ret_New_Report where Fund_Type="";
//	delete from Debt_Report_New where Fund_Type="";
	
	public static void main(String[] args)
	{
		Session ssn = null;
		int mc=1;
		int db_save=1;
		Debt_Report_New ob1 = null;
		Composite_pk ob1_pk =null;
		int frst_iteration=1;
				
		double temp_weight=0;
		
		double ans_1=0,ans_2=0,ans_3=0,fin_res=0;
		
		ArrayList<Debt_Report_New> dr_m = new ArrayList<Debt_Report_New>();
		
		double ret_12_mnths=0,ret_36_mnths=0;
		
		long chek_sch_cd=0;
		String class_chk=null;
		java.util.Date date_chk=null;
		long tmp_sc=0;
		 int cat_count=0;
		 generate_category();
		
		try
		  {
			
			while(cat_count < fund_Type_arr.size())
		   {
			ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    
		    Date Date_As_On_Report= new Date(118, 05, 30);  // as on date should be fixed before running
 		    ArrayList<Long> scheme_codes = new ArrayList<Long>();
// 		    
//		    String Fund_Type="Debt : Liquid";
//		    String Fund_Type="Debt : Ultra Short Term";		    
//		    String Fund_Type="Debt : Short Term";	
//		    String Fund_Type="Debt : Long Term";
//		    String Fund_Type="Debt : Medium Term";
//		    String Fund_Type="Hybrid : Debt Oriented";
//		    String Fund_Type="Debt : Dynamic Bond";
		    String dd_1 = new SimpleDateFormat("yyyy-MM-dd").format(Date_As_On_Report);		   
//		    String Fund_Type="Debt : Medium & Long Term";
//		    
		    String Fund_Type = fund_Type_arr.get(cat_count);
		    
		    String Comment=Fund_Type+"_as_on_"+dd_1;
		    String Output_File_Name="";
		    String test_sql="";
		    
		    String pattern = "yyyy-MM-dd";
		    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		    String to_date = simpleDateFormat.format(Date_As_On_Report);
		    
		    ArrayList<Credit_rating_sum_groups> new_calc = new ArrayList<Credit_rating_sum_groups>();
		    ArrayList<Credit_rating_sum_groups> mn_lst = new ArrayList<Credit_rating_sum_groups>();
		    Rolling_Return rr =null;
		    Report_6_pk key =null;
		    
//		    List<Object[]> result= ssn.createSQLQuery("select csrg.* from credit_rating_sum_groups csrg join scheme_details_fulls sdf on csrg.schemecode=sdf.schemecode where csrg.invdate='2016-12-31' and csrg.classification like '%Liquid%' and sdf.type_code!=2").list();
		    List<Object[]> result= ssn.createSQLQuery("select csrg.* from credit_rating_sum_groups csrg join scheme_details_fulls sdf on csrg.schemecode=sdf.schemecode where csrg.classification like '%"+Fund_Type+"%' and sdf.type_code!=2 and invdate=(select max(invdate) from credit_rating_sum_groups) order by schemecode").list(); 
//		    List<Object[]> result= ssn.createSQLQuery("select * from credit_rating_sum_groups where classification like '%Liquid%' order by schemecode").list();
		    
		    for(int i=0;i<result.size();i++)
			{
		    	Object[] data = result.get(i);
		    	Credit_rating_sum_groups obj = new Credit_rating_sum_groups();

		    	obj.setClassification(data[1].toString());
		    	obj.setHold_percent(Double.valueOf(data[3].toString()));
		    	obj.setInv_date(Date_As_On_Report);
		    	obj.setScheme_code(new Long(data[0].toString()));
		    	obj.setRv_group(data[4].toString());
		    	
		    	mn_lst.add(obj);
		    	
		    	 tmp_sc = obj.getScheme_code();
		    	
//		    	 if(i==0)
//		    	 {
//		    		 scheme_codes.add(obj.getScheme_code());
//		    	 }
		    	 
		    	
		    	
		    	if(scheme_codes.contains(tmp_sc))
		    	{
//		    		 System.out.println("Schemecode ADDED -->>"+obj.getScheme_code());
		    	}
		    	else
		    	{
//		    	   System.out.println("3 Years rolling Return getting calculated for---->>"+obj.getScheme_code());
//		    	   System.out.println(Fund_Type+"  "+3+"    "+to_date);
		    	   scheme_codes.add(obj.getScheme_code());
		    	   
		    	   
		    	     rr = new Rolling_Return();
			         key = new Report_6_pk();
			         key.setScheme_code(obj.getScheme_code());
				     key.setFrom_date(Date_As_On_Report);
				     key.setFund_Type(Fund_Type);
				     rr.setKey(key);
				     int scheme_code_temp = (int) obj.getScheme_code();
		    	     Rolling_Return_Main.generate_rolling_return(Date_As_On_Report, scheme_code_temp,3,rr,ssn);
		    	     ssn.save(rr);
		    	}
			}
		    
		    
		    System.out.println("ROlling Return And AUM calculated For those schemecodes");
		          
		             ssn.getTransaction().commit();
		             ssn.beginTransaction();
		    
//		    System.exit(0);
//		    ArrayList<Credit_rating_sum_groups> mn_lst = (ArrayList<Credit_rating_sum_groups>) ssn.createQuery("from Credit_rating_sum_groups where classification like '%Liquid%' order by scheme_code").list();
		    
		     for(Credit_rating_sum_groups crsg: mn_lst)
		     {
		    	 new_calc.add(crsg);
		    	
		    	if(new_calc.size()>=2 && frst_iteration!=1)
		    	{
		    		
//		    		System.out.println("1-"+(new_calc.get(new_calc.size()-1).getClassification().equals(new_calc.get(new_calc.size()-2).getClassification())));
//		    	    System.out.println("Sch->"+(new_calc.get(new_calc.size()-1).getKey().getScheme_code()==new_calc.get(new_calc.size()-2).getKey().getScheme_code())); 	
//		    		System.out.println("D->"+(new_calc.get(new_calc.size()-1).getKey().getInv_date().compareTo(new_calc.get(new_calc.size()-2).getKey().getInv_date())));
		    		
		   
		    		
		    		   if(( new_calc.get(new_calc.size()-1).getClassification().equals(new_calc.get(new_calc.size()-2).getClassification()) )
		    				   && (new_calc.get(new_calc.size()-1).getScheme_code()==new_calc.get(new_calc.size()-2).getScheme_code())
		    				   && (new_calc.get(new_calc.size()-1).getInv_date().compareTo(new_calc.get(new_calc.size()-2).getInv_date()))==0)
		    		   {
		    			   
		    			    frst_iteration++;	 
//				    		System.out.println("SAEME DTATa--->>>");
		    			   
		    		   }
		    		   else
		    		   {
//		    			   System.out.println("DATA VALUE CHANGED---->>>");
		    			   double tot_val=0;
		    			   new_calc.remove(new_calc.size()-1); // removing the last item as that scheme code is different
		    			   
		    			   
		    			   
//		    			   System.out.println("Credit Rating-->>"+get_credit_rating(new_calc));
		    			   
		    			   dr_m.get(0).setCredit_rating(get_credit_rating(new_calc));
		    			   
		    			   System.out.println("Date-->>"+dr_m.get(0).getKey().getStart_dt());
		    			   System.out.println("schemecode-->>"+ dr_m.get(0).getKey().getScheme_code());
		    			   		    			   
		    			   ssn.save(dr_m.get(0));
		    			   ssn.getTransaction().commit();
		    			   ssn.beginTransaction();
		    			   ssn.flush();
		    			   ssn.clear();
		    			   
		    			   dr_m.clear();
		    			   
		    			   
		    			   
//		    			   ArrayList<Debt_Report_1> avg_mat_lst = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where day=? and scheme_code=?").setDate(0,crsg.getKey().getInv_date()).setLong(1,crsg.getKey().getScheme_code()).list();
////		    			   
//		    			   avg_mat_lst.get(0).setCredit_rating(tot_val);
//		    			   ssn.update(avg_mat_lst.get(0));
		    			   
//		    			   ob1.setCredit_rating(tot_val);
//		    			   ssn.save(ob1);
		    			   
                      
		    			   
		    			   
		    			   frst_iteration=1;
		    			   
		    			   new_calc.clear();
		    			   
		    			   new_calc.add(crsg);
		    			   
		    			   chek_sch_cd=0;
		    			   class_chk=null;
		    			   date_chk=null;
		    				
		    			   
		    		   }
			    		
			    		
			    }
		    	else
		    	{
		    	        frst_iteration=1;
		    	}
		    	 
		    	 
		    	 if(frst_iteration==1)
		    	 {
		    		 
		    		 
//		    		 System.out.println("IN MAIN CLASS which should run-->>"+mc);
		    		 chek_sch_cd = crsg.getScheme_code();
			    	 class_chk=crsg.getClassification();
			    	 date_chk = crsg.getInv_date();
                       
			    	  mc++;
			    	 
			    	 
			    	 ob1 = new Debt_Report_New();
			    	 ob1_pk = new Composite_pk();
			    	 
			    	 ob1_pk.setStart_dt(crsg.getInv_date());
			    	 ob1_pk.setScheme_code(crsg.getScheme_code());
			    	 ob1_pk.setFund_Type(Fund_Type); // setting Fund_Type
//			    	 ob1_pk.setComment(Comment); //
			    	 
			    	 
			    	 ob1.setKey(ob1_pk);
			    	
			    	 
			    	 
			    	 
			    	 ArrayList<Scheme_Detail> sdf = (ArrayList<Scheme_Detail>) ssn.createQuery("from scheme_details_fulls where schemecode=?").setLong(0,crsg.getScheme_code()).list(); 
			    	 
			    	  for(Scheme_Detail gg : sdf)
			    	  {
			    		  ob1.setScheme_name(gg.getS_NAME());
			    	  }
			    	  
			    	  			    	  
                      ArrayList<Rolling_Return>	rrn = (ArrayList<Rolling_Return>) ssn.createQuery("from rolling_ret_New_Report where key.scheme_code="+crsg.getScheme_code()+" and key.from_date ='"+to_date+"' and key.Fund_Type='"+Fund_Type+"'").list();     	 
                       
                      for(Rolling_Return rr1 : rrn)
                      {
                    	  ob1.setRolling_ret_3(rr1.getRolling_ret_3());
                    	  ob1.setAum(rr1.getAum());
                      }
                      
//                      List<Object[]> result_22= ssn.createSQLQuery("select aum,invdate from mf_portfolios where schemecode=(select primary_fd_code from scheme_details_fulls where schemecode=? ) and invdate<=? order by invdate desc limit 1").setLong(0,crsg.getScheme_code()).setDate(1,crsg.getInv_date()).list(); 
////	    		      List<Object[]> result= ssn.createSQLQuery("select schemecode, invdate, sum(holdpercentage) as holdpercentage, count(*) as tottal_count, aum from mf_portfolios where schemecode=(select primary_fd_code from scheme_details_fulls where schemecode=?) and invdate>=? and invdate<=? group by invdate").setLong(0,arm.getKey().getScheme_code()).setDate(1,ddd).setDate(2,arm.getKey().getStart_dt()).list();
//	    		      
//                     if(result_22.size()>0)
//                     {
//                   	  Object[] data_1 = result_22.get(0);  	                                	  
//                   	  ob1.setAum(((double) data_1[0])/100);
//                   
//                     }
			    	 
			    	 dr_m.add(ob1); 
			    	 
//			    	 ssn.save(ob1);
//			    	 db_save++;
			    	 
			    	 
			    	 
//			    	 if(db_save%100==0)
//			    	 {
//			    		 ssn.getTransaction().commit();
//			    		 ssn.getTransaction().begin();
//			    		 db_save=1;
//			    	 }
			    	
//			    	 
			    	 
			    	 
			    	 frst_iteration++;
		    	 }
		    	
		    	 
		     }
		     
		         
		             if(dr_m.size()!=0)
		             {
		            	 dr_m.get(0).setCredit_rating(get_credit_rating(new_calc));
		            	 ssn.save(dr_m.get(0));
		             }
		    
		             
		             ssn.getTransaction().commit();
		             ssn.beginTransaction();
		             
//		                                           ///////----------xxxxx(Start)------------////                           
//		                                             
		             
		             ssn.doWork(new Work() {			
		       			@Override
		       			public void execute(Connection conn) throws SQLException 
		       			{
		       				Statement stmt = (Statement) conn.createStatement();
		       				stmt.executeUpdate("delete from Debt_Report_New where rolling_ret_3 = 0 and Fund_Type='"+Fund_Type+"'");
		       				
		       				System.out.println("36 Months ROlling Returns which are 0  are removed");
		       			}
		       		});
//		             
//										             Query query = (Query) ssn.createQuery("delete from Debt_Report_1 where return_36_months=0 and Fund_Type='"+Fund_Type+"'");
//										              
//										             int result_2 = query.executeUpdate();
//										              
//										             if (result_2 > 0) {
//										                 System.out.println("36 Months Returns which are 0  are removed");
//										             }
										             
										             ArrayList<Debt_Report_New> drm = (ArrayList<Debt_Report_New>) ssn.createQuery("from Debt_Report_New where Fund_Type='"+Fund_Type+"'").list();
//										             
										             for(Debt_Report_New bb : drm)
										             {
										            	 if(bb.getAum()<100)
										            	 {
										            		 bb.setStar("Unrated");
										            	 }
										            	 
										            	 ssn.save(bb);
										             }
										             System.out.println("all aum below 100 crore updated as Unrated");
										             
//										             Query query_1 = ssn.createQuery("update Debt_Report_1 set star='Unrated' where aum < 100");
////										             
////										             		             
//										             int result_1 = query_1.executeUpdate();
////										             
//										             if (result_1 > 0) {
//										                 System.out.println("all aum below 100 crore updated as unrated");
//										             }
//										             
//										             
										             ssn.getTransaction().commit();
										             ssn.getTransaction().begin();
										             
//										             Query qry_1 = ssn.createQuery("from Debt_Report_1");
										             ArrayList<Debt_Report_New> drm1 = (ArrayList<Debt_Report_New>) ssn.createQuery("from Debt_Report_New where Fund_Type='"+Fund_Type+"'").list();
										             for(Debt_Report_New ob11 : drm1)
										             {
										            	 double comp_score = ((ob11.getRolling_ret_3() * 0.65) + (ob11.getCredit_rating()*0.35));
									                     
									                     ob11.setComposite_score(comp_score);
									                     ssn.update(ob11);
										             }
										             
										            
								                     
								                     ssn.getTransaction().commit();
										             ssn.beginTransaction();
//										             
//										             /////-------xxxxx---------------//////
//								                     Genrate_Rank(ssn);
                     
                     
//                      ssn.close();
//                      ssn = HIbernateSession.getSessionFactory().openSession(); 
//		              ssn.beginTransaction();
		              
		             
                                          
//                     Genrate_Rank_for_Weight(ssn);
                     
                     Generate_start_rating(ssn,Fund_Type);
		             
                     
                     if(Fund_Type.toUpperCase().contains("LIQUID"))
 			   		{   
                    	 Output_File_Name="Debt_Liquid.csv";
                    	 test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("ULTRA") && Fund_Type.toUpperCase().contains("SHORT"))
 			   		{
                    	Output_File_Name="Debt_UltraShort.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("SHORT") && !Fund_Type.toUpperCase().contains("ULTRA"))
 			   		{
                    	Output_File_Name="Debt_Short.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("MEDIUM") && !Fund_Type.toUpperCase().contains("LONG"))
 			   		{
                    	Output_File_Name="Debt_Medium.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("LONG") && Fund_Type.toUpperCase().contains("MEDIUM"))
 			   		{
                    	Output_File_Name="Debt_MEdium_to_Long.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("LOW"))
  			   		{   
                     	 Output_File_Name="Debt_Low_DURATION.csv";
                     	 test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
  			   		}
                    else if(Fund_Type.toUpperCase().contains("GILT"))
  			   		{   
                     	 Output_File_Name="Debt_Gilt_Fund.csv";
                     	 test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
  			   		}                     
                    else if(Fund_Type.toUpperCase().contains("DYNAMIC") && Fund_Type.toUpperCase().contains("BOND"))
 			   		{
                    	Output_File_Name="Debt_Dynamic_Bond.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("BANKING") && Fund_Type.toUpperCase().contains("PSU"))
 			   		{
                    	Output_File_Name="Debt_Baning_Psu.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("CORPORATE") && Fund_Type.toUpperCase().contains("PSU"))
 			   		{
                    	Output_File_Name="Debt_Corporate.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                    else if(Fund_Type.toUpperCase().contains("CREDIT") && Fund_Type.toUpperCase().contains("RISK"))
 			   		{
                    	Output_File_Name="Debt_Credit_Risk.csv";
                    	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
                     
                     
                     
                     
 			   		else if(Fund_Type.toUpperCase().contains("BALANCED") && Fund_Type.toUpperCase().contains("ORIENTED") && Fund_Type.toUpperCase().contains("HYBRID"))
 			   		{
 			   		    Output_File_Name="Hybrid_Debt_Oriented_Balanced.csv";
          			   	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
 			   		}
 			   	    else if(Fund_Type.toUpperCase().contains("CONSERVATIVE") && Fund_Type.toUpperCase().contains("ORIENTED") && Fund_Type.toUpperCase().contains("HYBRID"))
			   		{
			   		    Output_File_Name="Hybrid_Debt_Oriented_Conservative.csv";
      			   	test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
			   		}
// 			   	    else if(Fund_Type.toUpperCase().contains("EQUITY") && Fund_Type.toUpperCase().contains("ORIENTED"))
//			   		{
// 			   	        Output_File_Name="Hybrid_Equity_Oriented.csv"; 
//      			   	    test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'";
//			   		}
// 			   		else if(Fund_Type.toUpperCase().contains("ARBITRAGE"))
// 			   		{
// 			   		     Output_File_Name="Hybrid_Arbitrage.csv";
//    			   		 test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'"; 
// 			   		}
 			   		else
 			   		{
 			   			//Others
			   		     Output_File_Name="Debt_Report_Others.csv";
     			   		 test_sql  ="select \"scheme_code\",\"Scheme_Name\",\"AUM\",\"X3\",\"Credit_Rating\",\"Composite_Score\",\"Rating\" UNION select scheme_code,scheme_name,aum,rolling_ret_3,credit_rating,composite_score,star from Debt_Report_New where Fund_Type='"+Fund_Type+"' order by Composite_Score desc into outfile'/var/lib/mysql-files/"+Output_File_Name+"' FIELDS TERMINATED BY ','ENCLOSED BY '\'LINES TERMINATED BY '\\n'"; 
 			   		}
                     
                    ssn = HIbernateSession.getSessionFactory().openSession(); 
           		    ssn.beginTransaction();
           		    final String  final_sql=test_sql;
           		    
	           		  ssn.doWork(new Work() {
	           			  
	           			@Override
	           			public void execute(Connection conn) throws SQLException 
	           			{
	           				Statement stmt = (Statement) conn.createStatement();
	           				stmt.executeQuery(final_sql);
	           			}
	           		});
                     
//           		    ssn.close();
           		  
           		    System.out.println("<--------------------Generating Csv---Please open folder /var/lib/mysql-Files to see the reports------------------->"); 
                    ssn.close();  
                    
                    cat_count++;
                    
		  }// end-of-main-category-loop
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		finally
		{
//			ssn.getTransaction().commit();
			if(ssn.isOpen())
     	      ssn.close();
			
		    System.out.println("<<<<----Report COmplete----->>>>>");
		}
	}
	
	
	
	private static void Generate_start_rating(Session ssn ,String Fund_Type) 
	{
//		ssn.getTransaction().commit();
		ssn.beginTransaction();
		
		int rec_counter=1;
		int tmp_size=0, top_grp_1=0,top_grp_2=0,top_grp_3=0,top_grp_4=0,top_grp_5=0,diff=0;
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//        ssn.beginTransaction();
        
        ArrayList<Debt_Report_New> mn_lst_rank_wise = (ArrayList<Debt_Report_New>) ssn.createQuery("from Debt_Report_New where star is null and Fund_Type='"+Fund_Type+"' order by composite_score desc").list();
        tmp_size = mn_lst_rank_wise.size();
        
        top_grp_1=(int) Math.round(tmp_size*.10);
        top_grp_2=(int) Math.round(tmp_size*.25);
        top_grp_3=(int) Math.round(tmp_size*.30);
        top_grp_4=(int) Math.round(tmp_size*.25);
        top_grp_5=(int) Math.round(tmp_size*.10);
        
        if((top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5)>tmp_size)
        {
        	top_grp_5 = top_grp_5 - ( (top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5) - tmp_size );
        }
        else if ((top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5)<tmp_size)
        {
        	diff= (tmp_size - (top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5));
        	if(diff>0)
        	{
        		top_grp_5 = top_grp_5+diff;
        	}
        }
        
//       System.out.println("Size-->"+tmp_size);
//       System.out.println("1->"top_grp_1);
//       System.out.println("2->"+top_grp_2);
//       System.out.println("3->"+top_grp_3);
//       System.out.println("4->"+top_grp_4);
//       System.out.println("5->"+top_grp_5);
        
        for(Debt_Report_New ob : mn_lst_rank_wise)
        {
        	
        	 
        		 
             if(rec_counter>=1 && rec_counter<=top_grp_1)
             {
//            	 System.out.println("5 star");
		           	     
		           	  if(ob.getAum()<100)
		         	 {
		           		ob.setStar("Unrated");
		         	 }
		         	 else
		         	 {
		         		ob.setStar("5");
		         	 }
             }
             
             if(rec_counter>top_grp_1 &&  rec_counter<=(top_grp_1+top_grp_2))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("4");
	         	 }
//            	 System.out.println("4 star");
            
             }
             if(rec_counter>(top_grp_1+top_grp_2) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("3");
	         	 }
           	 //            	 System.out.println("3 star");
            
             }
             if(rec_counter>(top_grp_1+top_grp_2+top_grp_3) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("2");
	         	 }
           	 //            	 System.out.println("2 star");
            
             }
             if(rec_counter>(top_grp_1+top_grp_2+top_grp_3+top_grp_4) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("1");
	         	 }
           	 //            	 System.out.println("1 star");
            
             }
             
             
             ssn.update(ob);
        	 rec_counter++;
     
        }
         
       ssn.getTransaction().commit();
//		ssn.close();
	}



	
	private static double get_credit_rating(ArrayList<Credit_rating_sum_groups> new_calc) {
		
		double tot_val=0;
		double tmp_hld_prcnt=0;
		
		 for(Credit_rating_sum_groups oo:new_calc)
		   {  
//			     System.out.println("HOlding Percentage--->>"+oo.getHold_percent()+" Scheme COde-->"+oo.getKey().getScheme_code());
			     
//			      if(oo.getHold_percent()>0)
//			      {
//			    	  tmp_hld_prcnt =oo.getHold_percent(); 
//			      }
//			      else
//			      {
//			    	  tmp_hld_prcnt = 0;
//			      }
			        
			    	tmp_hld_prcnt =oo.getHold_percent(); 
			   
			     if(oo.getRv_group().equalsIgnoreCase("AAA"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*9);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Cash & Equivalent"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*10);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("SOV"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*10);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("AA"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*8);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("A"))   // for A and  A-
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*7);	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("A-"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*7);	 
			     }
			     
			     else if(oo.getRv_group().equalsIgnoreCase("Below A"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*5);	 
			     }
			     
			     else if(oo.getRv_group().equalsIgnoreCase("Others"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Deposits"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Equity"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Unrated"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     
			   
		   }
		 
		 return tot_val;
		
	}
}
