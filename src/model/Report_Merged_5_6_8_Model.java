package model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import model.Report_6_pk;

@Entity
public class Report_Merged_5_6_8_Model 
{ 
   @EmbeddedId	
   Report_6_pk key;
   
   
   String Scheme_Name;
   // Quarter 
   String quarter;
   
   // nav_report_final;
   
  
   Double forwar_9_mnths;
   
  
   Double forwar_12_mnths;
   
   
   Double forwar_18_mnths;
   
   
   Double forwar_36_mnths;
   // nav_report_final;
   
   Double backward_3;
   
   
   Double backward_6;
   
   
   Double backward_12;
   
   
   Double backward_18;
   
   
   Double backward_24;
   
   
   Double backward_30;
   
   
   Double backward_36;
   
   
   Double backward_42;
   
   
   Double backward_48;
   
   
   Double backward_54;
   
   
   Double backward_60;
   
   // Report 5;
   
   Double year_1;
   
   
   Double year_1_1;
   
   
   Double year_1_2;
   
   
   Double year_1_3;
   
   
   Double year_1_4;
   
   // Report 6;
   
   
   Double last_4_neg_avg_cat_ret_otb;
   
   
   Double last_8_neg_avg_cat_ret_otb;
   
   
   Double last_12_neg_avg_cat_ret_otb;
   
   
   Double last_16_neg_avg_cat_ret_otb;
   
   
   Double last_20_neg_avg_cat_ret_otb;
   
   
   Double last_4_pos_avg_cat_ret_otb;
   
   
   Double last_8_pos_avg_cat_ret_otb;
   
   
   Double last_12_pos_avg_cat_ret_otb;
   
   
   Double last_16_pos_avg_cat_ret_otb;
   
   
   Double last_20_pos_avg_cat_ret_otb;
   
   // new added on 21.10.2016
   
   
   Double last_4_neg_act_ret_sum;
   
   
   Double last_8_neg_act_ret_sum;
   
   
   Double last_12_neg_act_ret_sum;
   
   
   Double last_16_neg_act_ret_sum;
   
   
   Double last_20_neg_act_ret_sum;
   
   
   Double last_4_pos_act_ret_sum;
   
   
   Double last_8_pos_act_ret_sum;
   
   
   Double last_12_pos_act_ret_sum;
   
   
   Double last_16_pos_act_ret_sum;
   
   
   Double last_20_pos_act_ret_sum;

   
   
   Double last_4_pos_nav_ret_value_sum;
   Double last_8_pos_nav_ret_value_sum;
   Double last_12_pos_nav_ret_value_sum;
   Double last_16_pos_nav_ret_value_sum;
   Double last_20_pos_nav_ret_value_sum;
   //Report 8 
   
   Double cri;
   
   
   Long no_of_stock;
  
   
   // calmar Ratio
   
   
   Double max_Drawdown_year_1;
   
   Double max_Drawdown_year_2;
   
   
   Double max_Drawdown_year_3;
   
   
   Double max_Drawdown_year_4;
   
   
   Double max_Drawdown_year_5;
   
   
   //Report 10
   
   
   Double avg_return_50_minus_200;
   
   
   Double last_200_day_return;
   
// new addition
   
   Double ex_ratio;
   
   
   Double sc_aum;
   
   
// newest addition {Standard Deviation}   
   
