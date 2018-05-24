package BenchMarkIndex;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class PK_benchmark implements Serializable{

	 java.util.Date date;
	 String name;
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 
	 
	 
	 
}
