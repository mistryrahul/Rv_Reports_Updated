package completeDebt;

public class DebtAll {

	public static void main(String[] args) 
	{
		String Fund_Type;
		String date_list;
	      
		   Fund_Type="EQUITY_LARGE_CAP_NEW_30.09.2017_Test";  // has to be passed		  
//		   Fund_Type="EQUITY_ELSS_NEW_30.09.2017_Test";  // has to be passed		 
//		   Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.09.2017";  // has to be passed
//		   Fund_Type="EQUITY_MULTI_CAP_NEW_30.09.2017";  // has to be passed
		   date_list="/home/rv/Desktop/files_to_upload/date_list.txt";
		   String resp="";
		   
		   String scheme_code_list_path="/home/rv/Desktop/files_to_upload/EQUITY_LARGE_CAP_LIST_31_mar_17.txt";
		   
		   Avg_Return_Runner_1 rp1=new Avg_Return_Runner_1();
		   
		   if( Fund_Type.startsWith("EQUITY_LARGE_CAP") || Fund_Type.startsWith("EQUITY_MID_SMALL") || Fund_Type.startsWith("EQUITY_MULTI_CAP"))
		   {
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
				    									  String sql = "insert into Custom_Merged_Report_W_Rank(from_date,scheme_code,quarter,Scheme_Name,backward_3,backward_6,backward_12,backward_18,backward_24,backward_30,backward_36,backward_42,backward_48,backward_54,backward_60,forwar_9_mnths,forwar_12_mnths ,forwar_18_mnths ,forwar_36_mnths,last_4_neg_avg_cat_ret_otb ,last_4_pos_avg_cat_ret_otb,last_8_neg_avg_cat_ret_otb,last_8_pos_avg_cat_ret_otb ,last_12_neg_avg_cat_ret_otb ,last_12_pos_avg_cat_ret_otb ,last_16_neg_avg_cat_ret_otb ,last_16_pos_avg_cat_ret_otb ,last_20_neg_avg_cat_ret_otb ,last_20_pos_avg_cat_ret_otb ,last_4_neg_act_ret_sum,last_8_neg_act_ret_sum,last_12_neg_act_ret_sum,last_16_neg_act_ret_sum,last_20_neg_act_ret_sum,last_4_pos_act_ret_sum,last_8_pos_act_ret_sum,last_12_pos_act_ret_sum,last_16_pos_act_ret_sum,last_20_pos_act_ret_sum,cri,no_of_stock,year_1,year_1_1 ,year_1_2 ,year_1_3 ,year_1_4 ,max_Drawdown_year_1,max_Drawdown_year_2,max_Drawdown_year_3,max_Drawdown_year_4,max_Drawdown_year_5,avg_return_50_minus_200,last_200_day_return,ex_ratio,sc_aum,Fund_Type,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum) select from_date, scheme_code, quarter,Scheme_Name, backward_3, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36,backward_42,backward_48, backward_54, backward_60 , forwar_9_mnths, forwar_12_mnths , forwar_18_mnths , forwar_36_mnths , last_4_neg_avg_cat_ret_otb , last_4_pos_avg_cat_ret_otb,  last_8_neg_avg_cat_ret_otb,  last_8_pos_avg_cat_ret_otb , last_12_neg_avg_cat_ret_otb , last_12_pos_avg_cat_ret_otb , last_16_neg_avg_cat_ret_otb , last_16_pos_avg_cat_ret_otb ,  last_20_neg_avg_cat_ret_otb , last_20_pos_avg_cat_ret_otb , last_4_neg_act_ret_sum, last_8_neg_act_ret_sum, last_12_neg_act_ret_sum, last_16_neg_act_ret_sum, last_20_neg_act_ret_sum, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, cri, no_of_stock,  year_1, year_1_1 , year_1_2 , year_1_3 , year_1_4 , max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return,  ex_ratio, sc_aum, Fund_Type ,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum from Report_Merged_5_6_8_Model where backward_60!=0 and Fund_Type='"+Fund_Type+"'";
				    									  
//				    									  Run-Custome_Report_Merged_main_after_coping_data_into_that_table
				    									  System.out.println("---<All Reports Complete>---");
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
		   else if(Fund_Type.startsWith("EQUITY_ELSS"))
		   {
			    
		   }
		   

	}

}
