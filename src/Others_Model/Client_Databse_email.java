package Others_Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client_Databse_email 
{
	@Id
	long id;
	String email;
	String valid_email_address;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getValid_email_address() {
		return valid_email_address;
	}
	public void setValid_email_address(String valid_email_address) {
		this.valid_email_address = valid_email_address;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}
