package com.Rest_Assurd;

import static io.restassured.RestAssured.*;

import com.RequestBody.UserDefinedMethods;
import com.RequestBody.addAddress;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;
import org.testng.Assert;

public class Test1 {
	static String placeid;
	public static void main(String[] args) {
		testAddPlace();
		GetPlace();
		updatePlace() ;
		GetPlace();
		deletePlace();
		//GetPlace();
	}
	
	public static void testAddPlace() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(addAddress.Addplace())
		.when().post("maps/api/place/add/json")
		.then().assertThat().statusCode(200)
		.body("scope",equalTo("APP"))
		.extract().response().asString();
		System.out.println(response);
		
		JsonPath js=new JsonPath(response);
		placeid=js.get("place_id");
		//System.out.println(placeid);
	}
	
	public static void GetPlace() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().queryParam("place_id", placeid).queryParam("key", "qaclick123")
		.when().post("maps/api/place/get/json")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		//System.out.println(response);
		
		//JsonPath jp=new JsonPath(response);
		JsonPath jp=UserDefinedMethods.rawToJson(response);
		String address=jp.get("address");
		System.out.println(address);
	}
	
	public static void updatePlace() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().queryParam("key", "qaclick123").header("Content-Type","application/json")
				.body(addAddress.updatePlace(placeid))
				.when().put("maps/api/place/update/json")
				.then().extract().response().asString();
		JsonPath jp=new JsonPath(response);		
		String address=jp.get("msg");
		System.out.println(address);
		Assert.assertEquals(address,"Address successfully updated");
	}
	
	public static void deletePlace() {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123")
		.body(addAddress.deletePlace(placeid))
		.when().delete("maps/api/place/delete/json")
		.then().extract().asString();
		System.out.println(response);
		JsonPath jp=new JsonPath(response);	
		String address=jp.get("status");
		System.out.println(address);
	}
	
}
