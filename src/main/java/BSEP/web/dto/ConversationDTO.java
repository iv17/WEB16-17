package BSEP.web.dto;

import java.util.Date;

import BSEP.beans.Conversation;

public class ConversationDTO {

    private int id;
	private String name;
	private String description;
	private String purpose;
	private Date dateCreated;
	
	
	public ConversationDTO() {
		
	}
	
	public ConversationDTO(Conversation conversation) {
		id = conversation.getId();
		name = conversation.getName();
		description = conversation.getDescription();
		purpose = conversation.getPurpose();
		dateCreated = conversation.getDateCreated();
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
	
	public String getPurpose() {
		return purpose;
	}
	
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	
}
