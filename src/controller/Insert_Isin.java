package controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Navhistfull_adjnavrs;
import model.Schemeisin;

public class Insert_Isin 
{
     public static void main(String args[])
     {
    	 double no_of_lines;
 		String scheme_cd="", dt="",tmp_val="";
 		final Pattern pattern = Pattern.compile("<<row>>(.+?)<</row>>");
 		Matcher matcher;
 		long i= 0;  // make this the last id after each operation
 		int i_i=1;
 		Session ssn = null;
 		try
 		{   
 			LineIterator it = FileUtils.lineIterator(new File("/home/rv/Desktop/scheme_isin/SchemeISIN/SchemeISINMaster.ace"), "UTF-8");
 			SessionFactory sessionfactry = new Configuration().configure().buildSessionFactory();
 			ssn = sessionfactry.openSession();
 			ssn.beginTransaction();
 			
 			
 			while (it.hasNext()) // if the file has lines 
      	    {

 				tmp_val=it.nextLine();
 				
 				
 				if(tmp_val.equals("<<eof>>"))
 				{
 					i=1;
 					break;
 					
 				}
 				matcher = pattern.matcher(tmp_val);
 				matcher.find();
 				String[] separated = matcher.group(1).split("\\|");
 						
 				Schemeisin nb = new Schemeisin();
 				nb.setId(Integer.parseInt(separated[0]));
 				
 				
 				nb.setIsin(separated[1]);
 				
 				nb.setScheme_code(Long.parseLong(separated[2]));
 				
 				nb.setAmc_code(Long.parseLong(separated[3]));
 				
 				nb.setNseSymbol(separated[4]);
 				
 				nb.setSeries(separated[5]);
 				
 				nb.setRTAScheme_code(separated[6]);
 				
 				nb.setAMCSchemecode(separated[7]);
 				
 				nb.setLongSchemeDescrip(separated[8]);
 				
 				nb.setShortSchemeDescrip(separated[9]);
 				
 				ssn.save(nb);
 				i_i++;
 				
 				
// 				//nb.setNav_date(new java.sql.Date( new SimpleDateFormat("yyyy-mm-dd").parse(separated[1]).getTime()));
// 				
// 				java.util.Date dd = new SimpleDateFormat("yyyy-MM-dd").parse(separated[1].substring(0,10));
// 				
//// 				java.util.Date dd = new SimpleDateFormat("M/dd/yyyy").parse(separated[1]);
// 				
// 				//System.out.println("SQl DAte After Conversion-->"+new java.sql.Date(dd.getTime()));
// 				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
// 				//System.out.println("DATe Actual-->"+separated[1].substring(0, 10));
// 				//System.out.println("DATe Parsed-->>"+dd);
// 				
// 				nb.setNavdate(new java.sql.Date(dd.getTime()));
// 			   
// 								
// 				
// 				//System.out.println("DATe-->"+new java.sql.Date(dd.getTime()));
// 				//nb.setNav_date(new java.sql.Date( new java.util.Date(separated[1]).getTime() ));
// 				if(separated[2] != null && !separated[2].isEmpty())
// 				{
// 					nb.setNavrs(Double.parseDouble(separated[2]));	
// 				}
// 				else
// 				{
// 					nb.setNavrs(0.00);
// 				}
// 				
// 				if(separated[3] != null && !separated[3].isEmpty())
// 				{
// 					nb.setAdjnavrs(Double.parseDouble(separated[3]));
// 				}
// 				else
// 				{
// 					nb.setAdjnavrs(0.00);
// 				}
// 				
// 				if(separated[4] != null && !separated[4].isEmpty())
// 				{
// 					nb.setRepurprice(Double.parseDouble(separated[4]));	
// 				}
// 				else
// 				{
// 					nb.setRepurprice(0.00);
// 				}
 				
 				if (i_i%500==0)
				{
					  ssn.flush();
				      ssn.clear();
				      ssn.getTransaction().commit(); 
				      ssn.beginTransaction();
				      i_i=1;
				}
      	    }
 		}
 		catch (Exception e) 
 		{
             e.printStackTrace();
		}
 		finally
 		{
 			ssn.getTransaction().commit();
 			ssn.close();
 		}
     }
}
