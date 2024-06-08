import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

public class demo {
	
	WebDriver d=new ChromeDriver();
	
	
	
	public static void main(String[] args) {
		
		
		WebDriver d=new ChromeDriver();
		d.get("https://www.facebook.com");
		System.out.println(d.getPageSource());
	WebElement e = d.findElement(null);
		Select s=new Select(e);
		Actions a=new Actions(d);
		RemoteWebDriver rwd=(RemoteWebDriver) d;
		TakesScreenshot ts=rwd;
		
//		try {
//			String s = "a";
//			System.out.println(s.charAt(10));
//			System.out.println("haii");
//		} 
//		
//	catch (StringIndexOutOfBoundsException e) {
//		
//	}
//		catch (Exception e) {
//			
//		}
//		finally {
//			System.out.println("hello");
//		}
	}
}
