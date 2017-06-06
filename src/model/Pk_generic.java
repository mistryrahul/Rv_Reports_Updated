package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Pk_generic implements Serializable
{
	   @Column(name="schemecode")
	   long scheme_code;
	   
	   @Column(name="date")
	   java.util.Date day;
	  
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public java.util.Date getDay() {
		return day;
	}
	public void setDay(java.util.Date day) {
		this.day = day;
	}
	   
	   
}