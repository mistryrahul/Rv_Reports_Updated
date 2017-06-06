package model;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="navhistfull_adjnavs")
public class nav_hist
{
	   @EmbeddedId
	   Nav_hist_PK key;
	   
	   double navrs;
	   double adjnavrs;
	   double repurprice;
	   double saleprice;
	   double adjustednav_c;
	   double adjustednav_nonc;
	   String flag;
	   
	public Nav_hist_PK getKey() {
		return key;
	}
	public void setKey(Nav_hist_PK key) {
		this.key = key;
	}
	public double getNavrs() {
		return navrs;
	}
	public void setNavrs(double navrs) {
		this.navrs = navrs;
	}
	public double getAdjnavrs() {
		return adjnavrs;
	}
	public void setAdjnavrs(double adjnavrs) {
		this.adjnavrs = adjnavrs;
	}
	public double getRepurprice() {
		return repurprice;
	}
	public void setRepurprice(double repurprice) {
		this.repurprice = repurprice;
	}
	public double getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(double saleprice) {
		this.saleprice = saleprice;
	}
	public double getAdjustednav_c() {
		return adjustednav_c;
	}
	public void setAdjustednav_c(double adjustednav_c) {
		this.adjustednav_c = adjustednav_c;
	}
	public double getAdjustednav_nonc() {
		return adjustednav_nonc;
	}
	public void setAdjustednav_nonc(double adjustednav_nonc) {
		this.adjustednav_nonc = adjustednav_nonc;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}

}
