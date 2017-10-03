package completeDebt;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import controller.Nav_report_temp_1_main;
import model.Nav_report_temp_1;
import model.nav_report_3_stable;

public class Nav_Report_temp_1_Runner 
{
   
	public String Calculate_Nav_Report(String Fund_Type)
	{
		
//		Generate_rank();
		
//		String Fund_Type;
		Session ssn = null;
		int i=0,db_flag=0;
		long scheme_code_temp=0;
		Nav_report_temp_1 tmp_obj=null;
		//String date_inp="31/03/2012";
		
		try
		{
			
			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
			ssn = sessionfactry.openSession();
//			ssn.beginTransaction();
		
			
//			Query query = ssn.createQuery("from controller.nav_report_3_stable order by scheme_code,id");
//			List<controller.nav_report_3_stable> results = query.list();
//			Criteria criteria_1 = ssn.createCriteria( nav_report_3_stable.class );
//			criteria_1.setProjection( Projections.distinct(Projections.property("nav_from_date")));  		
//	  		criteria_1.add(Restrictions.eq("scheme_Code", s_code));
//	  		criteria_1.addOrder(Order.asc("nav_from_date"));
			
			
			List<Long> results = ssn.createCriteria( nav_report_3_stable.class ).setProjection( Projections.distinct(Projections.property("scheme_Code"))).add(Restrictions.eq("Fund_Type", Fund_Type)).list();
			
//			List<Long> results = new ArrayList<Long>();
//			results.add((long)7615);
			
			ssn.close(); // closing session
		    
		    for(long sch_cd : results)
		    {
		    	
		    	
		    	Nav_report_temp_1_main.Get_Dates(sch_cd,Fund_Type);
		    	
		    }
		    
		    System.out.println("<---COMPLETE MAKING REPORT--->");
		    System.out.println("<----Started Caculating Rank---->");
		    Nav_report_temp_1_main.Generate_rank(Fund_Type);
		    
		    
//			ssn.getTransaction().commit(); // committing session
		
			 
			
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return e.getMessage();
		}
		
		return "success";
	}
	
}
