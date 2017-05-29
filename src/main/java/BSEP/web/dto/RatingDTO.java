package BSEP.web.dto;

import java.util.Date;

import BSEP.beans.Rating;

public class RatingDTO {

	private int id;
	private int rate;
	private Date date;
	private CommentDTO commentDTO;
	private UserDTO userDTO;
	
	public RatingDTO() {
		
	}

	public RatingDTO(Rating rating) {
		id = rating.getId();
		rate = rating.getId();
		date = rating.getDate();
		commentDTO = new CommentDTO(rating.getComment());
		userDTO = new UserDTO(rating.getUser());
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public CommentDTO getCommentDTO() {
		return commentDTO;
	}

	public void setCommentDTO(CommentDTO commentDTO) {
		this.commentDTO = commentDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}
	
	
	
}
