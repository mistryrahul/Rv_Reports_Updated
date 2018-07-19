package NewQuarterlyReports;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.mysql.fabric.xmlrpc.base.Array;
import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Statement;

import model.Nav_report_temp_1;
import model.Report_6_pk;
import model.Scheme_available;
import sessionFactory.HIbernateSession;
public class NewEquityReportRunner {
	static String ret_type=""; 
	
//	delete from  rolling_ret_New_Report;
//  delete from Scheme_available;	
	static ArrayList<String> rating_list=new ArrayList<String>();
	static HashMap<Long,Double> scheme_ret =new HashMap<Long,Double>(); 
	
	private static ArrayList<String> schemecode_list_path_arr = new ArrayList<String>();
	private static ArrayList<String> fund_Type_arr = new ArrayList<String>();
	
	public static void generate_category_Equity()
	{
     	 schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_LARGE_CAP_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_MULTI_CAP_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_LARGE_AND_MID_CAP_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_MID_CAP_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_SMALL_CAP_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_ELSS_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_INFRASTRUCTURE_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_THEMATIC_CONSUMPTION_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/HYBRID_EQUITY_ORIENTED_JUNE_2018.txt");
         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/HYBRID_ARBITRAGE_JUNE_2018.txt");         
     	 
         fund_Type_arr.add("EQUITY_LARGE_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_MULTI_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_LARGE_AND_MID_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_MID_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_SMALL_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_ELSS_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_INFRASTRUCTURE_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_THEMATIC_CONSUMPTION_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_HYBRID_EQUITY_ORIENTED_CAP_30.06.2018");
         fund_Type_arr.add("EQUITY_HYBRID_ARBITRAGE_CAP_30.06.2018");
         
//		 String scheme_code_list_path="/home/rv/Desktop/files_to_upload/EQUITY_ELSS_MARCH_2018.TXT";
//		 String Fund_Type="Equity_Debt_Oriented";
		 
		 
	}
	
	
	
