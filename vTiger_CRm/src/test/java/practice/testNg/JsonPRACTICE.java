package practice.testNg;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

public class JsonPRACTICE {
@Test
public void sample() throws Throwable {
	FileReader fr=new FileReader("./configAppData/vTigerCommondata.json");
	
	JSONParser jp=new JSONParser();
	Object o = jp.parse(fr);
	Object o2 = o;
	JSONObject jo=(JSONObject) o;
	
	
	
	 
	
	
	
}
}
