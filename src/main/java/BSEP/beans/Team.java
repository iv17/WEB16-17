package BSEP.beans;

import java.io.Serializable;

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
@Table(name = "team")
public class Team implements Serializable {

	private static final long serialVersionUID = -4840610289482297579L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = true)
	private String name;
	
	@Column(name = "description", unique = false, nullable = true)
	private String description;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "team_leader", referencedColumnName = "id", nullable = true) 
	private User teamLeader;
	
	
	public Team() {
	
	}

	public Team(String name, String description, User teamLeader) {
		this.name = name;
		this.description = description;
		this.teamLeader = teamLeader;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getTeamLeader() {
		return teamLeader;
	}

	public void setTeamLeader(User teamLeader) {
		this.teamLeader = teamLeader;
	}


	
}
