package onBuy.com.practice;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

public class JsonRead {
	@Test
	public void ReadData() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser p=new JSONParser();
		Object obj = p.parse(new FileReader("C:\\Users\\lenovo\\Desktop\\AppData.json"));
		
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("Browser"));
		System.out.println(map.get("UserUrl"));
		System.out.println(map.get("AdminUrl"));
		System.out.println(map.get("AdminUn"));
		System.out.println(map.get("AdminPwd"));
		System.out.println(map.get("UserUn"));
		System.out.println(map.get("UserPwd"));

	}

}
