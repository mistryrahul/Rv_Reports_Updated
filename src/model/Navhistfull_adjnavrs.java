package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="navhistfull_adj_nav_rs")
public class Navhistfull_adjnavrs 
{
   @Id	
   long id;	
   
   long schemecode;
   Date navdate;
   double navrs;
   double adjnavrs;
   double repurprice;
   double saleprice;
   double adjustednav_c;
   double adjustednav_nonc;
   String flag;
   
   
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
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
}

