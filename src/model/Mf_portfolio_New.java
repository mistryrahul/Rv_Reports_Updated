package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import model.MF_portfolio_pk;

@Entity(name="mf_portfolios")
public class Mf_portfolio_New 
{
   
   @EmbeddedId	
   MF_portfolio_pk key;	
	
   @Column(name="invenddate")
   Date inv_end_date;
   
   @Column(name="fincode")
   Long fincode;
   
   @Column(name="asect_code")
   Long asect_code;
   
   @Column(name="sect_code")
   Long sect_code;
   
   @Column(name="noshares")
   Double noshares;
   
   @Column(name="mktval")
   Double mktval;
   
   @Column(name="aum")
   Double aum;
   
   @Column(name="holdpercentage")
   Double holdpercentage;
   
   @Column(name="compname")
   String compname;
   
   @Column(name="sect_name")
   String sect_name;
   
   @Column(name="asect_name")
   String asect_name;
   
   @Column(name="rating")
   String rating;
   
   @Column(name="upd_flag")
   String upd_flag;
   
   
public MF_portfolio_pk getKey() {
	return key;
}
public void setKey(MF_portfolio_pk key) {
	this.key = key;
}
public Date getInv_end_date() {
	return inv_end_date;
}
public void setInv_end_date(Date inv_end_date) {
	this.inv_end_date = inv_end_date;
}
public Long getFincode() {
	return fincode;
}
public void setFincode(Long fincode) {
	this.fincode = fincode;
}
public Long getAsect_code() {
	return asect_code;
}
public void setAsect_code(Long asect_code) {
	this.asect_code = asect_code;
}
public Long getSect_code() {
	return sect_code;
}
public void setSect_code(Long sect_code) {
	this.sect_code = sect_code;
}
public Double getNoshares() {
	return noshares;
}
public void setNoshares(Double noshares) {
	this.noshares = noshares;
}
public Double getMktval() {
	return mktval;
}
public void setMktval(Double mktval) {
	this.mktval = mktval;
}
public Double getAum() {
	return aum;
}
public void setAum(Double aum) {
	this.aum = aum;
}
public Double getHoldpercentage() {
	return holdpercentage;
}
public void setHoldpercentage(Double holdpercentage) {
	this.holdpercentage = holdpercentage;
}
public String getCompname() {
	return compname;
}
public void setCompname(String compname) {
	this.compname = compname;
}
public String getSect_name() {
	return sect_name;
}
public void setSect_name(String sect_name) {
	this.sect_name = sect_name;
}
public String getAsect_name() {
	return asect_name;
}
public void setAsect_name(String asect_name) {
	this.asect_name = asect_name;
}
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}
public String getUpd_flag() {
	return upd_flag;
}
public void setUpd_flag(String upd_flag) {
	this.upd_flag = upd_flag;
}
  

   
   
   
}
