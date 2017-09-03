package BSEP.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "user")
public class User implements Serializable {

	
	private static final long serialVersionUID = 704378297884438999L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "username", unique = false, nullable = true)
	private String username;
	
	@Column(name = "password", unique = false, nullable = true)
	private String password;
	
	@Column(name = "name", unique = false, nullable = true)
	private String name;
	
	@Column(name = "surname", unique = false, nullable = true)
	private String surname;
	
	@Column(name = "phone_number", unique = false, nullable = true)
	private String phoneNumber;
	
	@Column(name = "email", unique = false, nullable = true)
	private String email;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true) 
	private Location location;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "image_id", referencedColumnName = "id", nullable = true) 
	private Image image;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true) 
	private Role role;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "status_id", referencedColumnName = "id", nullable = true) 
	private Status status;
	
	@Column(name = "blocked", unique = false, nullable = true)
	private Boolean blocked;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "creator") @JsonIgnore
	private Set<Snippet> snippets;

	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user") @JsonIgnore
	private Set<Comment> comments;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "user") @JsonIgnore
	private Set<Rating> ratings;

	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name = "user_team", 
		joinColumns = {@JoinColumn(name = "id")}, 
		inverseJoinColumns = {@JoinColumn(name = "team_id")})
	private Set<Team> teams;	
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "teamLeader") @JsonIgnore
	private Set<Team> leaderTeams;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();

	public User() {
		
	}


	public User(String username, String password, String name, String surname, String phoneNumber, String email,
			Location location, Image image, Role role, Status status, Boolean blocked) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.location = location;
		this.image = image;
		this.role = role;
		this.status = status;
		this.blocked = blocked;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Set<Snippet> getSnippets() {
		return snippets;
	}

	public void setSnippets(Set<Snippet> snippets) {
		this.snippets = snippets;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<Team> getLeaderTeams() {
		return leaderTeams;
	}

	public void setLeaderTeams(Set<Team> leaderTeams) {
		this.leaderTeams = leaderTeams;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
	

}
