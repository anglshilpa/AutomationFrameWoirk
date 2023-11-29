package vt.practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RetryListners {
	
	
	 @Test(retryAnalyzer = vt.GenericUtilities.RetryAnalyzerImplementation.class)
	 public void retryListners(){
		 
		 Assert.assertTrue(false);
		 System.out.println("hello");
		System.out.println("hi");
		
		System.out.println("hello dis will give u conflict");
	 }

}
