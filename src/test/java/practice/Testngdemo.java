package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testngdemo {
	@Test
	
	public void t1(){
		System.out.println("Test case 1 ");
	}
	@Test
	public void t2(){
		System.out.println("Test case 2 ");
	}
	@BeforeMethod
	public void bm(){
		System.out.println("Before method");
	}
	@AfterMethod
	public void am(){
		System.out.println("After method");
	}
	@BeforeClass
	public void bc(){
		System.out.println("Before Class");
	}
	@AfterClass
	public void ac(){
		System.out.println("After Class");
	}

}
