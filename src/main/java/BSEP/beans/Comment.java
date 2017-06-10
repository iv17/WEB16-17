package BSEP.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "comment")
public class Comment implements Serializable {


	private static final long serialVersionUID = -5720814979747558344L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "text", unique = false, nullable = false)
	private String text;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true) 
	private User user;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "snippet_id", referencedColumnName = "id", nullable = true) 
	private Snippet snippet;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "comment") @JsonIgnore
	private Set<Rating> ratings;

	
	public Comment() {

	}

	public Comment(String text, Date date) {
		this.text = text;
		this.date = date;
	}
	
	public Comment(String text, Date date, Snippet snippet, User user) {
		this.text = text;
		this.date = date;
		this.user = user;
		this.snippet = snippet;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Snippet getSnippet() {
		return snippet;
	}

	public void setSnippet(Snippet snippet) {
		this.snippet = snippet;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}
		
	
}
