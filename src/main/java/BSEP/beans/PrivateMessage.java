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
}
