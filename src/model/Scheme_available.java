package model;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Scheme_available {
	 @EmbeddedId
	 Report_6_pk key;
	 
	 String scheme_name;

	public Report_6_pk getKey() {
		return key;
	}

	public void setKey(Report_6_pk key) {
		this.key = key;
	}

	public String getScheme_name() {
		return scheme_name;
	}

	public void setScheme_name(String scheme_name) {
		this.scheme_name = scheme_name;
	}
	
	
}
