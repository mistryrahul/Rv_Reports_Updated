package NewQuarterlyReports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.mysql.jdbc.CallableStatement;

import model.Report_6_pk;
import model.Rolling_Return;
import sessionFactory.HIbernateSession;

public class Rolling_Return_New_Runner 
{
	public String Generate_Rolling_Return(String Fund_Type, Session ssn) 
	{
		String resp_code="Success"; 
		int db_flag=0;
		double rr_5=0,rr_4=0,rr_3=0,rr_2=0;
		Rolling_Return rr = null;
		Report_6_pk key = null;
		
//		 Session ssn=null;
		  try
		  {
			  
//			 ssn = HIbernateSession.getSessionFactory().openSession(); 
//			 ssn.beginTransaction();
//			 int loop=0;
//			 String Fund_Type="EQUITY_ELSS_NEW_31.03.2018";
			
			 
			 Query q = ssn.createQuery("select key.from_date,key.scheme_code from Scheme_available where key.Fund_Type='"+Fund_Type+"' order by key.scheme_code, key.from_date");
			    
			 List<Object[]> datas= (List<Object[]>)q.list();
		     for(Object[] d: datas)
		     {
		         java.util.Date date = (Date) d[0];
		         Integer scheme_code = Integer.parseInt(d[1].toString());
		         
		         rr = new Rolling_Return();
		         key = new Report_6_pk();
		         key.setScheme_code(scheme_code);
			     key.setFrom_date(date);
			     key.setFund_Type(Fund_Type);
			     rr.setKey(key);
			     
		         
//		         generate_rolling_return(date,scheme_code,5,rr,ssn); 	  
//		         generate_rolling_return(date,scheme_code,4,rr,ssn); 	
		         generate_rolling_return(date,scheme_code,3,rr,ssn); 	
		         generate_rolling_return(date,scheme_code,2,rr,ssn); 	
//		         break;
		         ssn.save(rr);
		         db_flag++;
		         
		         if(db_flag%500==0)
		 		    {
		 		    	 ssn.getTransaction().commit();
		 		         ssn.beginTransaction();
		 		    	 ssn.flush();
				         ssn.clear();
		 		    	
		 		        db_flag=0;
		 		    }
		         
		         
//		         break;
		         
		         		         
//		         System.out.println("Date-->>"+date+" <---Schemecode-->>"+scheme_code);
		         
		         
		         
		         
//		         loop++;
		     }
			 
		      
		     ssn.getTransaction().commit();
			 System.out.println("------Report Complete------"); 
			 
			  
		  }
		  catch (Exception e) {
			  e.printStackTrace();
			  resp_code="Error";
		}
		  finally
		  {
//			 if (ssn!=null && ssn.isOpen())
//			 {
//				ssn.close();
//			 }
					 
		  }
       return resp_code;
	}
	
