package NewQuarterlyReports;

import java.util.ArrayList;

import org.hibernate.Session;

import sessionFactory.HIbernateSession;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		  Session ssn= null;
//		  ssn = HIbernateSession.getSessionFactory().openSession(); 
//		  ssn.beginTransaction();
//		  
//		NewEquityReportRunner.get_rating_list(ssn, "EQUITY_ELSS_31.03.2018", 3, "2010-06-30");
//		
//		  ssn.close();
		
		
		
		ArrayList<String> as = new ArrayList<String>();
		as.add("aa");
		String c="aa";
		System.out.println(as.contains(c));
		if(as.contains(c))
		{
			 System.out.println("in alllll");
		}
//		as.add("aa");
//		as.add("bb");
	}

}
