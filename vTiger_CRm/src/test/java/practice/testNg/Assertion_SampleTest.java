package practice.testNg;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion_SampleTest {

	@Test
	public void sampleTest(Method m) {
		Reporter.log(m.getName()+"\t test start");
		Reporter.log("Step-1",true);
		
		Reporter.log("",true);
		
		Reporter.log(null, true);
		
		Assert.assertEquals("pavan","pavan");
		Reporter.log("Step-2",true);
		
		Assert.assertEquals("pavan","pavan");

		Reporter.log("Step-3",true);
		Assert.assertEquals("pavan","pavan");

		Reporter.log("Step-4",true);
		Assert.assertEquals("pavan","pavan");
		
		Reporter.log("Step-5",true);
		Reporter.log(m.getName());
		
		
		
	}
	@Test
	public void sampleTest1(Method m) {
		Reporter.log(m.getName());
		Reporter.log("Step-1",true);
		SoftAssert assertObj=new SoftAssert();
		
		assertObj.assertEquals("pavan","kpavan");
		Reporter.log("Step-2",true);
		
		assertObj.assertEquals("pavan","pavan");
		
		Reporter.log("Step-3",true);
		assertObj.assertEquals("pavann","pavan");
	
//		Assert.assertEquals("pavann","pavan");
		
		Reporter.log("Step-4",true);
		assertObj.assertEquals("pavan","pavan");

		
		Reporter.log("Step-5",true);
//		assertObj.assertAll();
	}
	
	
	
}
