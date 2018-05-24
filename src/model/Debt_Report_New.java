package model;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import New_Elss_Model.Composite_pk;
import debt_Model.Pk_generic;

@Entity
public class Debt_Report_New {
	@EmbeddedId
	Composite_pk key;
	double composite_score;
	String scheme_name;
	double credit_rating;
   	double rolling_ret_3;
   	double aum;
   	String star;
   	
	public Composite_pk getKey() {
		return key;
	}
	public void setKey(Composite_pk key) {
		this.key = key;
	}
	public double getComposite_score() {
		return composite_score;
	}
	public void setComposite_score(double composite_score) {
		this.composite_score = composite_score;
	}
	public String getScheme_name() {
		return scheme_name;
	}
	public void setScheme_name(String scheme_name) {
		this.scheme_name = scheme_name;
	}
	public double getCredit_rating() {
		return credit_rating;
	}
	public void setCredit_rating(double credit_rating) {
		this.credit_rating = credit_rating;
	}
	public double getRolling_ret_3() {
		return rolling_ret_3;
	}
	public void setRolling_ret_3(double rolling_ret_3) {
		this.rolling_ret_3 = rolling_ret_3;
	}
	public double getAum() {
		return aum;
	}
	public void setAum(double aum) {
		this.aum = aum;
	}
	public String getStar() {
		return star;
	}
	public void setStar(String star) {
		this.star = star;
	}
    
   	
   	
}
