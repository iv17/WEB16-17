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
public class Rating implements Serializable{

	private static final long serialVersionUID = -9030407310231894333L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false , unique = true)
	private int id;
	
	@Column(name = "plus_rate", unique = false, nullable = true)
	private int plus_rate;
	
	@Column(name = "minus_rate", unique = false, nullable = true)
	private int minus_rate;
	
	@Column(name = "date", unique = false, nullable = true)
	private Date date;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "comment_id", referencedColumnName = "id", nullable = true) 
	private Comment comment;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true) 
	private User user;
	
	
	public Rating() {
		
	}

	public Rating(int plus_rate, int minus_rate, Date date, Comment comment, User user) {
		this.plus_rate = plus_rate;
		this.minus_rate = minus_rate;
		this.date = date;
		this.comment = comment;
		this.user = user;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPlus_rate() {
		return plus_rate;
	}

	public void setPlus_rate(int plus_rate) {
		this.plus_rate = plus_rate;
	}

	public int getMinus_rate() {
		return minus_rate;
	}

	public void setMinus_rate(int minus_rate) {
		this.minus_rate = minus_rate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
