package BSEP.beans;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "attachment")
public class Attachment implements Serializable {


	private static final long serialVersionUID = -3593072198079892205L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = true)
	private String name;
	
	@Column(name = "description", unique = false, nullable = true)
	private String description;
	
	@Column(name = "data", unique = false, nullable = true)
	private byte [] data;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "attachment_type_id", referencedColumnName = "id", nullable = true) 
	private AttachmentType attachmentType;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "access_id", referencedColumnName = "id", nullable = true) 
	private Access access;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "visibility_id", referencedColumnName = "id", nullable = true) 
	private Visibility visibility;

	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy = "attachments")  
	private Set<Message> messages;
	
	
	public Attachment() {
		
	}

	public Attachment(String name, String description, byte[] data, AttachmentType attachmentType,
			Access access, Visibility visibility) {
		this.name = name;
		this.description = description;
		this.data = data;
		this.attachmentType = attachmentType;
		this.access = access;
		this.visibility = visibility;
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public AttachmentType getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(AttachmentType attachmentType) {
		this.attachmentType = attachmentType;
	}

	public Access getAccess() {
		return access;
	}

	public void setAccess(Access access) {
		this.access = access;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	
	
}
