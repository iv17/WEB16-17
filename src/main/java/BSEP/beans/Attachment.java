package BSEP.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "description", unique = false, nullable = false)
	private String description;
	
	@Column(name = "data", unique = false, nullable = false)
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
	
}
