package BenchMarkIndex;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;

import sessionFactory.HIbernateSession;

public class Benchmark_main {

	public static void main(String[] args) 
	{
	     String dir_location="/home/rv/Desktop/indicesniftytri";
		 Workbook workbook;
		 Sheet datatypeSheet;
		 Iterator<Row> iterator;
		 Iterator<Cell> cellIterator;
		 String temp_file_name=null;
		 
		 PK_benchmark key=null;
		 benchmark_template obj = null;
		 java.util.Date temp_date=null;
		 Session ssn=null;
		 try
		 {
			 ArrayList<benchmark_template> total_list = new ArrayList<benchmark_template>();
			 ArrayList<String> file_name = new ArrayList<String>();
			 
			 File[] files = new File(dir_location).listFiles();
			
             
			for (File file : files) 
			 {
				if(!file.getName().contains("lock"))
			    {
				    file_name.add(file.getName());
			    }   
			 }
			
							
					 ssn = HIbernateSession.getSessionFactory().openSession(); 
					 ssn.beginTransaction();
					 
					 
					    for(String file : file_name)
						{
//						    if (file.isFile()) 
//						    {     
						    	
						         temp_file_name = file.replaceAll(" ", "_");
						         
						         System.out.println("-=-=-=-=>   "+file.replaceAll(" ", "_")+"  <<-----");
						         
						         workbook = new XSSFWorkbook(new FileInputStream(new File(dir_location+"/"+file)));
						         datatypeSheet = (Sheet) workbook.getSheetAt(0);
						         iterator = datatypeSheet.iterator();   
						          
						         
						         
						         key = new PK_benchmark();
						         obj = new benchmark_template();
						         
				        	     key.setName(temp_file_name);
				        	     
				        	     
				        	     
						         while (iterator.hasNext()) 
						         {
						        	     
//                                           
						                Row currentRow = iterator.next();
						                cellIterator = currentRow.iterator();
						                int counter=0;
						                while (cellIterator.hasNext()) 
						                {
//						                	 SKIPPING THE FIRST ROW AS IT IS a HEADER
						                	if(counter==0)
						                	{
						                		counter++;
						                		continue;
						                	}
						                	
						                    Cell currentCell = cellIterator.next();
						                    //getCellTypeEnum shown as deprecated for version 3.15
						                    //getCellTypeEnum ill be renamed to getCellType starting from version 4.0
						                    if (currentCell.getCellTypeEnum() == CellType.STRING) 
						                    {
						                        System.out.print(currentCell.getStringCellValue() + "-S-");
						                        
						                    } 
						                    else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) 
						                    {
						                    	if (HSSFDateUtil.isCellDateFormatted(currentCell)) 
						                    	{
						                    		temp_date = currentCell.getDateCellValue();
						                    		key.setDate(temp_date);
						                    		obj.setKey(key);						                    		
//						                    		System.out.print(currentCell.getDateCellValue() + "-D-");
						                    	}
						                    	else
						                    	{
//						                    		System.out.print(currentCell.getNumericCellValue() + "-N-");
						                    		obj.setPrice(currentCell.getNumericCellValue());
						                    		total_list.add(obj);
						                            
						                    		
						                    		key = new PK_benchmark();
											        obj = new benchmark_template();
											         
									        	    key.setName(temp_file_name);
						                
						                    	}
						                    	
						                        
						                    }

						                    counter++;
						                }
//						                System.out.println();

//						         }
						         
						         workbook.close();
						    }
						    
						    for(benchmark_template bt : total_list)
							  {
								 ssn.save(bt);
								 
							  }
						    total_list.clear();
						    
						    ssn.getTransaction().commit();
						    ssn.beginTransaction();
						    ssn.clear();
						    ssn.flush();
						    temp_file_name=null;
						    System.out.println("=-=-=-=-=-=<Completed File-> "+temp_file_name+" -=-=-=-=-=-=-"); 
						    
					} 
					
					
					   System.out.println("<------All Files Uploaded------>>");
					  
					 
			 
		 }
		 catch(Exception e)
		 {
//			 System.out.println(temp_file_name);
			 e.printStackTrace();
			 
		 }

	}

}