	private static void generate_rolling_return(Date date, Integer scheme_code, int year,Rolling_Return rr ,Session ssn) {
        
		Calendar cal = Calendar.getInstance();	  	  
		double ret;
		
	  	  cal.setTime(date);
//	      cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+3));
	      cal.add(Calendar.YEAR,-(year-1));
	      Date derived_date = cal.getTime();
	      
	      String pattern = "yyyy-MM-dd";
	      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
	      String to_date = simpleDateFormat.format(date);
	      String from_date = simpleDateFormat.format(derived_date);
	      

	      
	      ssn.doWork(new Work() {
			
			@Override
			public void execute(Connection conn) throws SQLException {
				// TODO Auto-generated method stub
//				CallableStatement cstmt =  (CallableStatement) conn.prepareCall("{ CALL RVcalculateRollingReturn(?,?,?,?,?,?)}");
				CallableStatement cstmt =  (CallableStatement) conn.prepareCall("call RVTest(?,?,?,?)");
				
//				System.out.println("--From Date-->>"+from_date);
//				System.out.println("--To Date-->>"+to_date);
//				System.out.println("--Schemecode-->>"+scheme_code);

				cstmt.setString(1, from_date);
				cstmt.setString(2, to_date);
				cstmt.setInt(3, scheme_code);
				cstmt.setString(4, rr.getKey().getFund_Type());
				
//				cstmt.registerOutParameter(4, java.sql.Types.FLOAT);
//				cstmt.registerOutParameter(5, java.sql.Types.FLOAT);
//				cstmt.registerOutParameter(6, java.sql.Types.FLOAT);
//				 System.out.println("-==-=-=-=-=-BEFORE EXECUTE-=-=-==-"+from_date+" Todate-->"+to_date+" schemecode->"+scheme_code);
//				cstmt.execute();
				
				
				
//				System.out.println("GOT Result From Stored Procedure-->>>"+cstmt.getDouble(4));
//	            System.out.println("GOT Result From Stored Procedure-->>>"+cstmt.getFloat(5));
//	            System.out.println("GOT Result From Stored Procedure-->>>"+cstmt.getFloat(6));
				
	         
				boolean hadResults = cstmt.execute();
//				System.out.println("-==-=-=-=-=-AFTER EXECUTE-=-=-==-");
				if (hadResults) {
			        ResultSet rs = cstmt.getResultSet();
			       
			        if (rs.next()) {
			        	
//			        	System.out.println(rs.getDouble("rolling_return"));
//			        	System.out.println(rs.getDouble("aum"));
//			        	System.out.println(rs.getDouble("forwar_return"));
			        	
//			            System.out.println("GOT Result From Stored Procedure-->>>"+rs.getDouble(1));
//			            System.out.println("Forward_Return-->>>"+rs.getDouble(2));
//			            System.out.println("GOT Result From Stored Procedure-->>>"+rs.getDouble(3));
//			        	if(year==5) // not using
//			        	 {
//			        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
//			        		rr.setRolling_ret_5(rs.getDouble(1));
//			        		
//			        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
//			        			rr.setAum(rs.getDouble(3));
//			        		
//			        		
//			        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
//			        			{
//			        			   rr.setForward_12(rs.getDouble(2));
//			        			}
//			        		else
//			        		{
////			        			System.out.println("In ELSE PART 5"); 
//			        			rr.setForward_12(0.00);
//			        		}
//			        	 }
//			        	 if(year==4) // not using
//			        	{
//			        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
//			        		rr.setRolling_ret_4(rs.getDouble(1));
//			        		
//			        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
//			        			rr.setAum(rs.getDouble(3));
//			        		
//			        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
//			        			rr.setForward_12(rs.getDouble(2));
//			        		else{
////			        			System.out.println("In ELSE PART 4"); 
//			        			rr.setForward_12(0.00);
//			        		}
//			        	}
			        	 if(year==3)
			        	{
			        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
			        		rr.setRolling_ret_3(rs.getDouble(1));
			        		
			        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
			        			rr.setAum(rs.getDouble(3));
			        		
			        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
			        			rr.setForward_12(rs.getDouble(2));
			        		else{
//			        			System.out.println("In ELSE PART 3"); 
			        			rr.setForward_12(0.00);
			        		}
			        	}
			        	else if(year==2)
			        	{
			        		if(Double.compare(rs.getDouble(1),-99999.99)!=0)
			        		  rr.setRolling_ret_2(rs.getDouble(1));
			        		
			        		
			        		if(Double.compare(rs.getDouble(3),-99999.99)!=0)
			        			rr.setAum(rs.getDouble(3));
			        		
			        		if(Double.compare(rs.getDouble(2),-99999.99)!=0)
			        			rr.setForward_12(rs.getDouble(2));
			        		else{
//			        			System.out.println("In ELSE PART 2"); 
			        			rr.setForward_12(0.00);
			        		}
			        	}
//			        	ret = ret1;
			        	
			        }
			       
				}
				
				
			}
		});
	      
//	      System.out.println("<---Got YeAR-->>"+date);
//     	  System.out.println("<--After operation-->>"+derived_date);
	      
	     
		
	}
}
