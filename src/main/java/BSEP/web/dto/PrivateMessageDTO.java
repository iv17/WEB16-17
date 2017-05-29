package BSEP.web.dto;

import BSEP.beans.PrivateMessage;

public class PrivateMessageDTO {

	private UserDTO sender;
	private UserDTO receiver;
	private PrivateConversationDTO privateConversationDTO;
	
	public PrivateMessageDTO() {
		
	}
	
	public PrivateMessageDTO(PrivateMessage privateMessage) {
		sender = new UserDTO(privateMessage.getSender());
		receiver = new UserDTO(privateMessage.getReceiver());
		privateConversationDTO = new PrivateConversationDTO(privateMessage.getPrivateConversation());
	}
	
	public UserDTO getSender() {
		return sender;
	}
	
	public void setSender(UserDTO sender) {
		this.sender = sender;
	}
	
	public UserDTO getReceiver() {
		return receiver;
	}
	
	public void setReceiver(UserDTO receiver) {
		this.receiver = receiver;
	}
	
	public PrivateConversationDTO getPrivateConversationDTO() {
		return privateConversationDTO;
	}
	
	public void setPrivateConversationDTO(PrivateConversationDTO privateConversationDTO) {
		this.privateConversationDTO = privateConversationDTO;
	}
	
	

}
