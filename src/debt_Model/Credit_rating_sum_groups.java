package debt_Model;

public class Credit_rating_sum_groups 
{
	long scheme_code;
	java.util.Date inv_date;
	String rv_group;
	String classification;
    double hold_percent;
    
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public java.util.Date getInv_date() {
		return inv_date;
	}
	public void setInv_date(java.util.Date inv_date) {
		this.inv_date = inv_date;
	}
	public String getRv_group() {
		return rv_group;
	}
	public void setRv_group(String rv_group) {
		this.rv_group = rv_group;
	}
	public String getClassification() {
		return classification;
	}
	public void setClassification(String classification) {
		this.classification = classification;
	}
	public double getHold_percent() {
		return hold_percent;
	}
	public void setHold_percent(double hold_percent) {
		this.hold_percent = hold_percent;
	}
    
    
}
