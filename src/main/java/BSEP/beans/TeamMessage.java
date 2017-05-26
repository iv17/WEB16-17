package BSEP.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "team_message")
public class TeamMessage extends Message {

	
	private static final long serialVersionUID = -1887209737133522699L;
	
	@ManyToOne @JsonIgnore
	@JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = true) 
	private User sender;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "team_message") @JsonIgnore
	private Set<User> receivers;
}
