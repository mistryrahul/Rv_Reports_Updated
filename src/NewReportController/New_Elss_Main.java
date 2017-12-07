package NewReportController;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import New_Elss_Model.Composite_pk;
import New_Elss_Model.New_Elss_Model;
import controller.Avg_return_Main;
import controller.Return_main;
import model.Custom_Merged_Report_W_Rank;
import model.Scheme_Detail;
import model.nav_hist;
import model.nav_report_3_stable;
import sessionFactory.HIbernateSession;

public class New_Elss_Main {

	public static void main(String[] args) 
	{
	   
		String Fund_Type="";
        Session ssn=null;
        try
        {
        	
        	Fund_Type="EQUITY_LARGE_CAP_NEW_30.09.2017";  // has to be passed    
        	
        	
//        	ssn = HIbernateSession.getSessionFactory().openSession(); 
//	         ssn.beginTransaction();
//	        generate_rank(ssn,Fund_Type);
//        	
//        	
//        	System.out.println("<<<<Rank GENERATE--->>");
//
//        	System.exit(0);
        	
            List<Long> scheme_code_lst_lng = new ArrayList<Long>();		  	
		  	List<Long> temp_schem_code = new ArrayList<Long>();
		  	
//		    LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/date_list.txt"), "UTF-8"); 
////			  LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/custom_date_list.txt"), "UTF-8"); 
//		  	while(it.hasNext())
//		     	{
//			            	date_lst.add(it.nextLine());
//		     	}
		  	
		  	
		  	LineIterator it_s = FileUtils.lineIterator(new File("/home/rv/Desktop/files_to_upload/Equity_Large_Cap_Sept_2017.txt"), "UTF-8");
		  	
		  	
		  	
		  	 while (it_s.hasNext()) // if the file has lines 
	            {
		            temp_schem_code.add(Long.parseLong(it_s.nextLine()));
	            }		
		  	
	 
	         System.out.println("File loaded Successfullyy-----");
	        
	           
	         ssn = HIbernateSession.getSessionFactory().openSession(); 
	         ssn.beginTransaction();
	         
		     for(int indx=0;indx<temp_schem_code.size();indx++)
		   	  {
		   		  ArrayList<Scheme_Detail> schm_dtl = (ArrayList<Scheme_Detail>) ssn.createQuery("from scheme_details_fulls where schemecode=? and type_code!=2 and plan!=5").setLong(0, temp_schem_code.get(indx)).list();
		   		    
		   			    if(schm_dtl.size()==0)
		   			    {
		   	               // oo.remove(indx);
		   			    }
		   			    else
		   			    {
		   			    	scheme_code_lst_lng.add(temp_schem_code.get(indx));
		   			    }
		   		   
		   	  }
	         
		     if(scheme_code_lst_lng.size()==0)
			  {
				  System.out.println("NO DATA LEFT TO EXECUTE:---------------");
				  System.out.println("EXIT");
				  System.exit(0);
			  }
	     
	         java.util.Date temp_Date=null;
	         double year_1_temp=-1;
	         double year_3_temp=-1;
	         double year_2_temp=-1;
	         double res=-1;
	         double aum=-1;
	         int db_save=0;
	         
	         Composite_pk new_pk=null;
	         New_Elss_Model new_obj= null;
	         
	         
		     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		     double yr_1=0,yr_3=0,yr_2=0;
		     int counter=0;
		     for(long schemecode : scheme_code_lst_lng)
		     {
		    	 System.out.println("Schemecode-->"+schemecode);
		    	 
		    	 
		    	 
			    	 List<Object[]> result= ssn.createSQLQuery("select * from rolling_returns where schemecode=? and return_1_years is not null").setLong(0,schemecode).list(); 
	//   		      List<Object[]> result= ssn.createSQLQuery("select schemecode, invdate, sum(holdpercentage) as holdpercentage, count(*) as tottal_count, aum from mf_portfolios where schemecode=(select primary_fd_code from scheme_details_fulls where schemecode=?) and invdate>=? and invdate<=? group by invdate").setLong(0,arm.getKey().getScheme_code()).setDate(1,ddd).setDate(2,arm.getKey().getStart_dt()).list();
	   		      
	                 if(result.size()>0)
	                 {
	                	 Object[] data;
//	                	 System.out.println("<<<-=-=-=-=-=-=-=-=-=-=-=-=>>>");
	                 	 for(int y=0;y<result.size();y++)
	                 	 {
	               	      data = result.get(y);
	                	 
	                	  
	               	   
	               	      java.util.Date dd = formatter.parse(data[1].toString());
	               	                
	               	              
	               	       
			               	       if((dd.getMonth()==11 && (dd.getDate()>=24 && dd.getDate()<=31)) || (dd.getMonth()==8 && (dd.getDate()>=23 && dd.getDate()<=30)) || (dd.getMonth()==5 && (dd.getDate()>=23 && dd.getDate()<=30)) || (dd.getMonth()==2 && (dd.getDate()>=24 && dd.getDate()<=31)) )
			               	       {
	//		               	    	System.out.println("New Date--->>"+dd);
			               	    	         
			               	    	        
			               	    	   
			               	    	if(counter==0)
					               	{
//					               		System.out.println("-----------IN ZERO------------");
					               		temp_Date = dd;
	//				               		System.out.println("Temp Date-->>"+temp_Date);
	//				               		System.out.println("DD-->"+dd);
					               	
					               	}
			               	    	
			               	    	  if(temp_Date.getMonth()!=dd.getMonth())
					               	  {
			               	    		  
			               	    		  
			               	    		  
			               	    		nav_hist tmp_obj=null,b=null;
			               	    		
	//				               		if(year_1_temp!=0 || year_3_temp!=0 || year_5_temp!=0) 
	//				               		{   
			               	    		  
			               	    	      new_pk = new Composite_pk();
			           		    	      new_pk.setFund_Type(Fund_Type);
			           		    	      new_pk.setScheme_code(schemecode); 
			               	    		  new_pk.setStart_dt(temp_Date);
			               	    		 
			               	    		  new_obj = new New_Elss_Model();
			               	    		
			               	    		  if(temp_Date.getMonth()==11)
			               	    		  {
	//		               	    			  Q4
			               	    			new_obj.setQuarter("Q4_"+(temp_Date.getYear()+1900));
			               	    		  }
			               	    		  else if(temp_Date.getMonth()==8)
			               	    		  {
	//		               	    			  Q3;
			               	    			new_obj.setQuarter("Q3_"+(temp_Date.getYear()+1900));
			               	    		  }
			               	    		  else if(temp_Date.getMonth()==5)
			               	    		  {
	//		               	    			  Q2
			               	    			new_obj.setQuarter("Q2_"+(temp_Date.getYear()+1900));
			               	    		  }
			               	    		  else if(temp_Date.getMonth()==2)
			               	    		  {
	//		               	    			  Q1;
			               	    			new_obj.setQuarter("Q1_"+(temp_Date.getYear()+1900));
			               	    		  }
			               	    		  else
			               	    		  {
	//		               	    			  no-case
			               	    			new_obj.setQuarter("wrong QUARTER");
			               	    			System.out.println("<<<<<<<<----Wrong Quarter----->>>>>>>");
			               	    			System.exit(0);
			               	    		  }
			               	    		  
			          
			               	    		  
					               			ArrayList<nav_hist> list = get_list_of_dates_db(temp_Date,schemecode);
						               		 if(list.size()>1)
						    		  		 {
						    		  		    tmp_obj = list.get(0);
						    		  		  
//						    		  		  List<nav_hist> mm = get_list_of_dates_db(get_date(temp_Date, 36),schemecode);
						    		  		  List<nav_hist> mm = get_list_of_dates_db(get_date(temp_Date, 12),schemecode); 
						    		  		    
						    		  		  if(mm.size() >= 1) 
								  				{
								  				   b = mm.get(0);						  				 
	//							  				   res = (((tmp_obj.getAdjnavrs() - b.getAdjnavrs())/ b.getAdjnavrs())*100);
								  				   res = (((b.getAdjnavrs() - tmp_obj.getAdjnavrs())/ tmp_obj.getAdjnavrs())*100);								  				  
//								  				  res = (Math.pow(((res/100)+1), 0.333) -1)*100;
	//								               		System.out.println("36 Months-->"+res);
								  				}
						    		  		 }
					               			 
						               		if(res!=-1)	
							               		   new_obj.setForward_36_ret(res);
					               			
//					               		    System.out.println("<------>"+temp_Date+"<----->");
	//					               		System.out.println(year_1_temp);
	//					               		System.out.println(year_3_temp);
	//					               		System.out.println(year_5_temp);
							               	 
					               		    year_1_temp=Calculate_Rolling_Return(ssn,schemecode,temp_Date,1);
					               		 
					               		    if(year_1_temp!=-1)
						               		new_obj.setYear_1_return(year_1_temp);
					               		    
					               		    year_3_temp=Calculate_Rolling_Return(ssn,schemecode,temp_Date,3);
					               		    if(year_3_temp!=-1)
					               		    new_obj.setYear_3_return(year_3_temp);
					               		    
					               		    year_2_temp=Calculate_Rolling_Return(ssn,schemecode,temp_Date,5);
					               		    if(year_2_temp!=-1)
					               		    new_obj.setYear_2_return(year_2_temp);
						               		
					               			
					               		
					               		 
					               		   
					               			
					               			List<Object[]> result_1= ssn.createSQLQuery("SELECT mf.`invdate` , round(mf.`holdpercentage`,2) as holdpercentage, mf.aum FROM `mf_portfolios` mf join scheme_classifications sc on sc.primary_fd_code = mf.schemecode WHERE sc.`schemecode` = ? AND mf.asect_code =1 AND DATE_FORMAT( mf.`invdate` , '%Y-%m-%d' ) =  date_format((select max(date_format(invdate,'%Y-%m-%d')) as invdate from mf_portfolios  where schemecode = (select primary_fd_code from scheme_classifications where schemecode = ?) and invdate<=?),'%Y-%m-%d') ORDER BY mf.`holdpercentage` DESC").setLong(0,schemecode).setLong(1,schemecode).setDate(2,temp_Date).list();
							    		      
			                                  if(result_1.size()>0)
			                                  {
			                                	  Object[] data_1 = result_1.get(0);
			                                	  
	//		                                	  System.out.println(data_1[2]);
			                                	  aum =  (Double.valueOf(data_1[2].toString())/100);   //set-AUM
			                                	  
	//		                                	  rm568.setSc_aum(((double) data[2])/100);		                                	  
	//		                                	  System.out.println(data[3]);		                                	  		                                	  
	//		                                	  rm568.setNo_of_stock(result.size());		                                	  
			                                  }
			                                  if(aum!=-1)	 
			                                  new_obj.setAum(aum);
			                                  
			                                  
			                                  new_obj.setKey(new_pk);
			                                  
	//		                                  if(new_obj.getYear_1_return()!= null)
			                                  {
			                                  ssn.save(new_obj);
			                                  }
			                                  db_save++;
			                                  
			                                  
			                                  if(db_save==50)
			                                  {		                                	
			                              		ssn.getTransaction().commit();
	//		                              		ssn.flush();
	//		          					        ssn.clear();
	//		                              		ssn.close();
			                              		ssn.beginTransaction();
			                                	db_save=1;
			                                  }
			                                  
			                                  
//					               			System.out.println("<<<<---END---->>>>");
					               				
	//				               		}
					               		
					               		year_1_temp=-1;
					               		year_3_temp=-1;
					               		year_2_temp=-1;
					               		aum=-1;
					               		res=-1;
					               		
					               	  }
			               	    	   
			               	    	      
					               	    	if(data[6]!=null)
						               	       {
	//						               	    	  System.out.println(data[6]);
							               	    	  yr_1 = Double.valueOf(data[6].toString());
							               	    	  year_1_temp = yr_1;
						               	       }
						               	       else
						               	       {
	//					               	    	   	  System.out.println("No-DATA");
						               	       }
						               	       
							               	   if(data[7]!=null)
							            	   {
	//								            	    System.out.println(data[7]);
									            	    yr_3 = Double.valueOf(data[7].toString());
									            	    year_3_temp = yr_3;
							            	   }
							               	   else
							               	   {
	//						               		   System.out.println("No-DATA");
							               		 
							               	   }
							               	   if(data[8]!=null)
							         	       {
	//							         	    	System.out.println(data[8]);
								         	    	yr_2 = Double.valueOf(data[8].toString());
								         	    	year_2_temp = yr_2;
							         	       }
							               	   else
							               	   {
	//						               		   System.out.println("No-DATA");
							               	   }
							               	   
							               	
							               	 
							              	temp_Date = dd;
							              	counter++;
			               	       }
	               	         
	               	                     	       
		               	   
	//	               	   System.out.println(data[7]);
	//	               	   System.out.println(data[8]);
	//               	                                	  
	//               	  rm568.setSc_aum(((double) data[2])/100);
	               	  
	//               	  System.out.println(data[3]);
	               	  
	               	  
	//               	  rm568.setNo_of_stock(result.size());
	                 	 }
	                 	 System.out.println("<------END------>");
	                 }
	                 counter=0;
		    	 
		     }
		
//		     Closing-The_Transaction
		     
		     if(ssn.getTransaction().isActive()) 
		      		ssn.getTransaction().commit();
		            
		     ssn.beginTransaction();
		     
		     Query query = ssn.createQuery("delete from Elss_new where year_3_return=0 and Fund_Type ='"+Fund_Type+"'");
//             
             int result_2 = query.executeUpdate();
		     
		     generate_rank(ssn,Fund_Type);

    	
        	
        	
        }
        catch (Exception e) 
        {
        	 System.out.println("<<<----ERROR------>>>>");	
		     e.printStackTrace();
		   
		}
        finally
        {
        	
        	if(ssn.isOpen())
      		ssn.close();
      		System.out.println("<<<<<<<<<<<<<<-------_Report Complete-------->>>>>>>>>>>");
        }

	}
	
	
	public static double Calculate_Rolling_Return(Session ssn,long schemecode, Date date, int year) throws ParseException 
	{    
		
		System.out.println("<-------------------IN ROLLING_RETURN-AVERAGE-------------------------->");
		 
		 java.util.Date temp_date=null;
		 java.util.Date upto_date=null;
		 double final_result=-1;
		 
		 temp_date=date;
		 
				 if(temp_date.getMonth()==11)
				 {
					 temp_date.setDate(31);
				 }
				 else if(temp_date.getMonth()==8)
				 {
					 temp_date.setDate(30);
				 }
				 else if(temp_date.getMonth()==5)
				 {
					 temp_date.setDate(30);
				 }
				 else if(temp_date.getMonth()==2)
				 {
					 temp_date.setDate(31);
				 }
				 
			System.out.println("temp-Date----->>>"+temp_date);	 
		 
		 	 			 
				 
		 Calendar cal = Calendar.getInstance();
	     cal.setTime(temp_date);
	     int months=0;
	     if(year==1)
	     {   
	    	 months=-12;
	    	 cal.add(Calendar.MONTH,months);	 
	     }
	     else if(year==3)
	     {   
	    	 months=-36;
	    	 cal.add(Calendar.MONTH,months);	 
	     }
	     else if(year==5)
	     {   
	    	 months=-60;
	    	 cal.add(Calendar.MONTH,months);	 
	     }
	     
	     upto_date = cal.getTime();
	     
	     System.out.println("UPto Date--->>>"+upto_date);
	     
	     
	     Date upto_date_7 = new Date(upto_date.getTime()-((1000 * 60 * 60 * 24)*7));
	     
	     System.out.println("Upto Dtae 7-->>"+upto_date_7);
	     
	     List<Object[]> check_db= ssn.createSQLQuery("select date_format(date,'%Y-%m-%d') as date from rolling_returns where schemecode=? and date>=? and date<=? and return_"+year+"_years is not null order by date desc").setLong(0,schemecode).setDate(1,upto_date_7).setDate(2,upto_date).list(); 
	     
	     System.out.println("");
	     
	     if(check_db.size() > 0)
	     {
//	    	 System.out.println("<<<<<-----in REsultset----------->>>>>>");
	    	 Object[] data2 =check_db.toArray();
//	    	 System.out.println("=-=-=-=-=====");
//	    	 System.out.println("-=-=-=-=====-=>>>"+data2[0]);
	    	 SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	    	 
	    	 System.out.println("--------------------->>>>>"+data2[0].toString());
           	 Date temp_dt = formatter.parse(data2[0].toString());
           	 
//           	 System.out.println("-=-=-=Parsed Date---->>>");
//           	 System.out.println("TEMP_DATE----------->>>>>>>"+temp_dt);
//	    	 System.out.println("DATE----------->>>>>>>"+date);
//	    	 System.out.println("Schemecode--->>"+schemecode);
	    	 List<Object[]> result= ssn.createSQLQuery("select * from rolling_returns where schemecode=? and date >=? and date <=?").setLong(0,schemecode).setDate(1, temp_dt).setDate(2, date).list();
	          double sum=0;
	          int counter_2=0;
	          
	    	 if(result.size() > 0)
	    	 {
	    		 for(int r=0;r<result.size();r++)
	    		 {
	    			 Object[] data3 = result.get(r);
	    			  
	    			 System.out.println("DATA-3---->>"+data3[6]);
	    			 if(year==1)
	    			 {
	    				 System.out.println("Data-3--6->>"+data3[6]);
	    				 if(data3[6]!=null)
	    				 {
			    		         sum = sum + Double.valueOf(data3[6].toString());
			    		         counter_2++;
	    				 }
	    			 }
	    			 else if(year==3)
	    			 {
	    				 System.out.println("Data-3--7->>"+data3[7]);
	    				 if(data3[7]!=null)
	    				 {
		    				 sum = sum + Double.valueOf(data3[7].toString());
		    		         counter_2++;
	    				 }
	    			 }
	    			 else if(year==5)
	    			 {   
	    				 System.out.println("Data-3--7->>"+data3[7]);
	    				 if(data3[8]!=null)
	    				 {
		    				 sum = sum + Double.valueOf(data3[8].toString());
		    		         counter_2++;
	    				 }
	    			 }
	    			 
	    			 
	    			 
	    		 }
	    		 System.out.println("Counter-0------->>>"+counter_2);
	    		 final_result=sum/counter_2;
	    		  
	    	 }
	    	 
	     }		
		return final_result;
	}


