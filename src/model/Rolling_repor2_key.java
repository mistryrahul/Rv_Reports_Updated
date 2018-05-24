package model;

import java.io.Serializable;

public class Rolling_repor2_key implements Serializable
{
	java.util.Date from_date;	
	String Fund_Type;
	
	public java.util.Date getFrom_date() {
		return from_date;
	}
	public void setFrom_date(java.util.Date from_date) {
		this.from_date = from_date;
	}
	public String getFund_Type() {
		return Fund_Type;
	}
	public void setFund_Type(String fund_Type) {
		Fund_Type = fund_Type;
	}
	
	
	
}
