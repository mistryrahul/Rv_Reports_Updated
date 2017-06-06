package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class composite_pk_Sd implements Serializable
{
	 
	  long scheme_code;
	  String Fund_Type;
	  java.util.Date date;
	  int Sd_day;
	
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public String getFund_Type() {
		return Fund_Type;
	}
	public void setFund_Type(String fund_Type) {
		Fund_Type = fund_Type;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public int getSd_day() {
		return Sd_day;
	}
	public void setSd_day(int sd_day) {
		Sd_day = sd_day;
	}
	
	
	
	  
	  
}
