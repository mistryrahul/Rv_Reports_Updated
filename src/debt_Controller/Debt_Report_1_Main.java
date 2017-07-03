package debt_Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.poi.util.SystemOutLogger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import debt_Model.Avg_maturity;
import debt_Model.Credit_rating_sum_groups;
import debt_Model.Debt_Report_1;
import debt_Model.Pk_generic;
import model.ExpenceRatio;
import model.Mf_portfolio_New;
import model.Scheme_Detail;
import model.nav_hist;
import sessionFactory.HIbernateSession;

public class Debt_Report_1_Main 
{
     
	public static void main(String[] args)
	{
		Session ssn = null;
		int mc=1;
		int db_save=1;
		Debt_Report_1 ob1 = null;
		Pk_generic ob1_pk =null;
		int frst_iteration=1;
				
		double temp_weight=0;
		
		double ans_1=0,ans_2=0,ans_3=0,fin_res=0;
		
		ArrayList<Debt_Report_1> dr_m = new ArrayList<Debt_Report_1>();
		
		double ret_12_mnths=0,ret_36_mnths=0;
		
		long chek_sch_cd=0;
		String class_chk=null;
		java.util.Date date_chk=null;
		
		try
		  {
			ssn = HIbernateSession.getSessionFactory().openSession(); 
		    ssn.beginTransaction();	
		    
		    Date Date_As_On_Report= new Date(117, 05, 30);  // as no date should be fixed before running
 		    
//		    String Fund_Type="Debt : Liquid";
//		    String Fund_Type="Debt : Ultra Short Term";
		    
		    
//		   String Fund_Type="Debt : Short Term";
		    
		   String dd_1 = new SimpleDateFormat("yyyy-MM-dd").format(Date_As_On_Report);
		   
//		    String Fund_Type="Debt : Medium & Long Term";
		    String Fund_Type="Hybrid : Debt Oriented";
		    
		    String Comment=Fund_Type+"_as_on_"+dd_1;
		    
		    ArrayList<Credit_rating_sum_groups> new_calc = new ArrayList<Credit_rating_sum_groups>();
		    ArrayList<Credit_rating_sum_groups> mn_lst = new ArrayList<Credit_rating_sum_groups>();
		    
//		    List<Object[]> result= ssn.createSQLQuery("select csrg.* from credit_rating_sum_groups csrg join scheme_details_fulls sdf on csrg.schemecode=sdf.schemecode where csrg.invdate='2016-12-31' and csrg.classification like '%Liquid%' and sdf.type_code!=2").list();
		    List<Object[]> result= ssn.createSQLQuery("select csrg.* from credit_rating_sum_groups csrg join scheme_details_fulls sdf on csrg.schemecode=sdf.schemecode where csrg.classification like '%"+Fund_Type+"%' and sdf.type_code!=2 and invdate=(select max(invdate) from credit_rating_sum_groups) order by schemecode").list(); 
//		    List<Object[]> result= ssn.createSQLQuery("select * from credit_rating_sum_groups where classification like '%Liquid%' order by schemecode").list();
		    
		    for(int i=0;i<result.size();i++)
			{
		    	Object[] data = result.get(i);
		    	Credit_rating_sum_groups obj = new Credit_rating_sum_groups();

		    	obj.setClassification(data[1].toString());
		    	obj.setHold_percent(Double.valueOf(data[3].toString()));
		    	obj.setInv_date(Date_As_On_Report);
		    	obj.setScheme_code(new Long(data[0].toString()));
		    	obj.setRv_group(data[4].toString());
		    	
		    	mn_lst.add(obj);
			}
		    
//		    ArrayList<Credit_rating_sum_groups> mn_lst = (ArrayList<Credit_rating_sum_groups>) ssn.createQuery("from Credit_rating_sum_groups where classification like '%Liquid%' order by scheme_code").list();
		    
		     for(Credit_rating_sum_groups crsg: mn_lst)
		     {
		    	 new_calc.add(crsg);
		    	
		    	if(new_calc.size()>=2 && frst_iteration!=1)
		    	{
		    		
//		    		System.out.println("1-"+(new_calc.get(new_calc.size()-1).getClassification().equals(new_calc.get(new_calc.size()-2).getClassification())));
//		    	    System.out.println("Sch->"+(new_calc.get(new_calc.size()-1).getKey().getScheme_code()==new_calc.get(new_calc.size()-2).getKey().getScheme_code())); 	
//		    		System.out.println("D->"+(new_calc.get(new_calc.size()-1).getKey().getInv_date().compareTo(new_calc.get(new_calc.size()-2).getKey().getInv_date())));
		    		
		   
		    		
		    		   if(( new_calc.get(new_calc.size()-1).getClassification().equals(new_calc.get(new_calc.size()-2).getClassification()) )
		    				   && (new_calc.get(new_calc.size()-1).getScheme_code()==new_calc.get(new_calc.size()-2).getScheme_code())
		    				   && (new_calc.get(new_calc.size()-1).getInv_date().compareTo(new_calc.get(new_calc.size()-2).getInv_date()))==0)
		    		   {
		    			   
		    			    frst_iteration++;	 
//				    		System.out.println("SAEME DTATa--->>>");
		    			   
		    		   }
		    		   else
		    		   {
//		    			   System.out.println("DATA VALUE CHANGED---->>>");
		    			   double tot_val=0;
		    			   new_calc.remove(new_calc.size()-1); // removing the last item as that scheme code is different
		    			   
		    			   
		    			   
//		    			   System.out.println("Credit Rating-->>"+get_credit_rating(new_calc));
		    			   
		    			   dr_m.get(0).setCredit_rating(get_credit_rating(new_calc));
		    			   
		    			   System.out.println("Date-->>"+dr_m.get(0).getKey().getDay());
		    			   System.out.println("schemecode-->>"+ dr_m.get(0).getKey().getScheme_code());
		    			   
		    			   
		    			   ssn.save(dr_m.get(0));
		    			   ssn.getTransaction().commit();
		    			   ssn.beginTransaction();
		    			   ssn.flush();
		    			   ssn.clear();
		    			   
		    			   dr_m.clear();
		    			   
		    			   
		    			   
//		    			   ArrayList<Debt_Report_1> avg_mat_lst = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where day=? and scheme_code=?").setDate(0,crsg.getKey().getInv_date()).setLong(1,crsg.getKey().getScheme_code()).list();
////		    			   
//		    			   avg_mat_lst.get(0).setCredit_rating(tot_val);
//		    			   ssn.update(avg_mat_lst.get(0));
		    			   
//		    			   ob1.setCredit_rating(tot_val);
//		    			   ssn.save(ob1);
		    			   
                      
		    			   
		    			   
		    			   frst_iteration=1;
		    			   
		    			   new_calc.clear();
		    			   
		    			   new_calc.add(crsg);
		    			   
		    			   chek_sch_cd=0;
		    			   class_chk=null;
		    			   date_chk=null;
		    				
		    			   
		    		   }
			    		
			    		
			    }
		    	else
		    	{
		    	        frst_iteration=1;
		    	}
		    	 
		    	 
		    	 if(frst_iteration==1)
		    	 {
		    		 
		    		 
//		    		 System.out.println("IN MAIN CLASS which should run-->>"+mc);
		    		 chek_sch_cd = crsg.getScheme_code();
			    	 class_chk=crsg.getClassification();
			    	 date_chk = crsg.getInv_date();
                       
			    	  mc++;
			    	 
			    	 
			    	 ob1 = new Debt_Report_1();
			    	 ob1_pk = new Pk_generic();
			    	 
			    	 ob1_pk.setDay(crsg.getInv_date());
			    	 ob1_pk.setScheme_code(crsg.getScheme_code());
			    	 
			    	 ob1_pk.setComment(Comment); //
			    	 
			    	 
			    	 ob1.setKey(ob1_pk);
			    	 ob1.setFund_Type(Fund_Type); // setting Fund_Type
			    	 
			    	 
			    	 List<Object[]> rs1= ssn.createSQLQuery("SELECT schemecode,round(if(avg_mat_days='days',avg_mat_num/365, if(avg_mat_days='months',avg_mat_num/12, avg_mat_num)),2) as avg_maturity,round(if(mod_dur_days='days',mod_dur_num/365, if(mod_dur_days='months',mod_dur_num/12, mod_dur_num)),2) as modified_duration, ytm,date FROM avg_maturities where  schemecode = (select primary_fd_code from scheme_details_fulls where schemecode=?) AND date=(select max(date) from avg_maturities where schemecode=(select primary_fd_code from scheme_details_fulls where schemecode=?) and date<=?)order by date desc limit 1").setLong(0,crsg.getScheme_code()).setLong(1,crsg.getScheme_code()).setDate(2,crsg.getInv_date()).list();
			    	 
			    	 if(rs1.size()>0)
                     {
                   	  Object[] data = rs1.get(0);
//                   	  System.out.println("schemecode--->>"+crsg.getScheme_code());
//                   	  System.out.println(data[2]);
                   	  
                   	  //setting AVERAGE_MATURITY
                   	  
                   	  if(data[2]!=null)
                   	  {
                   		double tmn = Double.valueOf(data[2].toString());
                    	   ob1.setModified_duration(tmn);   
                   	  }
                   	  
                   	  if(data[1]!=null)
                   	  {
                   		double tmn2 = Double.valueOf(data[1].toString());
                 	    ob1.setAvg_maturity(tmn2);  
                   	  }
                   	   
                    	
                     }
			    	 
			    	 ArrayList<Scheme_Detail> sdf = (ArrayList<Scheme_Detail>) ssn.createQuery("from scheme_details_fulls where schemecode=?").setLong(0,crsg.getScheme_code()).list(); 
			    	 
			    	  for(Scheme_Detail gg : sdf)
			    	  {
			    		  ob1.setScheme_name(gg.getS_NAME());
			    	  }
			    	 
			    	  
			    	  //setting Quarters
			    	  {
					    		  if( ob1.getKey().getDay().getMonth()==2 || ob1.getKey().getDay().getMonth()==1)
					    			{
					    				ob1.setQuarter("Qtr_1_"+( ob1.getKey().getDay().getYear()-100));
		//			    				ob_tmp.setComment("Q1_"+( Ob2.getNav_date().getYear()-100));	
					    			}
					    			else if(ob1.getKey().getDay().getMonth()==4 || ob1.getKey().getDay().getMonth()==5) 
					    			{
//					    				ob_ts.setComent("Qtr_2_"+( dt.getYear()-100));
					    				ob1.setQuarter("Qtr_2_"+( ob1.getKey().getDay().getYear()-100));
					    			}
					    			else if(ob1.getKey().getDay().getMonth()==8 || ob1.getKey().getDay().getMonth()==7)
					    			{
//					    				ob_ts.setComent("Qtr_3_"+( dt.getYear()-100));
					    				ob1.setQuarter("Qtr_3_"+( ob1.getKey().getDay().getYear()-100));
					    			}
					    			else if(ob1.getKey().getDay().getMonth()==11 || ob1.getKey().getDay().getMonth()==0)
					    			{
		//			    				ob_tmp.setComment("Q4_"+( Ob2.getNav_date().getYear()-100));
//					    				ob_ts.setComent("Qtr_4_"+( dt.getYear()-100));
					    				ob1.setQuarter("Qtr_1_"+( ob1.getKey().getDay().getYear()-100));
					    			}
					    			else
					    			{
					    			        System.out.println("<<<<<<<<<<<<<<<----------------->>>>>>>>>>>>>>>>>>>>>>>>>>>");	
//					    				    System.out.println("Scheme Code-->>"+sch_code);
//					    				    System.out.println("Date-->"+dt);
					    				    System.out.println("<<<<<<<<<<<<<<<----------------->>>>>>>>>>>>>>>>>>>>>>>>>>>");
					    				    
					    				    System.exit(0);
					    			}
			    	  }
			    	  
			    	  
			    	  
			    	  
			    	 ret_12_mnths = calculate_return(crsg,-12, ssn);
			    	 
			    	 if(!Double.toString(ret_12_mnths).equals("-99.99"))
			    	 {
			    		 ob1.setReturn_12_months(ret_12_mnths);	 
			    	 }
			    	 
			    	 
			    	 
			    	 ret_36_mnths = calculate_return(crsg,-36, ssn);
			    	  
			    	 if(!Double.toString(ret_36_mnths).equals("-99.99"))
			    	 {
//			    		 System.out.println("36 Months Return-->>"+ret_36_mnths);
			    		 
			    		 ans_1= ((ret_36_mnths/100) +1);
			    		 ans_2= (0.333333333);
			    		 ans_3 = Math.pow(ans_1 ,ans_2);
			    		 fin_res = ( ans_3 -1 )*100;
		
//			    		 System.out.println("Ans_1->"+ans_1);
//			    		 System.out.println("Ans_2->"+ans_2);
//			    		 System.out.println("Ans_3->"+ans_3);			    		 
//			    		 System.out.println("Result--->>>"+fin_res);
			    		 
			    		 ob1.setReturn_36_months(fin_res);
			    	 }
			    	 
			    	 
			    	 //last ex-ratio where value is not 0
//			    	 ArrayList<ExpenceRatio> e_rat = (ArrayList<ExpenceRatio>) ssn.createQuery("from ExpenceRatio where scheme_code=? and day<=? and ex_ratio!=0 order by day desc").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).list();
			    	 ArrayList<ExpenceRatio> e_rat = (ArrayList<ExpenceRatio>) ssn.createQuery("from expenceratios where schemecode=? and date<=? order by date desc").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).setMaxResults(1).list();
			    	 
			    	 if(e_rat.size()>0)
			    	 { 
			    		 if(e_rat.get(0).getEx_ratio()==null)
			    		 {
//			    			 ob1.setEx_ratio(e_rat.get(0).getEx_ratio());	 
			    		 }
			    		 else
			    		 {
			    			 ob1.setEx_ratio(e_rat.get(0).getEx_ratio());	 
			    		 }
			    		 
                	 }

//                     ArrayList<Mf_portfolio_New> sch_aum_mf_prtflio = (ArrayList<Mf_portfolio_New>) ssn.createQuery("from mf_portfolios where schemecode=? and invdate<=?").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).setMaxResults(1).list();
//			    	 
//			    	 if(sch_aum_mf_prtflio.size()>0)
//			    	 {
//			    		 ob1.setAum(sch_aum_mf_prtflio.get(0).getAum()/100); // cause it is in lakhs, we need that in crores
//			    		 
//                	 }
			    	 
			    	 
			    	 List<Object[]> result_22= ssn.createSQLQuery("select aum,invdate from mf_portfolios where schemecode=(select primary_fd_code from scheme_details_fulls where schemecode=? ) and invdate<=? order by invdate desc limit 1").setLong(0,crsg.getScheme_code()).setDate(1,crsg.getInv_date()).list(); 
//	    		      List<Object[]> result= ssn.createSQLQuery("select schemecode, invdate, sum(holdpercentage) as holdpercentage, count(*) as tottal_count, aum from mf_portfolios where schemecode=(select primary_fd_code from scheme_details_fulls where schemecode=?) and invdate>=? and invdate<=? group by invdate").setLong(0,arm.getKey().getScheme_code()).setDate(1,ddd).setDate(2,arm.getKey().getStart_dt()).list();
	    		      
                     if(result_22.size()>0)
                     {
                   	  Object[] data_1 = result_22.get(0);  	                                	  
                   	  ob1.setAum(((double) data_1[0])/100);
                   
                     }
			    	 
//			    	 // Previous AUM- 
//			    	 ArrayList<Scheme_Paum> sch_aum = (ArrayList<Scheme_Paum>) ssn.createQuery("from Scheme_Paum where scheme_code=? and day=?").setLong(0, crsg.getScheme_code()).setDate(1,crsg.getInv_date()).list(); 
//			    	 if(sch_aum.size()>0)
//			    	 {
//			    		 ob1.setAum(sch_aum.get(0).getAvg_aum()/100); // cause it is in lakhs, we need that in crores
//			    		 
//                	 }
			    	 
			    	 
                                     
                     
                     
			    	 
			    	 dr_m.add(ob1); 
			    	 
//			    	 ssn.save(ob1);
//			    	 db_save++;
			    	 
			    	 
			    	 
//			    	 if(db_save%100==0)
//			    	 {
//			    		 ssn.getTransaction().commit();
//			    		 ssn.getTransaction().begin();
//			    		 db_save=1;
//			    	 }
			    	
//			    	 
			    	 
			    	 
			    	 frst_iteration++;
		    	 }
		    	
		    	 
		     }
		     
		         
		             if(dr_m.size()!=0)
		             {
		            	 dr_m.get(0).setCredit_rating(get_credit_rating(new_calc));
		            	 ssn.save(dr_m.get(0));
		             }
		    
		             
		             ssn.getTransaction().commit();
		             ssn.beginTransaction();
		             
//		                                           ///////----------xxxxx(Start)------------////                           
//		                  
//		             
										             Query query = ssn.createQuery("delete from Debt_Report_1 where return_36_months=0 and Fund_Type='"+Fund_Type+"'");
//										              
										             int result_2 = query.executeUpdate();
//										              
										             if (result_2 > 0) {
										                 System.out.println("36 Months Returns which are 0  are removed");
										             }
										             
										             ArrayList<Debt_Report_1> drm = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where Fund_Type='"+Fund_Type+"'").list();
//										             
										             for(Debt_Report_1 bb : drm)
										             {
										            	 if(bb.getAum()<100)
										            	 {
										            		 bb.setStar("Unrated");
										            	 }
										            	 
										            	 ssn.save(bb);
										             }
										             System.out.println("all aum below 100 crore updated as Unrated");
										             
//										             Query query_1 = ssn.createQuery("update Debt_Report_1 set star='Unrated' where aum < 100");
////										             
////										             		             
//										             int result_1 = query_1.executeUpdate();
////										             
//										             if (result_1 > 0) {
//										                 System.out.println("all aum below 100 crore updated as unrated");
//										             }
//										             
//										             
										             ssn.getTransaction().commit();
										             ssn.getTransaction().begin();
										             
//										             Query qry_1 = ssn.createQuery("from Debt_Report_1");
										             ArrayList<Debt_Report_1> drm1 = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where Fund_Type='"+Fund_Type+"'").list();
										             for(Debt_Report_1 ob11 : drm1)
										             {
										            	 double comp_score = ((ob11.getReturn_12_months()* 0.2) + (ob11.getReturn_36_months()*0.4) + (ob11.getCredit_rating()*0.4));
									                     
									                     ob11.setComposite_score(comp_score);
									                     ssn.update(ob11);
										             }
										             
										            
								                     
								                     ssn.getTransaction().commit();
										             ssn.beginTransaction();
//										             
//										             /////-------xxxxx---------------//////
//								                     Genrate_Rank(ssn);
                     
                     
//                      ssn.close();
//                      ssn = HIbernateSession.getSessionFactory().openSession(); 
//		              ssn.beginTransaction();
		              
		              ArrayList<Debt_Report_1> mn_lst_totl = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null").list();
                     
                       for(Debt_Report_1 ob : mn_lst_totl)
                       {
                    	   temp_weight=(ob.getCredit_rating_rank()*0.3)+(ob.getReturn_12_months_rank()*0.2)+(ob.getReturn_36_months_rank()*0.3)+(ob.getModified_duration_rank()*0.2);
                           ob.setWeight_to_ranks(temp_weight);
                           
                           temp_weight=0;
                           
                           ssn.update(ob);
                       }
                     ssn.getTransaction().commit();
                                          
//                     Genrate_Rank_for_Weight(ssn);
                     
                     Generate_start_rating(ssn,Fund_Type);
		             
                      
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
		finally
		{
//			ssn.getTransaction().commit();
     	    ssn.close();
		    System.out.println("<<<<----Report COmplete----->>>>>");
		}
	}
	
	
	
