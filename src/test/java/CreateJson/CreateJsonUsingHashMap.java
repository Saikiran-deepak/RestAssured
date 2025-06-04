package CreateJson;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateJsonUsingHashMap {

	public static void main(String[] args) {
		//Required	dependency <!-- https://mvnrepository.com/artifact/org.hamcrest/hamcrest -->
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("accuracy",50);
		map.put("name","Frontline house2");
		map.put("phone_number"," 111 222 3333");
		map.put("address","29, Kiran side layout, cohen 09");
		map.put("website","http://google.com");
		map.put("language","ENG-IN");

		ArrayList<String> al=new ArrayList<String>();
		al.add( "shoe park");
		al.add( "shop");
		map.put("types", al);
		HashMap<String,String> map2=new HashMap<String,String>();
		map2.put("lat", "-38.383494");
		map2.put("lng", " 33.427362");
		map.put("location", map2);
		
		//System.out.println(map);
		
		Response response1 = given().contentType(ContentType.JSON).body(map).log().body()
				.post("https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123");
		
		response1.prettyPrint();
		
	}
}
