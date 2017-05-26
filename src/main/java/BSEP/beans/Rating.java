package BSEP.beans;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "rating")
public class Rating implements Serializable {

	
	private static final long serialVersionUID = 5716771512325287770L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "rate", unique = false, nullable = false)
	private int rate;
	
	@Column(name = "date", unique = false, nullable = false)
	private Date date;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = true) 
	private Comment comment;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true) 
	private User user;
}
