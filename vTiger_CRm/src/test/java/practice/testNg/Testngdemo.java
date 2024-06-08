package practice.testNg;

import org.testng.annotations.Test;

public class Testngdemo {
	
		@Test()
		public void c() {
			System.out.println("c");
		}
		@Test(dependsOnMethods = "b")
		public void a() {
			System.out.println("a");
		}
		@Test(priority = 1)
		public void b() {
			System.out.println("b");
		}
		
		@Test()
		public void a1() {
			System.out.println("a1");
		}
	
}
