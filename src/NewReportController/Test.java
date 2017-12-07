package NewReportController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import sessionFactory.HIbernateSession;

public class Test {

	public static void main(String[] args) throws ParseException 
	{
         
		Session ssn=null;
		ssn = HIbernateSession.getSessionFactory().openSession(); 
	    ssn.beginTransaction();
		 
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
	    String dt = "2008-03-31";
	    Date dd = null;
	    dd= formatter.parse(dt);
	    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
	      System.out.println(dd);
	    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=");
	    double r = New_Elss_Main.Calculate_Rolling_Return(ssn,226,dd, 1);
		
	    
	    System.out.println("Rolling-Return--->>"+r);
	    
		ssn.close();
		
	}

}
