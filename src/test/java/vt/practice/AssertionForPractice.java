package vt.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionForPractice {
	
	@Test
	public void assrtion()
	{
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(true,false);
		System.out.println("step3");
		System.out.println("step3");
	}

}