	 public static void main(String args[])
	 {   
		 
		 Session ssn= null;
		 DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		   
		 
		 String Output_File_Name="";
		 String test_sql="";
		 String scheme_code_list_path="";
		 String Fund_Type="";

		 int db_flag=0;
		 int cat_count=0;
		 generate_category_Equity(); 
		 // Category List prepared
		 
		try {
			  
//			System.out.println(fund_Type_arr.size());
			
//			while(cat_count < fund_Type_arr.size())
//			{
//				   scheme_code_list_path = schemecode_list_path_arr.get(cat_count);
//				   Fund_Type = 	fund_Type_arr.get(cat_count);
//				   
//				   System.out.println(scheme_code_list_path);
//				   System.out.println(Fund_Type);
//				   cat_count++;
//			}
//			System.exit(0);
			
			while(cat_count < fund_Type_arr.size())
			{
				
			   scheme_code_list_path = schemecode_list_path_arr.get(cat_count);
			   Fund_Type = 	fund_Type_arr.get(cat_count);
			   
			   
			   Date staring_date = new SimpleDateFormat("dd/MM/yyyy").parse("31/03/2000");

			   // please set end date properly
			   Date end_date = new SimpleDateFormat("dd/MM/yyyy").parse("30/06/2018");
//			   int counter=0;
		       Date curr_date_tmp=staring_date;
			   ArrayList<String> date_array = new ArrayList<String>();
		       Calendar cal = Calendar.getInstance();
		       cal.setTime(staring_date);
		      
		       Scheme_available obj=null;
			   Report_6_pk ky = null;
			   
			   List<Long> temp_schem_code = new ArrayList<Long>();
 			  	
//			  	LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/scheme_code_list_EQUITY_ELSS_2017.txt"), "UTF-8");		  			  			 
//			  	LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/EQUITY_ELSS_LIST_31_may_17.txt"), "UTF-8");
			  	LineIterator it_s = FileUtils.lineIterator(new File(scheme_code_list_path), "UTF-8");
			  	
			  	
			  	   
				while (it_s.hasNext()) // if the file has lines 
			   	    {
					  temp_schem_code.add(Long.parseLong(it_s.nextLine().trim()));
			   	    }		
		       
		       while(curr_date_tmp.compareTo(end_date) < 0 || curr_date_tmp.compareTo(end_date)== 0)
		       {
		    	   date_array.add(df.format(curr_date_tmp));
		    	   
		    	   cal.add(Calendar.MONTH, 3);  
		    	   cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		    	   curr_date_tmp = cal.getTime();
		       }
		       
		      
		       String date_list_arr = String.join(",", date_array);
		       
		       
		     System.out.println("-=-=-=-=-=-=-=-<Date Array>=-=-=-=-=-=-==-=-");
		        System.out.println(date_array);
		        System.out.println("-=-=-=NORMAL--=-=Array-===-=-=");
		        System.out.println(date_list_arr);
		     System.out.println("-=-=-=-=-=-=-=-<END>=-=-=-=-=-=-==-=-");
		
		      
		     ssn = HIbernateSession.getSessionFactory().openSession(); 
			 ssn.beginTransaction();    
			
		     
			 for(Long schemecode : temp_schem_code) {
				 get_3_years_Date(ssn,date_list_arr,date_array.size(),Fund_Type,schemecode);
				 
				   System.out.println("-------------------->>"+ret_type);
			       if( !ret_type.equals("NO_VAL") && !ret_type.equals("CLOSE ENDED FUND"))
			       {
			    	      db_flag ++;
			       }
			       else
			       {
			    	   System.out.println("CLOSE ENDED FUND-->>"+schemecode);
			       }
			       
			       if(db_flag%5==0)
			       {
			    	   ssn.getTransaction().commit();
			    	   ssn.beginTransaction();
			       }
			 }
			 
			 ssn.getTransaction().commit();
			 ssn.beginTransaction();
//			  3 years return date calculated for all schemecodes in this category.
			  
			 Rolling_Return_New_Runner rn = new Rolling_Return_New_Runner();
             String ret = rn.Generate_Rolling_Return(Fund_Type,ssn);
		     if(ret.equals("Success") || ret=="Success")
		     {
		    	 System.out.println("Summary Report Generated");
		     }
		     

		     
		     ssn.beginTransaction();
		     
		     Query q33 =  ssn.createQuery("select distinct(DATE_FORMAT(key.from_date,'%Y-%m-%d')) as from_date from rolling_ret_New_Report where key.Fund_Type='"+Fund_Type+"'");
		     ArrayList<String> date_list = (ArrayList<String>) q33.list();
		     
		     for(String dd : date_list)
		     {
		         get_rating_list(ssn, Fund_Type,3,dd);
		         get_rating_list(ssn, Fund_Type,2,dd);
		     }   
		          ssn.getTransaction().commit();   
		          ssn.beginTransaction();
		     System.out.println("Before commit--=-=-=-=-=-=-"+rating_list.size());     
		     
		     		     
		    
		    
		    		  
		 		     
//				              ssn.doWork(new Work() {
//				            	  
//								@Override
//								public void execute(Connection conn) throws SQLException {
//									int q_updater = 0 ;    
//						 		    String bulk_update ="";
//						 		     
//									for(String query : rating_list)
//								     {
//								    	
//								    	 if(q_updater==0)
//								    	 {
//								    		 bulk_update = query+";";
//								    	 }
//								    	 else
//								    	 {
//								    	   bulk_update = bulk_update+query+";";
//								    	 }
//								    	 
//								    	 q_updater++;
//								     }	 
//									
//									if(q_updater%50==0)
//							    	 {
////										    final String uq = bulk_update;
//											CallableStatement cstmt =  (CallableStatement) conn.prepareCall("call Calc_Rating(?)");
//											cstmt.setString(1,bulk_update);									
//											cstmt.executeUpdate();
//											boolean hadResults = cstmt.execute();
//		//											System.out.println("-==-=-=-=-=-AFTER EXECUTE-=-=-==-");
//		//											if (hadResults) {
//										    ResultSet rs = cstmt.getResultSet();
//										       
//										    while (rs.next()) 
//										    {
//										        	 
//										        	System.out.println(rs.getString(1));
//		//								        	scheme_ret.put(rs.getLong(1),rs.getDouble(2));
//		//								        	System.out.println(rs.getString(1));
//		//										        	System.out.println(rs.getString(2));
//										        	
//										    }
//							    	 }
//								        
//									
//								}
//						});
		    	
		    	 
		    	
		     
		           
		       
//		     System.out.println(bulk_update);
		            
		     
		    
		     
		     
					 String pr_1 ="set global sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION'";
				     Query query = ssn.createSQLQuery(pr_1);
				     int result = query.executeUpdate();
				     String pr_2 ="set session sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';";
				     query = ssn.createSQLQuery(pr_2);
				     result = query.executeUpdate();
				    	
				   	 ssn.getTransaction().commit();
				   	 ssn.beginTransaction();	
		          
//				   	 System.out.println("=-=TIme to make CSV-=-=-");
		          if(Fund_Type.toUpperCase().contains("LARGE") && !Fund_Type.toUpperCase().contains("MID"))
			   		{   
		         	
		         	Output_File_Name="Large_Cap_Report.csv";
//		         	String test_sql ="select  \"from_date\", \"scheme_code\", \"quarter\", \"Scheme Name\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\",\"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\" UNION ALL select from_date, scheme_code, quarter, Scheme_Name, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'  FIELDS TERMINATED BY ','   ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
		         	test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F12\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
		         	
			   		}
			   		else if(Fund_Type.toUpperCase().contains("MID") && !Fund_Type.toUpperCase().contains("LARGE"))
			   		{
			   			Output_File_Name="Mid_Cap_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F12\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
			   		else if(Fund_Type.toUpperCase().contains("MID") && Fund_Type.toUpperCase().contains("LARGE"))
			   		{
			   			Output_File_Name="Mid_and_Large_Cap_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F12\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
			   		else if(Fund_Type.toUpperCase().contains("SMALL"))
			   		{
			   			Output_File_Name="Small_Cap_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F12\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
			   		else if(Fund_Type.toUpperCase().contains("MULTI"))
			   		{
			   			Output_File_Name="Multi_Cap_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F12\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
			   		else if(Fund_Type.toUpperCase().contains("ELSS"))
			   		{
			   			Output_File_Name="Elss_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F36\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
			   		else if(Fund_Type.toUpperCase().contains("INFRASTRUCTURE"))
			   		{
			   			Output_File_Name="Infrastructure_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F36\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
		          
			   		else if(Fund_Type.toUpperCase().contains("ARBITRAGE") && Fund_Type.toUpperCase().contains("HYBRID"))
			   		{
			   			Output_File_Name="Equity_Arbitrage_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F36\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
			   		else if(Fund_Type.toUpperCase().contains("HYBRID") && !Fund_Type.toUpperCase().contains("ARBITRAGE"))
			   		{
			   			Output_File_Name="Hybrid_Equity_Oriented_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F36\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
			   		else if(Fund_Type.toUpperCase().contains("THEMATIC"))
			   		{
			   			Output_File_Name="Equity_THEMATIC_Report.csv";
			   			test_sql  ="select \"date\",\"Scheme_Code\",\"Scheme_Name\",\"AUM\",\"X2\",\"X3\",\"F36\",\"X2R\",\"X3R\" union select rrn.from_date, rrn.scheme_code,sa.scheme_name,rrn.aum,rrn.rolling_ret_2,rolling_ret_3,rrn.forward_12,if(rrn.rolling_ret_2_rating=0,'Unrated',rolling_ret_2_rating) as rolling_ret_2_rating,if(rrn.rolling_ret_3_rating=0,'Unrated',rolling_ret_3_rating) as rolling_ret_3_rating from rolling_ret_New_Report rrn join Scheme_available sa on rrn.scheme_code=sa.scheme_code and rrn.from_date=sa.from_date where rrn.Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
			   		}
//		          Equity_Arbitrage
		            
		          final String  final_sql=test_sql;
				    
				  ssn.doWork(new Work() {			
					@Override
					public void execute(Connection conn) throws SQLException 
					{
						Statement stmt = (Statement) conn.createStatement();
						stmt.executeQuery(final_sql);
					}
				});
		            
				    
				    ssn.close();
				  
				    System.out.println("---<All Reports Complete, csv file may be found in '/var/lib/mysql-files' folder>---");
				    
				    cat_count++;
				    
		  } // end-of--category-loop    
		          
		          
		} 
		catch (ParseException e) {
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			 if(ssn!=null && ssn.isOpen())
			 {
				 
				 ssn.close();
				 System.out.println("-=-=-=-=-=-ALL Report Completed-=-=-=-=--");
			 }
		}
		  
		 
		 
	 }

public static void get_rating_list(Session ssn, String Fund_Type, int ret_yr, String date) {
	
	int tmp_size=0, top_grp_1=0,top_grp_2=0,top_grp_3=0,top_grp_4=0,top_grp_5=0,diff=0;
	ArrayList<Sample_data> scheme_ret = new ArrayList<Sample_data>();
//	Sample_data obj = null;
//	System.out.println("coming here");
	
	ssn.doWork(new Work() {
		
		
		@Override
		public void execute(Connection conn) throws SQLException 
		{
			
//			System.out.println(date+"      "+Fund_Type+"        "+ret_yr);
			scheme_ret.clear();
//					final java.sql.Array sqlArray = conn.createArrayOf(java.sql.Types.ARRAY , date_list_arr);
			CallableStatement cstmt =  (CallableStatement) conn.prepareCall("call rating_NEW_rep(?,?,?)");
			cstmt.setString(1,date);
			cstmt.setString(2, Fund_Type);
			cstmt.setInt(3,ret_yr);
//			cstmt.executeUpdate();
			boolean hadResults = cstmt.execute();
//					System.out.println("-==-=-=-=-=-AFTER EXECUTE-=-=-==-");
					if (hadResults) {
		        ResultSet rs = cstmt.getResultSet();
		       
//		        if (rs.next()) {
		        
		    
						        while (rs.next()) {
//						        	System.out.println("-0=-=-===-=-=-=-=-=-=-"+rs.getString(1)); 
						        	
//						        		System.out.println(rs.getLong(1)+" , "+rs.getDouble(2)+","+date);
//							        	scheme_ret.put(rs.getLong(1),rs.getDouble(2));	
//						        		scheme_ret.
						        		Sample_data obj = new Sample_data();
						        		obj.setScheme_code(rs.getLong(1));
						        		obj.setValue(rs.getDouble(1)); 
						        		scheme_ret.add(obj);
				//		        	System.out.println(rs.getString(1));
				//				        	System.out.println(rs.getString(2));
						        }
		    		 
						        		        }
		        
		        
		        
//					}
		}
			 
	});
	   
	 tmp_size = scheme_ret.size();
	 
	 System.out.println(tmp_size);
    if(tmp_size > 0)
    {
   	 System.out.println("Scheme Return Size--->>"+tmp_size);
		 
   	    top_grp_1=(int) Math.round(tmp_size*.10);
        top_grp_2=(int) Math.round(tmp_size*.25);
        top_grp_3=(int) Math.round(tmp_size*.30);
        top_grp_4=(int) Math.round(tmp_size*.25);
        top_grp_5=(int) Math.round(tmp_size*.10);
        
        
        
         System.out.println("top_grp_1/top_grp_2/top_grp_3/top_grp_4/top_grp_5");
         System.out.println(top_grp_1+","+top_grp_2+","+top_grp_3+","+top_grp_4+","+top_grp_5);
         
        int rec_counter =1;
        
        
   	 for(Sample_data bb :scheme_ret){  
//   		   System.out.println("IN actual lloooooppppp---->>>"+m.getKey()+" "+m.getValue());
   		    
   		   if(rec_counter>=1 && rec_counter<=top_grp_1)
              {		           	     
//   			   System.out.println(5);
//   			     rating_list.add("update rolling_ret_New_Report SET rolling_ret_"+ret_yr+"_rating = 5 where scheme_code="+m.getKey()+" and Fund_Type='"+Fund_Type+"' and from_date='"+date+"'");
        			Bulk_update(ssn, Fund_Type, date, (long) bb.getScheme_code(), 5, ret_yr);
              }
              
   		   else if(rec_counter>top_grp_1 &&  rec_counter<=(top_grp_1+top_grp_2))
              {
//   			   System.out.println(4);
//   			   rating_list.add("update rolling_ret_New_Report SET rolling_ret_"+ret_yr+"_rating = 4 where scheme_code="+m.getKey()+" and Fund_Type='"+Fund_Type+"' and from_date='"+date+"'");
   			Bulk_update(ssn, Fund_Type, date, (long) bb.getScheme_code(), 4, ret_yr);
              }
   		   else if(rec_counter>(top_grp_1+top_grp_2) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3))
              {
//   			   System.out.println(3);
//   			   rating_list.add("update rolling_ret_New_Report SET rolling_ret_"+ret_yr+"_rating = 3 where scheme_code="+m.getKey()+" and Fund_Type='"+Fund_Type+"' and from_date='"+date+"'");
            	 //            	 System.out.println("3 star");
     		Bulk_update(ssn, Fund_Type, date, (long) bb.getScheme_code(), 3, ret_yr);
              }
   		   else if(rec_counter>(top_grp_1+top_grp_2+top_grp_3) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4))
              {
//   			   System.out.println(2);
//   			   rating_list.add("update rolling_ret_New_Report SET rolling_ret_"+ret_yr+"_rating = 2 where scheme_code="+m.getKey()+" and Fund_Type='"+Fund_Type+"' and from_date='"+date+"'");
            	 //            	 System.out.println("2 star");
   			Bulk_update(ssn, Fund_Type, date, (long) bb.getScheme_code(), 2, ret_yr); 
              }
   		   else if(rec_counter>(top_grp_1+top_grp_2+top_grp_3+top_grp_4) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5))
              {
//   			   System.out.println(1);
//   			   rating_list.add("update rolling_ret_New_Report SET rolling_ret_"+ret_yr+"_rating = 1 where scheme_code="+m.getKey()+" and Fund_Type='"+Fund_Type+"' and from_date='"+date+"'");
            	 //            	 System.out.println("1 star");
   			Bulk_update(ssn, Fund_Type, date, (long) bb.getScheme_code(), 1, ret_yr);
              }
   		   
   		   rec_counter++;
   		  }  
   	
   	       ssn.getTransaction().commit();
   	       ssn.beginTransaction();
   	 
    }
	
}
    private static void Bulk_update(Session ssn, String Fund_Type,String date , long scheme_code, int rating,int ret_year )
    {
    	
    	System.out.println("in BULK UPDATE");
    	ssn.doWork(new Work() {
    		
    		
    		@Override
    		public void execute(Connection conn) throws SQLException 
    		{
    			CallableStatement cstmt =  (CallableStatement) conn.prepareCall("call Bulk_Update(?,?,?,?,?)");
    			cstmt.setInt(1,(int) scheme_code);
    			cstmt.setString(2, Fund_Type);
    			cstmt.setString(3,date);
    			cstmt.setInt(4,rating);
    			cstmt.setInt(5,ret_year);
    			cstmt.executeUpdate();
    		}
    			 
    	});
    }
	private static void get_3_years_Date(Session ssn, String date_list_arr , int size , String Fund_Type, long scheme_code) 
	{
		NewEquityReportRunner.ret_type ="NO_VAL";
		    
		ssn.doWork( new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
				
//				final java.sql.Array sqlArray = conn.createArrayOf(java.sql.Types.ARRAY , date_list_arr);
				CallableStatement cstmt =  (CallableStatement) conn.prepareCall("call Rv_FirstReport(?,?,?,?)");
				
				cstmt.setString(1,date_list_arr); 
				cstmt.setLong(2, scheme_code);
				cstmt.setInt(3, size);
				cstmt.setString(4, Fund_Type);
//				cstmt.executeUpdate();
				boolean hadResults = cstmt.execute();
//				System.out.println("-==-=-=-=-=-AFTER EXECUTE-=-=-==-");
				if (hadResults) {
			        ResultSet rs = cstmt.getResultSet();
			       
			        while (rs.next()) {
			        	 
//			        	System.out.println(rs.getString(1));
			        	NewEquityReportRunner.ret_type = rs.getString(1);
//			        	System.out.println(rs.getString(2));
			        }
			        
			        
			        
				}
			}
		}); 
	}
}
