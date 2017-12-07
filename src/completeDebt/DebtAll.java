package completeDebt;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.Statement;

import sessionFactory.HIbernateSession;

public class DebtAll {

    public static void main(String[] args) 
    {   
    	String test_sql = "";
    	String Output_File_Name=null; 
        String Fund_Type;
        String date_list;
        Session ssn = null; 
	    
//          Fund_Type="EQUITY_LARGE_CAP_NEW_30.09.2017";  // has to be passed          
//        Fund_Type="EQUITY_ELSS_NEW_30.09.2017_Test";  // has to be passed         
             Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.09.2017_Test1";  // has to be passed
//           Fund_Type="EQUITY_MULTI_CAP_NEW_30.09.2017";  // has to be passed
            date_list="/home/rv/Desktop/files_to_upload/date_list.txt";
           String resp="";
           Custom_Merged_Report_Runner final_rep = new Custom_Merged_Report_Runner();
     	final_rep.Generate_Rank(Fund_Type);
     	
//     	String pr_1 ="SET sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''))";
		     	ssn = HIbernateSession.getSessionFactory().openSession(); 
		     	ssn.beginTransaction();  
//		     	String pr_1 ="SET sql_mode=(SELECT REPLACE(@@sql_mode, 'ONLY_FULL_GROUP_BY', ''))";
//		     	Query query = ssn.createSQLQuery(pr_1);
//		   		int result = query.executeUpdate();
		    	String pr_1 ="set global sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION'";
		     	Query query = ssn.createSQLQuery(pr_1);
		    	int result = query.executeUpdate();
		    	String pr_2 ="set session sql_mode='STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';";
		    	query = ssn.createSQLQuery(pr_2);
		    	result = query.executeUpdate();
		    	
		   		ssn.getTransaction().commit();
				ssn.close(); 
     	 
           String scheme_code_list_path="/home/rv/Desktop/files_to_upload/Equity_Mid_Small_Cap_Sept_2017.txt";
           
           Avg_Return_Runner_1 rp1=new Avg_Return_Runner_1();
           
           if( Fund_Type.startsWith("EQUITY_LARGE_CAP") || Fund_Type.startsWith("EQUITY_MID_SMALL") || Fund_Type.startsWith("EQUITY_MULTI_CAP"))
//           if( Fund_Type.startsWith("EQUITY_MID_SMALL") || Fund_Type.startsWith("EQUITY_MULTI_CAP"))
           {
        	   System.out.println("----------------");
        	     System.out.println("<--- in ifffff--->");
        	   System.out.println("----------------");
        	   
               resp= rp1.Calculate_Avg_Return(Fund_Type, scheme_code_list_path);
               if(resp=="success")
               {    
                   Excel_Report_Main_Runner rp2 = new Excel_Report_Main_Runner();
                   resp = rp2.Calculate_Excel_Report(Fund_Type, scheme_code_list_path);
                    if(resp=="success")
                    {
                        Return_Main_Runner rp3 = new Return_Main_Runner();
                        resp = rp3.Calculate_Return_Report(Fund_Type, date_list);
                        if(resp=="success")
                        {
                            Nav_Report_temp_1_Runner rp4 = new Nav_Report_temp_1_Runner();
                            resp = rp4.Calculate_Nav_Report(Fund_Type);
                            if(resp=="success")
                            {
                                Report_5_Main_Runner rp5 = new Report_5_Main_Runner();
                                resp = rp5.Calculate_Report_5(Fund_Type);
                                if(resp=="success")
                                {
//                                    Report_6_Main_Runner rp6 = new Report_6_Main_Runner();
//                                    resp = rp6.Calculate_Report_6(Fund_Type);
//                                    if(resp=="success")
//                                    {
                                        Calmar_Ratio_Runner rp7 = new Calmar_Ratio_Runner();
                                        resp = rp7.Calculate_Calmar_Ratio(Fund_Type);
                                        if(resp=="success")
                                        {
                                            Report_10_Runner rp8 = new Report_10_Runner();
                                            resp = rp8.Calculate_report_10(Fund_Type);
                                            if(resp=="success")
                                            {
//                                                Sdev_Report_Runner rp9 = new Sdev_Report_Runner();
//                                                resp = rp9.Calculate_SDev_Report(Fund_Type);
//                                                if(resp=="success")
//                                                {
                                                    Merged_Main_Runner rp_10 = new Merged_Main_Runner();
                                                    resp=rp_10.Calculate_Merged_Report(Fund_Type);
                                                    if(resp=="success")
                                                    {
                                                    	   ssn = HIbernateSession.getSessionFactory().openSession(); 
                                                 		   ssn.beginTransaction();
                                                 		  String sql = "insert into Custom_Merged_Report_W_Rank(from_date,scheme_code,quarter,Scheme_Name,backward_3,backward_6,backward_12,backward_18,backward_24,backward_30,backward_36,backward_42,backward_48,backward_54,backward_60,forwar_9_mnths,forwar_12_mnths ,forwar_18_mnths ,forwar_36_mnths,last_4_neg_avg_cat_ret_otb ,last_4_pos_avg_cat_ret_otb,last_8_neg_avg_cat_ret_otb,last_8_pos_avg_cat_ret_otb ,last_12_neg_avg_cat_ret_otb ,last_12_pos_avg_cat_ret_otb ,last_16_neg_avg_cat_ret_otb ,last_16_pos_avg_cat_ret_otb ,last_20_neg_avg_cat_ret_otb ,last_20_pos_avg_cat_ret_otb ,last_4_neg_act_ret_sum,last_8_neg_act_ret_sum,last_12_neg_act_ret_sum,last_16_neg_act_ret_sum,last_20_neg_act_ret_sum,last_4_pos_act_ret_sum,last_8_pos_act_ret_sum,last_12_pos_act_ret_sum,last_16_pos_act_ret_sum,last_20_pos_act_ret_sum,cri,no_of_stock,year_1,year_1_1 ,year_1_2 ,year_1_3 ,year_1_4 ,max_Drawdown_year_1,max_Drawdown_year_2,max_Drawdown_year_3,max_Drawdown_year_4,max_Drawdown_year_5,avg_return_50_minus_200,last_200_day_return,ex_ratio,sc_aum,Fund_Type,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum) select from_date, scheme_code, quarter,Scheme_Name, backward_3, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36,backward_42,backward_48, backward_54, backward_60 , forwar_9_mnths, forwar_12_mnths , forwar_18_mnths , forwar_36_mnths , last_4_neg_avg_cat_ret_otb , last_4_pos_avg_cat_ret_otb,  last_8_neg_avg_cat_ret_otb,  last_8_pos_avg_cat_ret_otb , last_12_neg_avg_cat_ret_otb , last_12_pos_avg_cat_ret_otb , last_16_neg_avg_cat_ret_otb , last_16_pos_avg_cat_ret_otb ,  last_20_neg_avg_cat_ret_otb , last_20_pos_avg_cat_ret_otb , last_4_neg_act_ret_sum, last_8_neg_act_ret_sum, last_12_neg_act_ret_sum, last_16_neg_act_ret_sum, last_20_neg_act_ret_sum, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, cri, no_of_stock,  year_1, year_1_1 , year_1_2 , year_1_3 , year_1_4 , max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return,  ex_ratio, sc_aum, Fund_Type ,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum from Report_Merged_5_6_8_Model where backward_60!=0 and backward_60 is not null and Fund_Type='"+Fund_Type+"'";
  		                                           
                                                      	      query = ssn.createSQLQuery(sql);
  		                                              		  result = query.executeUpdate();
  			                                          		  ssn.getTransaction().commit();
  		                                          		      ssn.close(); 
  		                                          		      System.out.println("<----Transferred to Custome_Merged_Report----->");
                                                              
  		                                          		         final_rep = new Custom_Merged_Report_Runner();
  		                                          		  
  		                                          		        final_rep.Generate_Rank(Fund_Type);
  		                                          		  
  		                                          		      
  		                                          		      
//                                                          Run-Custome_Report_Merged_main_after_coping_data_into_that_table
//                                                          System.out.println("---<All Reports Complete>---");
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Error occured in Merged Main Report ->"+resp);
                                                    }
                                                    
//                                                }
//                                                else
//                                                {
//                                                    System.out.println("Error occured in Standard Deviation ->"+resp);
//                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Error occured in Report 10 ->"+resp);
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Error occured in Calmar Ratio Report ->"+resp);
                                        }
//                                    }
//                                    else
//                                    {
//                                        System.out.println("Error occured in Nav Report_6 ->"+resp);
//                                    }
                                }
                                else
                                {
                                    System.out.println("Error occured in Nav Report_5 ->"+resp);
                                }
                            }
                            else
                            {
                                System.out.println("Error occured in Nav Report Temp 1 Report ->"+resp);
                            }
                        }
                        else
                        {
                            System.out.println("Error occured in Return Main Report ->"+resp);
                        }
                    }
                    else
                    {
                        System.out.println("Error Occured in Excel Return main Report ->"+resp);   
                    }
               }
               else
               {
                  System.out.println("Error Occured in Avg_Return Report ->"+resp);   
               }
           }
         else if(Fund_Type.startsWith("EQUITY_ELSS"))
//           else if(Fund_Type.startsWith("EQUITY_ELSS") || Fund_Type.startsWith("EQUITY_LARGE_CAP"))
           {
        	   System.out.println("----------------");
      	         System.out.println("<--- in ELSS--->");
      	       System.out.println("----------------");
                
                
               
               resp= rp1.Calculate_Avg_Return(Fund_Type, scheme_code_list_path);
               if(resp=="success")
               {    
                   Excel_Report_Main_Runner rp2 = new Excel_Report_Main_Runner();
                   resp = rp2.Calculate_Excel_Report(Fund_Type, scheme_code_list_path);
                    if(resp=="success")
                    {
                        Return_Main_Runner rp3 = new Return_Main_Runner();
                        resp = rp3.Calculate_Return_Report(Fund_Type, date_list);
                        if(resp=="success")
                        {
                            Nav_Report_temp_1_Runner rp4 = new Nav_Report_temp_1_Runner();
                            resp = rp4.Calculate_Nav_Report(Fund_Type);
                            if(resp=="success")
                            {
                                Report_5_Main_Runner rp5 = new Report_5_Main_Runner();
                                resp = rp5.Calculate_Report_5(Fund_Type);
                                if(resp=="success")
                                {
                                    Report_6_Main_Runner rp6 = new Report_6_Main_Runner();
                                    resp = rp6.Calculate_Report_6(Fund_Type);
                                    if(resp=="success")
                                    {
                                        Calmar_Ratio_Runner rp7 = new Calmar_Ratio_Runner();
                                        resp = rp7.Calculate_Calmar_Ratio(Fund_Type);
                                        if(resp=="success")
                                        {
                                            Report_10_Runner rp8 = new Report_10_Runner();
                                            resp = rp8.Calculate_report_10(Fund_Type);
                                            if(resp=="success")
                                            {
                                                Sdev_Report_Runner rp9 = new Sdev_Report_Runner();
                                                resp = rp9.Calculate_SDev_Report(Fund_Type);
                                                if(resp=="success")
                                                {
                                                    Merged_Main_Runner rp_10 = new Merged_Main_Runner();
                                                    resp=rp_10.Calculate_Merged_Report(Fund_Type);
                                                    if(resp=="success")
                                                    {
                                                         // String sql = "insert into Custom_Merged_Report_W_Rank(from_date,scheme_code,quarter,Scheme_Name,backward_3,backward_6,backward_12,backward_18,backward_24,backward_30,backward_36,backward_42,backward_48,backward_54,backward_60,forwar_9_mnths,forwar_12_mnths ,forwar_18_mnths ,forwar_36_mnths,last_4_neg_avg_cat_ret_otb ,last_4_pos_avg_cat_ret_otb,last_8_neg_avg_cat_ret_otb,last_8_pos_avg_cat_ret_otb ,last_12_neg_avg_cat_ret_otb ,last_12_pos_avg_cat_ret_otb ,last_16_neg_avg_cat_ret_otb ,last_16_pos_avg_cat_ret_otb ,last_20_neg_avg_cat_ret_otb ,last_20_pos_avg_cat_ret_otb ,last_4_neg_act_ret_sum,last_8_neg_act_ret_sum,last_12_neg_act_ret_sum,last_16_neg_act_ret_sum,last_20_neg_act_ret_sum,last_4_pos_act_ret_sum,last_8_pos_act_ret_sum,last_12_pos_act_ret_sum,last_16_pos_act_ret_sum,last_20_pos_act_ret_sum,cri,no_of_stock,year_1,year_1_1 ,year_1_2 ,year_1_3 ,year_1_4 ,max_Drawdown_year_1,max_Drawdown_year_2,max_Drawdown_year_3,max_Drawdown_year_4,max_Drawdown_year_5,avg_return_50_minus_200,last_200_day_return,ex_ratio,sc_aum,Fund_Type,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum) select from_date, scheme_code, quarter,Scheme_Name, backward_3, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36,backward_42,backward_48, backward_54, backward_60 , forwar_9_mnths, forwar_12_mnths , forwar_18_mnths , forwar_36_mnths , last_4_neg_avg_cat_ret_otb , last_4_pos_avg_cat_ret_otb,  last_8_neg_avg_cat_ret_otb,  last_8_pos_avg_cat_ret_otb , last_12_neg_avg_cat_ret_otb , last_12_pos_avg_cat_ret_otb , last_16_neg_avg_cat_ret_otb , last_16_pos_avg_cat_ret_otb ,  last_20_neg_avg_cat_ret_otb , last_20_pos_avg_cat_ret_otb , last_4_neg_act_ret_sum, last_8_neg_act_ret_sum, last_12_neg_act_ret_sum, last_16_neg_act_ret_sum, last_20_neg_act_ret_sum, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, cri, no_of_stock,  year_1, year_1_1 , year_1_2 , year_1_3 , year_1_4 , max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return,  ex_ratio, sc_aum, Fund_Type ,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum from Report_Merged_5_6_8_Model where backward_60!=0 and Fund_Type='"+Fund_Type+"'";
                                                   
                                                       ssn = HIbernateSession.getSessionFactory().openSession(); 
                                               		   ssn.beginTransaction();
                                               		String sql = "insert into Custom_Merged_Report_W_Rank(from_date,scheme_code,quarter,Scheme_Name,backward_3,backward_6,backward_12,backward_18,backward_24,backward_30,backward_36,backward_42,backward_48,backward_54,backward_60,forwar_9_mnths,forwar_12_mnths ,forwar_18_mnths ,forwar_36_mnths,last_4_neg_avg_cat_ret_otb ,last_4_pos_avg_cat_ret_otb,last_8_neg_avg_cat_ret_otb,last_8_pos_avg_cat_ret_otb ,last_12_neg_avg_cat_ret_otb ,last_12_pos_avg_cat_ret_otb ,last_16_neg_avg_cat_ret_otb ,last_16_pos_avg_cat_ret_otb ,last_20_neg_avg_cat_ret_otb ,last_20_pos_avg_cat_ret_otb ,last_4_neg_act_ret_sum,last_8_neg_act_ret_sum,last_12_neg_act_ret_sum,last_16_neg_act_ret_sum,last_20_neg_act_ret_sum,last_4_pos_act_ret_sum,last_8_pos_act_ret_sum,last_12_pos_act_ret_sum,last_16_pos_act_ret_sum,last_20_pos_act_ret_sum,cri,no_of_stock,year_1,year_1_1 ,year_1_2 ,year_1_3 ,year_1_4 ,max_Drawdown_year_1,max_Drawdown_year_2,max_Drawdown_year_3,max_Drawdown_year_4,max_Drawdown_year_5,avg_return_50_minus_200,last_200_day_return,ex_ratio,sc_aum,Fund_Type,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum) select from_date, scheme_code, quarter,Scheme_Name, backward_3, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36,backward_42,backward_48, backward_54, backward_60 , forwar_9_mnths, forwar_12_mnths , forwar_18_mnths , forwar_36_mnths , last_4_neg_avg_cat_ret_otb , last_4_pos_avg_cat_ret_otb,  last_8_neg_avg_cat_ret_otb,  last_8_pos_avg_cat_ret_otb , last_12_neg_avg_cat_ret_otb , last_12_pos_avg_cat_ret_otb , last_16_neg_avg_cat_ret_otb , last_16_pos_avg_cat_ret_otb ,  last_20_neg_avg_cat_ret_otb , last_20_pos_avg_cat_ret_otb , last_4_neg_act_ret_sum, last_8_neg_act_ret_sum, last_12_neg_act_ret_sum, last_16_neg_act_ret_sum, last_20_neg_act_ret_sum, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, cri, no_of_stock,  year_1, year_1_1 , year_1_2 , year_1_3 , year_1_4 , max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return,  ex_ratio, sc_aum, Fund_Type ,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum from Report_Merged_5_6_8_Model where backward_60!=0 and backward_60 is not null and Fund_Type='"+Fund_Type+"'";
		                                           
                                                    	     query = ssn.createSQLQuery(sql);
		                                              		 result = query.executeUpdate();
			                                          		  ssn.getTransaction().commit();
		                                          		      ssn.close(); 
		                                          		      System.out.println("<----Transferred to Custome_Merged_Report----->");
		                                          		  
		                                          		       final_rep = new Custom_Merged_Report_Runner();
	  		                                          		  
		                                          		      final_rep.Generate_Rank(Fund_Type);
		                                          		        
//                                                          Run-Custome_Report_Merged_main_after_coping_data_into_that_table
//                                                          System.out.println("---<All Reports Complete>---");
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Error occured in Merged Main Report ->"+resp);
                                                    }
                                                    
                                                }
                                                else
                                                {
                                                    System.out.println("Error occured in Standard Deviation ->"+resp);
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("Error occured in Report 10 ->"+resp);
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("Error occured in Calmar Ratio Report ->"+resp);
                                        }
                                    }
                                    else
                                    {
                                        System.out.println("Error occured in Nav Report_6 ->"+resp);
                                    }
                                }
                                else
                                {
                                    System.out.println("Error occured in Nav Report_5 ->"+resp);
                                }
                            }
                            else
                            {
                                System.out.println("Error occured in Nav Report Temp 1 Report ->"+resp);
                            }
                        }
                        else
                        {
                            System.out.println("Error occured in Return Main Report ->"+resp);
                        }
                    }
                    else
                    {
                        System.out.println("Error Occured in Excel Return main Report ->"+resp);   
                    }
               }
               else
               {
                  System.out.println("Error Occured in Avg_Return Report ->"+resp);   
               }
                  
               
               
               
           }
           
           
           
           System.out.println("<--------------------Generating Csv---Please open folder /var/lib/mysql-Files to see the reports------------------->");
           
            if(Fund_Type.toUpperCase().contains("LARGE"))
	   		{   
            	
            	Output_File_Name="Large_Cap_Report.csv";
//            	String test_sql ="select  \"from_date\", \"scheme_code\", \"quarter\", \"Scheme Name\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\",\"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\" UNION ALL select from_date, scheme_code, quarter, Scheme_Name, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'  FIELDS TERMINATED BY ','   ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
            	test_sql  ="select \"from_date\", \"scheme_code\", \"Scheme Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
            	
	   		}
	   		else if(Fund_Type.toUpperCase().contains("MID"))
	   		{
	   			Output_File_Name="Mid_Small_Cap_Report.csv";
	   			 test_sql  ="select \"from_date\", \"scheme_code\", \"Scheme Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";	
	   		}
	   		else if(Fund_Type.toUpperCase().contains("MULTI"))
	   		{
	   			Output_File_Name="Multi_Cap_Report.csv";
	   			 test_sql  ="select \"from_date\", \"scheme_code\", \"Scheme Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"F12\", \"R_F12\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, forwar_12_mnths, R_forwar_12_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else if(Fund_Type.toUpperCase().contains("ELSS"))
	   		{
	   			Output_File_Name="Elss_Report.csv";
	   			 test_sql="select \"from_date\", \"scheme_code\", \"Scheme_Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"X22\", \"X23\", \"X24\", \"X25\", \"X26\", \"X27\", \"X28\", \"X29\", \"X30\", \"X31\", \"X32\", \"X33\", \"X34\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"R_X22\", \"R_X23\", \"R_X24\", \"R_X25\", \"R_X26\", \"R_X27\", \"R_X28\", \"R_X29\", \"F36\", \"R_F36\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, Sdev_12_mnths, Sdev_24_mnths, Sdev_36_mnths, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, last_4_pos_nav_ret_value_sum, last_8_pos_nav_ret_value_sum, last_12_pos_nav_ret_value_sum, last_16_pos_nav_ret_value_sum, last_20_pos_nav_ret_value_sum, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, R_Sdev_12_mnths, R_Sdev_24_mnths, R_Sdev_36_mnths, R_last_4_pos_act_ret_sum, R_last_8_pos_act_ret_sum, R_last_12_pos_act_ret_sum, R_last_16_pos_act_ret_sum, R_last_20_pos_act_ret_sum, forwar_36_mnths, R_forwar_36_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
	   		}
	   		else
	   		{
	   			Output_File_Name="Others_Report.csv";
	   			test_sql="select \"from_date\", \"scheme_code\", \"Scheme_Name\", \"quarter\", \"X1\", \"X2\", \"X3\", \"X4\", \"X5\", \"X6\", \"X7\", \"X8\", \"X9\", \"X10\", \"X11\", \"X12\", \"X13\", \"X14\", \"X15\", \"X16\", \"X17\", \"X18\", \"X19\", \"X20\", \"X21\", \"X22\", \"X23\", \"X24\", \"X25\", \"X26\", \"X27\", \"X28\", \"X29\", \"X30\", \"X31\", \"X32\", \"X33\", \"X34\", \"R_X1\", \"R_X2\", \"R_X3\", \"R_X4\", \"R_X5\", \"R_X6\", \"R_X7\", \"R_X8\", \"R_X9\", \"R_X10\", \"R_X11\", \"R_X12\", \"R_X13\", \"R_X14\", \"R_X15\", \"R_X16\", \"R_X17\", \"R_X18\", \"R_X19\", \"R_X20\", \"R_X21\", \"R_X22\", \"R_X23\", \"R_X24\", \"R_X25\", \"R_X26\", \"R_X27\", \"R_X28\", \"R_X29\", \"F36\", \"R_F36\", \"Z1\", \"Z2\", \"Z3\", \"Z4\"UNION ALL select from_date, scheme_code, Scheme_Name, quarter, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36, backward_42, backward_48, backward_54, backward_60, year_1_1, year_1_2, year_1_3, year_1_4, max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return, Sdev_12_mnths, Sdev_24_mnths, Sdev_36_mnths, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, last_4_pos_nav_ret_value_sum, last_8_pos_nav_ret_value_sum, last_12_pos_nav_ret_value_sum, last_16_pos_nav_ret_value_sum, last_20_pos_nav_ret_value_sum, R_backward_6, R_backward_12, R_backward_18, R_backward_24, R_backward_30, R_backward_36, R_backward_42, R_backward_48, R_backward_54, R_backward_60, R_year_1_1, R_year_1_2, R_year_1_3, R_year_1_4, R_max_Drawdown_year_1, R_max_Drawdown_year_2, R_max_Drawdown_year_3, R_max_Drawdown_year_4, R_max_Drawdown_year_5, R_avg_return_50_minus_200, R_last_200_day_return, R_Sdev_12_mnths, R_Sdev_24_mnths, R_Sdev_36_mnths, R_last_4_pos_act_ret_sum, R_last_8_pos_act_ret_sum, R_last_12_pos_act_ret_sum, R_last_16_pos_act_ret_sum, R_last_20_pos_act_ret_sum, forwar_36_mnths, R_forwar_36_mnths, backward_12, backward_24, ex_ratio, sc_aum from Custom_Merged_Report_W_Rank where Fund_Type='"+Fund_Type+"'into outfile'/var/lib/mysql-files/"+Output_File_Name+"'FIELDS TERMINATED BY ','ENCLOSED BY '\"'LINES TERMINATED BY '\\n'";
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
            
  		    ssn.close();
  		  
  		    System.out.println("---<All Reports Complete>---");
    }

}