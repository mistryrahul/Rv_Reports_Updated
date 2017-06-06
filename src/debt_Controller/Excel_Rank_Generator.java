package debt_Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Session;

import controller.Excel_Rank_generator_Model;
import debt_Model.Hybrid_Report_Model;
import sessionFactory.HIbernateSession;



public class Excel_Rank_Generator {

	public static void main(String[] args){
		 Session ssn=null;
		String fileName = "/home/rv/Desktop/Equity_Rating_31.12.2016.xlsx";
		
		
		LineIterator it_s;
		try {
	       
			FileInputStream fis = new FileInputStream(new File(fileName));
			
			 Workbook workbook = null;
			
			if(fileName.toLowerCase().endsWith("xlsx"))
			{
				workbook = new XSSFWorkbook(fis);
			}
			else if(fileName.toLowerCase().endsWith("xls"))
			{
				workbook = new HSSFWorkbook(fis);
			}
			
			java.util.Date dd=null;
			
			Sheet sheet = workbook.getSheetAt(0);
	        
			Iterator<Row> rowIterator = sheet.iterator();
//	        Stock_rank_db srdb = null;
//			Stock_rank_db_PK pkk = null;
			
			long temp_acc_code=0;
			String temp_Compname=null;
			int row_incrementor=0;
			
			ArrayList<Excel_Rank_generator_Model> rank_list = new ArrayList<Excel_Rank_generator_Model>();
			
			
			while (rowIterator.hasNext()) 
	        {
				 			 
				Row row = rowIterator.next();
				 
				   Iterator<Cell> cellIterator = row.cellIterator();
				   int cell_counter=0;
				   
				   temp_acc_code=0;
				   temp_Compname=null;
				   
				   Excel_Rank_generator_Model rm = new Excel_Rank_generator_Model();
				  
				  
				   
					while (cellIterator.hasNext()) 
		               {
				    	   Cell cell = cellIterator.next();
				    	   
				    	   if(cell.getCellType()== Cell.CELL_TYPE_STRING )
				    	   {
				    		   if(cell_counter==1)
				    		   {
//				    			   crsg.setClassification(cell.getStringCellValue());
//				    			   System.out.print("Classification-(1)->"+cell.getStringCellValue()+"\t");
				    		   }
				    		   else
				    		   {
//				    			   System.out.print("Rv_Group-(4)->"+cell.getStringCellValue()+"\t");
//				    			   crsg.setRv_group(cell.getStringCellValue());
				    		   }
				    	   }
				    	   else if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC )
				    	   {
				    		   
				    		 if( DateUtil.isCellDateFormatted(cell))
				    		  {
//			    			  System.out.println("DATE-(2)->>"+cell.getDateCellValue()+"\t");
				    			  				    			  
//				    			  crsg.setInv_date(dd);
				    			  if(cell_counter==0)
				    			  {
				    				  dd = cell.getDateCellValue();
				    				   rm.setDay(dd);
				    			  }
				    			  
				    			  
				    		  }
				    		  else
				    		  {
				    			    if(cell_counter==1)
				    			    {
//				    				   temp_acc_code = (long) cell.getNumericCellValue();
//				    				   System.out.print("Scheme_Code-(0)->"+cell.getNumericCellValue() +"\t");
//				    				   System.out.println("Scheme_Code-->>"+cell.getNumericCellValue());  				   
//				    				   scheme_code_list.add((int) cell.getNumericCellValue());			 
				    				   rm.setScheme_code((long) cell.getNumericCellValue());
				    			    }
				    			    if(cell_counter==15)
				    			    { 
				    			    	rm.setAum(cell.getNumericCellValue());
				    			    }
				    			    if(cell_counter==16)
				    			    {
				    			     	rm.setScore(cell.getNumericCellValue());
				    			     	rank_list.add(rm);
				    			    }
				    			    
				    			   else
				    			   {
//				    				   System.out.print("HOlding-(3)->>"+cell.getNumericCellValue() +"\t"); 
//				    				   crsg.setHold_percent((double) cell.getNumericCellValue());
				    			   }
				    		  }
				    	   }
				    	   cell_counter++;
				        }
//					System.out.println();
				 row_incrementor++;
	        }
			
		    ssn = HIbernateSession.getSessionFactory().openSession();
			ssn.beginTransaction();
			
			for(Excel_Rank_generator_Model bb : rank_list)
			{
				ssn.save(bb);
			}
			
		   ssn.getTransaction().commit();
           ssn.beginTransaction();  		 
		   
           ArrayList<Excel_Rank_generator_Model> gnr_lst= (ArrayList<Excel_Rank_generator_Model>) ssn.createQuery("from Excel_Rank_generator_Model").list();
           
           for(Excel_Rank_generator_Model bb : gnr_lst)
           {
        	   if(bb.getAum()<100)
        	   {
        		   bb.setStar("0");
        	   }
        	   
        	   ssn.save(bb);
           }
		       ssn.getTransaction().commit();
		       ssn.beginTransaction();
		       
		       Generate_start_rating(ssn);
		       
		       ssn.beginTransaction();
		       
		       ArrayList<Excel_Rank_generator_Model> gnr_lst_2= (ArrayList<Excel_Rank_generator_Model>) ssn.createQuery("from Excel_Rank_generator_Model").list();    
		      
		       System.out.println("<---Overrighting Excel FIle----->>>");
		       
		       long temp_scheme_code = 0;
		       java.util.Date temp_dd=null;
		       
		       for(Excel_Rank_generator_Model bb : gnr_lst_2)
	           {
		    	   rowIterator = sheet.iterator();
		    	   
		    	   while (rowIterator.hasNext()) 
			        {
						 			 
						Row row = rowIterator.next();
						 
//						   Iterator<Cell> cellIterator = row.cellIterator();
						   int cell_counter=0;
						   
						   temp_acc_code=0;
						   temp_Compname=null;
						   
						
						    
						    if(row.getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC )
						    {
						    	temp_scheme_code = (long) row.getCell(1).getNumericCellValue();
						    	
						    	  if(DateUtil.isCellDateFormatted(row.getCell(0)))
								    {
							    	    temp_dd = row.getCell(0).getDateCellValue();
								    }
						    	
						    }
						    
						  
						    
						    System.out.println("schemecode-->>"+temp_scheme_code);
						    System.out.println("Date-->>"+temp_dd);
						    System.out.println("Start--->>>"+bb.getStar());
						    String mmm = bb.getStar();
						    
						  if(temp_scheme_code==bb.getScheme_code() && (temp_dd.compareTo(bb.getDay()) == 0))
						  {  
							  Cell cell = row.createCell(18);
//							  Cell cell = row.getCell(18);
							  cell.setCellValue(mmm);
							  System.out.println("Found Value-->>"); 
							  break;
							   
						  }
						   
					 
//							while (cellIterator.hasNext()) 
//				               {
//						    	   Cell cell = cellIterator.next();
//						    	   if(cell_counter==0)
//						    	   {
//						    		   if(cell.getNumericCellValue()==bb.getScheme_code() && )
//						    	   }
//						    	   
//				               }
			        }
		    	   
		    	   
	           }
               
		       
		       fis.close();
		       
		   	   OutputStream fileOut = new FileOutputStream(new File(fileName));
//		       FileOutputStream fileOut = new FileOutputStream("C:\\TestData\\POI\\poi-test.xls");
		   	   workbook.write(fileOut);
		   	   workbook.close();
		       fileOut.close();
               
		       
		       if(ssn.createQuery("delete from Excel_Rank_generator_Model").executeUpdate()>0)
		       {
		    	   System.out.println("Delete Complete Successfully");
		       }
           
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			ssn.getTransaction().commit();
			ssn.close();
			System.out.println("----Report Complete----");
		}

	  	   
				

	        	
	}
	 
	private static void Generate_start_rating(Session ssn ) 
	{
//		ssn.getTransaction().commit();
//		ssn.beginTransaction();
		
		int rec_counter=1;
		int tmp_size=0, top_grp_1=0,top_grp_2=0,top_grp_3=0,top_grp_4=0,top_grp_5=0,diff=0;
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//        ssn.beginTransaction();
        
        ArrayList<Excel_Rank_generator_Model> mn_lst_rank_wise = (ArrayList<Excel_Rank_generator_Model>) ssn.createQuery("from Excel_Rank_generator_Model where star is null order by score desc").list();
        tmp_size = mn_lst_rank_wise.size();
        
        top_grp_1=(int) Math.round(tmp_size*.10);
        top_grp_2=(int) Math.round(tmp_size*.25);
        top_grp_3=(int) Math.round(tmp_size*.30);
        top_grp_4=(int) Math.round(tmp_size*.25);
        top_grp_5=(int) Math.round(tmp_size*.10);
        
        if((top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5)>tmp_size)
        {
        	top_grp_5 = top_grp_5 - ( (top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5) - tmp_size );
        }
        else if ((top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5)<tmp_size)
        {
        	diff= (tmp_size - (top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5));
        	if(diff>0)
        	{
        		top_grp_5 = top_grp_5+diff;
        	}
        }
        
//       System.out.println("Size-->"+tmp_size);
//       System.out.println("1->"top_grp_1);
//       System.out.println("2->"+top_grp_2);
//       System.out.println("3->"+top_grp_3);
//       System.out.println("4->"+top_grp_4);
//       System.out.println("5->"+top_grp_5);
        
        for(Excel_Rank_generator_Model ob : mn_lst_rank_wise)
        {
        	
        	 
        		 
             if(rec_counter>=1 && rec_counter<=top_grp_1)
             {
//            	 System.out.println("5 star");
		           	     
		           	  if(ob.getAum()<100)
		         	 {
		           		ob.setStar("Unrated");
		         	 }
		         	 else
		         	 {
		         		ob.setStar("5");
		         	 }
             }
             
             if(rec_counter>top_grp_1 &&  rec_counter<=(top_grp_1+top_grp_2))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("4");
	         	 }
//            	 System.out.println("4 star");
            
             }
             if(rec_counter>(top_grp_1+top_grp_2) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("3");
	         	 }
           	 //            	 System.out.println("3 star");
            
             }
             if(rec_counter>(top_grp_1+top_grp_2+top_grp_3) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("2");
	         	 }
           	 //            	 System.out.println("2 star");
            
             }
             if(rec_counter>(top_grp_1+top_grp_2+top_grp_3+top_grp_4) &&  rec_counter<=(top_grp_1+top_grp_2+top_grp_3+top_grp_4+top_grp_5))
             {
            	 if(ob.getAum()<100)
	         	 {
	           		ob.setStar("Unrated");
	         	 }
	         	 else
	         	 {
	         		ob.setStar("1");
	         	 }
           	 //            	 System.out.println("1 star");
            
             }
             
             
             ssn.update(ob);
        	 rec_counter++;
     
        }
         
       ssn.getTransaction().commit();
//		ssn.close();
	}
}
