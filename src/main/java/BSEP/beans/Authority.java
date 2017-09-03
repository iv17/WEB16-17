package BSEP.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "authority")
public class Authority implements Serializable {
	
	
	private static final long serialVersionUID = -308061403748834766L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "name", unique = true, nullable = true)
	private String name;
	
	@OneToMany(mappedBy = "authority", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
	private Set<UserAuthority> userAuthorities = new HashSet<UserAuthority>();

	
	public Authority() {
		
	}

	public Authority(String name) {
		this.name = name;
	}
	
	
	public Authority(Long id, String name, Set<UserAuthority> userAuthorities) {
		this.id = id;
		this.name = name;
		this.userAuthorities = userAuthorities;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserAuthority> getUserAuthorities() {
		return userAuthorities;
	}

	public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
		this.userAuthorities = userAuthorities;
	}
}
