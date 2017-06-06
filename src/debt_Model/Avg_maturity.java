package debt_Model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="avg_maturities")
public class Avg_maturity
{
	 long amc_code;
	   
	   @EmbeddedId
	   Pk_generic_1 key;
	   
	   @Column(name="invenddate")
	   java.util.Date inv_end_date;
	   
	   @Column(name="avg_mat_num")
	   Double avg_mat_num;
	   
	   @Column(name="avg_mat_days")
	   String avg_mat_days;
	   
	   @Column(name="mod_dur_num")
	   Double mod_dur_num;
	   
	   @Column(name="mod_dur_days")
	   String mod_dur_days;
	   
	   @Column(name="ytm")
	   Double ytm;
	   
	   @Column(name="turnover_ratio")
	   Double turnover_ratio;
	   
	   @Column(name="tr_mode")
	   String tr_mode;
	   
	   @Column(name="upd_flag")
	   String upd_flag;

	public long getAmc_code() {
		return amc_code;
	}

	public void setAmc_code(long amc_code) {
		this.amc_code = amc_code;
	}

	public Pk_generic_1 getKey() {
		return key;
	}

	public void setKey(Pk_generic_1 key) {
		this.key = key;
	}

	public java.util.Date getInv_end_date() {
		return inv_end_date;
	}

	public void setInv_end_date(java.util.Date inv_end_date) {
		this.inv_end_date = inv_end_date;
	}

	public Double getAvg_mat_num() {
		return avg_mat_num;
	}

	public void setAvg_mat_num(Double avg_mat_num) {
		this.avg_mat_num = avg_mat_num;
	}

	public String getAvg_mat_days() {
		return avg_mat_days;
	}

	public void setAvg_mat_days(String avg_mat_days) {
		this.avg_mat_days = avg_mat_days;
	}

	public Double getMod_dur_num() {
		return mod_dur_num;
	}

	public void setMod_dur_num(Double mod_dur_num) {
		this.mod_dur_num = mod_dur_num;
	}

	public String getMod_dur_days() {
		return mod_dur_days;
	}

	public void setMod_dur_days(String mod_dur_days) {
		this.mod_dur_days = mod_dur_days;
	}

	public Double getYtm() {
		return ytm;
	}

	public void setYtm(Double ytm) {
		this.ytm = ytm;
	}

	public Double getTurnover_ratio() {
		return turnover_ratio;
	}

	public void setTurnover_ratio(Double turnover_ratio) {
		this.turnover_ratio = turnover_ratio;
	}

	public String getTr_mode() {
		return tr_mode;
	}

	public void setTr_mode(String tr_mode) {
		this.tr_mode = tr_mode;
	}

	public String getUpd_flag() {
		return upd_flag;
	}

	public void setUpd_flag(String upd_flag) {
		this.upd_flag = upd_flag;
	}
	   
	   
	
	   
	   
}
