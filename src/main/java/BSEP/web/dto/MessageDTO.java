package BSEP.web.dto;

import java.util.Date;
import java.util.Set;

import BSEP.beans.Attachment;
import BSEP.beans.Message;

public class MessageDTO {

	private int id;
	private String text;
	private Date date;
	private Set<AttachementDTO> attachments;
	
	public MessageDTO() {
		
	}
	

	public MessageDTO(Message message) {
		id = message.getId();
		text = message.getText();
		date = message.getDate();
		for (Attachment attachment : message.getAttachments()) {
			attachments.add(new AttachementDTO(attachment));
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

	public Set<AttachementDTO> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<AttachementDTO> attachments) {
		this.attachments = attachments;
	}
	
	
}
