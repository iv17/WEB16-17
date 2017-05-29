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
@Table(name = "visibility")
public class Visibility implements Serializable { //PUBLIC, TEAM, LINKED, PRIVATE

	
	private static final long serialVersionUID = -6421601052034805652L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "snippet") @JsonIgnore
	Set<Snippet> snippets;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "attachment") @JsonIgnore
	Set<Attachment> attachments;
	
	public Visibility() {
	
	}

	public Visibility(int id, String name) {
		this.id = id;
		this.name = name;
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

	public Set<Snippet> getSnippets() {
		return snippets;
	}

	public void setSnippets(Set<Snippet> snippets) {
		this.snippets = snippets;
	}

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}

	
}