	private static void Generate_start_rating(Session ssn ,String Fund_Type) 
	{
//		ssn.getTransaction().commit();
		ssn.beginTransaction();
		
		int rec_counter=1;
		int tmp_size=0, top_grp_1=0,top_grp_2=0,top_grp_3=0,top_grp_4=0,top_grp_5=0,diff=0;
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//        ssn.beginTransaction();
        
        ArrayList<Debt_Report_1> mn_lst_rank_wise = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null and Fund_Type='"+Fund_Type+"' order by composite_score desc").list();
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
        
        for(Debt_Report_1 ob : mn_lst_rank_wise)
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

	private static void Genrate_Rank_for_Weight(Session ssn) 
	{
		 double retval=99999;
		 double temp_val_hldr=123.00;
		 int rank_hldr=1;
		 int same_rank_flag=0;
		 
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//	    ssn.beginTransaction();
	    
		ArrayList<Debt_Report_1> quarter_list = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null order by weight_to_ranks desc").list();
	    
		rank_hldr= quarter_list.size()+1;
		
		for(Debt_Report_1 arm: quarter_list)
		{
			 retval = Double.compare(temp_val_hldr,arm.getWeight_to_ranks());
	 		    
		    	if(retval==0)
		    	{
		    	    arm.setRank_of_weight_to_ranks(rank_hldr);
		    	    ssn.update(arm);
//		    	    db_flag++;
		    	    same_rank_flag--;
		    	}
		    	else
		    	{   
		    		rank_hldr=rank_hldr+same_rank_flag;
		    		same_rank_flag=0;
		    		rank_hldr=rank_hldr-1;
		    		
		    		arm.setRank_of_weight_to_ranks(rank_hldr);
		    	    ssn.update(arm);
//		    	    db_flag++;  
		    	}
		    	
		    	
		    	temp_val_hldr=arm.getWeight_to_ranks();
		}
	    
	    
	    ssn.getTransaction().commit();
	    ssn.beginTransaction();
//	    ssn.close();
		
	 	
	}
	
	

	private static void Genrate_Rank(Session ssn)
	{
	     
		ArrayList<Debt_Report_1> quarter_list = null;
		String colum_lst[] = {"return_12_months","return_36_months","credit_rating","modified_duration"};
		double temp_val_hldr=0;
		int rank_hldr=1;
		int same_rank_flag=0;
		int retval=99;
		
//		Session ssn = HIbernateSession.getSessionFactory().openSession(); 
//	    ssn.beginTransaction();
	    
	    for(String colmn : colum_lst)
	    {
	    	if(colmn.equals("modified_duration"))
	    	{
	    		  quarter_list = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null order by "+colmn+" desc").list();
	    		  rank_hldr=0;  
	    	}
	    	else
	    	{
	    		quarter_list = (ArrayList<Debt_Report_1>) ssn.createQuery("from Debt_Report_1 where star is null order by "+colmn+" desc").list();
	    		rank_hldr=quarter_list.size()+1;
	    	}
	    	
	    	
//	    	System.out.println("<<<<<<<<<--------LIST SIZE----------------->>>>>>>>>>>>>>>>>>>>");
//    	    System.out.println(quarter_list.size());
//    	    System.out.println("<<<<<<<<<--------LIST SIZE END----------->>>>>>>>>>>>>>>>>>>>");
	    	
	    	
	    	   temp_val_hldr=-999999;
//   	    	   rank_hldr=0;
   	    	   same_rank_flag=0;
   	    	   
   	    	   for(Debt_Report_1 arm : quarter_list)
   	    	   {
   	    		   
		   	    		if(colmn=="return_12_months")
		 			   {
		    			   retval = Double.compare(temp_val_hldr,arm.getReturn_12_months());
		  		 		    
		 	 		    	if(retval==0)
		 	 		    	{
		 	 		    	    arm.setReturn_12_months_rank(rank_hldr);
		 	 		    	    ssn.update(arm);
//		 	 		    	    db_flag++;
		 	 		    	    same_rank_flag--;
		 	 		    	}
		 	 		    	else
		 	 		    	{   
		 	 		    		rank_hldr=rank_hldr+same_rank_flag;
		 			    		same_rank_flag=0;
		 			    		rank_hldr=rank_hldr-1;
		 			    		
		 	 		    		arm.setReturn_12_months_rank(rank_hldr);
		 	 		    	    ssn.update(arm);
//		 	 		    	    db_flag++;  
		 	 		    	}
		 	 		    	
		 	 		    	temp_val_hldr=arm.getReturn_12_months();
		 			   }
		   	    		
		   	    		if(colmn=="return_36_months")
			 			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getReturn_36_months());
			  		 		    
			 	 		    	if(retval==0)
			 	 		    	{
			 	 		    	    arm.setReturn_36_months_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;
			 	 		    	    same_rank_flag--;
			 	 		    	}
			 	 		    	else
			 	 		    	{   
			 	 		    		rank_hldr=rank_hldr+same_rank_flag;
			 			    		same_rank_flag=0;
			 			    		rank_hldr=rank_hldr-1;
			 			    		
			 	 		    		arm.setReturn_36_months_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;  
			 	 		    	}
			 	 		    	
			 	 		    	temp_val_hldr=arm.getReturn_36_months();
			 			   }	
		   	    		
		   	    		if(colmn=="credit_rating")
			 			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getCredit_rating());
			  		 		    
			 	 		    	if(retval==0)
			 	 		    	{
			 	 		    	    arm.setCredit_rating_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;
			 	 		    	    same_rank_flag--;
			 	 		    	}
			 	 		    	else
			 	 		    	{   
			 	 		    		rank_hldr=rank_hldr+same_rank_flag;
			 			    		same_rank_flag=0;
			 			    		rank_hldr=rank_hldr-1;
			 			    		
			 	 		    		arm.setCredit_rating_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;  
			 	 		    	}
			 	 		    	
			 	 		    	
			 	 		    	temp_val_hldr=arm.getCredit_rating();
			 			   }
		   	    		
