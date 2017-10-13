package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="rolling_avg")
public class RollingReturnAvgModel 
{
     
	@EmbeddedId
	private RollingAvg_CompositeKey key;
	 
	 double avg_rol_yr_1;
	 double avg_rol_yr_3;
	 
	 
	public RollingAvg_CompositeKey getKey() {
		return key;
	}
	public void setKey(RollingAvg_CompositeKey key) {
		this.key = key;
	}
	public double getAvg_rol_yr_1() {
		return avg_rol_yr_1;
	}
	public void setAvg_rol_yr_1(double avg_rol_yr_1) {
		this.avg_rol_yr_1 = avg_rol_yr_1;
	}
	public double getAvg_rol_yr_3() {
		return avg_rol_yr_3;
	}
	public void setAvg_rol_yr_3(double avg_rol_yr_3) {
		this.avg_rol_yr_3 = avg_rol_yr_3;
	}	 
}
