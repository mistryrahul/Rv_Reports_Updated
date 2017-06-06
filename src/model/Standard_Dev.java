package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="Standard_deviation")
public class Standard_Dev
{
	@EmbeddedId
	   composite_pk_Sd key;
	   double standard_deviation;
	   
	   
public composite_pk_Sd getKey() {
	return key;
}
public void setKey(composite_pk_Sd key) {
	this.key = key;
}
public double getStandard_deviation() {
	return standard_deviation;
}
public void setStandard_deviation(double standard_deviation) {
	this.standard_deviation = standard_deviation;
}


}
