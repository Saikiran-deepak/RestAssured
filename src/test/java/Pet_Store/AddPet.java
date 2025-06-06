package Pet_Store;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import Body.PetStorePostRequestBody;

public class AddPet {
	PetStorePostRequestBody b;
	int placeID;

	@Test(priority = 1)
	public void addNewPet() {
		b = new PetStorePostRequestBody();

		Response response = given().contentType(ContentType.JSON).body(b.addPetBody())
				.post("https://petstore.swagger.io/v2/pet");
		// response.prettyPrint();
		JsonPath js = response.jsonPath();
		placeID = js.getInt("id");
	}

	@Test(priority = 2, dependsOnMethods = "addNewPet")
	public void getPetDetails() {
		Response response = given().pathParam("id", placeID).log().body()
				.get("https://petstore.swagger.io/v2/pet/{id}");
		JsonPath js = response.jsonPath();
		Integer id = js.get("category.id");
		String cName = js.get("category.name");
		List<Object> tags = js.getList("tags.id");
		int a = tags.size();
		for (int i = 0; i < tags.size(); i++) {
			Integer tagID = js.get("tags[" + i + " ].id");
			String tagName = js.get("tags[" + i + "].name");
			System.out.println(tagID);
			System.out.println(tagName);
		}
		System.out.println(id);
		System.out.println(cName);

	}

	@Test(priority = 3, dependsOnMethods = "getPetDetails")
	public void updatePet() {
		given().contentType(ContentType.JSON).body(b.updatePetBody()).post("https://petstore.swagger.io/v2/pet");
	}

	@Test(priority = 4, dependsOnMethods = "updatePet")
	public void getPetDetailsAfterUpdate() {
		Response response = given().pathParam("id", placeID).log().body()
				.get("https://petstore.swagger.io/v2/pet/{id}");
		JsonPath js = response.jsonPath();
		Integer id2 = js.get("category.id");
		String cName2 = js.get("category.name");
		List<Object> tags = js.getList("tags.id");
		int a = tags.size();
		for (int i = 0; i < tags.size(); i++) {
			Integer tagID2 = js.get("tags[" + i + " ].id");
			String tagName2 = js.get("tags[" + i + "].name");
			System.out.println(tagID2);
			System.out.println(tagName2);
		}
		System.out.println(id2);
		System.out.println(cName2);

	}
	@Test(priority=5, dependsOnMethods= "getPetDetailsAfterUpdate")
	public void deletePet() {
		given().contentType(ContentType.JSON).pathParam("id",placeID)
		.post("https://petstore.swagger.io/v2/pet/{id}");
	}
}
