package debt_Model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Pk_generic implements Serializable
{
	   long scheme_code;
	   java.util.Date day;
	   String comment;
	   
	   
	   
	   
	  
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
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
