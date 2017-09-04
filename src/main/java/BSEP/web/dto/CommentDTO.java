package BSEP.web.dto;

import java.util.Date;

import BSEP.beans.Comment;
import BSEP.beans.Rating;

public class CommentDTO {

	private int id;
	private String text;
	private Date date;
	private UserDTO userDTO;
	private SnippetDTO snippetDTO;

	private int plus = 0;
	private int minus = 0;

	public CommentDTO() {

	}

	public CommentDTO(int id) {
		this.id = id;
	}

	public CommentDTO(Comment comment) {
		id = comment.getId();
		text = comment.getText();
		date = comment.getDate();
		userDTO = new UserDTO(comment.getUser());
		snippetDTO = new SnippetDTO(comment.getSnippet());
		if(comment.getRatings().size() != 0) {
			for (Rating rating : comment.getRatings()) {
				if(comment.getRatings().size() == 0) {
					plus = 0;
					minus = 0;
				} else {
					plus += rating.getPlus();
					minus += rating.getMinus();
				}
			}
		}

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

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public int getMinus() {
		return minus;
	}

	public void setMinus(int minus) {
		this.minus = minus;
	}


}
