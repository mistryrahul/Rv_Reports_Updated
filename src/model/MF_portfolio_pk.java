package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MF_portfolio_pk implements Serializable
{
  @Column(name="invdate")	
  Date invdate;
  
  @Column(name="schemecode")	
  long scheme_code;
  
  @Column(name="srno")	
  long srno;
  
  
public Date getInvdate() {
	return invdate;
}
public void setInvdate(Date invdate) {
	this.invdate = invdate;
}
public long getScheme_code() {
	return scheme_code;
}
public void setScheme_code(long scheme_code) {
	this.scheme_code = scheme_code;
}
public long getSrno() {
	return srno;
}
public void setSrno(long srno) {
	this.srno = srno;
} 
}
