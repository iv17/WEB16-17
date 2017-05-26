package BSEP.beans;

import java.util.ArrayList;

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
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "private_conversation") @JsonIgnore
	ArrayList<PrivateMessage> messages;
	
}
