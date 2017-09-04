package BSEP.web.dto;

import java.util.Date;

import BSEP.beans.Comment;

public class CommentDTO {

	private int id;
	private String text;
	private Date date;
	private UserDTO userDTO;
	private SnippetDTO snippetDTO;
	
	public CommentDTO() {
		
	}
	
	public CommentDTO(Comment comment) {
		id = comment.getId();
		text = comment.getText();
		date = comment.getDate();
		userDTO = new UserDTO(comment.getUser());
		snippetDTO = new SnippetDTO(comment.getSnippet());
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

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public SnippetDTO getSnippetDTO() {
		return snippetDTO;
	}

	public void setSnippetDTO(SnippetDTO snippetDTO) {
		this.snippetDTO = snippetDTO;
	}
	
	
}
