package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;

@Embeddable
public class Nav_hist_PK implements Serializable
{
	 long schemecode;
	 Date navdate;
	 
	public long getSchemecode() {
		return schemecode;
	}
	public void setSchemecode(long schemecode) {
		this.schemecode = schemecode;
	}
	public Date getNavdate() {
		return navdate;
	}
	public void setNavdate(Date navdate) {
		this.navdate = navdate;
	}	 	   
}
