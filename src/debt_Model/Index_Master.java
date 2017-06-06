package debt_Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="index_msts")
public class Index_Master 
{
	@Id 
	Long indexcode;
	
	Long fincode;
	
	String scripcode;
	
	String indexname;
	
	String upd_flag;

	public Long getIndexcode() {
		return indexcode;
	}

	public void setIndexcode(Long indexcode) {
		this.indexcode = indexcode;
	}

	public Long getFincode() {
		return fincode;
	}

	public void setFincode(Long fincode) {
		this.fincode = fincode;
	}

	public String getScripcode() {
		return scripcode;
	}

	public void setScripcode(String scripcode) {
		this.scripcode = scripcode;
	}

	public String getIndexname() {
		return indexname;
	}

	public void setIndexname(String indexname) {
		this.indexname = indexname;
	}

	public String getUpd_flag() {
		return upd_flag;
	}

	public void setUpd_flag(String upd_flag) {
		this.upd_flag = upd_flag;
	}
   
	
	
}
