package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.IndexColumn;

import model.Report_6_pk;

@Entity
public class Custom_Merged_Report_W_Rank 
{
	 @EmbeddedId	
	   Report_6_pk key;

	 // Quarter 
	   String quarter;
	   
	   String Scheme_Name;
	   // nav_report_final;
	   
	   //@Column(nullable=false)
	   Double forwar_9_mnths;
	   
	   //@Column(nullable=false)
	   Integer R_forwar_9_mnths;
	   
	   //@Column(nullable=false)
	   Double forwar_12_mnths;
	   
	   //@Column(nullable=false)
	   Integer R_forwar_12_mnths;
	   
	   //@Column(nullable=false)
	   Double forwar_18_mnths;
	   
	   //@Column(nullable=false)
	   Integer R_forwar_18_mnths;
	   
	   //@Column(nullable=false)
	   Double forwar_36_mnths;
	   
	   //@Column(nullable=false)
	   Integer R_forwar_36_mnths;
	   
	   // nav_report_final;
	   //@Column(nullable=false)
	   Double backward_3;
	   
	   //@Column(nullable=false)
	   Double backward_6;
	   
	   //@Column(nullable=false)
	   Integer R_backward_6;
	   
	   //@Column(nullable=false)
	   Double backward_12;
	   
	   //@Column(nullable=false)
	   Integer R_backward_12;
	   
	   //@Column(nullable=false)
	   Double backward_18;
	   
	   //@Column(nullable=false)
	   Integer R_backward_18;
	   
	   //@Column(nullable=false)
	   Double backward_24;
	   
	   //@Column(nullable=false)
	   Integer R_backward_24;
	   
	   //@Column(nullable=false)
	   Double backward_30;
	   
	   //@Column(nullable=false) 
	   Integer R_backward_30;
	   
	   Double backward_36;
	   
	   //@Column(nullable=false)
	   Integer R_backward_36;
	   
	   //@Column(nullable=false)
	   Double backward_42;
	   
	   //@Column(nullable=false)
	   Integer R_backward_42;
	   
	   //@Column(nullable=false)
	   Double backward_48;
	   
	   //@Column(nullable=false)
	   Integer R_backward_48;
	   
	   //@Column(nullable=false)
	   Double backward_54;
	   
	   //@Column(nullable=false)
	   Integer R_backward_54;
	   
	   //@Column(nullable=false)
	   Double backward_60;
	   
	   //@Column(nullable=false)
	   Integer R_backward_60;
	   
	// Report 5;
	   //@Column(nullable=false)
	   Double year_1;
	   
	   //@Column(nullable=false)
	   Integer R_year_1;
	   
	   //@Column(nullable=false)
	   Double year_1_1;
	   
	   //@Column(nullable=false)
	   Integer R_year_1_1;
	   
	   //@Column(nullable=false)
	   Double year_1_2;
	   
	   //@Column(nullable=false)
	   Integer R_year_1_2;
	   
	   //@Column(nullable=false)
	   Double year_1_3;
	   
	   //@Column(nullable=false)
	   Integer R_year_1_3;
	   
	   //@Column(nullable=false)
	   Double year_1_4;
	   
	   //@Column(nullable=false)
	   Integer R_year_1_4;
	   
