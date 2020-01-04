package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="rolling_ret_New_Report")
public class Rolling_Return {

	 @EmbeddedId
	 Report_6_pk key;
//	 String scheme_name;
	 
//	 double rolling_ret_5;
//	 double rolling_ret_4;
	 
	 double rolling_ret_5;
	 int rolling_ret_5_rating;
	 
	 double rolling_ret_4;
	 int rolling_ret_4_rating;
	 
	 double rolling_ret_3;
	 int rolling_ret_3_rating;
	 
	 double rolling_ret_2;
	 int rolling_ret_2_rating;
	 
	 double aum;
	 double forward_12;
	 
	public Report_6_pk getKey() {
		return key;
	}
	public void setKey(Report_6_pk key) {
		this.key = key;
	}
	public double getRolling_ret_5() {
		return rolling_ret_5;
	}
	public void setRolling_ret_5(double rolling_ret_5) {
		this.rolling_ret_5 = rolling_ret_5;
	}
	public double getRolling_ret_4() {
		return rolling_ret_4;
	}
	public void setRolling_ret_4(double rolling_ret_4) {
		this.rolling_ret_4 = rolling_ret_4;
	}
	public double getRolling_ret_3() {
		return rolling_ret_3;
	}
	public void setRolling_ret_3(double rolling_ret_3) {
		this.rolling_ret_3 = rolling_ret_3;
	}
	public double getRolling_ret_2() {
		return rolling_ret_2;
	}
	public void setRolling_ret_2(double rolling_ret_2) {
		this.rolling_ret_2 = rolling_ret_2;
	}
	public double getAum() {
		return aum;
	}
	public void setAum(double aum) {
		this.aum = aum;
	}
	public double getForward_12() {
		return forward_12;
	}
	public void setForward_12(double forward_12) {
		this.forward_12 = forward_12;
	}
	public int getRolling_ret_3_rating() {
		return rolling_ret_3_rating;
	}
	public void setRolling_ret_3_rating(int rolling_ret_3_rating) {
		this.rolling_ret_3_rating = rolling_ret_3_rating;
	}
	public int getRolling_ret_2_rating() {
		return rolling_ret_2_rating;
	}
	public void setRolling_ret_2_rating(int rolling_ret_2_rating) {
		this.rolling_ret_2_rating = rolling_ret_2_rating;
	}
	 
	 
	 
	 
	 
}
