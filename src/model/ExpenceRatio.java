package model;

import java.util.jar.Attributes.Name;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import model.Pk_generic;

@Entity(name="expenceratios")
public class ExpenceRatio 
{
   @EmbeddedId
   Pk_generic key;
   
   @Column(name="amc_code")
   Long amc_code;
   
   @Column(name="exratio")
   Double ex_ratio;
   
   String upd_flag;

public Pk_generic getKey() {
	return key;
}
public void setKey(Pk_generic key) {
	this.key = key;
}
public Long getAmc_code() {
	return amc_code;
}
public void setAmc_code(Long amc_code) {
	this.amc_code = amc_code;
}
public Double getEx_ratio() {
	return ex_ratio;
}
public void setEx_ratio(Double ex_ratio) {
	this.ex_ratio = ex_ratio;
}
public String getUpd_flag() {
	return upd_flag;
}
public void setUpd_flag(String upd_flag) {
	this.upd_flag = upd_flag;
}
   

		
}
