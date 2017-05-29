package BSEP.web.dto;

import java.util.Date;

import BSEP.beans.Message;

public class MessageDTO {

	private int id;
	private String text;
	private Date date;
	
	
	public MessageDTO() {
		
	}
	
	public MessageDTO(Message message) {
		id = message.getId();
		text = message.getText();
		date = message.getDate();
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
	
	
}
