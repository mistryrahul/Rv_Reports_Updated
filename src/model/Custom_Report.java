package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Custom_Report")
public class Custom_Report 
{
	 @Id
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  long id;	
	  long scheme_Code;
	  java.util.Date nav_from_date;
	  java.util.Date nav_date;
	  double year_3;
	  double year_5;
	  double year_7;
	  double year_10;
//	  double return_val;
	  String comment;
//	  String Fund_Type;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getScheme_Code() {
		return scheme_Code;
	}
	public void setScheme_Code(long scheme_Code) {
		this.scheme_Code = scheme_Code;
	}
	public java.util.Date getNav_from_date() {
		return nav_from_date;
	}
	public void setNav_from_date(java.util.Date nav_from_date) {
		this.nav_from_date = nav_from_date;
	}
	public java.util.Date getNav_date() {
		return nav_date;
	}
	public void setNav_date(java.util.Date nav_date) {
		this.nav_date = nav_date;
	}
	public double getYear_3() {
		return year_3;
	}
	public void setYear_3(double year_3) {
		this.year_3 = year_3;
	}
	public double getYear_5() {
		return year_5;
	}
	public void setYear_5(double year_5) {
		this.year_5 = year_5;
	}
	public double getYear_7() {
		return year_7;
	}
	public void setYear_7(double year_7) {
		this.year_7 = year_7;
	}
	public double getYear_10() {
		return year_10;
	}
	public void setYear_10(double year_10) {
		this.year_10 = year_10;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	  
	  
	  
}
