package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="scheme_details_fulls")
public class Scheme_Detail 
{
     @Id
     @Column(name = "schemecode")
	 long scheme_code;
     
     @Column(name = "amfi_code",nullable = true)
	 long AMFI_CODE;
     
     @Column(name = "cmas_code",nullable = true)
	 String CAMS_CODE;
     
     @Column(name = "amc_code",nullable = true)
	 long AMC_CODE;
     
     @Column(name = "s_name",nullable = true)
	 String S_NAME;
     
     @Column(name = "amfi_name",nullable = true)
	 String AMFI_NAME;
     
     @Column(name = "isin_code",nullable = true)
	 String ISIN_CODE;
     
     @Column(name = "type_code",nullable = true)
	 Integer TYPE_CODE;
     
     @Column(name = "opt_code",nullable = true)
     Integer OPT_CODE;
     
     @Column(name = "classcode",nullable = true)
     Integer CLASSCODE;
     
     @Column(name = "theme_code",nullable = true)
     Integer THEME_CODE;
	 
     @Column(name = "rt_code",nullable = true)
     Integer RT_CODE;
     
     @Column(name = "plan",nullable = true)
     Integer PLAN;
     
     @Column(name = "cust_code",nullable = true)
     Integer CUST_CODE;
     
     @Column(name = "cust_code2",nullable = true)
     Integer CUST_CODE2;
     
     @Column(name = "price_freg",nullable = true)
     Integer PRICE_FREQ;
     
     @Column(name = "init_price",nullable = true)
	 Double INIT_PRICE;
     
     @Column(name = "offerprice",nullable = true)
	 Double OFFERPRICE;
     
     @Column(name = "nfo_open",nullable = true)
	 java.util.Date NFO_OPEN;
     
     @Column(name = "nfo_close",nullable = true)
	 java.util.Date NFO_CLOSE;
     
     @Column(name = "reopen_dt",nullable = true)
	 java.util.Date REOPEN_DT;
     
     @Column(name = "elf",nullable = true)
	 String ELF;
     
     @Column(name = "etf",nullable = true)
	 String ETF;
	 
     @Column(name = "stp",nullable = true)
     String STP;
     
     @Column(name = "primary_fund",nullable = true)
	 String PRIMARY_FUND;
     
     @Column(name = "primary_fd_code",nullable = true)
	 long PRIMARY_FD_CODE;
     
     @Column(name = "sip",nullable = true)
	 String SIP;
     
     @Column(name = "swp",nullable = true)
	 String SWP;
     
     @Column(name = "switch",nullable = true)
	 String SWITCH;
     
     @Column(name = "mininvt",nullable = true)
	 Double MININVT;
     
     @Column(name = "multiples",nullable = true)
     Integer MULTIPLES;
     
     @Column(name = "inc_invest",nullable = true)
	 Double INC_INVEST;
     
     @Column(name = "adnmultiples",nullable = true)
	 Double ADNMULTIPLES;
     
     @Column(name = "fund_mgr1",nullable = true)
	 String FUND_MGR1;
     
     @Column(name = "fund_mgr2",nullable = true)
	 String FUND_MGR2;
     
     @Column(name = "fund_mgr3",nullable = true)
	 String FUND_MGR3;
	 
     @Column(name = "fund_mgr4",nullable = true)
     String FUND_MGR4;
	 
     @Column(name = "since",nullable = true)
     java.util.Date SINCE;
	 
     @Column(name = "status",nullable = true)
     String STATUS;
	 
     @Column(name = "cutsub",nullable = true)
     String CUTSUB;
	 
     @Column(name = "cutred",nullable = true)
     String CUTRED;
	 
     @Column(name = "red",nullable = true)
     String RED;
     
     @Column(name = "mob_name",nullable = true)
	 String MOB_NAME;
     
     @Column(name = "div_freq",nullable = true)
     Integer DIV_FREQ;
     
     @Column(name = "scheme_symbol",nullable = true)
	 String Scheme_Symbol;
     
     @Column(name = "fund_mgr_code1",nullable = true)
     Integer FUND_MGR_CODE1;
	 
