package BSEP.web.dto;

import java.util.Set;

import BSEP.beans.Snippet;

public class SnippetDTO {

	private int id;
	private String description;
	private String data;
	private LanguageDTO language;
	private String url;
	private int duration;
	private Boolean blocked;
	private AccessDTO access;
	private VisibilityDTO visibility;
	private UserDTO creator;
	private Set<CommentDTO> comments;
	
	
	private String languageName;
	private String accessName;
	private String visibilityName;
	
	public SnippetDTO() {
		
	}

	public SnippetDTO(Snippet snippet) {
		id = snippet.getId();
		description = snippet.getDescription();
		data = snippet.getData();
		language = new LanguageDTO(snippet.getLanguage());
		url = snippet.getUrl();
		duration = snippet.getDuration();
		blocked = snippet.getBlocked();
		access = new AccessDTO(snippet.getAccess());
		visibility = new VisibilityDTO(snippet.getVisibility());
		creator = new UserDTO(snippet.getCreator());
		
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

	public LanguageDTO getLanguage() {
		return language;
	}

	public void setLanguage(LanguageDTO language) {
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

	public AccessDTO getAccess() {
		return access;
	}

	public void setAccess(AccessDTO access) {
		this.access = access;
	}

	public VisibilityDTO getVisibility() {
		return visibility;
	}

	public void setVisibility(VisibilityDTO visibility) {
		this.visibility = visibility;
	}

	public UserDTO getCreator() {
		return creator;
	}

	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}

	public Set<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDTO> comments) {
		this.comments = comments;
	}
	
	

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getAccessName() {
		return accessName;
	}

	public void setAccessName(String accessName) {
		this.accessName = accessName;
	}

	public String getVisibilityName() {
		return visibilityName;
	}

	public void setVisibilityName(String visibilityName) {
		this.visibilityName = visibilityName;
	}

	
}
