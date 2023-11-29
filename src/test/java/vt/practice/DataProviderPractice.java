package vt.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice {
	   
	 @Test(dataProvider = "dd")
	 public void readData(String name , int number)
	 {
		 System.out.println(name+"++++"+number);
	 }
	
	  @DataProvider(name="dd")
	  public Object[][] getData()
	  {
		  Object [][] data=new Object[3][2];
		  data[0][0] ="hello";
		  data[0][1] = 1000;
		  
		  data[1][0] ="hello";
		  data[1][1] = 2000;
		  
		  data[2][0] ="hello";
		  data[2][1] = 3000;
		  return data;
		  
	  }

}
