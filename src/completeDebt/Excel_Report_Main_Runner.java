package completeDebt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Excel_report_mn;
import model.Avg_ret_Model;
import sessionFactory.HIbernateSession;

public class Excel_Report_Main_Runner 
{
	
	public String Calculate_Excel_Report(String Fund_Type, String scheme_code_list_path)
	{
		 int comment_list_length=0;
//		 String Fund_Type;
         ArrayList<ArrayList<String>> book = new ArrayList<ArrayList<String>>();
         double res=0;
         int rank=0;
         int flag=0;
         ArrayList<String> comment_list = null;
         ArrayList<Long> scheme_code_list = null;
         
         ArrayList<Long> scheme_code_list_temp = new ArrayList<Long>();
         
         
         Session ssn = HIbernateSession.getSessionFactory().openSession();
//		 ssn.beginTransaction();
         
         // Type of fund is responsible for selecting appropriate scheme codes  
//         Fund_Type="EQUITY_ELSS"; // This field is mandatory
//         Fund_Type="EQUITY_SML"; // This field is mandatory
//           Fund_Type="EQUITY_LARGE_CAP_NEW_31.12.2016"; // This field is mandatory
//           Fund_Type="EQUITY_ELSS_NEW_31.12.2016";
//           Fund_Type="EQUITY_MULTI_CAP_NEW_30.9.2016"; // This field is mandatory
//           Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.9.2016";  // has to be passed 
//           Fund_Type="EQUITY_ELSS_NEW_30.9.2016";  // has to be passed               
//             Fund_Type="EQUITY_LARGE_CAP_NEW_31.05.2017";
         
//           Fund_Type="EQUITY_MID_SMALL_CAP_NEW_30.06.2017";  // has to be passed
            
//             Fund_Type="EQUITY_ELSS_NEW_30.06.2017";  // has to be passed
         
//           Fund_Type="EQUITY_ELSS_NEW_31.05.2017";  // has to be passed
//           Fund_Type="EQUITY_MULTI_CAP_NEW_31.03.2017";  // has to be passed
//             Fund_Type="EQUITY_MID_SMALL_CAP_NEW_31.03.2017";  // has to be passed
         
//                         // If required to done MANUALY for some scheme_Code 
//				         long[] schm_cd_lst = {23,407,447,489,716,748,758,903,905,931,933,942,950,1131,1273,1282,1283,1284,1331,1346,1348,1441,1464,1492,1608,1623,1849,1858,1956,1962,1973,2069,2090,2127,2129,2133,2171,2235,2271,2384,2390,2455,2461,2654,2669,2681,2711,2752,2782,2860,2896,3065,3247,3249,3281,3305,3317,3461,3581,3587,3626,3641,3644,4282,4457,4980,5153,6075,7329,7615,7747,7785,7841,7870,7874,8151,8217,8229,8250,8463,9078,9240,11889,12836,12860,12865,14493,14559,15557,16672,16706,21293,21769,24776,25378,25473,25995,26481,26778,27106,27775,28707,29082,29277,29359,29360,29424,29786,30021,30022,30395,30396,30397,31046,31353,31451,31571,31642,31837,32280,32348,32542,32658,33053,35321};
//				         
//				         for(long b : schm_cd_lst)
//				         {
//				        	 scheme_code_list_temp.add(b);
//				         }
//				         
//				         System.out.println("Added to list Successfully......");
//				         
//				         comment_list = (ArrayList<String>) ssn.createQuery("select DISTINCT(comment) from avg_return where scheme_code IN :list and Fund_Type='"+Fund_Type+"' order by end_dt ").setParameterList("list", scheme_code_list_temp).list();
//				         scheme_code_list = (ArrayList<Long>) ssn.createQuery("select DISTINCT(key.scheme_code) from avg_return where scheme_code IN :list and Fund_Type='"+Fund_Type+"' order by key.scheme_code ").setParameterList("list", scheme_code_list_temp).list();
//   		comment_list = new ArrayList<String>();
//   		scheme_code_list = new ArrayList<Long>();
//   		
//   		
//   		scheme_code_list.add((long)31642);
//   		comment_list.add("Q2_15");
//   		comment_list.add("Q3_15");
//   		comment_list.add("Q4_15");
//   		comment_list.add("Q1_16");
//   		comment_list.add("Q2_16");
//   		comment_list.add("Q3_16");
//   		comment_list.add("Q4_16");
         
         
//          int schm_cd_lst=15;
         
         
								        Criteria criteria_1 = ssn.createCriteria( Avg_ret_Model.class );
								 		criteria_1.setProjection( Projections.distinct(Projections.property("comment")));
								 		criteria_1.add(Restrictions.eq("key.Fund_Type", Fund_Type));
//								   		criteria_1.add(Restrictions.eq("key.scheme_Code", 33053));
								   		criteria_1.addOrder(Order.asc("end_dt"));
   		
   		
//   		Criteria criteria_2 = ssn.createCriteria( nav_report_3_stable.class );
// 		criteria_2.setProjection( Projections.distinct(Projections.property("scheme_Code")));
// 		criteria_2.add(Restrictions.eq("Fund_Type", Fund_Type));
////   		criteria_1.add(Restrictions.eq("scheme_Code", s_code));
//   		criteria_2.addOrder(Order.asc("scheme_Code"));
   		
									   		Criteria criteria_2 = ssn.createCriteria( Avg_ret_Model.class );
									 		criteria_2.setProjection( Projections.distinct(Projections.property("key.scheme_code")));
									 		criteria_2.add(Restrictions.eq("key.Fund_Type", Fund_Type));
//									   		criteria_2.add(Restrictions.eq("key.scheme_Code", 33053));
									   		criteria_2.addOrder(Order.asc("key.scheme_code"));
   		
   		   		
		comment_list = (ArrayList<String>) criteria_1.list();
		scheme_code_list = (ArrayList<Long>) criteria_2.list();
   		

		
		comment_list_length=comment_list.size();
//		ssn.getTransaction().commit();
 
       ArrayList<String> rows=null;
      for(Long s_code : scheme_code_list)
      {
    	  rows=new ArrayList<String>();
    	  rows.add(s_code.toString());
    	  
        for(String comment:comment_list)
        {
        	 res = Excel_report_mn.Generate_rows(comment ,s_code,ssn,Fund_Type);
        	 rank =Excel_report_mn.Get_Rank(comment ,s_code,ssn,Fund_Type);
        	 
        	 rows.add(Double.toString(res));
        	 rows.add(Integer.toString(rank));
        	 
        }
        
        book.add(rows);  // adding each row in the main list
      } 
      ssn.close();
     
    //Blank workbook
      HSSFWorkbook workbook = new HSSFWorkbook();
      HSSFSheet sheet = workbook.createSheet("AvgReport");
      
           
      comment_list.add(0, "scheme_code");
      int index_tmp=0;
      ArrayList<String> comment_list_revised = new ArrayList<String>(); 
    
      // adding the rank field in the exal files heading
      for(String xx :comment_list)
      { 
		if(index_tmp!=0)
		{
			comment_list_revised.add(xx);
			comment_list_revised.add(xx+"_Rank");
		}
		else
		{
			comment_list_revised.add(xx);
		}
		index_tmp++;
      }
     
      book.add(0, comment_list_revised);
      
      Map<Integer, String[]> data = new TreeMap<Integer, String[]>();
      int ln_no=0;
      for(ArrayList<String> lt : book)
        {
    	  String[] stockArr = new String[lt.size()];
    	  stockArr = lt.toArray(stockArr);
    	  
    	  data.put(++ln_no,stockArr);
    	  
        } 
    	  
      Set<Integer> keyset = data.keySet();
      int rownum = 0;
      for (int key : keyset)
      {
          Row row = sheet.createRow(rownum++);
          Object [] objArr = data.get(key);
          int cellnum = 0;
          for (Object obj : objArr)
          {
             Cell cell = row.createCell(cellnum++);
             if(obj instanceof String)
                  cell.setCellValue((String)obj);
              else if(obj instanceof Integer)
                  cell.setCellValue((Integer)obj);
          }
      }
            
      sheet = Excel_report_mn.Get_Average_Column_WISE(sheet,scheme_code_list.size() ,comment_list_revised.size(), Fund_Type);
      
//      GeneRating the New Sheet With 1 and -1 
        
      Excel_report_mn.Get_Cat_Avg_Indicator( scheme_code_list,comment_list,Fund_Type) ;
       
      
      
      
      try {
			FileOutputStream out = 
					new FileOutputStream(new File("/home/rv/Desktop/SampleReport.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Excel written successfully..");
			
			
			
			
		  }       
      catch (FileNotFoundException e) 
          {
			 e.printStackTrace();
			 
			 return e.getMessage();
			 
		  } catch (IOException e) 
		  {
			  e.printStackTrace();
			  return e.getMessage();
		  }     
//      XSSFWorkbook workbook = new XSSFWorkbook();
//      XSSFSheet sheet = workbook.createSheet("Java Books");
      
      
      return "success";
	}
        
	
}
