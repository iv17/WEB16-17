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
	
	@Column(name = "lat", unique = false, nullable = false)
	private double lat;
	
	@Column(name = "lng", unique = false, nullable = false)
	private double lng;
	
	@Column(name = "country", unique = false, nullable = false)
	private String country;
	
	@Column(name = "city", unique = false, nullable = false)
	private String city;
	
	@Column(name = "street", unique = false, nullable = false)
	private String street;
	
	@Column(name = "number", unique = false, nullable = false)
	private String number;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "location") @JsonIgnore
	Set<User> users;

}
