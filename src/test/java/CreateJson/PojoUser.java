package CreateJson;

import java.util.ArrayList;

public class PojoUser {

	private String accuracy;
	private String name;
	private String phone_number;
	private String address;
	private String website;
	private String language;
	private ArrayList<String> type;
	private LocationPojo location;

	public PojoUser(String accuracy, String name, String phone_number, String address, String website, String language,
			Float lat, Float lng) {
		this.accuracy = accuracy;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.website = website;
		this.language = language;
		this.type = new ArrayList<String>();
		this.setLocation(new LocationPojo(lat, lng));
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

//	public ArrayList<Float> getLoc() {
//		return loc;
//	}
//
//	public void setLoc(ArrayList<Float> mobile) {
//		this.loc = mobile;
//	}

	public void setType(String... typedetails) {
		for (int i = 0; i < typedetails.length; i++) {
			this.type.add(typedetails[i]);
		}
	}

	public ArrayList<String> getType() {
		return type;
	}

	public LocationPojo getLocation() {
		return location;
	}

	public void setLocation(LocationPojo location) {
		this.location = location;
	}

}
