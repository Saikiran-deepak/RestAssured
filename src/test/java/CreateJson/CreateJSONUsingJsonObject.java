package CreateJson;

import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateJSONUsingJsonObject {
	public static void main(String[] args) {
		// Required Dependency <!-- https://mvnrepository.com/artifact/org.json/json -->
		JSONObject jsonOBJ = new JSONObject();
		jsonOBJ.put("accuracy", 50);
		jsonOBJ.put("name", "Frontline house2");
		jsonOBJ.put("phone_number", " 111 222 3333");
		jsonOBJ.put("address", "29, Kiran side layout, cohen 09");
		jsonOBJ.put("website", "http://google.com");
		jsonOBJ.put("language", "ENG-IN");
		JSONArray Types = new JSONArray();
		Types.put("shoe park");
		Types.put("shop");
		jsonOBJ.put("types", Types);
		JSONObject location = new JSONObject();
		location.put("lat", "-38.383494");
		location.put("lng", " 33.427362");
		jsonOBJ.put("location", location);
		
		Response response=given().contentType(ContentType.JSON).body(jsonOBJ.toString()).log().all()
				.post("https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123");
	}
}
