package Others_Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import Others_Model.Client_Databse_email;
import sessionFactory.HIbernateSession;

public class Generate_DataBase_excel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session ssn = null;
		FileInputStream fis = null;	
		String fileName=null;  
		ArrayList<Client_Databse_email> cd_list = new ArrayList<Client_Databse_email>();
		int db_flag=1;
		
try {	
		File folder = new File("/home/rv/Downloads/pan-India-mails/Pan_India_Data_Base_1/Confidential/Bangalore Data 500/banglore HNI");   // complete folder path
		File[] listOfFiles = folder.listFiles(new FilenameFilter() { @Override public boolean accept(File dir, String name) { return name.endsWith(".xls") || name.endsWith(".xlsx") ; } });
        
		
		    for (int i = 0; i < listOfFiles.length; i++) {
		      if (listOfFiles[i].isFile()) 
		      {
		    	  fis = new FileInputStream(listOfFiles[i]);
		    	  
		    	  fileName = listOfFiles[i].getName();
		    	  
		    	  Workbook workbook = null;
		    	  
		    	  try
		    	  {
		    		if(fileName.toLowerCase().endsWith("xlsx"))
					{
						workbook = new XSSFWorkbook(fis);
					}
					else if(fileName.toLowerCase().endsWith("xls"))
					{  
						try
						{
							workbook = new HSSFWorkbook(fis);
						}
						catch ( org.apache.poi.poifs.filesystem.OfficeXmlFileException e) 
						{
							fis = new FileInputStream(listOfFiles[i]);	
							workbook = new XSSFWorkbook(fis);
						}
//						workbook = new HSSFWorkbook(fis);
//						workbook = new XSSFWorkbook(fis);
						
					}
		    	  }
		    	  catch (org.apache.poi.EncryptedDocumentException e) 
		    	  {
					
					 System.out.println(fileName+" is Password Protected---Skipping to next Files");
					 fis.close();
					 continue;
				  }
		    		 
		    		
		    		 int no_of_sheets = workbook.getNumberOfSheets();
		    		 
		    		 for(int s=0;s<no_of_sheets;s++)
		    		 {
		    			 Sheet sheet = workbook.getSheetAt(s);
		    			 
		    			 cd_list =  findEmail(sheet,"@",cd_list);
		    			 
		    		 }
		    		 
		    		 
		       workbook.close();	  
		       fis.close();
		    	   
		      } 
		      
		      
		       
		           
		    }
		    
//		    System.out.println("ArrayList Size--->>"+cd_list.size());
		    if(cd_list.size() > 0)
		    {
			ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    
		    Criteria criteria = ssn.createCriteria(Client_Databse_email.class)
		    	    .setProjection(Projections.max("id"));
		     long max_id = (long) criteria.uniqueResult();
		     
		    for(Client_Databse_email obj : cd_list)
		    {
//		    	Client_Databse_email oo = null;
//		    	oo = ssn.get(Client_Databse_email.class, obj.getEmail());
		    	
		    	
//		    	if(oo!=null && oo.getEmail()!=null)
//		    	{
//		    		
//		    	}
//		    	else
//		    	{  
		    	    max_id++;
		    	    obj.setId(max_id);
		    		ssn.save(obj);
		    		db_flag++;
		    		
		    		if(db_flag%50==0)
		    		{
		    			ssn.flush();
		    			ssn.clear();
		    			ssn.getTransaction().commit();
		    			ssn.beginTransaction();
		    			db_flag=1;
		    		}
//		    	}
		    	
		    	
		    }
		    
		    System.out.println("ArrayList Size-->>"+cd_list.size());
		   }
		    
     }
catch(Exception e)
    {     
	      System.out.println("File Name--->>"+fileName); 
	      
	      System.out.println("Error Message--->>"+e.getMessage());
	      
	      e.printStackTrace();
    }
finally
{   
//	ssn.getTransaction().commit();
	if(ssn!=null)
	{
	ssn.close();
	}
	System.out.println("<------- Searching Complete------>>>");
}
		

	} 
	
	
	   
	private static ArrayList<Client_Databse_email> findEmail(Sheet sheet, String cellContent, ArrayList<Client_Databse_email> cd_list) {
	  String searched_content=null;
	  String[] splited = null;
	  
	    for (Row row : sheet) {
	        for (Cell cell : row) {
	            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
//	            	System.out.println(cell.getRichStringCellValue().getString());
	                if (cell.getRichStringCellValue().getString().trim().contains(cellContent) && cell.getRichStringCellValue().getString().trim().contains(".") ) {
//	                    return row.getRowNum(); 
	                	
	                	searched_content = cell.getRichStringCellValue().getString();
	                	if(searched_content.length() >= 20)
	                	{
	                		
	                		splited = searched_content.split(" ");
		                	 
		                	for(String ss :splited)
		                	{
		                		if(ss.contains("@"))
		                		{
//		                			System.out.println(ss.trim());
//		                			System.out.println("Validation--->>"+isValidEmailAddress(ss.trim()));
		                			Client_Databse_email cde = new Client_Databse_email();
		                			cde.setEmail(ss.trim());
		                			 if( isValidEmailAddress(ss.trim()) == true )
		                			 {
		                				 cde.setValid_email_address("True"); 
		                			 }
		                			 else
		                			 {
		                				 cde.setValid_email_address("False");	 
		                			 } 
//		                			
		                			 cd_list.add(cde);
		                		}
		                	}
	                		 		
	                	}
	                	else
	                	{
	                		
//	                		System.out.println(searched_content.trim());
//	                		System.out.println("Validation--->>"+isValidEmailAddress(searched_content.trim()));
	                		
	                		Client_Databse_email cde = new Client_Databse_email();
                			cde.setEmail(searched_content.trim());
                			 if( isValidEmailAddress(searched_content.trim()) == true )
                			 {
                				 cde.setValid_email_address("True"); 
                			 }
                			 else
                			 {
                				 cde.setValid_email_address("False");	 
                			 }
                			 
                			 cd_list.add(cde);
	                		
	                	}
	                	
	                	
	                }
	            }
	        }
	    }               
	    return cd_list;
	}
	
	
	
	 public static boolean isValidEmailAddress(String email) 
	 {
         String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
         java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
         java.util.regex.Matcher m = p.matcher(email);
         return m.matches();
     }

	
	
	

}
