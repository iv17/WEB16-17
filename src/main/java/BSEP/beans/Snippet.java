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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "snippet")
public class Snippet implements Serializable {


	private static final long serialVersionUID = 1102031599278352983L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "description", unique = false, nullable = true)
	private String description;
	
	@Column(name = "data", unique = false, nullable = true)
	private String data;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "language_id", referencedColumnName = "id", nullable = true) 
	private Language language;
	
	@Column(name = "url", unique = false, nullable = true)
	private String url;
	
	@Column(name = "duration", unique = false, nullable = true)
	private int duration;
	
	@Column(name = "blocked", unique = false, nullable = true)
	private Boolean blocked;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "access_id", referencedColumnName = "id", nullable = true) 
	private Access access;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "visibility_id", referencedColumnName = "id", nullable = true) 
	private Visibility visibility;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "creator_id", referencedColumnName = "id", nullable = true) 
	private User creator;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "snippet") @JsonIgnore
	private Set<Comment> comments;

	
	public Snippet() {
		
	}


	public Snippet(String description, String data, Language language, String url, int duration,
			Boolean blocked, Access access, Visibility visibility, User creator) {
		this.description = description;
		this.data = data;
		this.language = language;
		this.url = url;
		this.duration = duration;
		this.blocked = blocked;
		this.access = access;
		this.visibility = visibility;
		this.creator = creator;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	
}
