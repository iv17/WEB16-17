package BSEP.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "private_conversation")
public class PrivateConversation extends Conversation {
	
	private static final long serialVersionUID = -8774784542639048042L;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "creator_id", referencedColumnName = "id", nullable = true) 
	private User creator;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "member_id", referencedColumnName = "id", nullable = true) 
	private User member;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "privateConversation") @JsonIgnore
	Set<PrivateMessage> messages;

	public PrivateConversation() {
		super();
	}
	
	public PrivateConversation(User creator, User member) {
		this.creator = creator;
		this.member = member;
	}

	public PrivateConversation(User creator, User member, Set<PrivateMessage> messages) {
		this.creator = creator;
		this.member = member;
		this.messages = messages;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public Set<PrivateMessage> getMessages() {
		return messages;
	}

	public void setMessages(Set<PrivateMessage> messages) {
		this.messages = messages;
	}
	
	
	
}