     @Column(name = "fund_mgr_code2",nullable = true)
     Integer FUND_MGR_CODE2;
     
     @Column(name = "fund_mgr_code3",nullable = true)
     Integer FUND_MGR_CODE3;
     
     @Column(name = "fund_mgr_code4",nullable = true)
     Integer FUND_MGR_CODE4;
     
     @Column(name = "redemption_date",nullable = true)
	 java.util.Date Redemption_date;
     
     @Column(name = "dateofallot",nullable = true)
	 java.util.Date DateOfAllot;
     
     @Column(name = "div_code",nullable = true)
	 Double Div_Code;
     
     @Column(name = "legalnames",nullable = true)
	 String LegalNames;
     
     @Column(name = "amfitype",nullable = true)
	 String AMFIType;
     
     @Column(name = "nontxnday",nullable = true)
	 String NonTxnDay;
     
     @Column(name = "schemebank",nullable = true)
	 String SchemeBank;
     
     @Column(name = "schemebankaccountnumber",nullable = true)
	 String SchemeBankAccountNumber;
     
     @Column(name = "schemebankbranch",nullable = true)
	 String SchemeBankBranch;
     
     @Column(name = "dividendoptionflag",nullable = true)
	 String DividendOptionFlag;
     
     @Column(name = "lockinperiod",nullable = true)
	 String LockInPeriod;
     
     @Column(name = "ispurchaseavailable",nullable = true)
	 String IsPurchaseAvailable;
     
     @Column(name = "isredeemavailable",nullable = true)
	 String IsRedeemAvailable;
     
     @Column(name = "minredemptionamount",nullable = true)
	 Double MinRedemptionAmount;
     
     @Column(name = "redemptionmultipleamount",nullable = true)
	 Double RedemptionMultipleAmount;
     
     @Column(name = "minredemptionunits",nullable = true)
	 Double MinRedemptionUnits;
     
     @Column(name = "redemptionmultiplesunits",nullable = true)
	 Double RedemptionMultiplesUnits;
     
     @Column(name = "minswitchamount",nullable = true)
	 Double MinSwitchAmount;
     
     @Column(name = "switchmultipleamount",nullable = true)
	 Double SwitchMultipleAmount;
     
     @Column(name = "minswitchunits",nullable = true)
	 Double MinSwitchUnits;
     
     @Column(name = "switchmultiplesunits",nullable = true)
	 Double SwitchMultiplesUnits;
     
     @Column(name = "securitycode",nullable = true)
	 String SecurityCode;
     
     @Column(name = "unit",nullable = true)
	 String Unit;
     
     @Column(name = "switchout",nullable = true)
	 String SwitchOut;
     
     @Column(name = "minswitchoutamount",nullable = true)
	 Double MinSwitchOutAmount;
     
     @Column(name = "switchoutmultipleamount",nullable = true)
	 Double SwitchOutMultipleAmount;
     
     @Column(name = "minswitchoutunits",nullable = true)
	 Double MinSwitchOutUnits;
     
     @Column(name = "switchoutmultiplesunits",nullable = true)
	 Double SwitchOutMultiplesUnits;
     
     @Column(name = "incept_date",nullable = true)
	 java.util.Date Incept_date;
     
     @Column(name = "incept_nav",nullable = true)
	 Double Incept_Nav;
     
     @Column(name = "defaultopt",nullable = true)
	 String DefaultOpt;
     
     @Column(name = "defaultplan",nullable = true)
	 String DefaultPlan;
     
     @Column(name = "lockperiod",nullable = true)
     Integer LockPeriod;
     
     @Column(name = "oddraftdate",nullable = true)
	 java.util.Date ODDraftDate;
     
//     @Column(name = "rv_classification")
//	 String RV_Classification;
	 
	 
	 
	 
	 
	 public Scheme_Detail()
	 {
		 
	 }
	 
