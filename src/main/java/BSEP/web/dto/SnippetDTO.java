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
	private AccessDTO accessDTO;
	private VisibilityDTO visibilityDTO;
	private UserDTO creatorDTO;
	private Set<CommentDTO> comments;
	
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
		accessDTO = new AccessDTO(snippet.getAccess());
		visibilityDTO = new VisibilityDTO(snippet.getVisibility());
		creatorDTO = new UserDTO(snippet.getCreator());
		
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

	public AccessDTO getAccessDTO() {
		return accessDTO;
	}

	public void setAccessDTO(AccessDTO accessDTO) {
		this.accessDTO = accessDTO;
	}

	public VisibilityDTO getVisibilityDTO() {
		return visibilityDTO;
	}

	public void setVisibilityDTO(VisibilityDTO visibilityDTO) {
		this.visibilityDTO = visibilityDTO;
	}

	public UserDTO getCreatorDTO() {
		return creatorDTO;
	}

	public void setCreatorDTO(UserDTO creatorDTO) {
		this.creatorDTO = creatorDTO;
	}

	public Set<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(Set<CommentDTO> comments) {
		this.comments = comments;
	}
	
	
}
