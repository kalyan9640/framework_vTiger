package com.vTiger.crm.generic.fileUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonFileUtility {
	
public String getDataFromJsonFile(String key) throws Throwable {
	
	FileReader fr=new FileReader("./configAppData/vTigerCommondata.json");
	JSONParser parser=new JSONParser();
	Object obj=parser.parse(fr);
	JSONObject map=(JSONObject)obj;
	String data = map.get(key).toString();
	return data;

}
}