	public void Copy_Objects(Scheme_Detail obj) {
		
		scheme_code = obj.scheme_code;
		AMFI_CODE = obj.AMFI_CODE;
		CAMS_CODE = obj.CAMS_CODE;
		AMC_CODE = obj.AMC_CODE;
		S_NAME = obj.S_NAME;
		AMFI_NAME = obj.AMFI_NAME;
		ISIN_CODE = obj.ISIN_CODE;
		TYPE_CODE = obj.TYPE_CODE;
		OPT_CODE = obj.OPT_CODE;
		CLASSCODE = obj.CLASSCODE;
		THEME_CODE = obj.THEME_CODE;
		RT_CODE = obj.RT_CODE;
		PLAN = obj.PLAN;
		CUST_CODE = obj.CUST_CODE;
		CUST_CODE2 = obj.CUST_CODE2;
		PRICE_FREQ = obj.PRICE_FREQ;
		INIT_PRICE = obj.INIT_PRICE;
		OFFERPRICE = obj.OFFERPRICE;
		NFO_OPEN = obj.NFO_OPEN;
		NFO_CLOSE = obj.NFO_CLOSE;
		REOPEN_DT = obj.REOPEN_DT;
		ELF = obj.ELF;
		ETF = obj.ETF;
		STP = obj.STP;
		PRIMARY_FUND = obj.PRIMARY_FUND;
		PRIMARY_FD_CODE = obj.PRIMARY_FD_CODE;
		SIP = obj.SIP;
		SWP = obj.SWP;
		SWITCH = obj.SWITCH;
		MININVT = obj.MININVT;
		MULTIPLES = obj.MULTIPLES;
		INC_INVEST = obj.INC_INVEST;
		ADNMULTIPLES = obj.ADNMULTIPLES;
		FUND_MGR1 = obj.FUND_MGR1;
		FUND_MGR2 = obj.FUND_MGR2;
		FUND_MGR3 = obj.FUND_MGR3;
		FUND_MGR4 = obj.FUND_MGR4;
		SINCE = obj.SINCE;
		STATUS = obj.STATUS;
		CUTSUB = obj.CUTSUB;
		CUTRED = obj.CUTRED;
		RED = obj.RED;
		MOB_NAME = obj.MOB_NAME;
		DIV_FREQ = obj.DIV_FREQ;
		Scheme_Symbol = obj.Scheme_Symbol;
		FUND_MGR_CODE1 = obj.FUND_MGR_CODE1;
		FUND_MGR_CODE2 = obj.FUND_MGR_CODE2;
		FUND_MGR_CODE3 = obj.FUND_MGR_CODE3;
		FUND_MGR_CODE4 = obj.FUND_MGR_CODE4;
		Redemption_date = obj.Redemption_date;
		DateOfAllot = obj.DateOfAllot;
		Div_Code = obj.Div_Code;
		LegalNames = obj.LegalNames;
		AMFIType = obj.AMFIType;
		NonTxnDay = obj.NonTxnDay;
		SchemeBank = obj.SchemeBank;
		SchemeBankAccountNumber = obj.SchemeBankAccountNumber;
		SchemeBankBranch = obj.SchemeBankBranch;
		DividendOptionFlag = obj.DividendOptionFlag;
		LockInPeriod = obj.LockInPeriod;
		IsPurchaseAvailable = obj.IsPurchaseAvailable;
		IsRedeemAvailable = obj.IsRedeemAvailable;
		MinRedemptionAmount = obj.MinRedemptionAmount;
		RedemptionMultipleAmount = obj.RedemptionMultipleAmount;
		MinRedemptionUnits = obj.MinRedemptionUnits;
		RedemptionMultiplesUnits = obj.RedemptionMultiplesUnits;
		MinSwitchAmount = obj.MinSwitchAmount;
		SwitchMultipleAmount = obj.SwitchMultipleAmount;
		MinSwitchUnits = obj.MinSwitchUnits;
		SwitchMultiplesUnits = obj.SwitchMultiplesUnits;
		SecurityCode = obj.SecurityCode;
		Unit = obj.Unit;
		SwitchOut = obj.SwitchOut;
		MinSwitchOutAmount = obj.MinSwitchOutAmount;
		SwitchOutMultipleAmount = obj.SwitchOutMultipleAmount;
		MinSwitchOutUnits = obj.MinSwitchOutUnits;
		SwitchOutMultiplesUnits = obj.SwitchOutMultiplesUnits;
		Incept_date = obj.Incept_date;
		Incept_Nav = obj.Incept_Nav;
		DefaultOpt = obj.DefaultOpt;
		DefaultPlan = obj.DefaultPlan;
		LockPeriod = obj.LockPeriod;
		ODDraftDate = obj.ODDraftDate;
//		RV_Classification = obj.RV_Classification;
	}
	public long getScheme_code() {
		return scheme_code;
	}
	public void setScheme_code(long scheme_code) {
		this.scheme_code = scheme_code;
	}
	public long getAMFI_CODE() {
		return AMFI_CODE;
	}
	public void setAMFI_CODE(long aMFI_CODE) {
		AMFI_CODE = aMFI_CODE;
	}
	public String getCAMS_CODE() {
		return CAMS_CODE;
	}
	public void setCAMS_CODE(String cAMS_CODE) {
		CAMS_CODE = cAMS_CODE;
	}
	public long getAMC_CODE() {
		return AMC_CODE;
	}
	public void setAMC_CODE(long aMC_CODE) {
		AMC_CODE = aMC_CODE;
	}
	public String getS_NAME() {
		return S_NAME;
	}
	public void setS_NAME(String s_NAME) {
		S_NAME = s_NAME;
	}
	public String getAMFI_NAME() {
		return AMFI_NAME;
	}
	public void setAMFI_NAME(String aMFI_NAME) {
		AMFI_NAME = aMFI_NAME;
	}
	public String getISIN_CODE() {
		return ISIN_CODE;
	}
	public void setISIN_CODE(String iSIN_CODE) {
		ISIN_CODE = iSIN_CODE;
	}
	public Integer getTYPE_CODE() {
		return TYPE_CODE;
	}
	public void setTYPE_CODE(Integer tYPE_CODE) {
		TYPE_CODE = tYPE_CODE;
	}
	public Integer getOPT_CODE() {
		return OPT_CODE;
	}
	public void setOPT_CODE(Integer oPT_CODE) {
		OPT_CODE = oPT_CODE;
	}
	public Integer getCLASSCODE() {
		return CLASSCODE;
	}
	public void setCLASSCODE(Integer cLASSCODE) {
		CLASSCODE = cLASSCODE;
	}
	public Integer getTHEME_CODE() {
		return THEME_CODE;
	}
	public void setTHEME_CODE(Integer tHEME_CODE) {
		THEME_CODE = tHEME_CODE;
	}
	public Integer getRT_CODE() {
		return RT_CODE;
	}
	public void setRT_CODE(Integer rT_CODE) {
		RT_CODE = rT_CODE;
	}
	public Integer getPLAN() {
		return PLAN;
	}
	public void setPLAN(Integer pLAN) {
		PLAN = pLAN;
	}
	public Integer getCUST_CODE() {
		return CUST_CODE;
	}
	public void setCUST_CODE(Integer cUST_CODE) {
		CUST_CODE = cUST_CODE;
	}
	public Integer getCUST_CODE2() {
		return CUST_CODE2;
	}
	public void setCUST_CODE2(Integer cUST_CODE2) {
		CUST_CODE2 = cUST_CODE2;
	}
	public Integer getPRICE_FREQ() {
		return PRICE_FREQ;
	}
	public void setPRICE_FREQ(Integer pRICE_FREQ) {
		PRICE_FREQ = pRICE_FREQ;
	}
	public Double getINIT_PRICE() {
		return INIT_PRICE;
	}
	public void setINIT_PRICE(Double iNIT_PRICE) {
		INIT_PRICE = iNIT_PRICE;
	}
	public Double getOFFERPRICE() {
		return OFFERPRICE;
	}
	public void setOFFERPRICE(Double oFFERPRICE) {
		OFFERPRICE = oFFERPRICE;
	}
	public java.util.Date getNFO_OPEN() {
		return NFO_OPEN;
	}
	public void setNFO_OPEN(java.util.Date nFO_OPEN) {
		NFO_OPEN = nFO_OPEN;
	}
	public java.util.Date getNFO_CLOSE() {
		return NFO_CLOSE;
	}
	public void setNFO_CLOSE(java.util.Date nFO_CLOSE) {
		NFO_CLOSE = nFO_CLOSE;
	}
	public java.util.Date getREOPEN_DT() {
		return REOPEN_DT;
	}
	public void setREOPEN_DT(java.util.Date rEOPEN_DT) {
		REOPEN_DT = rEOPEN_DT;
	}
	public String getELF() {
		return ELF;
	}
	public void setELF(String eLF) {
		ELF = eLF;
	}
	public String getETF() {
		return ETF;
	}
	public void setETF(String eTF) {
		ETF = eTF;
	}
	public String getSTP() {
		return STP;
	}
	public void setSTP(String sTP) {
		STP = sTP;
	}
	public String getPRIMARY_FUND() {
		return PRIMARY_FUND;
	}
	public void setPRIMARY_FUND(String pRIMARY_FUND) {
		PRIMARY_FUND = pRIMARY_FUND;
	}
	public long getPRIMARY_FD_CODE() {
		return PRIMARY_FD_CODE;
	}
	public void setPRIMARY_FD_CODE(long pRIMARY_FD_CODE) {
		PRIMARY_FD_CODE = pRIMARY_FD_CODE;
	}
	public String getSIP() {
		return SIP;
	}
	public void setSIP(String sIP) {
		SIP = sIP;
	}
	public String getSWP() {
		return SWP;
	}
	public void setSWP(String sWP) {
		SWP = sWP;
	}
	public String getSWITCH() {
		return SWITCH;
	}
	public void setSWITCH(String sWITCH) {
		SWITCH = sWITCH;
	}
	public Double getMININVT() {
		return MININVT;
	}
	public void setMININVT(Double mININVT) {
		MININVT = mININVT;
	}
	public Integer getMULTIPLES() {
		return MULTIPLES;
	}
	public void setMULTIPLES(Integer mULTIPLES) {
		MULTIPLES = mULTIPLES;
	}
	public Double getINC_INVEST() {
		return INC_INVEST;
	}
	public void setINC_INVEST(Double iNC_INVEST) {
		INC_INVEST = iNC_INVEST;
	}
	public Double getADNMULTIPLES() {
		return ADNMULTIPLES;
	}
	public void setADNMULTIPLES(Double aDNMULTIPLES) {
		ADNMULTIPLES = aDNMULTIPLES;
	}
	public String getFUND_MGR1() {
		return FUND_MGR1;
	}
	public void setFUND_MGR1(String fUND_MGR1) {
		FUND_MGR1 = fUND_MGR1;
	}
	public String getFUND_MGR2() {
		return FUND_MGR2;
	}
	public void setFUND_MGR2(String fUND_MGR2) {
		FUND_MGR2 = fUND_MGR2;
	}
	public String getFUND_MGR3() {
		return FUND_MGR3;
	}
	public void setFUND_MGR3(String fUND_MGR3) {
		FUND_MGR3 = fUND_MGR3;
	}
	public String getFUND_MGR4() {
		return FUND_MGR4;
	}
	public void setFUND_MGR4(String fUND_MGR4) {
		FUND_MGR4 = fUND_MGR4;
	}
	public java.util.Date getSINCE() {
		return SINCE;
	}
	public void setSINCE(java.util.Date sINCE) {
		SINCE = sINCE;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getCUTSUB() {
		return CUTSUB;
	}
	public void setCUTSUB(String cUTSUB) {
		CUTSUB = cUTSUB;
	}
	public String getCUTRED() {
		return CUTRED;
	}
	public void setCUTRED(String cUTRED) {
		CUTRED = cUTRED;
	}
	public String getRED() {
		return RED;
	}
	public void setRED(String rED) {
		RED = rED;
	}
	public String getMOB_NAME() {
		return MOB_NAME;
	}
	public void setMOB_NAME(String mOB_NAME) {
		MOB_NAME = mOB_NAME;
	}
	public Integer getDIV_FREQ() {
		return DIV_FREQ;
	}
	public void setDIV_FREQ(Integer dIV_FREQ) {
		DIV_FREQ = dIV_FREQ;
	}
	public String getScheme_Symbol() {
		return Scheme_Symbol;
	}
	public void setScheme_Symbol(String scheme_Symbol) {
		Scheme_Symbol = scheme_Symbol;
	}
	public Integer getFUND_MGR_CODE1() {
		return FUND_MGR_CODE1;
	}
	public void setFUND_MGR_CODE1(Integer fUND_MGR_CODE1) {
		FUND_MGR_CODE1 = fUND_MGR_CODE1;
	}
	public Integer getFUND_MGR_CODE2() {
		return FUND_MGR_CODE2;
	}
	public void setFUND_MGR_CODE2(Integer fUND_MGR_CODE2) {
		FUND_MGR_CODE2 = fUND_MGR_CODE2;
	}
	public Integer getFUND_MGR_CODE3() {
		return FUND_MGR_CODE3;
	}
	public void setFUND_MGR_CODE3(Integer fUND_MGR_CODE3) {
		FUND_MGR_CODE3 = fUND_MGR_CODE3;
	}
	public Integer getFUND_MGR_CODE4() {
		return FUND_MGR_CODE4;
	}
	public void setFUND_MGR_CODE4(Integer fUND_MGR_CODE4) {
		FUND_MGR_CODE4 = fUND_MGR_CODE4;
	}
	public java.util.Date getRedemption_date() {
		return Redemption_date;
	}
	public void setRedemption_date(java.util.Date redemption_date) {
		Redemption_date = redemption_date;
	}
	public java.util.Date getDateOfAllot() {
		return DateOfAllot;
	}
	public void setDateOfAllot(java.util.Date dateOfAllot) {
		DateOfAllot = dateOfAllot;
	}
	public Double getDiv_Code() {
		return Div_Code;
	}
	public void setDiv_Code(Double div_Code) {
		Div_Code = div_Code;
	}
	public String getLegalNames() {
		return LegalNames;
	}
	public void setLegalNames(String legalNames) {
		LegalNames = legalNames;
	}
	public String getAMFIType() {
		return AMFIType;
	}
	public void setAMFIType(String aMFIType) {
		AMFIType = aMFIType;
	}
	public String getNonTxnDay() {
		return NonTxnDay;
	}
	public void setNonTxnDay(String nonTxnDay) {
		NonTxnDay = nonTxnDay;
	}
	public String getSchemeBank() {
		return SchemeBank;
	}
	public void setSchemeBank(String schemeBank) {
		SchemeBank = schemeBank;
	}
	public String getSchemeBankAccountNumber() {
		return SchemeBankAccountNumber;
	}
	public void setSchemeBankAccountNumber(String schemeBankAccountNumber) {
		SchemeBankAccountNumber = schemeBankAccountNumber;
	}
	public String getSchemeBankBranch() {
		return SchemeBankBranch;
	}
	public void setSchemeBankBranch(String schemeBankBranch) {
		SchemeBankBranch = schemeBankBranch;
	}
	public String getDividendOptionFlag() {
		return DividendOptionFlag;
	}
	public void setDividendOptionFlag(String dividendOptionFlag) {
		DividendOptionFlag = dividendOptionFlag;
	}
	public String getLockInPeriod() {
		return LockInPeriod;
	}
	public void setLockInPeriod(String lockInPeriod) {
		LockInPeriod = lockInPeriod;
	}
	public String getIsPurchaseAvailable() {
		return IsPurchaseAvailable;
	}
	public void setIsPurchaseAvailable(String isPurchaseAvailable) {
		IsPurchaseAvailable = isPurchaseAvailable;
	}
	public String getIsRedeemAvailable() {
		return IsRedeemAvailable;
	}
	public void setIsRedeemAvailable(String isRedeemAvailable) {
		IsRedeemAvailable = isRedeemAvailable;
	}
	public Double getMinRedemptionAmount() {
		return MinRedemptionAmount;
	}
	public void setMinRedemptionAmount(Double minRedemptionAmount) {
		MinRedemptionAmount = minRedemptionAmount;
	}
	public Double getRedemptionMultipleAmount() {
		return RedemptionMultipleAmount;
	}
	public void setRedemptionMultipleAmount(Double redemptionMultipleAmount) {
		RedemptionMultipleAmount = redemptionMultipleAmount;
	}
	public Double getMinRedemptionUnits() {
		return MinRedemptionUnits;
	}
	public void setMinRedemptionUnits(Double minRedemptionUnits) {
		MinRedemptionUnits = minRedemptionUnits;
	}
	public Double getRedemptionMultiplesUnits() {
		return RedemptionMultiplesUnits;
	}
	public void setRedemptionMultiplesUnits(Double redemptionMultiplesUnits) {
		RedemptionMultiplesUnits = redemptionMultiplesUnits;
	}
	public Double getMinSwitchAmount() {
		return MinSwitchAmount;
	}
	public void setMinSwitchAmount(Double minSwitchAmount) {
		MinSwitchAmount = minSwitchAmount;
	}
	public Double getSwitchMultipleAmount() {
		return SwitchMultipleAmount;
	}
	public void setSwitchMultipleAmount(Double switchMultipleAmount) {
		SwitchMultipleAmount = switchMultipleAmount;
	}
	public Double getMinSwitchUnits() {
		return MinSwitchUnits;
	}
	public void setMinSwitchUnits(Double minSwitchUnits) {
		MinSwitchUnits = minSwitchUnits;
	}
	public Double getSwitchMultiplesUnits() {
		return SwitchMultiplesUnits;
	}
	public void setSwitchMultiplesUnits(Double switchMultiplesUnits) {
		SwitchMultiplesUnits = switchMultiplesUnits;
	}
	public String getSecurityCode() {
		return SecurityCode;
	}
	public void setSecurityCode(String securityCode) {
		SecurityCode = securityCode;
	}
	public String getUnit() {
		return Unit;
	}
	public void setUnit(String unit) {
		Unit = unit;
	}
	public String getSwitchOut() {
		return SwitchOut;
	}
	public void setSwitchOut(String switchOut) {
		SwitchOut = switchOut;
	}
	public Double getMinSwitchOutAmount() {
		return MinSwitchOutAmount;
	}
	public void setMinSwitchOutAmount(Double minSwitchOutAmount) {
		MinSwitchOutAmount = minSwitchOutAmount;
	}
	public Double getSwitchOutMultipleAmount() {
		return SwitchOutMultipleAmount;
	}
	public void setSwitchOutMultipleAmount(Double switchOutMultipleAmount) {
		SwitchOutMultipleAmount = switchOutMultipleAmount;
	}
	public Double getMinSwitchOutUnits() {
		return MinSwitchOutUnits;
	}
	public void setMinSwitchOutUnits(Double minSwitchOutUnits) {
		MinSwitchOutUnits = minSwitchOutUnits;
	}
	public Double getSwitchOutMultiplesUnits() {
		return SwitchOutMultiplesUnits;
	}
	public void setSwitchOutMultiplesUnits(Double switchOutMultiplesUnits) {
		SwitchOutMultiplesUnits = switchOutMultiplesUnits;
	}
	public java.util.Date getIncept_date() {
		return Incept_date;
	}
	public void setIncept_date(java.util.Date incept_date) {
		Incept_date = incept_date;
	}
	public Double getIncept_Nav() {
		return Incept_Nav;
	}
	public void setIncept_Nav(Double incept_Nav) {
		Incept_Nav = incept_Nav;
	}
	public String getDefaultOpt() {
		return DefaultOpt;
	}
	public void setDefaultOpt(String defaultOpt) {
		DefaultOpt = defaultOpt;
	}
	public String getDefaultPlan() {
		return DefaultPlan;
	}
	public void setDefaultPlan(String defaultPlan) {
		DefaultPlan = defaultPlan;
	}
	public Integer getLockPeriod() {
		return LockPeriod;
	}
	public void setLockPeriod(Integer lockPeriod) {
		LockPeriod = lockPeriod;
	}
	public java.util.Date getODDraftDate() {
		return ODDraftDate;
	}
	public void setODDraftDate(java.util.Date oDDraftDate) {
		ODDraftDate = oDDraftDate;
	}
//	public String getRV_Classification() {
//		return RV_Classification;
//	}
//	public void setRV_Classification(String rV_Classification) {
//		RV_Classification = rV_Classification;
//	}
	 
	 
	 
	 
	 
	 

}