   Double Sdev_12_mnths;
   Double Sdev_24_mnths;
   Double Sdev_36_mnths;
   
   
   
   
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

public void setForwar_9_mnths(Double forwar_9_mnths) {
	this.forwar_9_mnths = forwar_9_mnths;
}

public String getQuarter() {
	return quarter;
}

public void setQuarter(String quarter) {
	this.quarter = quarter;
}

public Report_6_pk getKey() {
	return key;
}

public Double getForwar_12_mnths() {
	return forwar_12_mnths;
}

public Double getForwar_18_mnths() {
	return forwar_18_mnths;
}

public Double getBackward_6() {
	return backward_6;
}

public Double getBackward_12() {
	return backward_12;
}

public Double getBackward_18() {
	return backward_18;
}

public Double getBackward_24() {
	return backward_24;
}

public Double getBackward_30() {
	return backward_30;
}

public Double getBackward_36() {
	return backward_36;
}

public Double getBackward_42() {
	return backward_42;
}

public Double getBackward_48() {
	return backward_48;
}

public Double getBackward_54() {
	return backward_54;
}

public Double getBackward_60() {
	return backward_60;
}

public Double getYear_1() {
	return year_1;
}

public Double getYear_1_1() {
	return year_1_1;
}

public Double getYear_1_2() {
	return year_1_2;
}

public Double getYear_1_3() {
	return year_1_3;
}

public Double getYear_1_4() {
	return year_1_4;
}

public Double getLast_4_neg_avg_cat_ret_otb() {
	return last_4_neg_avg_cat_ret_otb;
}

public Double getLast_8_neg_avg_cat_ret_otb() {
	return last_8_neg_avg_cat_ret_otb;
}

public Double getLast_12_neg_avg_cat_ret_otb() {
	return last_12_neg_avg_cat_ret_otb;
}

public Double getLast_16_neg_avg_cat_ret_otb() {
	return last_16_neg_avg_cat_ret_otb;
}

public Double getLast_20_neg_avg_cat_ret_otb() {
	return last_20_neg_avg_cat_ret_otb;
}

public Double getLast_4_pos_avg_cat_ret_otb() {
	return last_4_pos_avg_cat_ret_otb;
}

public Double getLast_8_pos_avg_cat_ret_otb() {
	return last_8_pos_avg_cat_ret_otb;
}

public Double getLast_12_pos_avg_cat_ret_otb() {
	return last_12_pos_avg_cat_ret_otb;
}

public Double getLast_16_pos_avg_cat_ret_otb() {
	return last_16_pos_avg_cat_ret_otb;
}

public Double getLast_20_pos_avg_cat_ret_otb() {
	return last_20_pos_avg_cat_ret_otb;
}

public Double getCri() {
	return cri;
}

public long getNo_of_stock() {
	return no_of_stock;
}

public void setKey(Report_6_pk key) {
	this.key = key;
}

public void setForwar_12_mnths(Double forwar_12_mnths) {
	this.forwar_12_mnths = forwar_12_mnths;
}

public void setForwar_18_mnths(Double forwar_18_mnths) {
	this.forwar_18_mnths = forwar_18_mnths;
}

public void setBackward_6(Double backward_6) {
	this.backward_6 = backward_6;
}

public void setBackward_12(Double backward_12) {
	this.backward_12 = backward_12;
}

public void setBackward_18(Double backward_18) {
	this.backward_18 = backward_18;
}

public void setBackward_24(Double backward_24) {
	this.backward_24 = backward_24;
}

public void setBackward_30(Double backward_30) {
	this.backward_30 = backward_30;
}

public void setBackward_36(Double backward_36) {
	this.backward_36 = backward_36;
}

public void setBackward_42(Double backward_42) {
	this.backward_42 = backward_42;
}

public void setBackward_48(Double backward_48) {
	this.backward_48 = backward_48;
}

public void setBackward_54(Double backward_54) {
	this.backward_54 = backward_54;
}

public void setBackward_60(Double backward_60) {
	this.backward_60 = backward_60;
}

public void setYear_1(Double year_1) {
	this.year_1 = year_1;
}

public void setYear_1_1(Double year_1_1) {
	this.year_1_1 = year_1_1;
}

public void setYear_1_2(Double year_1_2) {
	this.year_1_2 = year_1_2;
}

public void setYear_1_3(Double year_1_3) {
	this.year_1_3 = year_1_3;
}

public void setYear_1_4(Double year_1_4) {
	this.year_1_4 = year_1_4;
}

public void setLast_4_neg_avg_cat_ret_otb(Double last_4_neg_avg_cat_ret_otb) {
	this.last_4_neg_avg_cat_ret_otb = last_4_neg_avg_cat_ret_otb;
}

public void setLast_8_neg_avg_cat_ret_otb(Double last_8_neg_avg_cat_ret_otb) {
	this.last_8_neg_avg_cat_ret_otb = last_8_neg_avg_cat_ret_otb;
}

public void setLast_12_neg_avg_cat_ret_otb(Double last_12_neg_avg_cat_ret_otb) {
	this.last_12_neg_avg_cat_ret_otb = last_12_neg_avg_cat_ret_otb;
}

public void setLast_16_neg_avg_cat_ret_otb(Double last_16_neg_avg_cat_ret_otb) {
	this.last_16_neg_avg_cat_ret_otb = last_16_neg_avg_cat_ret_otb;
}

public void setLast_20_neg_avg_cat_ret_otb(Double last_20_neg_avg_cat_ret_otb) {
	this.last_20_neg_avg_cat_ret_otb = last_20_neg_avg_cat_ret_otb;
}

public void setLast_4_pos_avg_cat_ret_otb(Double last_4_pos_avg_cat_ret_otb) {
	this.last_4_pos_avg_cat_ret_otb = last_4_pos_avg_cat_ret_otb;
}

public void setLast_8_pos_avg_cat_ret_otb(Double last_8_pos_avg_cat_ret_otb) {
	this.last_8_pos_avg_cat_ret_otb = last_8_pos_avg_cat_ret_otb;
}

public void setLast_12_pos_avg_cat_ret_otb(Double last_12_pos_avg_cat_ret_otb) {
	this.last_12_pos_avg_cat_ret_otb = last_12_pos_avg_cat_ret_otb;
}

public void setLast_16_pos_avg_cat_ret_otb(Double last_16_pos_avg_cat_ret_otb) {
	this.last_16_pos_avg_cat_ret_otb = last_16_pos_avg_cat_ret_otb;
}

public void setLast_20_pos_avg_cat_ret_otb(Double last_20_pos_avg_cat_ret_otb) {
	this.last_20_pos_avg_cat_ret_otb = last_20_pos_avg_cat_ret_otb;
}

public void setCri(Double cri) {
	this.cri = cri;
}

public void setNo_of_stock(long no_of_stock) {
	this.no_of_stock = no_of_stock;
}

public Double getMax_Drawdown_year_1() {
	return max_Drawdown_year_1;
}

public Double getMax_Drawdown_year_2() {
	return max_Drawdown_year_2;
}

public Double getMax_Drawdown_year_3() {
	return max_Drawdown_year_3;
}

public Double getMax_Drawdown_year_4() {
	return max_Drawdown_year_4;
}

public Double getMax_Drawdown_year_5() {
	return max_Drawdown_year_5;
}

public void setMax_Drawdown_year_1(Double max_Drawdown_year_1) {
	this.max_Drawdown_year_1 = max_Drawdown_year_1;
}

public void setMax_Drawdown_year_2(Double max_Drawdown_year_2) {
	this.max_Drawdown_year_2 = max_Drawdown_year_2;
}

public void setMax_Drawdown_year_3(Double max_Drawdown_year_3) {
	this.max_Drawdown_year_3 = max_Drawdown_year_3;
}

public void setMax_Drawdown_year_4(Double max_Drawdown_year_4) {
	this.max_Drawdown_year_4 = max_Drawdown_year_4;
}

public void setMax_Drawdown_year_5(Double max_Drawdown_year_5) {
	this.max_Drawdown_year_5 = max_Drawdown_year_5;
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

public Double getLast_4_neg_act_ret_sum() {
	return last_4_neg_act_ret_sum;
}

public void setLast_4_neg_act_ret_sum(Double last_4_neg_act_ret_sum) {
	this.last_4_neg_act_ret_sum = last_4_neg_act_ret_sum;
}

public Double getLast_8_neg_act_ret_sum() {
	return last_8_neg_act_ret_sum;
}

public void setLast_8_neg_act_ret_sum(Double last_8_neg_act_ret_sum) {
	this.last_8_neg_act_ret_sum = last_8_neg_act_ret_sum;
}

public Double getLast_12_neg_act_ret_sum() {
	return last_12_neg_act_ret_sum;
}

public void setLast_12_neg_act_ret_sum(Double last_12_neg_act_ret_sum) {
	this.last_12_neg_act_ret_sum = last_12_neg_act_ret_sum;
}

public Double getLast_16_neg_act_ret_sum() {
	return last_16_neg_act_ret_sum;
}

public void setLast_16_neg_act_ret_sum(Double last_16_neg_act_ret_sum) {
	this.last_16_neg_act_ret_sum = last_16_neg_act_ret_sum;
}

public Double getLast_20_neg_act_ret_sum() {
	return last_20_neg_act_ret_sum;
}

public void setLast_20_neg_act_ret_sum(Double last_20_neg_act_ret_sum) {
	this.last_20_neg_act_ret_sum = last_20_neg_act_ret_sum;
}

public Double getLast_4_pos_act_ret_sum() {
	return last_4_pos_act_ret_sum;
}

public void setLast_4_pos_act_ret_sum(Double last_4_pos_act_ret_sum) {
	this.last_4_pos_act_ret_sum = last_4_pos_act_ret_sum;
}

public Double getLast_8_pos_act_ret_sum() {
	return last_8_pos_act_ret_sum;
}

public void setLast_8_pos_act_ret_sum(Double last_8_pos_act_ret_sum) {
	this.last_8_pos_act_ret_sum = last_8_pos_act_ret_sum;
}

public Double getLast_12_pos_act_ret_sum() {
	return last_12_pos_act_ret_sum;
}

public void setLast_12_pos_act_ret_sum(Double last_12_pos_act_ret_sum) {
	this.last_12_pos_act_ret_sum = last_12_pos_act_ret_sum;
}

public Double getLast_16_pos_act_ret_sum() {
	return last_16_pos_act_ret_sum;
}

public void setLast_16_pos_act_ret_sum(Double last_16_pos_act_ret_sum) {
	this.last_16_pos_act_ret_sum = last_16_pos_act_ret_sum;
}

public Double getLast_20_pos_act_ret_sum() {
	return last_20_pos_act_ret_sum;
}

public void setLast_20_pos_act_ret_sum(Double last_20_pos_act_ret_sum) {
	this.last_20_pos_act_ret_sum = last_20_pos_act_ret_sum;
}

public String getScheme_Name() {
	return Scheme_Name;
}

public void setScheme_Name(String scheme_Name) {
	Scheme_Name = scheme_Name;
}

public void setNo_of_stock(Long no_of_stock) {
	this.no_of_stock = no_of_stock;
}

public Double getSdev_12_mnths() {
	return Sdev_12_mnths;
}

public void setSdev_12_mnths(Double sdev_12_mnths) {
	Sdev_12_mnths = sdev_12_mnths;
}

public Double getSdev_24_mnths() {
	return Sdev_24_mnths;
}

public void setSdev_24_mnths(Double sdev_24_mnths) {
	Sdev_24_mnths = sdev_24_mnths;
}

public Double getSdev_36_mnths() {
	return Sdev_36_mnths;
}

public void setSdev_36_mnths(Double sdev_36_mnths) {
	Sdev_36_mnths = sdev_36_mnths;
}
 
   
}

