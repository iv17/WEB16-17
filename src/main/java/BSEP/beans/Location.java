package BSEP.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "location")
public class Location implements Serializable {


	private static final long serialVersionUID = -1111804887427054210L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "lat", unique = false, nullable = true)
	private double lat;
	
	@Column(name = "lng", unique = false, nullable = true)
	private double lng;
	
	@Column(name = "country", unique = false, nullable = true)
	private String country;
	
	@Column(name = "city", unique = false, nullable = true)
	private String city;
	
	@Column(name = "street", unique = false, nullable = true)
	private String street;
	
	@Column(name = "number", unique = false, nullable = true)
	private String number;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "location") @JsonIgnore
	Set<User> users;

	public Location() {
		
	}

	public Location(double lat, double lng, String country, String city, String street, String number) {
		this.lat = lat;
		this.lng = lng;
		this.country = country;
		this.city = city;
		this.street = street;
		this.number = number;
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

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	
}
