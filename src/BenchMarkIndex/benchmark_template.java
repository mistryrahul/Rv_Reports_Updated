package BenchMarkIndex;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class benchmark_template 
{
  @EmbeddedId
  PK_benchmark key;
  int index_code;
  double price;
  
public PK_benchmark getKey() {
	return key;
}
public void setKey(PK_benchmark key) {
	this.key = key;
}
public int getIndex_code() {
	return index_code;
}
public void setIndex_code(int index_code) {
	this.index_code = index_code;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
  
  
  
  
  
}
