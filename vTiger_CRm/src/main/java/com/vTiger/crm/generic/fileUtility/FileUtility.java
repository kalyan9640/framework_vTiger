package com.vTiger.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;


/**
 * contains resuable method of property file
 * @author Pavan Kalyan
 */
public class FileUtility {
	
	/**
	 * 
	 * @param key
	 * @return String
	 * @throws Throwable
	 */
	
public String getDataFromPropertiesFile(String key) throws Throwable{
	
	FileInputStream fin=new FileInputStream("./configAppData/vTigerCommondata.properties");
	Properties p=new Properties();
	p.load(fin);
	String data = p.getProperty(key);
	
	return data;
}
}
