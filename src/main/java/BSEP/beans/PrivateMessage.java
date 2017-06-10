package BSEP.beans;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "private_message")
public class PrivateMessage extends Message {


	private static final long serialVersionUID = -3966381607551170008L;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = true) 
	private User sender;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "receiver_id", referencedColumnName = "id", nullable = true) 
	private User receiver;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "conversation_id", referencedColumnName = "id", nullable = true) 
	private PrivateConversation privateConversation;
	
	public PrivateMessage() {
		super();
	}
	
	public PrivateMessage(Message message, User sender, User receiver) {
		super();
		this.text = message.getText();
		this.date = message.getDate();
		this.sender = sender;
		this.receiver = receiver;
	}
	
	public PrivateMessage(User sender, User receiver, PrivateConversation privateConversation) {
		this.sender = sender;
		this.receiver = receiver;
		this.privateConversation = privateConversation;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public PrivateConversation getPrivateConversation() {
		return privateConversation;
	}

	public void setPrivateConversation(PrivateConversation privateConversation) {
		this.privateConversation = privateConversation;
	}
	
	
}
