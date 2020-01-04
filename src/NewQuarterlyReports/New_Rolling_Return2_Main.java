package NewQuarterlyReports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Statement;

import model.New_Rolling_Report2;
import model.Report_6_pk;
import model.RollingAvg_CompositeKey;
import model.RollingReturnAvgModel;
import model.Rolling_Return;
import model.Rolling_repor2_key;
import sessionFactory.HIbernateSession;

public class New_Rolling_Return2_Main {
	
private static ArrayList<String> fund_Type_arr = new ArrayList<String>();
	
	public static void generate_category_Equity_Summary()
	{
//     	 schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_LARGE_CAP_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_MULTI_CAP_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_LARGE_AND_MID_CAP_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_MID_CAP_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_SMALL_CAP_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_ELSS_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_INFRASTRUCTURE_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/EQUITY_THEMATIC_CONSUMPTION_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/HYBRID_EQUITY_ORIENTED_JUNE_2018.txt");
//         schemecode_list_path_arr.add("/home/rv/Desktop/files_to_upload/HYBRID_ARBITRAGE_JUNE_2018.txt");         
     	 
		    fund_Type_arr.add("EQUITY_LARGE_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_MULTI_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_LARGE_AND_MID_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_MID_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_SMALL_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_ELSS_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_INFRASTRUCTURE_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_THEMATIC_CONSUMPTION_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_HYBRID_EQUITY_ORIENTED_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_HYBRID_ARBITRAGE_CAP_30.09.2019");
	        
	        fund_Type_arr.add("HYBRID_DYNAMIC_ASSET_SELECTION_CAP_30.09.2019");
	        fund_Type_arr.add("EQUITY_VALUE_CONTRA_CAP_30.09.2019");
	        fund_Type_arr.add("Equity_Sectoral_Financial_Services_30.09.2019");
	        fund_Type_arr.add("Equity_Thematic_30.09.2019");
	        fund_Type_arr.add("Hybrid_Solution_Oriented_30.09.2019");
         
//		 String scheme_code_list_path="/home/rv/Desktop/files_to_upload/EQUITY_ELSS_MARCH_2018.TXT";
//		 String Fund_Type="Equity_Debt_Oriented";
		 
		 
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int db_flag=0;
		double rr_5=0,rr_4=0,rr_3=0,rr_2=0;
		New_Rolling_Report2 rr = null;
		Rolling_repor2_key key = null;
		String Output_File_Name="";
		String test_sql="";
		Session ssn=null;
		
		 int cat_count=0;
		 generate_category_Equity_Summary(); 
		 
		  try
		  {   
			  
				while(cat_count < fund_Type_arr.size())
				{
					
//				   
				   String Fund_Type = 	fund_Type_arr.get(cat_count);
				   
			  
	 		  
			  
			  
		ssn = HIbernateSession.getSessionFactory().openSession(); 
		 ssn.beginTransaction();
//		 int loop=0;
//		 String Fund_Type="EQUITY_ELSS_31.03.2018";
//		 String Fund_Type="EQUITY_LARGE_CAP_31.03.2018";
//		 String Fund_Type="EQUITY_MULTI_CAP_31.03.2018";
//		 String Fund_Type="EQUITY_MID_CAP_31.03.2018";
//		 String Fund_Type="EQUITY_SMALL_CAP_31.03.2018";
//		 String Fund_Type="Equity_Sector_Infrastructure_31.03.2018";
//		 String Fund_Type="Equity_Arbitrage";
//		 String Fund_Type="Equity_Debt_Oriented";
		 
		 Query q = ssn.createQuery("select distinct(key.from_date) from rolling_ret_New_Report where key.Fund_Type='"+Fund_Type+"' order by key.from_date");
		    
		ArrayList<java.util.Date> bb = (ArrayList<Date>) q.list();
		
//		 List<Object[]> datas= (List<Object[]>)q.list();
		 
		 for(java.util.Date dd : bb)
		 {
			 key = new Rolling_repor2_key();
			 key.setFrom_date(dd);
			 key.setFund_Type(Fund_Type);
			 rr= new New_Rolling_Report2();
			 rr.setKey(key);
			 
//			 System.out.println(dd);
			 generate_report(dd,2,rr,ssn);
			 generate_report(dd,3,rr,ssn);
//			 generate_report(dd,4,rr,ssn);
//			 generate_report(dd,5,rr,ssn);
			 
			 
			 ssn.save(rr);
	         db_flag++;
	         
	         if(db_flag%500==0)
	 		    {
	 		    	 ssn.getTransaction().commit();
	 		         ssn.beginTransaction();
	 		    	 ssn.flush();
			         ssn.clear();
	 		    	
	 		        db_flag=0;
	 		    }
	         

			 
		 }
		 ssn.getTransaction().commit();    
		 System.out.println("==-=-=-==-=-< Report Generating Complte >=-=-=-=--=--==");
		 
		 if(Fund_Type.toUpperCase().contains("LARGE") && !Fund_Type.toUpperCase().contains("MID") )
	   		{   
      	
            	Output_File_Name="Summary_Large_Cap_Report.csv";
//      	String test_sql ="select  \"from_date\", \"scheme_code\", \"quarter\", \"Scheme Name\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\",\"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\" UNION ALL select from_date, scheme_code, quarter, Scheme_Name, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'  FIELDS TERMINATED BY ','   ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
      	
	   		}
	   		else if(Fund_Type.toUpperCase().contains("MID") && !Fund_Type.toUpperCase().contains("LARGE") )
	   		{
	   			Output_File_Name="Summary_Mid_Cap_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("MID") && Fund_Type.toUpperCase().contains("LARGE") )
	   		{
	   			Output_File_Name="Summary_Mid_And_Large_Cap_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("SMALL"))
	   		{
	   			Output_File_Name="Summary_Small_Cap_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("MULTI"))
	   		{
	   			Output_File_Name="Summary_Multi_Cap_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("ELSS"))
	   		{
	   			Output_File_Name="Summary_Elss_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("INFRASTRUCTURE"))
	   		{
	   			Output_File_Name="Summary_Infrastructure_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("ARBITRAGE") && Fund_Type.toUpperCase().contains("HYBRID"))
	   		{
	   			Output_File_Name="Summary_Equity_Arbitrage_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("HYBRID") && !Fund_Type.toUpperCase().contains("ARBITRAGE") && !Fund_Type.toUpperCase().contains("ASSET") && !Fund_Type.toUpperCase().contains("SOLUTION"))
	   		{
	   			Output_File_Name="Summary_Hybrid_Equity_Oriented_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("THEMATIC") && !Fund_Type.toUpperCase().contains("CONSUMPTION"))
	   		{
	   			Output_File_Name="Summary_Equity_Thematic_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("THEMATIC") && Fund_Type.toUpperCase().contains("CONSUMPTION"))
	   		{
	   			Output_File_Name="Summary_Equity_Thematic_Consumption_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("HYBRID") && Fund_Type.toUpperCase().contains("DYNAMIC")&&Fund_Type.toUpperCase().contains("ASSET"))
	   		{
	   			Output_File_Name="Summary_Hybrid_Dynamic_Asset_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("HYBRID") && Fund_Type.toUpperCase().contains("SOLUTION"))
	   		{
	   			Output_File_Name="Summary_Hybrid_Solution_Oriented.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("SECTORAL") && Fund_Type.toUpperCase().contains("FINANCIAL") && Fund_Type.toUpperCase().contains("SERVICES"))
	   		{
	   			Output_File_Name="Summary_Sectorial_Financial_Services.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
		   
		 
	   		else if(Fund_Type.toUpperCase().contains("VALUE") && Fund_Type.toUpperCase().contains("CONTRA"))
	   		{
	   			Output_File_Name="Summary_Equity_VALUE_CONTRA_Report.csv";
	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//            	test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\",\"X5\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4,avg_of_top_forward_12_rr5 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   			test_sql  ="select \"DATE\",\"No Of Funds\",\"Category Avg\",\"X2\",\"X3\" ,\"X4\" UNION select from_date,no_of_funds,avg_of_forward_12_rr2,avg_of_top_forward_12_rr2,avg_of_top_forward_12_rr3,avg_of_top_forward_12_rr4 from New_Rolling_Report2 where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
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
		 
	} // end-of-category-loop
//	     for(Object[] d: datas)
//	     {
//	    	  System.out.println(d[0]);
////	    	  java.util.Date date = (Date) d[0];
////	    	  System.out.println(date);
//	     }
		  }
		  catch (Exception e) 
		  {
		    e.printStackTrace();
		  }
		  finally
		  {
			  if (ssn!=null && ssn.isOpen())
				 {
				    
					ssn.close();
					System.out.println("Session CLosed");
				 }
			  System.out.println("----All Reports Completed----");
		  }

	}
	
	
	public static void generate_report(Date date, int return_year, New_Rolling_Report2 rr, Session ssn )
	{
		Calendar cal = Calendar.getInstance();	  	  
		double ret;
		
//	  	  cal.setTime(date);
////	  cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
//	      cal.add(Calendar.YEAR,-(return_year-1));
//	      Date derived_date = cal.getTime();
	      
	      String pattern = "yyyy-MM-dd";
	      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	      String to_date = simpleDateFormat.format(date);
//	      String from_date = simpleDateFormat.format(derived_date);
	
//	      System.out.println("-=-=-=-=-=date-=-=->"+to_date);
	      ssn.doWork(new Work() {
				
				@Override
				public void execute(Connection conn) throws SQLException {
					// TODO Auto-generated method stub
//					CallableStatement cstmt =  (CallableStatement) conn.prepareCall("{ CALL RVcalculateRollingReturn(?,?,?,?,?,?)}");
					CallableStatement cstmt =  (CallableStatement) conn.prepareCall("call RVFinal_report(?,?,?)");
					
//					System.out.println("--From Date-->>"+from_date);
//					System.out.println("--To Date-->>"+to_date);
//					System.out.println("--Schemecode-->>"+scheme_code);

//					cstmt.setString(1, from_date);
					cstmt.setString(1, to_date);
					cstmt.setInt(2, return_year);
					cstmt.setString(3, rr.getKey().getFund_Type());
//					cstmt.registerOutParameter(4, java.sql.Types.FLOAT);
//					cstmt.registerOutParameter(5, java.sql.Types.FLOAT);
//					cstmt.registerOutParameter(6, java.sql.Types.FLOAT);
					 
					cstmt.execute();
													
//					System.out.println("GOT Result From Stored Procedure-->>>"+cstmt.getDouble(4));
//		            System.out.println("GOT Result From Stored Procedure-->>>"+cstmt.getFloat(5));
//		            System.out.println("GOT Result From Stored Procedure-->>>"+cstmt.getFloat(6));
					
		         
					boolean hadResults = cstmt.execute();
					if (hadResults) {
				        ResultSet rs = cstmt.getResultSet();
				       
				        if (rs.next()) {
				        	
//				        	System.out.println(rs.getDouble("rolling_return"));
//				        	System.out.println(rs.getDouble("aum"));
//				        	System.out.println(rs.getDouble("forwar_return"));
				        	
//				            System.out.println("GOT Result From Stored Procedure-->>>"+rs.getDouble(1));
//				            System.out.println("Forward_Return-->>>"+rs.getDouble(2));
//				            System.out.println("GOT Result From Stored Procedure-->>>"+rs.getDouble(3));
//				        	if(return_year==5)
//				        	 {
//				        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
//				        		rr.setAvg_of_forward_12_rr2(rs.getDouble(1));
//				        			        		
//				        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
//				        			{
//				        			   rr.setAvg_of_top_forward_12_rr5(rs.getDouble(2));
//				        			}
//				        		else
//				        		{
////				        			System.out.println("In ELSE PART 5"); 
//				        			rr.setAvg_of_top_forward_12_rr5(0);
//				        		}
//				        		
//				        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
//				        			rr.setNo_of_funds(rs.getInt(3));
//				        	 }
//				        	if(return_year==4)
//				        	{
//				        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
//					        		rr.setAvg_of_forward_12_rr2(rs.getDouble(1));
//					        			        		
//					        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
//					        			{
//					        			   rr.setAvg_of_top_forward_12_rr4(rs.getDouble(2));
//					        			}
//					        		else
//					        		{
////					        			System.out.println("In ELSE PART 5"); 
//					        			rr.setAvg_of_top_forward_12_rr4(0);
//					        		}
//					        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
//					        			rr.setNo_of_funds(rs.getInt(3));
//				        	}
				        	if(return_year==3)
				        	{
				        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
					        		rr.setAvg_of_forward_12_rr2(rs.getDouble(1));
					        			        		
					        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
					        			{
					        			   rr.setAvg_of_top_forward_12_rr3(rs.getDouble(2));
					        			}
					        		else
					        		{
//					        			System.out.println("In ELSE PART 5"); 
					        			rr.setAvg_of_top_forward_12_rr3(0);
					        		}
					        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
					        			rr.setNo_of_funds(rs.getInt(3));
				        	}
				        	else if(return_year==2)
				        	{
				        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
					        		rr.setAvg_of_forward_12_rr2(rs.getDouble(1));
					        			        		
					        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
					        			{
					        			   rr.setAvg_of_top_forward_12_rr2(rs.getDouble(2));
					        			}
					        		else
					        		{
//					        			System.out.println("In ELSE PART 5"); 
					        			rr.setAvg_of_top_forward_12_rr2(0);
					        		}
					        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
					        			rr.setNo_of_funds(rs.getInt(3));
				        	}
//				        	ret = ret1;
				        	
				        }
				       
					}
					
					
				}
			});
	      
	}

}
