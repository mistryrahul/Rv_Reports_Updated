package completeDebt;

import java.util.ArrayList;

import org.hibernate.Session;

import model.Custom_Merged_Report_W_Rank;
import sessionFactory.HIbernateSession;

public class Custom_Merged_Report_Runner 
{
 
	void Generate_Rank(String Fund_Type)
	{
//		String Fund_Type;
		double temp_val_hldr;
		int rank_hldr=0;
		double retval=-99989;
	    int db_flag=1;// for data base session Resting
	    int same_rank_flag=0;
		try
		{     			 
//		String colum_lst[] = {"backward_6","backward_12","backward_18","backward_24","backward_30","backward_36","backward_42","backward_48","backward_54","backward_60","forwar_9_mnths","forwar_12_mnths","forwar_18_mnths","forwar_36_mnths","last_4_neg_avg_cat_ret_otb","last_4_pos_avg_cat_ret_otb","last_8_neg_avg_cat_ret_otb","last_8_pos_avg_cat_ret_otb","last_12_neg_avg_cat_ret_otb","last_12_pos_avg_cat_ret_otb","last_16_neg_avg_cat_ret_otb","last_16_pos_avg_cat_ret_otb", "last_20_neg_avg_cat_ret_otb" , "last_20_pos_avg_cat_ret_otb","cri","no_of_stock","year_1_1","year_1_2","year_1_3","year_1_4","max_Drawdown_year_1","max_Drawdown_year_2","max_Drawdown_year_3","max_Drawdown_year_4","max_Drawdown_year_5","avg_return_50_minus_200","last_200_day_return"};

		String colum_lst[] = {"backward_6","backward_12","backward_18","backward_24","backward_30","backward_36","backward_42","backward_48","backward_54","backward_60","forwar_9_mnths","forwar_12_mnths","forwar_18_mnths","forwar_36_mnths","last_4_neg_avg_cat_ret_otb","last_4_pos_avg_cat_ret_otb","last_8_neg_avg_cat_ret_otb","last_8_pos_avg_cat_ret_otb","last_12_neg_avg_cat_ret_otb","last_12_pos_avg_cat_ret_otb","last_16_neg_avg_cat_ret_otb","last_16_pos_avg_cat_ret_otb", "last_20_neg_avg_cat_ret_otb" , "last_20_pos_avg_cat_ret_otb","last_4_neg_act_ret_sum","last_8_neg_act_ret_sum","last_12_neg_act_ret_sum","last_16_neg_act_ret_sum","last_20_neg_act_ret_sum","last_4_pos_act_ret_sum","last_8_pos_act_ret_sum","last_12_pos_act_ret_sum","last_16_pos_act_ret_sum","last_20_pos_act_ret_sum","cri","no_of_stock","year_1_1","year_1_2","year_1_3","year_1_4","max_Drawdown_year_1","max_Drawdown_year_2","max_Drawdown_year_3","max_Drawdown_year_4","max_Drawdown_year_5","avg_return_50_minus_200","last_200_day_return","Sdev_12_mnths","Sdev_24_mnths","Sdev_36_mnths"};		 
			
		 // Type of fund is responsible for selecting appropriate scheme codes  
//        Fund_Type="EQUITY_ELSS"; // This field is mandatory
//		  Fund_Type="Report_Merged_5_6_8_Model"; // This field is mandatory
//		  Fund_Type="EQUITY_MULTI_CAP_NEW_30.9.2016"; // This field is mandatory 
//		  Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.9.2016";  // has to be passed
//		  Fund_Type="EQUITY_ELSS_NEW_30.9.2016";	
		
//		  Fund_Type="EQUITY_LARGE_CAP_NEW_31.03.2017";  // has to be passed
		  
//		  Fund_Type="EQUITY_MID_SMALL_CAP_NEW_31.03.2017";  // has to be passed
		
//		  Fund_Type="EQUITY_ELSS_NEW_31.03.2017";  // has to be passed
		
//		  Fund_Type="EQUITY_MULTI_CAP_NEW_31.03.2017";  // has to be passed
		  
//		  Fund_Type="EQUITY_MULTI_CAP_NEW_31.12.2016";  // has to be passed
//		  Fund_Type="EQUITY_MID_SMALL_CAP_NEW_31.12.2016";  // has to be passed
//		  Fund_Type="EQUITY_ELSS_NEW_31.05.2017";  // has to be passed
//		  Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.06.2017";  // has to be passed
		
//		 Fund_Type="EQUITY_LARGE_CAP_NEW_30.09.2017";  // has to be passed
			
		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
	    ssn.beginTransaction();		
	    
			//	    String sql="insert into Custom_Merged_Report_W_Rank(from_date,scheme_code,quarter,Scheme_Name,backward_3,backward_6,backward_12,backward_18,backward_24,backward_30,backward_36,backward_42,backward_48,backward_54,backward_60,forwar_9_mnths,forwar_12_mnths ,forwar_18_mnths ,forwar_36_mnths,last_4_neg_avg_cat_ret_otb ,last_4_pos_avg_cat_ret_otb,last_8_neg_avg_cat_ret_otb,last_8_pos_avg_cat_ret_otb ,last_12_neg_avg_cat_ret_otb ,last_12_pos_avg_cat_ret_otb ,last_16_neg_avg_cat_ret_otb ,last_16_pos_avg_cat_ret_otb ,last_20_neg_avg_cat_ret_otb ,last_20_pos_avg_cat_ret_otb ,last_4_neg_act_ret_sum,last_8_neg_act_ret_sum,last_12_neg_act_ret_sum,last_16_neg_act_ret_sum,last_20_neg_act_ret_sum,last_4_pos_act_ret_sum,last_8_pos_act_ret_sum,last_12_pos_act_ret_sum,last_16_pos_act_ret_sum,last_20_pos_act_ret_sum,cri,no_of_stock,year_1,year_1_1 ,year_1_2 ,year_1_3 ,year_1_4 ,max_Drawdown_year_1,max_Drawdown_year_2,max_Drawdown_year_3,max_Drawdown_year_4,max_Drawdown_year_5,avg_return_50_minus_200,last_200_day_return,ex_ratio,sc_aum,Fund_Type,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum) select from_date, scheme_code, quarter,Scheme_Name, backward_3, backward_6, backward_12, backward_18, backward_24, backward_30, backward_36,backward_42,backward_48, backward_54, backward_60 , forwar_9_mnths, forwar_12_mnths , forwar_18_mnths , forwar_36_mnths , last_4_neg_avg_cat_ret_otb , last_4_pos_avg_cat_ret_otb,  last_8_neg_avg_cat_ret_otb,  last_8_pos_avg_cat_ret_otb , last_12_neg_avg_cat_ret_otb , last_12_pos_avg_cat_ret_otb , last_16_neg_avg_cat_ret_otb , last_16_pos_avg_cat_ret_otb ,  last_20_neg_avg_cat_ret_otb , last_20_pos_avg_cat_ret_otb , last_4_neg_act_ret_sum, last_8_neg_act_ret_sum, last_12_neg_act_ret_sum, last_16_neg_act_ret_sum, last_20_neg_act_ret_sum, last_4_pos_act_ret_sum, last_8_pos_act_ret_sum, last_12_pos_act_ret_sum, last_16_pos_act_ret_sum, last_20_pos_act_ret_sum, cri, no_of_stock,  year_1, year_1_1 , year_1_2 , year_1_3 , year_1_4 , max_Drawdown_year_1, max_Drawdown_year_2, max_Drawdown_year_3, max_Drawdown_year_4, max_Drawdown_year_5, avg_return_50_minus_200, last_200_day_return,  ex_ratio, sc_aum, Fund_Type ,Sdev_12_mnths,Sdev_24_mnths,Sdev_36_mnths,last_4_pos_nav_ret_value_sum,last_8_pos_nav_ret_value_sum,last_12_pos_nav_ret_value_sum,last_16_pos_nav_ret_value_sum,last_20_pos_nav_ret_value_sum from Report_Merged_5_6_8_Model where backward_60!=0 and Fund_Type='"+Fund_Type+"'";
			//	    
			//	    SQLQuery query = ssn.createSQLQuery(sql);
			//	    
			////	    int upd_resp= ssn.createQuery(sql).executeUpdate();
			//	    
			//	    
			//	    int upd_resp=query.executeUpdate();
			//	    
			//	    if(upd_resp==1)
			//	    {
			//	    	System.out.println("Successfully Updated:------>>");
			//	    }
	    
	    
	    ArrayList<String> quarter_list = (ArrayList<String>) ssn.createQuery("select distinct(quarter) from Custom_Merged_Report_W_Rank where key.Fund_Type='"+Fund_Type+"' ").list();
	    
	    for(String quarter : quarter_list)
	    {
//	    	temp_val_hldr=0;
//	    	rank_hldr=1;
	    	
	    	for(String column : colum_lst)
	    	{  
//	    		   System.out.println("Generating Rank of-->>"+column);
	    		   ArrayList<Custom_Merged_Report_W_Rank> data_lst = (ArrayList<Custom_Merged_Report_W_Rank>) ssn.createQuery("from Custom_Merged_Report_W_Rank where quarter='"+quarter+"' and key.Fund_Type='"+Fund_Type+"' order by "+column).list();
	    		   
	    		   temp_val_hldr=-999999;
	   	    	   rank_hldr=0;
	   	    	   same_rank_flag=0;
	   	    	   
	   	    	   
	    		   for(Custom_Merged_Report_W_Rank arm : data_lst)
	    		   {
	    			   
	    			   
	    			   
	    			   if(column=="backward_6" && arm.getBackward_6()!=null )
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_6());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_6(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_6(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_6();
	    			   }
	    			   
	    			   if(column=="backward_12" && arm.getBackward_12()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_12());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_12(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_12(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_12();
	    			   }
	    			   
	    			   if(column=="backward_18" && arm.getBackward_18()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_18());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_18(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_18(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_18();
	    			   }
	    			   
	    			   if(column=="backward_24" && arm.getBackward_24()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_24());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_24(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_24(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_24();
	    			   }
	    			   
	    			   if(column=="backward_30" && arm.getBackward_30()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_30());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_30(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_30(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_30();
	    			   }
	    			   
	    			   if(column=="backward_36" && arm.getBackward_36()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_36());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_36(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_36(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_36();
	    			   }
	    			   
	    			   if(column=="backward_42" && arm.getBackward_42()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_42());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    		
			 		    	    arm.setR_backward_42(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_42(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_42();
	    			   }
	    			   
	    			   if(column=="backward_48" && arm.getBackward_48()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_48());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_48(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_48(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_48();
	    			   }
	    			   
	    			   if(column=="backward_54" && arm.getBackward_54()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_54());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_54(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_54(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_54();
	    			   }

	    			   if(column=="backward_60" && arm.getBackward_60()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getBackward_60());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_backward_60(rank_hldr-1);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_backward_60(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getBackward_60();
	    			   }
	    			   
	    			   if(column=="forwar_9_mnths" && arm.getForwar_9_mnths()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getForwar_9_mnths());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_forwar_9_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_forwar_9_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getForwar_9_mnths();
	    			   }
	    			   if(column=="forwar_12_mnths" && arm.getForwar_12_mnths()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getForwar_12_mnths());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_forwar_12_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_forwar_12_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getForwar_12_mnths();
	    			   }
	    			   
	    			   if(column=="forwar_18_mnths" && arm.getForwar_18_mnths()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getForwar_18_mnths());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_forwar_18_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_forwar_18_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getForwar_18_mnths();
	    			   }
	    			   
	    			   if(column=="forwar_36_mnths" && arm.getForwar_36_mnths()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getForwar_36_mnths());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_forwar_36_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_forwar_36_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getForwar_36_mnths();
	    			   }
	    			   
	    			   if(column=="cri" && arm.getCri()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getCri());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_cri(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_cri(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getCri();
	    			   }
	    			   
	    			   
	    			   if(column=="no_of_stock" && arm.getNo_of_stock()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getNo_of_stock());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_no_of_stocks(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_no_of_stocks(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getNo_of_stock();
	    			   }
	    			   
	    			   if(column=="last_4_neg_avg_cat_ret_otb" && arm.getLast_4_neg_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_4_neg_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_4_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_4_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_4_neg_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_4_pos_avg_cat_ret_otb" && arm.getLast_4_pos_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_4_pos_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_4_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_4_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_4_pos_avg_cat_ret_otb();
	    			   }
	    			   
	    			   
	    			   if(column=="last_8_neg_avg_cat_ret_otb" && arm.getLast_8_neg_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_8_neg_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_8_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_8_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_8_neg_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_8_pos_avg_cat_ret_otb" && arm.getLast_8_pos_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_8_pos_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_8_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_8_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_8_pos_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_12_neg_avg_cat_ret_otb" && arm.getLast_12_neg_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_12_neg_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_12_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_12_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_12_neg_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_12_pos_avg_cat_ret_otb" && arm.getLast_12_pos_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_12_pos_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_12_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_12_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_12_pos_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_16_neg_avg_cat_ret_otb" && arm.getLast_16_neg_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_16_neg_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_16_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_16_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_16_neg_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_16_pos_avg_cat_ret_otb" && arm.getLast_16_pos_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_16_pos_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_16_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_16_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_16_pos_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_20_neg_avg_cat_ret_otb" && arm.getLast_20_neg_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_20_neg_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_20_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_20_neg_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_20_neg_avg_cat_ret_otb();
	    			   }
	    			   
	    			   if(column=="last_20_pos_avg_cat_ret_otb" && arm.getLast_20_pos_avg_cat_ret_otb()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_20_pos_avg_cat_ret_otb());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_20_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_20_pos_avg_cat_ret_otb(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_20_pos_avg_cat_ret_otb();
	    			   }
	    			   //new added 
	    			   
	    			   if(column=="last_4_neg_act_ret_sum" && arm.getLast_4_neg_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_4_neg_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_4_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_4_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_4_neg_act_ret_sum();
	    			   }
	    			   
	    			   if(column=="last_8_neg_act_ret_sum" && arm.getLast_8_neg_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_8_neg_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_8_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_8_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_8_neg_act_ret_sum();
	    			   }
	    			   
	    			   if(column=="last_12_neg_act_ret_sum" && arm.getLast_12_neg_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_12_neg_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_12_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_12_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_12_neg_act_ret_sum();
	    			   }
	    			   
	    			   if(column=="last_16_neg_act_ret_sum" && arm.getLast_16_neg_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_16_neg_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_16_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_16_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_16_neg_act_ret_sum();
	    			   }
	    			   
	    			   
	    			   if(column=="last_20_neg_act_ret_sum" && arm.getLast_20_neg_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_20_neg_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_20_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_20_neg_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_20_neg_act_ret_sum();
	    			   }
	    			   
	    			   
	    			   if(column=="last_4_pos_act_ret_sum" && arm.getLast_4_pos_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_4_pos_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_4_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_4_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_4_pos_act_ret_sum();
	    			   }
	    			   
	    			   if(column=="last_8_pos_act_ret_sum" && arm.getLast_8_pos_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_8_pos_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_8_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_8_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_8_pos_act_ret_sum();
	    			   }
	    			   
	    			   if(column=="last_12_pos_act_ret_sum" && arm.getLast_12_pos_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_12_pos_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_12_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_12_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_12_pos_act_ret_sum();
	    			   }
	    			   
	    			   if(column=="last_16_pos_act_ret_sum" && arm.getLast_16_pos_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_16_pos_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_16_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_16_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_16_pos_act_ret_sum();
	    			   }
	    			   
	    			   if(column=="last_20_pos_act_ret_sum" && arm.getLast_20_pos_act_ret_sum()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_20_pos_act_ret_sum());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_20_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_last_20_pos_act_ret_sum(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_20_pos_act_ret_sum();
	    			   }
//	    			   max_Drawdown_year_1
	    			   
	    			   if(column=="max_Drawdown_year_1" && arm.getMax_Drawdown_year_1()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getMax_Drawdown_year_1());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_max_Drawdown_year_1(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_max_Drawdown_year_1(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getMax_Drawdown_year_1();
	    			   }
	    			   
	    			   if(column=="max_Drawdown_year_2" && arm.getMax_Drawdown_year_2()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getMax_Drawdown_year_2());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_max_Drawdown_year_2(rank_hldr-1);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_max_Drawdown_year_2(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getMax_Drawdown_year_2();
	    			   }
	    			   
	    			   if(column=="max_Drawdown_year_3" && arm.getMax_Drawdown_year_3()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getMax_Drawdown_year_3());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_max_Drawdown_year_3(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_max_Drawdown_year_3(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getMax_Drawdown_year_3();
	    			   }
	    			   
	    			   if(column=="max_Drawdown_year_4" && arm.getMax_Drawdown_year_4()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getMax_Drawdown_year_4());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_max_Drawdown_year_4(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
					    		same_rank_flag=0;
					    		rank_hldr=rank_hldr+1;
					    		
			 		    		arm.setR_max_Drawdown_year_4(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getMax_Drawdown_year_4();
	    			   }
	    			   
	    			   if(column=="max_Drawdown_year_5" && arm.getMax_Drawdown_year_5()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getMax_Drawdown_year_5());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_max_Drawdown_year_5(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_max_Drawdown_year_5(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getMax_Drawdown_year_5();
	    			   }
	    			   
	    			   
	    			   if(column=="year_1" && arm.getYear_1()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getYear_1());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_year_1(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_year_1(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getYear_1();
	    			   }
	    			   
	    			   
	    			   if(column=="year_1_1" && arm.getYear_1_1()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getYear_1_1());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_year_1_1(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_year_1_1(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getYear_1_1();
	    			   }
	    			   
	    			   
	    			   if(column=="year_1_2" && arm.getYear_1_2()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getYear_1_2());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_year_1_2(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_year_1_2(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getYear_1_2();
	    			   }
	    			   
	    			   
	    			   if(column=="year_1_3" && arm.getYear_1_3()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getYear_1_3());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_year_1_3(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	    same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_year_1_3(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getYear_1_3();
	    			   }
	    			   
	    			   if(column=="year_1_4" && arm.getYear_1_4()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getYear_1_4());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_year_1_4(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_year_1_4(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getYear_1_4();
	    			   }
	    			   
	    			   
	    			   //Sdev_12_month
	    			   
	    			   if(column=="Sdev_12_mnths" && arm.getSdev_12_mnths()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getSdev_12_mnths());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_Sdev_12_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_Sdev_12_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getSdev_12_mnths();
	    			   }
	    			   
	    			   	//Sdev_24_month
	    			   
	    			   if(column=="Sdev_24_mnths" && arm.getSdev_24_mnths()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getSdev_24_mnths());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_Sdev_24_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_Sdev_24_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getSdev_24_mnths();
	    			   }
	    			   
	    			   	//Sdev_36_month
	    			   
	    			   if(column=="Sdev_36_mnths" && arm.getSdev_36_mnths()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getSdev_36_mnths());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_Sdev_36_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_Sdev_36_mnths(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getSdev_36_mnths();
	    			   }
	    			   
	    			   
	    			   
//	    			   "avg_return_50_minus_200","last_200_day_return"
	    			   
	    			   if(column=="avg_return_50_minus_200" && arm.getAvg_return_50_minus_200()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getAvg_return_50_minus_200());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_avg_return_50_minus_200(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_avg_return_50_minus_200(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getAvg_return_50_minus_200();
	    			   }
	    			   
	    			   if(column=="last_200_day_return" && arm.getLast_200_day_return()!=null)
	    			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getLast_200_day_return());
		  		 		    
			 		    	if(retval==0)
			 		    	{
			 		    	    arm.setR_last_200_day_return(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	    db_flag++;
			 		    	   same_rank_flag++;
			 		    	}
			 		    	else
			 		    	{   
			 		    		
			 		    		rank_hldr=rank_hldr+same_rank_flag;
			 		    		same_rank_flag=0;
			 		    		rank_hldr=rank_hldr+1;
			 		    		
			 		    		arm.setR_last_200_day_return(rank_hldr);
			 		    	    ssn.update(arm);
			 		    	     db_flag++;  
			 		    	}
			 		    	
			 		    	
			 		    	temp_val_hldr=arm.getLast_200_day_return();
	    			   }
	    			   
	    			   
	    			   
	    			   if(db_flag%1000==0)
	   		 		    {
	   		 		    	 ssn.getTransaction().commit();
	   		 		         ssn.beginTransaction();
	   		 		    	 ssn.flush();
					         ssn.clear();
	   		 		    	
	   		 		        db_flag=0;
	   		 		    }
	    			   
	    			   

   
	    		   }
	    		   	    		   
	    		   
	    		   
	    	}
	    	
	    	
	    	
	    }
	    
	    
	    
	    ssn.getTransaction().commit();
		ssn.close(); 
			
			
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println("<<<<<----------- Rank Generation Complete------------>>>>");
		   	
		}
	}
	
}
