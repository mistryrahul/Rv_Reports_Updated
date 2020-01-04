package NewQuarterlyReports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Query;
import org.hibernate.Session;

import sessionFactory.HIbernateSession;

public class test {

	public static void main(String[] args) {
		
		
		
		int ccc = 249061124;
		
		
		
		
		System.out.println(ccc);
		
		
//		ArrayList<String> schemecode_list_path_arr = new ArrayList<String>();
//		ArrayList<String> fund_Type_arr = new ArrayList<String>();
//		
//		
//		schemecode_list_path_arr.add("Equity : Large Cap");
//        schemecode_list_path_arr.add("Equity : Multi Cap");
//        schemecode_list_path_arr.add("Equity : Large & Mid Cap");
//        schemecode_list_path_arr.add("Equity : Mid Cap");
//        schemecode_list_path_arr.add("Equity : Small Cap");
//        schemecode_list_path_arr.add("Equity : Tax Saving (ELSS)");
//        schemecode_list_path_arr.add("Equity : Sectoral - Infrastructure");
//        schemecode_list_path_arr.add("Equity : Thematic - Consumption");
//        schemecode_list_path_arr.add("Hybrid : Equity Oriented");
//        schemecode_list_path_arr.add("Hybrid : Arbitrage");
//        
//        schemecode_list_path_arr.add("Hybrid : Dynamic Asset Allocation");
//        schemecode_list_path_arr.add("Equity : Value / Contra");
//    	 
//        fund_Type_arr.add("EQUITY_LARGE_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_MULTI_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_LARGE_AND_MID_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_MID_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_SMALL_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_ELSS_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_INFRASTRUCTURE_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_THEMATIC_CONSUMPTION_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_HYBRID_EQUITY_ORIENTED_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_HYBRID_ARBITRAGE_CAP_30.09.2018");
//        
//        fund_Type_arr.add("HYBRID_DYNAMIC_ASSET_SELECTION_CAP_30.09.2018");
//        fund_Type_arr.add("EQUITY_VALUE_CONTRA_CAP_30.09.2018");
//		
//        Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//		ssn.beginTransaction();   
//		String scheme_code_list_path; 
//		 for(int i=0 ; i<= 11 ; i++ )
//		 { 
//			 scheme_code_list_path = schemecode_list_path_arr.get(i);
//			  
//			            
//			 Query q11 =  ssn.createSQLQuery("select distinct(schemecode) from scheme_classifications where classification='"+scheme_code_list_path+"'");
//			 List<Integer> temp_schem_code = (List<Integer>) q11.list();
//           System.out.println(schemecode_list_path_arr.get(i)+" -->>"+temp_schem_code.size());
//           
//           for(Integer schemecode1 : temp_schem_code) 
//           {
//        	  Long schemecode = new Long(schemecode1); 
//        	  System.out.println(schemecode);   
//           }
//		 }
//		 
//		 System.out.println("-=-=-=-=-=Report Complete-=-=-=-=");
//		 ssn.close();
		 
		 
		 
		 Date Date_As_On_Report= new Date(118, 8, 30);
		 System.out.println(Date_As_On_Report);
		
		// TODO Auto-generated method stub
//		  Session ssn= null;
//		  ssn = HIbernateSession.getSessionFactory().openSession(); 
//		  ssn.beginTransaction();
//		  
//		NewEquityReportRunner.get_rating_list(ssn, "EQUITY_ELSS_31.03.2018", 3, "2010-06-30");
//		
//		  ssn.close();
		

//		String scheme_code_list_path="/home/rv/Desktop/files_to_upload/elss_old_check.txt";
//		//=-----------------------=========-----------------------------------
//		ArrayList<Long> temp_schem_code = new ArrayList<Long>();
//		
//		try
//		{
//	 	LineIterator it_s = FileUtils.lineIterator(new File(scheme_code_list_path), "UTF-8");
//	  	
//	  	
//	  	   long tmp_val=0;
//		while (it_s.hasNext()) // if the file has lines 
//	   	    { 
//			    tmp_val = Long.valueOf(it_s.nextLine().trim());
//			
//			   if(temp_schem_code.contains(tmp_val)!=true)
//			   {
//			        temp_schem_code.add(tmp_val);
//			        System.out.println("insert");
//			   }
//			   else
//			   {
//				   System.out.println("Repeat");
//			   }
//	   	    }
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//	    ssn.beginTransaction();	
//		
//		for(long ss : temp_schem_code)
//		{
//			System.out.println(ss);
//			List<Object[]> result= ssn.createSQLQuery("select plan,ststus from scheme_details_fulls where schemecode="+ss+" and plan !=5 and type_code=1 and ispurchaseavailable='Y'").list();
//		}
//		 
//		
//		
//		System.out.println("-===-=-Complete=-=-=-=-=-");
//		}
//		catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
		//=-----------------------=========-----------------------------------		
		
//		String c="aa";
//		System.out.println(as.contains(c));
//		if(as.contains(c))
//		{
//			 System.out.println("in alllll");
//		}
//		as.add("aa");
//		as.add("bb");
	}

}
