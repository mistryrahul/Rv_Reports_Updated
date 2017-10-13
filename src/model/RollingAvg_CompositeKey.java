package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RollingAvg_CompositeKey implements Serializable
{
	 java.util.Date day;
	 String Fund_Type;
	 long scheme_code;
	 
	public java.util.Date getDay() {
		return day;
	}
	public void setDay(java.util.Date day) {
		this.day = day;
	}
	public String getFund_Type() {
		return Fund_Type;
	}
	public void setFund_Type(String fund_Type) {
		Fund_Type = fund_Type;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}	 
}
