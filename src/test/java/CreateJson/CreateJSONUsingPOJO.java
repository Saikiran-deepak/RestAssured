package CreateJson;

import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateJSONUsingPOJO {
public static void main(String[] args) {
	PojoUser	pojo=	new PojoUser("50", "Jiraiya", "9988776655", "Testing pojp address", "http://google.com", "ENG-IN",-38.383494f,33.427362f);
//	ArrayList<Float>	arrayList=new ArrayList<Float>();
//	arrayList.add(-38.383494f);
//	arrayList.add(33.427362f);
//	pojo.setMobile(arrayList);
	pojo.setType("Shor park","Shop");
	//LocationPojo locPojo=new LocationPojo(-38.383494f,33.427362f);
	
	Response response=given().contentType(ContentType.JSON).body(pojo).log().body()
			.post("https://rahulshettyacademy.com/maps/api/place/add/json?key=qaclick123");
	
}
}
