package model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class New_Rolling_Report2 {
   
	 @EmbeddedId
	 Rolling_repor2_key key;
//	 String comment; // Quarter of year
	 int no_of_funds;
	 
	 double avg_of_forward_12_rr2;
	 
	 double avg_of_top_forward_12_rr2;
	 
	 double avg_of_top_forward_12_rr3;
	  
	 double avg_of_top_forward_12_rr4;
	 	 
	 double avg_of_top_forward_12_rr5;
	 

	public Rolling_repor2_key getKey() {
		return key;
	}

	public void setKey(Rolling_repor2_key key) {
		this.key = key;
	}

	public int getNo_of_funds() {
		return no_of_funds;
	}

	public void setNo_of_funds(int no_of_funds) {
		this.no_of_funds = no_of_funds;
	}

	public double getAvg_of_forward_12_rr2() {
		return avg_of_forward_12_rr2;
	}

	public void setAvg_of_forward_12_rr2(double avg_of_forward_12_rr2) {
		this.avg_of_forward_12_rr2 = avg_of_forward_12_rr2;
	}

	public double getAvg_of_top_forward_12_rr2() {
		return avg_of_top_forward_12_rr2;
	}

	public void setAvg_of_top_forward_12_rr2(double avg_of_top_forward_12_rr2) {
		this.avg_of_top_forward_12_rr2 = avg_of_top_forward_12_rr2;
	}

	public double getAvg_of_top_forward_12_rr3() {
		return avg_of_top_forward_12_rr3;
	}

	public void setAvg_of_top_forward_12_rr3(double avg_of_top_forward_12_rr3) {
		this.avg_of_top_forward_12_rr3 = avg_of_top_forward_12_rr3;
	}

	public double getAvg_of_top_forward_12_rr4() {
		return avg_of_top_forward_12_rr4;
	}

	public void setAvg_of_top_forward_12_rr4(double avg_of_top_forward_12_rr4) {
		this.avg_of_top_forward_12_rr4 = avg_of_top_forward_12_rr4;
	}

	public double getAvg_of_top_forward_12_rr5() {
		return avg_of_top_forward_12_rr5;
	}

	public void setAvg_of_top_forward_12_rr5(double avg_of_top_forward_12_rr5) {
		this.avg_of_top_forward_12_rr5 = avg_of_top_forward_12_rr5;
	}
	 
	 
	  
}
