package BSEP.web.dto;

import BSEP.beans.PrivateConversation;

public class PrivateConversationDTO {

	private UserDTO creator;
	private UserDTO member;
	
	public PrivateConversationDTO() {
		
	}
	
	public PrivateConversationDTO(PrivateConversation privateConversation) {
		creator = new UserDTO(privateConversation.getCreator());
		member = new UserDTO(privateConversation.getMember());
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
	
	
}
