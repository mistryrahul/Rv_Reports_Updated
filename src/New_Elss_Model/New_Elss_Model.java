package New_Elss_Model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="Elss_new")
public class New_Elss_Model 
{
	
	@EmbeddedId
	private Composite_pk key;
	 
	String quarter;
	
  	double year_1_return;
  	int year_1_return_rank;
  	
  	double year_3_return;
  	int year_3_return_rank;
  	
  	
  	double year_4_return;
  	int year_4_return_rank;
  	

  	double year_5_return;
  	int year_5_return_rank;
  	
  	double year_2_return;
  	int year_2_return_rank;
  	
  	double forward_36_ret;
  	int forward_36_ret_rank;
  	
  	double aum;

	public Composite_pk getKey() {
		return key;
	}

	public void setKey(Composite_pk key) {
		this.key = key;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public double getYear_1_return() {
		return year_1_return;
	}

	public void setYear_1_return(double year_1_return) {
		this.year_1_return = year_1_return;
	}

	public int getYear_1_return_rank() {
		return year_1_return_rank;
	}

	public void setYear_1_return_rank(int year_1_return_rank) {
		this.year_1_return_rank = year_1_return_rank;
	}

	public double getYear_3_return() {
		return year_3_return;
	}

	public void setYear_3_return(double year_3_return) {
		this.year_3_return = year_3_return;
	}

	public int getYear_3_return_rank() {
		return year_3_return_rank;
	}

	public void setYear_3_return_rank(int year_3_return_rank) {
		this.year_3_return_rank = year_3_return_rank;
	}

	public double getYear_2_return() {
		return year_2_return;
	}

	public void setYear_2_return(double year_2_return) {
		this.year_2_return = year_2_return;
	}

	public int getYear_2_return_rank() {
		return year_2_return_rank;
	}

	public void setYear_2_return_rank(int year_2_return_rank) {
		this.year_2_return_rank = year_2_return_rank;
	}

	public double getForward_36_ret() {
		return forward_36_ret;
	}

	public void setForward_36_ret(double forward_36_ret) {
		this.forward_36_ret = forward_36_ret;
	}

	public int getForward_36_ret_rank() {
		return forward_36_ret_rank;
	}

	public void setForward_36_ret_rank(int forward_36_ret_rank) {
		this.forward_36_ret_rank = forward_36_ret_rank;
	}

	public double getAum() {
		return aum;
	}

	public double getYear_4_return() {
		return year_4_return;
	}

	public void setYear_4_return(double year_4_return) {
		this.year_4_return = year_4_return;
	}

	public int getYear_4_return_rank() {
		return year_4_return_rank;
	}

	public void setYear_4_return_rank(int year_4_return_rank) {
		this.year_4_return_rank = year_4_return_rank;
	}

	public double getYear_5_return() {
		return year_5_return;
	}

	public void setYear_5_return(double year_5_return) {
		this.year_5_return = year_5_return;
	}

	public int getYear_5_return_rank() {
		return year_5_return_rank;
	}

	public void setYear_5_return_rank(int year_5_return_rank) {
		this.year_5_return_rank = year_5_return_rank;
	}

	public void setAum(double aum) {
		this.aum = aum;
	}

  	
  	
  	
}
