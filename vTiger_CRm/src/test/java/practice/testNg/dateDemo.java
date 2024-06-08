package practice.testNg;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;



public class dateDemo {
@Test
	public void requiredDateYYYYMMDD() {
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		sdf.format(dateobj);
		Calendar cal=sdf.getCalendar();
		System.out.println(sdf.format(cal.getTime()));
		sdf.format(cal.getTime());
}
}