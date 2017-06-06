package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schemeisin 
{
	   int id;
	   
	   @Id
	   String isin;
	   
	   long scheme_code;
	   long amc_code;
	   String NseSymbol;
	   String series;
	   String RTAScheme_code;
	   String AMCSchemecode;
	   String LongSchemeDescrip;
	   String ShortSchemeDescrip;
	   
	   
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public long getAmc_code() {
		return amc_code;
	}
	public void setAmc_code(long amc_code) {
		this.amc_code = amc_code;
	}
	public String getNseSymbol() {
		return NseSymbol;
	}
	public void setNseSymbol(String nseSymbol) {
		NseSymbol = nseSymbol;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getRTAScheme_code() {
		return RTAScheme_code;
	}
	public void setRTAScheme_code(String rTAScheme_code) {
		RTAScheme_code = rTAScheme_code;
	}
	public String getAMCSchemecode() {
		return AMCSchemecode;
	}
	public void setAMCSchemecode(String aMCSchemecode) {
		AMCSchemecode = aMCSchemecode;
	}
	public String getLongSchemeDescrip() {
		return LongSchemeDescrip;
	}
	public void setLongSchemeDescrip(String longSchemeDescrip) {
		LongSchemeDescrip = longSchemeDescrip;
	}
	public String getShortSchemeDescrip() {
		return ShortSchemeDescrip;
	}
	public void setShortSchemeDescrip(String shortSchemeDescrip) {
		ShortSchemeDescrip = shortSchemeDescrip;
	}
	   
	   
	   
}
