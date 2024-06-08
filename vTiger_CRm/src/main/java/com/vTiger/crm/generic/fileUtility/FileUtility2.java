package com.vTiger.crm.generic.fileUtility;

import java.io.FileReader;
import java.util.Properties;

public class FileUtility2 {
public static void main(String [] args) throws Throwable{
	
	FileReader fin=new FileReader("./configAppData/vTigerCommondata.properties");
	Properties p=new Properties();
	p.load(fin);
	String data = p.getProperty("browser");
	System.out.println(data);
	
	
	
}
}