	private static void generate_rank(Session ssn,String Fund_Type) 
	{
		
//		    System.out.println("<---------------IN RANk GENERATOR----------->>>");
		int db_flag=0; 
		double retval=0;
		double temp_val_hldr=-999999;
	    int rank_hldr=0;
	    int same_rank_flag=0;
	    
		String colum_lst[] = {"forward_36_ret","year_1_return","year_3_return","year_2_return"}; 	
		
        ArrayList<String> quarter_list = (ArrayList<String>) ssn.createQuery("select distinct(quarter) from Elss_new where key.Fund_Type='"+Fund_Type+"' ").list();
	    
	    for(String quarter : quarter_list)
	    {
	    	
	    	for(String column : colum_lst)
	    	{  
	    		  ArrayList<New_Elss_Model> data_lst = (ArrayList<New_Elss_Model>) ssn.createQuery("from Elss_new where quarter='"+quarter+"' and key.Fund_Type='"+Fund_Type+"' and "+column+"!=0 order by "+column).list();
	    		  temp_val_hldr=-999999;
	   	    	  rank_hldr=0;
	   	    	  same_rank_flag=0;   
	   	    	 for(New_Elss_Model arm : data_lst)
	    		   {
		   	    		if(column=="forward_36_ret")
		    			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getForward_36_ret());
			  		 		    
				 		    	if(retval==0)
				 		    	{
				 		    	    arm.setForward_36_ret_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;
				 		    	    same_rank_flag++;
				 		    	}
				 		    	else
				 		    	{   
				 		    		rank_hldr=rank_hldr+same_rank_flag;
						    		same_rank_flag=0;
						    		rank_hldr=rank_hldr+1;
						    		
				 		    		arm.setForward_36_ret_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;  
				 		    	}
				 		    	
				 		    	
				 		    	temp_val_hldr=arm.getForward_36_ret();
		    			   }
		   	    		
		   	    		if(column=="year_1_return")
		    			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getYear_1_return());
			  		 		    
				 		    	if(retval==0)
				 		    	{
				 		    	    arm.setYear_1_return_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;
				 		    	    same_rank_flag++;
				 		    	}
				 		    	else
				 		    	{   
				 		    		rank_hldr=rank_hldr+same_rank_flag;
						    		same_rank_flag=0;
						    		rank_hldr=rank_hldr+1;
						    		
				 		    		arm.setYear_1_return_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;  
				 		    	}
				 		    	
				 		    	
				 		    	temp_val_hldr=arm.getYear_1_return();
		    			   }   
		   	    		
