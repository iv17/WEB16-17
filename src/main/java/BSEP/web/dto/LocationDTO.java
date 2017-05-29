package BSEP.web.dto;

import BSEP.beans.Location;

public class LocationDTO {

	private int id;
	private double lat;
	private double lng;
	private String country;
	private String city;
	private String street;
	private String number;
	
	public LocationDTO() {
		
	}
	
	public LocationDTO(Location location) {
		id = location.getId();
		lat = location.getLat();
		lng = location.getLng();
		country = location.getCountry();
		city = location.getCity();
		street = location.getStreet();
		number = location.getNumber();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getLat() {
		return lat;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public double getLng() {
		return lng;
	}
	
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
