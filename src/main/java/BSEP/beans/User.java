package BSEP.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "username", unique = false, nullable = false)
	private String username;
	
	@Column(name = "password", unique = false, nullable = false)
	private String password;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "surname", unique = false, nullable = false)
	private String surname;
	
	@Column(name = "phone_number", unique = false, nullable = false)
	private String phoneNumber;
	
	@Column(name = "email", unique = false, nullable = false)
	private String email;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "location_id", referencedColumnName = "id", nullable = true) 
	private Location location;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "role_id", referencedColumnName = "id", nullable = true) 
	private Role role;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "image_id", referencedColumnName = "id", nullable = true) 
	private Image image;
	
	@Column(name = "blocked", unique = false, nullable = false)
	private Boolean blocked;
	
	
	
	ArrayList<Snippet> snippets;
	ArrayList<Comment> comments;
	ArrayList<Rating> ratings;
	ArrayList<Team> teams;
	ArrayList<PrivateConversation> privateConversations;
	ArrayList<TeamConversation> teamConversations;
}