	// Report 6;
	   //@Column(nullable=false)
	   Double last_4_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_4_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_8_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_8_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_12_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_12_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_16_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_16_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_20_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_20_neg_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_4_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_4_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_8_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_8_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_12_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false) 
	   Integer R_last_12_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_16_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_16_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_20_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Integer R_last_20_pos_avg_cat_ret_otb;
	   
	   //@Column(nullable=false)
	   Double last_4_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_4_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_8_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_8_neg_act_ret_sum;
       
	   //@Column(nullable=false)
	   Double last_12_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_12_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_16_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_16_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_20_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_20_neg_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_4_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_4_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_8_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_8_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_12_pos_act_ret_sum;
	   
	   //@Column(nullable=false) 
	   Integer R_last_12_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_16_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_16_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_20_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Integer R_last_20_pos_act_ret_sum;
	   
	   //@Column(nullable=false)
	   Double last_4_pos_nav_ret_value_sum;
	   
	   //@Column(nullable=false)
	   Double last_8_pos_nav_ret_value_sum;
	   
	   //@Column(nullable=false)
	   Double last_12_pos_nav_ret_value_sum;
	   
	   //@Column(nullable=false)
	   Double last_16_pos_nav_ret_value_sum;
	   
	   //@Column(nullable=false)
	   Double last_20_pos_nav_ret_value_sum;
	   
	   
	  //Report 8 
	   //@Column(nullable=false)
	   Double cri;
	   
	   //@Column(nullable=false)
	   Integer R_cri;
	   
	   //@Column(nullable=false)
	   Long no_of_stock;
	   
	   //@Column(nullable=false)
	   Integer R_no_of_stocks;
	  
	   
	   // calmal Ratio
	   
	   //@Column(nullable=false)
	   Double max_Drawdown_year_1;
	   
	   //@Column(nullable=false)
	   Integer R_max_Drawdown_year_1;
	   
	   //@Column(nullable=false)
	   Double max_Drawdown_year_2;
	   
	   //@Column(nullable=false)
	   Integer R_max_Drawdown_year_2;
	   
	   //@Column(nullable=false)
	   Double max_Drawdown_year_3;
	   
	   //@Column(nullable=false)
	   Integer R_max_Drawdown_year_3;
	   
	   //@Column(nullable=false)
	   Double max_Drawdown_year_4;
	   
	   //@Column(nullable=false)
	   Integer R_max_Drawdown_year_4;
	   
	   //@Column(nullable=false)
	   Double max_Drawdown_year_5;
	   
	   //@Column(nullable=false)
	   Integer R_max_Drawdown_year_5;
	   
	   //Report10
	   
	   //@Column(nullable=false)
	   Double avg_return_50_minus_200;
	   
	   //@Column(nullable=false)
	   Integer R_avg_return_50_minus_200;
	   
	   //@Column(nullable=false)
	   Double last_200_day_return;
	   
	   //@Column(nullable=false)
	   Integer R_last_200_day_return;
	   
   // new addition
	   
	   //@Column(nullable=false)
	   Double ex_ratio;
	   
	   //@Column(nullable=false)
	   Double sc_aum;
	   
	// newest addition {Standard Deviation}   
	   //@Column(nullable=false)
	   Double Sdev_12_mnths;
	   
	   //@Column(nullable=false)
	   Integer R_Sdev_12_mnths;
	   
	   //@Column(nullable=false)
	   Double Sdev_24_mnths;
	   
	   //@Column(nullable=false)
	   Integer R_Sdev_24_mnths;
	   
	   //@Column(nullable=false)
	   Double Sdev_36_mnths;
	   
	   //@Column(nullable=false)
	   Integer R_Sdev_36_mnths;
	   
	   
	public Integer getR_avg_return_50_minus_200() {
		return R_avg_return_50_minus_200;
	}
	public Integer getR_last_200_day_return() {
		return R_last_200_day_return;
	}
	public void setR_avg_return_50_minus_200(Integer r_avg_return_50_minus_200) {
		R_avg_return_50_minus_200 = r_avg_return_50_minus_200;
	}
	public void setR_last_200_day_return(Integer r_last_200_day_return) {
		R_last_200_day_return = r_last_200_day_return;
	}
	public Double getAvg_return_50_minus_200() {
		return avg_return_50_minus_200;
	}
	public Double getLast_200_day_return() {
		return last_200_day_return;
	}
	public void setAvg_return_50_minus_200(Double avg_return_50_minus_200) {
		this.avg_return_50_minus_200 = avg_return_50_minus_200;
	}
	public void setLast_200_day_return(Double last_200_day_return) {
		this.last_200_day_return = last_200_day_return;
	}
	public Double getForwar_9_mnths() {
		return forwar_9_mnths;
	}
	public Integer getR_forwar_9_mnths() {
		return R_forwar_9_mnths;
	}
	public void setForwar_9_mnths(Double forwar_9_mnths) {
		this.forwar_9_mnths = forwar_9_mnths;
	}
	public void setR_forwar_9_mnths(Integer r_forwar_9_mnths) {
		R_forwar_9_mnths = r_forwar_9_mnths;
	}
	public Report_6_pk getKey() {
		return key;
	}
	public String getQuarter() {
		return quarter;
	}
	public Double getForwar_12_mnths() {
		return forwar_12_mnths;
	}
	public Integer getR_forwar_12_mnths() {
		return R_forwar_12_mnths;
	}
	public Double getForwar_18_mnths() {
		return forwar_18_mnths;
	}
	public Integer getR_forwar_18_mnths() {
		return R_forwar_18_mnths;
	}
	public Double getBackward_6() {
		return backward_6;
	}
	public Integer getR_backward_6() {
		return R_backward_6;
	}
	public Double getBackward_12() {
		return backward_12;
	}
	public Integer getR_backward_12() {
		return R_backward_12;
	}
	public Double getBackward_18() {
		return backward_18;
	}
	public Integer getR_backward_18() {
		return R_backward_18;
	}
	public Double getBackward_24() {
		return backward_24;
	}
	public Integer getR_backward_24() {
		return R_backward_24;
	}
	public Double getBackward_30() {
		return backward_30;
	}
	public Integer getR_backward_30() {
		return R_backward_30;
	}
	public Double getBackward_36() {
		return backward_36;
	}
	public Integer getR_backward_36() {
		return R_backward_36;
	}
	public Double getBackward_42() {
		return backward_42;
	}
	public Integer getR_backward_42() {
		return R_backward_42;
	}
	public Double getBackward_48() {
		return backward_48;
	}
	public Integer getR_backward_48() {
		return R_backward_48;
	}
	public Double getBackward_54() {
		return backward_54;
	}
	public Integer getR_backward_54() {
		return R_backward_54;
	}
	public Double getBackward_60() {
		return backward_60;
	}
	public Integer getR_backward_60() {
		return R_backward_60;
	}
	public Double getYear_1() {
		return year_1;
	}
	public Integer getR_year_1() {
		return R_year_1;
	}
	public Double getYear_1_1() {
		return year_1_1;
	}
	public Integer getR_year_1_1() {
		return R_year_1_1;
	}
	public Double getYear_1_2() {
		return year_1_2;
	}
	public Integer getR_year_1_2() {
		return R_year_1_2;
	}
	public Double getYear_1_3() {
		return year_1_3;
	}
	public Integer getR_year_1_3() {
		return R_year_1_3;
	}
	public Double getYear_1_4() {
		return year_1_4;
	}
	public Integer getR_year_1_4() {
		return R_year_1_4;
	}
	public Double getLast_4_neg_avg_cat_ret_otb() {
		return last_4_neg_avg_cat_ret_otb;
	}
	public Integer getR_last_4_neg_avg_cat_ret_otb() {
		return R_last_4_neg_avg_cat_ret_otb;
	}
	public Double getLast_8_neg_avg_cat_ret_otb() {
		return last_8_neg_avg_cat_ret_otb;
	}
	public Integer getR_last_8_neg_avg_cat_ret_otb() {
		return R_last_8_neg_avg_cat_ret_otb;
	}
	public Double getLast_12_neg_avg_cat_ret_otb() {
		return last_12_neg_avg_cat_ret_otb;
	}
	public Integer getR_last_12_neg_avg_cat_ret_otb() {
		return R_last_12_neg_avg_cat_ret_otb;
	}
	public Double getLast_16_neg_avg_cat_ret_otb() {
		return last_16_neg_avg_cat_ret_otb;
	}
	public Integer getR_last_16_neg_avg_cat_ret_otb() {
		return R_last_16_neg_avg_cat_ret_otb;
	}
	public Double getLast_20_neg_avg_cat_ret_otb() {
		return last_20_neg_avg_cat_ret_otb;
	}
	public Integer getR_last_20_neg_avg_cat_ret_otb() {
		return R_last_20_neg_avg_cat_ret_otb;
	}
	public Double getLast_4_pos_avg_cat_ret_otb() {
		return last_4_pos_avg_cat_ret_otb;
	}
	public Integer getR_last_4_pos_avg_cat_ret_otb() {
		return R_last_4_pos_avg_cat_ret_otb;
	}
	public Double getLast_8_pos_avg_cat_ret_otb() {
		return last_8_pos_avg_cat_ret_otb;
	}
	public Integer getR_last_8_pos_avg_cat_ret_otb() {
		return R_last_8_pos_avg_cat_ret_otb;
	}
	public Double getLast_12_pos_avg_cat_ret_otb() {
		return last_12_pos_avg_cat_ret_otb;
	}
	public Integer getR_last_12_pos_avg_cat_ret_otb() {
		return R_last_12_pos_avg_cat_ret_otb;
	}
	public Double getLast_16_pos_avg_cat_ret_otb() {
		return last_16_pos_avg_cat_ret_otb;
	}
	public Integer getR_last_16_pos_avg_cat_ret_otb() {
		return R_last_16_pos_avg_cat_ret_otb;
	}
	public Double getLast_20_pos_avg_cat_ret_otb() {
		return last_20_pos_avg_cat_ret_otb;
	}
	public Integer getR_last_20_pos_avg_cat_ret_otb() {
		return R_last_20_pos_avg_cat_ret_otb;
	}
	public Double getCri() {
		return cri;
	}
	public Integer getR_cri() {
		return R_cri;
	}
	public Long getNo_of_stock() {
		return no_of_stock;
	}
	public Integer getR_no_of_stocks() {
		return R_no_of_stocks;
	}
	public Double getMax_Drawdown_year_1() {
		return max_Drawdown_year_1;
	}
	public Integer getR_max_Drawdown_year_1() {
		return R_max_Drawdown_year_1;
	}
	public Double getMax_Drawdown_year_2() {
		return max_Drawdown_year_2;
	}
	public Integer getR_max_Drawdown_year_2() {
		return R_max_Drawdown_year_2;
	}
	public Double getMax_Drawdown_year_3() {
		return max_Drawdown_year_3;
	}
	public Integer getR_max_Drawdown_year_3() {
		return R_max_Drawdown_year_3;
	}
	public Double getMax_Drawdown_year_4() {
		return max_Drawdown_year_4;
	}
	public Integer getR_max_Drawdown_year_4() {
		return R_max_Drawdown_year_4;
	}
	public Double getMax_Drawdown_year_5() {
		return max_Drawdown_year_5;
	}
	public Integer getR_max_Drawdown_year_5() {
		return R_max_Drawdown_year_5;
	}
	public void setKey(Report_6_pk key) {
		this.key = key;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public void setForwar_12_mnths(Double forwar_12_mnths) {
		this.forwar_12_mnths = forwar_12_mnths;
	}
	public void setR_forwar_12_mnths(Integer r_forwar_12_mnths) {
		R_forwar_12_mnths = r_forwar_12_mnths;
	}
	public void setForwar_18_mnths(Double forwar_18_mnths) {
		this.forwar_18_mnths = forwar_18_mnths;
	}
	public void setR_forwar_18_mnths(Integer r_forwar_18_mnths) {
		R_forwar_18_mnths = r_forwar_18_mnths;
	}
	public void setBackward_6(Double backward_6) {
		this.backward_6 = backward_6;
	}
	public void setR_backward_6(Integer r_backward_6) {
		R_backward_6 = r_backward_6;
	}
	public void setBackward_12(Double backward_12) {
		this.backward_12 = backward_12;
	}
	public void setR_backward_12(Integer r_backward_12) {
		R_backward_12 = r_backward_12;
	}
	public void setBackward_18(Double backward_18) {
		this.backward_18 = backward_18;
	}
	public void setR_backward_18(Integer r_backward_18) {
		R_backward_18 = r_backward_18;
	}
	public void setBackward_24(Double backward_24) {
		this.backward_24 = backward_24;
	}
	public void setR_backward_24(Integer r_backward_24) {
		R_backward_24 = r_backward_24;
	}
	public void setBackward_30(Double backward_30) {
		this.backward_30 = backward_30;
	}
	public void setR_backward_30(Integer r_backward_30) {
		R_backward_30 = r_backward_30;
	}
	public void setBackward_36(Double backward_36) {
		this.backward_36 = backward_36;
	}
	public void setR_backward_36(Integer r_backward_36) {
		R_backward_36 = r_backward_36;
	}
	public void setBackward_42(Double backward_42) {
		this.backward_42 = backward_42;
	}
	public void setR_backward_42(Integer r_backward_42) {
		R_backward_42 = r_backward_42;
	}
	public void setBackward_48(Double backward_48) {
		this.backward_48 = backward_48;
	}
	public void setR_backward_48(Integer r_backward_48) {
		R_backward_48 = r_backward_48;
	}
	public void setBackward_54(Double backward_54) {
		this.backward_54 = backward_54;
	}
	public void setR_backward_54(Integer r_backward_54) {
		R_backward_54 = r_backward_54;
	}
	public void setBackward_60(Double backward_60) {
		this.backward_60 = backward_60;
	}
	public void setR_backward_60(Integer r_backward_60) {
		R_backward_60 = r_backward_60;
	}
	public void setYear_1(Double year_1) {
		this.year_1 = year_1;
	}
	public void setR_year_1(Integer r_year_1) {
		R_year_1 = r_year_1;
	}
	public void setYear_1_1(Double year_1_1) {
		this.year_1_1 = year_1_1;
	}
	public void setR_year_1_1(Integer r_year_1_1) {
		R_year_1_1 = r_year_1_1;
	}
	public void setYear_1_2(Double year_1_2) {
		this.year_1_2 = year_1_2;
	}
	public void setR_year_1_2(Integer r_year_1_2) {
		R_year_1_2 = r_year_1_2;
	}
	public void setYear_1_3(Double year_1_3) {
		this.year_1_3 = year_1_3;
	}
	public void setR_year_1_3(Integer r_year_1_3) {
		R_year_1_3 = r_year_1_3;
	}
	public void setYear_1_4(Double year_1_4) {
		this.year_1_4 = year_1_4;
	}
	public void setR_year_1_4(Integer r_year_1_4) {
		R_year_1_4 = r_year_1_4;
	}
	public void setLast_4_neg_avg_cat_ret_otb(Double last_4_neg_avg_cat_ret_otb) {
		this.last_4_neg_avg_cat_ret_otb = last_4_neg_avg_cat_ret_otb;
	}
	public void setR_last_4_neg_avg_cat_ret_otb(Integer r_last_4_neg_avg_cat_ret_otb) {
		R_last_4_neg_avg_cat_ret_otb = r_last_4_neg_avg_cat_ret_otb;
	}
	public void setLast_8_neg_avg_cat_ret_otb(Double last_8_neg_avg_cat_ret_otb) {
		this.last_8_neg_avg_cat_ret_otb = last_8_neg_avg_cat_ret_otb;
	}
	public void setR_last_8_neg_avg_cat_ret_otb(Integer r_last_8_neg_avg_cat_ret_otb) {
		R_last_8_neg_avg_cat_ret_otb = r_last_8_neg_avg_cat_ret_otb;
	}
	public void setLast_12_neg_avg_cat_ret_otb(Double last_12_neg_avg_cat_ret_otb) {
		this.last_12_neg_avg_cat_ret_otb = last_12_neg_avg_cat_ret_otb;
	}
	public void setR_last_12_neg_avg_cat_ret_otb(Integer r_last_12_neg_avg_cat_ret_otb) {
		R_last_12_neg_avg_cat_ret_otb = r_last_12_neg_avg_cat_ret_otb;
	}
	public void setLast_16_neg_avg_cat_ret_otb(Double last_16_neg_avg_cat_ret_otb) {
		this.last_16_neg_avg_cat_ret_otb = last_16_neg_avg_cat_ret_otb;
	}
	public void setR_last_16_neg_avg_cat_ret_otb(Integer r_last_16_neg_avg_cat_ret_otb) {
		R_last_16_neg_avg_cat_ret_otb = r_last_16_neg_avg_cat_ret_otb;
	}
	public void setLast_20_neg_avg_cat_ret_otb(Double last_20_neg_avg_cat_ret_otb) {
		this.last_20_neg_avg_cat_ret_otb = last_20_neg_avg_cat_ret_otb;
	}
	public void setR_last_20_neg_avg_cat_ret_otb(Integer r_last_20_neg_avg_cat_ret_otb) {
		R_last_20_neg_avg_cat_ret_otb = r_last_20_neg_avg_cat_ret_otb;
	}
	public void setLast_4_pos_avg_cat_ret_otb(Double last_4_pos_avg_cat_ret_otb) {
		this.last_4_pos_avg_cat_ret_otb = last_4_pos_avg_cat_ret_otb;
	}
	public void setR_last_4_pos_avg_cat_ret_otb(Integer r_last_4_pos_avg_cat_ret_otb) {
		R_last_4_pos_avg_cat_ret_otb = r_last_4_pos_avg_cat_ret_otb;
	}
	public void setLast_8_pos_avg_cat_ret_otb(Double last_8_pos_avg_cat_ret_otb) {
		this.last_8_pos_avg_cat_ret_otb = last_8_pos_avg_cat_ret_otb;
	}
	public void setR_last_8_pos_avg_cat_ret_otb(Integer r_last_8_pos_avg_cat_ret_otb) {
		R_last_8_pos_avg_cat_ret_otb = r_last_8_pos_avg_cat_ret_otb;
	}
	public void setLast_12_pos_avg_cat_ret_otb(Double last_12_pos_avg_cat_ret_otb) {
		this.last_12_pos_avg_cat_ret_otb = last_12_pos_avg_cat_ret_otb;
	}
	public void setR_last_12_pos_avg_cat_ret_otb(Integer r_last_12_pos_avg_cat_ret_otb) {
		R_last_12_pos_avg_cat_ret_otb = r_last_12_pos_avg_cat_ret_otb;
	}
	public void setLast_16_pos_avg_cat_ret_otb(Double last_16_pos_avg_cat_ret_otb) {
		this.last_16_pos_avg_cat_ret_otb = last_16_pos_avg_cat_ret_otb;
	}
	public void setR_last_16_pos_avg_cat_ret_otb(Integer r_last_16_pos_avg_cat_ret_otb) {
		R_last_16_pos_avg_cat_ret_otb = r_last_16_pos_avg_cat_ret_otb;
	}
	public void setLast_20_pos_avg_cat_ret_otb(Double last_20_pos_avg_cat_ret_otb) {
		this.last_20_pos_avg_cat_ret_otb = last_20_pos_avg_cat_ret_otb;
	}
	public void setR_last_20_pos_avg_cat_ret_otb(Integer r_last_20_pos_avg_cat_ret_otb) {
		R_last_20_pos_avg_cat_ret_otb = r_last_20_pos_avg_cat_ret_otb;
	}
	public void setCri(Double cri) {
		this.cri = cri;
	}
	public void setR_cri(Integer r_cri) {
		R_cri = r_cri;
	}
	public void setNo_of_stock(Long no_of_stock) {
		this.no_of_stock = no_of_stock;
	}
	public void setR_no_of_stocks(Integer r_no_of_stocks) {
		R_no_of_stocks = r_no_of_stocks;
	}
	public void setMax_Drawdown_year_1(Double max_Drawdown_year_1) {
		this.max_Drawdown_year_1 = max_Drawdown_year_1;
	}
	public void setR_max_Drawdown_year_1(Integer r_max_Drawdown_year_1) {
		R_max_Drawdown_year_1 = r_max_Drawdown_year_1;
	}
	public void setMax_Drawdown_year_2(Double max_Drawdown_year_2) {
		this.max_Drawdown_year_2 = max_Drawdown_year_2;
	}
	public void setR_max_Drawdown_year_2(Integer r_max_Drawdown_year_2) {
		R_max_Drawdown_year_2 = r_max_Drawdown_year_2;
	}
	public void setMax_Drawdown_year_3(Double max_Drawdown_year_3) {
		this.max_Drawdown_year_3 = max_Drawdown_year_3;
	}
	public void setR_max_Drawdown_year_3(Integer r_max_Drawdown_year_3) {
		R_max_Drawdown_year_3 = r_max_Drawdown_year_3;
	}
	public void setMax_Drawdown_year_4(Double max_Drawdown_year_4) {
		this.max_Drawdown_year_4 = max_Drawdown_year_4;
	}
	public void setR_max_Drawdown_year_4(Integer r_max_Drawdown_year_4) {
		R_max_Drawdown_year_4 = r_max_Drawdown_year_4;
	}
	public void setMax_Drawdown_year_5(Double max_Drawdown_year_5) {
		this.max_Drawdown_year_5 = max_Drawdown_year_5;
	}
	public void setR_max_Drawdown_year_5(Integer r_max_Drawdown_year_5) {
		R_max_Drawdown_year_5 = r_max_Drawdown_year_5;
	}
	public Double getBackward_3() {
		return backward_3;
	}
	public void setBackward_3(Double backward_3) {
		this.backward_3 = backward_3;
	}
	public Double getEx_ratio() {
		return ex_ratio;
	}
	public void setEx_ratio(Double ex_ratio) {
		this.ex_ratio = ex_ratio;
	}
	public Double getSc_aum() {
		return sc_aum;
	}
	public void setSc_aum(Double sc_aum) {
		this.sc_aum = sc_aum;
	}
	public Double getForwar_36_mnths() {
		return forwar_36_mnths;
	}
	public void setForwar_36_mnths(Double forwar_36_mnths) {
		this.forwar_36_mnths = forwar_36_mnths;
	}
	public Integer getR_forwar_36_mnths() {
		return R_forwar_36_mnths;
	}
	public void setR_forwar_36_mnths(Integer r_forwar_36_mnths) {
		R_forwar_36_mnths = r_forwar_36_mnths;
	}
	public Double getLast_4_neg_act_ret_sum() {
		return last_4_neg_act_ret_sum;
	}
	public void setLast_4_neg_act_ret_sum(Double last_4_neg_act_ret_sum) {
		this.last_4_neg_act_ret_sum = last_4_neg_act_ret_sum;
	}
	public Integer getR_last_4_neg_act_ret_sum() {
		return R_last_4_neg_act_ret_sum;
	}
	public void setR_last_4_neg_act_ret_sum(Integer r_last_4_neg_act_ret_sum) {
		R_last_4_neg_act_ret_sum = r_last_4_neg_act_ret_sum;
	}
	public Double getLast_8_neg_act_ret_sum() {
		return last_8_neg_act_ret_sum;
	}
	public void setLast_8_neg_act_ret_sum(Double last_8_neg_act_ret_sum) {
		this.last_8_neg_act_ret_sum = last_8_neg_act_ret_sum;
	}
	public Integer getR_last_8_neg_act_ret_sum() {
		return R_last_8_neg_act_ret_sum;
	}
	public void setR_last_8_neg_act_ret_sum(Integer r_last_8_neg_act_ret_sum) {
		R_last_8_neg_act_ret_sum = r_last_8_neg_act_ret_sum;
	}
	public Double getLast_12_neg_act_ret_sum() {
		return last_12_neg_act_ret_sum;
	}
	public void setLast_12_neg_act_ret_sum(Double last_12_neg_act_ret_sum) {
		this.last_12_neg_act_ret_sum = last_12_neg_act_ret_sum;
	}
	public Integer getR_last_12_neg_act_ret_sum() {
		return R_last_12_neg_act_ret_sum;
	}
	public void setR_last_12_neg_act_ret_sum(Integer r_last_12_neg_act_ret_sum) {
		R_last_12_neg_act_ret_sum = r_last_12_neg_act_ret_sum;
	}
	public Double getLast_16_neg_act_ret_sum() {
		return last_16_neg_act_ret_sum;
	}
	public void setLast_16_neg_act_ret_sum(Double last_16_neg_act_ret_sum) {
		this.last_16_neg_act_ret_sum = last_16_neg_act_ret_sum;
	}
	public Integer getR_last_16_neg_act_ret_sum() {
		return R_last_16_neg_act_ret_sum;
	}
	public void setR_last_16_neg_act_ret_sum(Integer r_last_16_neg_act_ret_sum) {
		R_last_16_neg_act_ret_sum = r_last_16_neg_act_ret_sum;
	}
	public Double getLast_20_neg_act_ret_sum() {
		return last_20_neg_act_ret_sum;
	}
	public void setLast_20_neg_act_ret_sum(Double last_20_neg_act_ret_sum) {
		this.last_20_neg_act_ret_sum = last_20_neg_act_ret_sum;
	}
	public Integer getR_last_20_neg_act_ret_sum() {
		return R_last_20_neg_act_ret_sum;
	}
	public void setR_last_20_neg_act_ret_sum(Integer r_last_20_neg_act_ret_sum) {
		R_last_20_neg_act_ret_sum = r_last_20_neg_act_ret_sum;
	}
	public Double getLast_4_pos_act_ret_sum() {
		return last_4_pos_act_ret_sum;
	}
	public void setLast_4_pos_act_ret_sum(Double last_4_pos_act_ret_sum) {
		this.last_4_pos_act_ret_sum = last_4_pos_act_ret_sum;
	}
	public Integer getR_last_4_pos_act_ret_sum() {
		return R_last_4_pos_act_ret_sum;
	}
	public void setR_last_4_pos_act_ret_sum(Integer r_last_4_pos_act_ret_sum) {
		R_last_4_pos_act_ret_sum = r_last_4_pos_act_ret_sum;
	}
	public Double getLast_8_pos_act_ret_sum() {
		return last_8_pos_act_ret_sum;
	}
	public void setLast_8_pos_act_ret_sum(Double last_8_pos_act_ret_sum) {
		this.last_8_pos_act_ret_sum = last_8_pos_act_ret_sum;
	}
	public Integer getR_last_8_pos_act_ret_sum() {
		return R_last_8_pos_act_ret_sum;
	}
	public void setR_last_8_pos_act_ret_sum(Integer r_last_8_pos_act_ret_sum) {
		R_last_8_pos_act_ret_sum = r_last_8_pos_act_ret_sum;
	}
	public Double getLast_12_pos_act_ret_sum() {
		return last_12_pos_act_ret_sum;
	}
	public void setLast_12_pos_act_ret_sum(Double last_12_pos_act_ret_sum) {
		this.last_12_pos_act_ret_sum = last_12_pos_act_ret_sum;
	}
	public Integer getR_last_12_pos_act_ret_sum() {
		return R_last_12_pos_act_ret_sum;
	}
	public void setR_last_12_pos_act_ret_sum(Integer r_last_12_pos_act_ret_sum) {
		R_last_12_pos_act_ret_sum = r_last_12_pos_act_ret_sum;
	}
	public Double getLast_16_pos_act_ret_sum() {
		return last_16_pos_act_ret_sum;
	}
	public void setLast_16_pos_act_ret_sum(Double last_16_pos_act_ret_sum) {
		this.last_16_pos_act_ret_sum = last_16_pos_act_ret_sum;
	}
	public Integer getR_last_16_pos_act_ret_sum() {
		return R_last_16_pos_act_ret_sum;
	}
	public void setR_last_16_pos_act_ret_sum(Integer r_last_16_pos_act_ret_sum) {
		R_last_16_pos_act_ret_sum = r_last_16_pos_act_ret_sum;
	}
	public Double getLast_20_pos_act_ret_sum() {
		return last_20_pos_act_ret_sum;
	}
	public void setLast_20_pos_act_ret_sum(Double last_20_pos_act_ret_sum) {
		this.last_20_pos_act_ret_sum = last_20_pos_act_ret_sum;
	}
	public Integer getR_last_20_pos_act_ret_sum() {
		return R_last_20_pos_act_ret_sum;
	}
	public void setR_last_20_pos_act_ret_sum(Integer r_last_20_pos_act_ret_sum) {
		R_last_20_pos_act_ret_sum = r_last_20_pos_act_ret_sum;
	}
	public String getScheme_Name() {
		return Scheme_Name;
	}
	public void setScheme_Name(String scheme_Name) {
		Scheme_Name = scheme_Name;
	}
	public Double getSdev_12_mnths() {
		return Sdev_12_mnths;
	}
	public void setSdev_12_mnths(Double sdev_12_mnths) {
		Sdev_12_mnths = sdev_12_mnths;
	}
	public Integer getR_Sdev_12_mnths() {
		return R_Sdev_12_mnths;
	}
	public void setR_Sdev_12_mnths(Integer r_Sdev_12_mnths) {
		R_Sdev_12_mnths = r_Sdev_12_mnths;
	}
	public Double getSdev_24_mnths() {
		return Sdev_24_mnths;
	}
	public void setSdev_24_mnths(Double sdev_24_mnths) {
		Sdev_24_mnths = sdev_24_mnths;
	}
	public Integer getR_Sdev_24_mnths() {
		return R_Sdev_24_mnths;
	}
	public void setR_Sdev_24_mnths(Integer r_Sdev_24_mnths) {
		R_Sdev_24_mnths = r_Sdev_24_mnths;
	}
	public Double getSdev_36_mnths() {
		return Sdev_36_mnths;
	}
	public void setSdev_36_mnths(Double sdev_36_mnths) {
		Sdev_36_mnths = sdev_36_mnths;
	}
	public Integer getR_Sdev_36_mnths() {
		return R_Sdev_36_mnths;
	}
	public void setR_Sdev_36_mnths(Integer r_Sdev_36_mnths) {
		R_Sdev_36_mnths = r_Sdev_36_mnths;
	}
	public Double getLast_4_pos_nav_ret_value_sum() {
		return last_4_pos_nav_ret_value_sum;
	}
	public void setLast_4_pos_nav_ret_value_sum(Double last_4_pos_nav_ret_value_sum) {
		this.last_4_pos_nav_ret_value_sum = last_4_pos_nav_ret_value_sum;
	}
	public Double getLast_8_pos_nav_ret_value_sum() {
		return last_8_pos_nav_ret_value_sum;
	}
	public void setLast_8_pos_nav_ret_value_sum(Double last_8_pos_nav_ret_value_sum) {
		this.last_8_pos_nav_ret_value_sum = last_8_pos_nav_ret_value_sum;
	}
	public Double getLast_12_pos_nav_ret_value_sum() {
		return last_12_pos_nav_ret_value_sum;
	}
	public void setLast_12_pos_nav_ret_value_sum(Double last_12_pos_nav_ret_value_sum) {
		this.last_12_pos_nav_ret_value_sum = last_12_pos_nav_ret_value_sum;
	}
	public Double getLast_16_pos_nav_ret_value_sum() {
		return last_16_pos_nav_ret_value_sum;
	}
	public void setLast_16_pos_nav_ret_value_sum(Double last_16_pos_nav_ret_value_sum) {
		this.last_16_pos_nav_ret_value_sum = last_16_pos_nav_ret_value_sum;
	}
	public Double getLast_20_pos_nav_ret_value_sum() {
		return last_20_pos_nav_ret_value_sum;
	}
	public void setLast_20_pos_nav_ret_value_sum(Double last_20_pos_nav_ret_value_sum) {
		this.last_20_pos_nav_ret_value_sum = last_20_pos_nav_ret_value_sum;
	}  
		
}
