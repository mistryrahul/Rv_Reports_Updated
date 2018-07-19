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
		as.add("ab");
		as.add("ac");
		as.add("ad");
		as.add("ae");
		as.add("af");
		as.add("ag");
		as.add("ah");
		as.add("ai");
		as.add("aj");
		
		ArrayList<String> asg = new ArrayList<String>();
		
		asg.add("aa1");
		asg.add("ab1");
		asg.add("ac1");
		asg.add("ad1");
		asg.add("ae1");
		asg.add("af1");
		asg.add("ag1");
		asg.add("ah1");
		asg.add("ai1");
		asg.add("aj1");
		
		
		int i = 0;
		
		while( i < asg.size())
		{
			System.out.println(asg.get(i));
			System.out.println(as.get(i));
			i++;
		}
		
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
