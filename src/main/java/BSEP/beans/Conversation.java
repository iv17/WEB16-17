package BSEP.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conversation")
public class Conversation implements Serializable {


	private static final long serialVersionUID = 3145160066874312039L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "description", unique = false, nullable = false)
	private String description;
	
	@Column(name = "purpose", unique = false, nullable = false)
	private String purpose;
	
	@Column(name = "date_created", unique = false, nullable = false)
	private Date dateCreated;
	
	
	
}