		   	    		if(column=="year_3_return")
		    			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getYear_3_return());
			  		 		    
				 		    	if(retval==0)
				 		    	{
				 		    	    arm.setYear_3_return_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;
				 		    	    same_rank_flag++;
				 		    	}
				 		    	else
				 		    	{   
				 		    		rank_hldr=rank_hldr+same_rank_flag;
						    		same_rank_flag=0;
						    		rank_hldr=rank_hldr+1;
						    		
				 		    		arm.setYear_3_return_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;  
				 		    	}
				 		    	
				 		    	
				 		    	temp_val_hldr=arm.getYear_3_return();
		    			   }
		   	    		
		   	    		if(column=="year_2_return")
		    			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getYear_2_return());
			  		 		    
				 		    	if(retval==0)
				 		    	{
				 		    	    arm.setYear_2_return_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;
				 		    	    same_rank_flag++;
				 		    	}
				 		    	else
				 		    	{   
				 		    		rank_hldr=rank_hldr+same_rank_flag;
						    		same_rank_flag=0;
						    		rank_hldr=rank_hldr+1;
						    		
				 		    		arm.setYear_2_return_rank(rank_hldr);
				 		    	    ssn.update(arm);
				 		    	    db_flag++;  
				 		    	}
				 		    	
				 		    	
				 		    	temp_val_hldr=arm.getYear_2_return();
		    			   }
		   	    		
		   	    	 if(db_flag%100==0)
	   		 		    {
	   		 		    	 ssn.getTransaction().commit();
	   		 		         ssn.beginTransaction();
	   		 		    	 ssn.flush();
					         ssn.clear();
	   		 		    	
	   		 		         db_flag=1;
	   		 		    }
	    		   }
	   	    	   
	    	}
	     
	    }
		
	    if(ssn.getTransaction().isActive())
		ssn.getTransaction().commit();
		ssn.close();
	}


	public static ArrayList<nav_hist> get_list_of_dates_db(java.util.Date day, long scheme_code) throws ParseException
	{
			  SimpleDateFormat formatter=null;
			  java.util.Date date_nav_chk_start=null;
			  java.util.Date date_nav_chk_end=null;
			  
			  Long l = new Long(scheme_code);
			  
			  ArrayList<nav_hist> lst = new ArrayList<nav_hist>();
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
			  formatter = new SimpleDateFormat("dd/MM/yyyy");
			  //System.out.println("DATE-FOrmatter-->>"+myDate);
			  date_nav_chk_start = day;	   
			  date_nav_chk_end = new Date(date_nav_chk_start.getTime()-((1000 * 60 * 60 * 24)*10));

			  // date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
			  Criteria criteria = ssn.createCriteria(nav_hist.class);
			  criteria.add(Restrictions.eq("key.schemecode",l)); 
			  
			  
			  criteria.add(Restrictions.between("key.navdate", date_nav_chk_end, date_nav_chk_start));
      		  
			  criteria.addOrder(org.hibernate.criterion.Order.desc("key.navdate"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
			  			  			  
		 return lst;
	}
	
	public static Date get_date(java.util.Date day, int months) throws ParseException
	{
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		  Calendar cal = Calendar.getInstance();
	      cal.setTime(day);
	      
	      
		      if(months > 0)
		      {
		    	  months=Math.abs(months);
		    	  cal.add(Calendar.MONTH,months);
		      }
		      else if(months < 0)
		      {
		    	  months=Math.abs(months);
		    	  cal.add(Calendar.MONTH,-months);
		      }
	      java.util.Date ddd = cal.getTime();
	      
//	      ddd.setDate(1);
	      
	      if(ddd.getMonth()==0 || ddd.getMonth()==2 || ddd.getMonth()==4 || ddd.getMonth()==6 || ddd.getMonth()==7 || ddd.getMonth()==9 || ddd.getMonth()==11)
	      {
	    	   ddd.setDate(31);
	      }
	      else
	      {
	    	   ddd.setDate(30);
	      }
	      
//	      SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
//	      String formatted = formatter.format(ddd);
	      
//	      return formatted;
	      return ddd;
	}

}
