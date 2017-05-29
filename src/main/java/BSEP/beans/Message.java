package BSEP.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "message")
public class Message implements Serializable {

	
	private static final long serialVersionUID = -8698064122936279494L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "message_id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "text", unique = false, nullable = false)
	private String text;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;
	
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinTable(name = "attachments_messages", 
		joinColumns = {@JoinColumn(name = "message_id")}, 
		inverseJoinColumns = {@JoinColumn(name = "id")})
	private Set<Attachment> attachments;

	
	public Message() {
		
	}

	public Message(String text, Date date, Set<Attachment> attachments) {
		this.text = text;
		this.date = date;
		this.attachments = attachments;
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

	public Set<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(Set<Attachment> attachments) {
		this.attachments = attachments;
	}
	

}
