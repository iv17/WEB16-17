package BSEP.web.dto;

import java.util.Set;

import BSEP.beans.PrivateConversation;
import BSEP.beans.PrivateMessage;

public class PrivateConversationDTO {

	private UserDTO creator;
	private UserDTO member;
	private Set<PrivateMessageDTO> messages;
	
	public PrivateConversationDTO() {
		
	}
	
	public PrivateConversationDTO(PrivateConversation privateConversation) {
		creator = new UserDTO(privateConversation.getCreator());
		member = new UserDTO(privateConversation.getMember());
		for (PrivateMessage privateMessage : privateConversation.getMessages()) {
			messages.add(new PrivateMessageDTO(privateMessage));
		}
	}
	
	public UserDTO getCreator() {
		return creator;
	}
	
	public void setCreator(UserDTO creator) {
		this.creator = creator;
	}
	
	public UserDTO getMember() {
		return member;
	}
	
	public void setMember(UserDTO member) {
		this.member = member;
	}

	public Set<PrivateMessageDTO> getMessages() {
		return messages;
	}

	public void setMessages(Set<PrivateMessageDTO> messages) {
		this.messages = messages;
	}
	
	
}
