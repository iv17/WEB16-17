package BSEP.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Mapping table between User and Authority
 * @author Goran
 *
 */
@Entity
@Table(name = "user_authority")
public class UserAuthority implements Serializable {
	
	
	private static final long serialVersionUID = -8476672626485238511L;

	
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false , unique = true)
	private Long id;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private User user;
	
	@ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	private Authority authority;

	public UserAuthority() {
		
	}
	
	public UserAuthority(User user, Authority authority) {
		this.user = user;
		this.authority = authority;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}
}
