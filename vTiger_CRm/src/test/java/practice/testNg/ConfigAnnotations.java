package practice.testNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConfigAnnotations {
	
	@BeforeClass()
	public void bc() {
		System.out.println("a Before  class");
	}
	
	@BeforeClass
	public void cBc() {
		System.out.println("c Before class");
	}
	
	@BeforeMethod()
	public void bm() {
		System.out.println("Before method");
	}
	
	
	@Test()
	public void CreateContactTest() {
		System.out.println("create contact");
	}
	
	@AfterMethod()
	public void am() {
		System.out.println("After method");
	}
	@AfterClass()
	public void aac() {
		System.out.println("After a class");
	}
	@AfterClass()
	public void bac() {
		System.out.println("After b class");
	}
}
