package practice.testNg;

import org.testng.annotations.Test;

public class trycatch {

	@Test(expectedExceptions = Throwable.class)
	public void m1() {
		try {
			System.out.println(10/0);
		} catch (StringIndexOutOfBoundsException e) {
			e.printStackTrace();
		}
		catch (ArrayIndexOutOfBoundsException e) {
			// TODO: handle exception
		}
		System.out.println("hii");
	}
}
