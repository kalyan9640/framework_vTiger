package com.vTiger.crm.generic.javaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * contains reusable java methods
 * 
 * @author Pavan Kalyan
 */

public class JavaUtility {
public int getRandomNumber() {
	Random random=new Random();
	int randomNumber = random.nextInt(5000);
	
	return randomNumber;
}

public String getSystemDateYYYYMMDD() {
	Date dateobj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	String date = sdf.format(dateobj);
	
	return date;
}
public String requiredDateYYYYMMDD(int days) {
	Date dateobj=new Date();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	sdf.format(dateobj);
	Calendar cal=sdf.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String requiredDate = sdf.format(cal.getTime());
	
	return requiredDate;
	
}
public static void main(String[] args) {
	JavaUtility j=new JavaUtility();
	System.out.println(j.requiredDateYYYYMMDD(-30));
	System.out.println(j.getRandomNumber());
	System.out.println(j.getSystemDateYYYYMMDD());
}


}
