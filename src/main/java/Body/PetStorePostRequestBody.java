package Body;

public class PetStorePostRequestBody {
	public  String addPetBody() {
		return "{\r\n"
				+ "    \"id\": 10111,\r\n"
				+ "    \"category\": {\r\n"
				+ "        \"id\": 10111,\r\n"
				+ "        \"name\": \"One Doggie\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"Doggie\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "        \"Www.google.com\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 1,\r\n"
				+ "            \"name\": \"Doggie1\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 2,\r\n"
				+ "            \"name\": \"Doggie2\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"available\"\r\n"
				+ "}";
	}
	
	public String updatePetBody(){
		return "{\r\n"
				+ "    \"id\": 10110,\r\n"
				+ "    \"category\": {\r\n"
				+ "        \"id\": 10111,\r\n"
				+ "        \"name\": \"Two Doggies\"\r\n"
				+ "    },\r\n"
				+ "    \"name\": \"Doggies\",\r\n"
				+ "    \"photoUrls\": [\r\n"
				+ "        \"www.googleDogiee.com\"\r\n"
				+ "    ],\r\n"
				+ "    \"tags\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 1,\r\n"
				+ "            \"name\": \"Doggie3\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 2,\r\n"
				+ "            \"name\": \"Doggie4\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"status\": \"available\"\r\n"
				+ "}";
	}
}