		   	    		if(colmn=="modified_duration")
			 			   {
			    			   retval = Double.compare(temp_val_hldr,arm.getModified_duration());
			  		 		    
			 	 		    	if(retval==0)
			 	 		    	{
			 	 		    	    arm.setModified_duration_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;
			 	 		    	    same_rank_flag++;
			 	 		    	}
			 	 		    	else
			 	 		    	{   
			 	 		    		rank_hldr=rank_hldr+same_rank_flag;
			 			    		same_rank_flag=0;
			 			    		rank_hldr=rank_hldr+1;
			 			    		
			 	 		    		arm.setModified_duration_rank(rank_hldr);
			 	 		    	    ssn.update(arm);
//			 	 		    	    db_flag++;  
			 	 		    	}
			 	 		    	
			 	 		    	
			 	 		    	temp_val_hldr=arm.getModified_duration();
			 			   }
		   	    		   
   	    	   }
   	    	   
   	    	   
   	    	   
   	    	  
	    	
	    	
	    	
	    	
	    }
	    
	    
//	    ssn.getTransaction().commit();
//	    ssn.close();
		
		
	}

	private static double get_credit_rating(ArrayList<Credit_rating_sum_groups> new_calc) {
		
		double tot_val=0;
		double tmp_hld_prcnt=0;
		
		 for(Credit_rating_sum_groups oo:new_calc)
		   {  
//			     System.out.println("HOlding Percentage--->>"+oo.getHold_percent()+" Scheme COde-->"+oo.getKey().getScheme_code());
			     
//			      if(oo.getHold_percent()>0)
//			      {
//			    	  tmp_hld_prcnt =oo.getHold_percent(); 
//			      }
//			      else
//			      {
//			    	  tmp_hld_prcnt = 0;
//			      }
			        
			    	tmp_hld_prcnt =oo.getHold_percent(); 
			   
			     if(oo.getRv_group().equalsIgnoreCase("AAA"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*9);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Cash & Equivalent"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*10);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("SOV"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*10);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("AA"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*8);
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("A"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*7);	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Below A"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*5);	 
			     }
			     
			     else if(oo.getRv_group().equalsIgnoreCase("Others"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Deposits"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Equity"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     else if(oo.getRv_group().equalsIgnoreCase("Unrated"))
			     {
			    	 tot_val = tot_val + ((tmp_hld_prcnt/100)*        0);	 //not set	 
			     }
			     
			   
		   }
		 
		 return tot_val;
		
	}

	static double calculate_return(Credit_rating_sum_groups crsg_obj,int months ,Session ssn) throws ParseException
	{

		ArrayList<nav_hist> nav_hst_lst_mn = get_list_of_dates_db(crsg_obj.getInv_date(),crsg_obj.getScheme_code());
		 
		
		 double nav_ret=0;
		 
            System.out.println("Date--->>"+crsg_obj.getInv_date());	
            System.out.println("Scheme_Code--->>"+crsg_obj.getScheme_code());
          
            
            if(nav_hst_lst_mn.size()==0)
   		    {
   			   return -99.99; 
            }
		    
		  java.util.Date d_x = null;
		  d_x = nav_hst_lst_mn.get(0).getKey().getNavdate();
		  
		  System.out.println("Date Value-->>"+nav_hst_lst_mn.get(0).getKey().getNavdate());
		  
		
			
			 Criteria criteria = ssn.createCriteria(model.nav_hist.class);
			 criteria.add(Restrictions.eq("key.schemecode",nav_hst_lst_mn.get(0).getKey().getSchemecode()));
			 criteria.add(Restrictions.eq("key.navdate",d_x));
			 
			 ArrayList<nav_hist> nav_hst_lst_mn1 = (ArrayList<nav_hist>) criteria.list();
			  
		
		 
		 
		 if(nav_hst_lst_mn1.size()>0)
		 {
			 java.util.Date ddd=null;
			 
			 Calendar cal = Calendar.getInstance();
	    	 cal.setTime(crsg_obj.getInv_date());
	    	 cal.add(Calendar.MONTH,months);
		     ddd = cal.getTime();
	    	 
		    
		     ArrayList<nav_hist> nav_hst_lst = get_list_of_dates_db(ddd, crsg_obj.getScheme_code());
		     
//		     System.out.println("SchemeCODE-->>"+nav_hst_lst_mn.get(0).getKey().getSchemecode()+" for ret month="+months);
//		     System.out.println("Start-Date-->>"+nav_hst_lst_mn.get(0).getKey().getNavdate()+" Nav"+nav_hst_lst_mn.get(0).getAdjnavrs());
//			 System.out.println("End DATE-->"+ddd+" End Nav"+nav_hst_lst.get(0).getAdjnavrs());
			  
			 
		     if(nav_hst_lst.size()>0)
		     {
		    	   if(months<0)
		    	   {
		    		   nav_ret = (((nav_hst_lst_mn.get(0).getAdjnavrs() - nav_hst_lst.get(0).getAdjnavrs())/nav_hst_lst.get(0).getAdjnavrs())*100); 
		    		   
		    	   }
		    	   else
		    	   {
		    		   nav_ret = ((( nav_hst_lst.get(0).getAdjnavrs() - nav_hst_lst_mn.get(0).getAdjnavrs() )/nav_hst_lst_mn.get(0).getAdjnavrs())*100);
		    		  
		    	   }
		    	 
		    	 
		    	 
		     }
		     else
		     {
		    	return -99.99; 
		     }
		     
		 }
		 else
		 {
			 return -99.99;
		 }
	     
	     
	     
		return nav_ret;
	}
	
	
	
	static ArrayList<nav_hist> get_list_of_dates_db(java.util.Date day, long sc) throws ParseException
	{
			  SimpleDateFormat formatter=null;
			  java.util.Date date_nav_chk_start=null;
			  java.util.Date date_nav_chk_end=null;
			  
			  ArrayList<nav_hist> lst = null;
			  Session ssn= HIbernateSession.getSessionFactory().openSession();
			 
//			  formatter = new SimpleDateFormat("dd/MM/yyyy");
//			  System.out.println("DATE-FOrmatter-->>"+myDate);
//			  date_nav_chk_start = formatter.parse(day);
			  
			  date_nav_chk_end = new Date(day.getTime()-((1000 * 60 * 60 * 24)*10));
			 
			  Criteria criteria = ssn.createCriteria(model.nav_hist.class);
			  criteria.add(Restrictions.eq("key.schemecode", sc)); 
			  criteria.add(Restrictions.between("key.navdate", date_nav_chk_end, day));
      		  criteria.addOrder(org.hibernate.criterion.Order.desc("key.navdate"));
			  lst =(ArrayList<nav_hist>) criteria.list();
			  
//			  ssn.getTransaction().commit();
			  ssn.close();
		 return lst;
	}
	
}
