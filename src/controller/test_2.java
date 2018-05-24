package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.Statement;

import sessionFactory.HIbernateSession;

public class test_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String Output_File_Name="";
//		String test_sql="";
//		 String Fund_Type="EQUITY_LARGE_CAP_NEW_31.12.2017";  // has to be passed
//		 
//		 System.out.println("<--------------------Generating Csv---Please open folder /var/lib/mysql-Files to see the reports------------------->");
//         
//         if(Fund_Type.toUpperCase().contains("LARGE"))
//	   		{   
//         	
//         	Output_File_Name="Large_Cap_Report.csv";
////         	String test_sql ="select  \"from_date\", \"scheme_code\", \"quarter\", \"Scheme Name\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\",\"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\" UNION ALL select from_date, scheme_code, quarter, Scheme_Name, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'  FIELDS TERMINATED BY ','   ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
//         	test_sql  ="select \"from_date\", \"scheme_code\", \"Scheme Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//         	
//	   		}
//	   		else if(Fund_Type.toUpperCase().contains("MID"))
//	   		{
//	   			Output_File_Name="Mid_Small_Cap_Report.csv";
//	   			 test_sql  ="select \"from_date\", \"scheme_code\", \"Scheme Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";	
//	   		}
//	   		else if(Fund_Type.toUpperCase().contains("MULTI"))
//	   		{
//	   			Output_File_Name="Multi_Cap_Report.csv";
//	   			 test_sql  ="select \"from_date\", \"scheme_code\", \"Scheme Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   		}
//	   		else if(Fund_Type.toUpperCase().contains("ELSS"))
//	   		{
//	   			Output_File_Name="Elss_Report.csv";
//	   			 test_sql="select \"from_date\", \"scheme_code\", \"Scheme_Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"X22\", \"X23\", \"X24\", \"X25\", \"X26\", \"X27\", \"X28\", \"X29\", \"X30\", \"X31\", \"X32\", \"X33\", \"X34\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"R_X22\", \"R_X23\", \"R_X24\", \"R_X25\", \"R_X26\", \"R_X27\", \"R_X28\", \"R_X29\", \"F36\", \"R_F36\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, Sdev_12_mnths, Sdev_24_mnths, Sdev_36_mnths, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, last_4_pos_nav_ret_value_sum, last_8_pos_nav_ret_value_sum, last_12_pos_nav_ret_value_sum, last_16_pos_nav_ret_value_sum, last_20_pos_nav_ret_value_sum, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, R_Sdev_12_mnths, R_Sdev_24_mnths, R_Sdev_36_mnths, R_last_4_pos_act_ret_sum, R_last_8_pos_act_ret_sum, R_last_12_pos_act_ret_sum, R_last_16_pos_act_ret_sum, R_last_20_pos_act_ret_sum, forwar_36_mnths, R_forwar_36_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   		}
//	   		else
//	   		{
//	   			Output_File_Name="Others_Report.csv";
//	   			test_sql="select \"from_date\", \"scheme_code\", \"Scheme_Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"X22\", \"X23\", \"X24\", \"X25\", \"X26\", \"X27\", \"X28\", \"X29\", \"X30\", \"X31\", \"X32\", \"X33\", \"X34\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"R_X22\", \"R_X23\", \"R_X24\", \"R_X25\", \"R_X26\", \"R_X27\", \"R_X28\", \"R_X29\", \"F36\", \"R_F36\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, Sdev_12_mnths, Sdev_24_mnths, Sdev_36_mnths, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, last_4_pos_nav_ret_value_sum, last_8_pos_nav_ret_value_sum, last_12_pos_nav_ret_value_sum, last_16_pos_nav_ret_value_sum, last_20_pos_nav_ret_value_sum, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, R_Sdev_12_mnths, R_Sdev_24_mnths, R_Sdev_36_mnths, R_last_4_pos_act_ret_sum, R_last_8_pos_act_ret_sum, R_last_12_pos_act_ret_sum, R_last_16_pos_act_ret_sum, R_last_20_pos_act_ret_sum, forwar_36_mnths, R_forwar_36_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
//	   		}
//         
//         
//         Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//		    ssn.beginTransaction();
//		    final String  final_sql=test_sql;
//		    
//		  ssn.doWork(new Work() {			
//			@Override
//			public void execute(Connection conn) throws SQLException 
//			{
//				Statement stmt = (Statement) conn.createStatement();
//				stmt.executeQuery(final_sql);
//			}
//		});
//         
//		    ssn.close();
//		  
//		    System.out.println("---<All Reports Complete>---");
		
		
		ArrayList<Long> ss = new ArrayList<Long>();
		
		ss.add((long) 1331);
		ss.add((long) 2);
		ss.add((long) 15);
		ss.add((long) 716);
		ss.add((long) 1313);
		ss.add((long) 2289);
		
		
		long xx =2;
		
		if(ss.contains(xx))
		{
			System.out.println("FOUND");
		}
		else
		{
			System.out.println("Not Found");
		}

	}

}
