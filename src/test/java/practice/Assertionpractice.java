package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertionpractice {
	
	// Hard assert 
	@Test
	public void demo1() {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals(true, false); // actual and expected should be same to pass test script
		System.out.println("step8");
	}
	
	// soft assert 
	@Test
	public void demo2() {
		
		SoftAssert sa = new SoftAssert();
		System.out.println("step3");
		System.out.println("step4");
		sa.assertEquals(true, false);
		System.out.println("step5");
		sa.assertAll();// logs all the failures at the end and stops the execution
		System.out.println("step6");
	}


}
