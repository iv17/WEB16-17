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
	
	@Column(name = "rate", unique = false, nullable = true)
	private int rate;
	
	@Column(name = "plus", unique = false, nullable = true)
	private int plus;
	
	@Column(name = "minus", unique = false, nullable = true)
	private int minus;
	
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

	public Rating(int plus, int minus, Date date, Comment comment, User user) {
		this.plus = plus;
		this.minus = minus;
		this.date = date;
		this.comment = comment;
		this.user = user;
	}
	
	public Rating(int id, int rate, int plus, int minus, Date date, Comment comment, User user) {
		this.id = id;
		this.rate = rate;
		this.plus = plus;
		this.minus = minus;
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

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getPlus() {
		return plus;
	}

	public void setPlus(int plus) {
		this.plus = plus;
	}

	public int getMinus() {
		return minus;
	}

	public void setMinus(int minus) {
		this.minus = minus;
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
