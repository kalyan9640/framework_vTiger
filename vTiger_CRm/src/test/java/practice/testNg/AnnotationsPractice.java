package practice.testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AnnotationsPractice {

	@BeforeClass(dependsOnMethods = "bc1")
	public void bc() {
		System.out.println("Before class");
	}
	
	@BeforeClass()
	public void bc1() {
		System.out.println("Before class 1");
	}
	
	
	@Test(expectedExceptions = Exception.class)
	public void test() {
		double b=10/0;
		System.out.println(b);	
		String s="";
		System.out.println(s.charAt(100));
		
	}
	
	

}
