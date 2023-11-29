package vt.GenericUtilities;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	/**
	 * this method is going to come up with random number for every run
	 */
	public int getRandom()
	{
		Random random=new Random();
		int ran = random.nextInt(1000);
		return ran;
		
	}
	/**
	 * this method is going to give u the current system date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		return  d.toString();
	}
	/**
	 * this method will give u d date n time of system in customized format
	 * @return
	 */
	public String  getsystemDateInFormat()
	{
		Date d=new Date();
		 String[] date = d.toString().split(" ");
		 String dateOfMonth = date[2];
		 String   month=date[1];
		 String  year=date[5];
		 String time=date[3].replace(":", "-");
		        
		 String systemDate=dateOfMonth+" "+month+" "+year+" "+time;
		 return systemDate;
	}

}
