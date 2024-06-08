package task;

import org.testng.annotations.Test;

public class CHARRANDOM {
@Test(invocationCount = 10)
public void test() {
	
String s="";
	String alpnum="123456789abcdefghijklmnopqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	
	for (int i = 0; i < 5; i++) {
		s=s+alpnum.charAt((int) (alpnum.length()*Math.random()));
	}
	System.out.println(s);
	
	
	
}

}
