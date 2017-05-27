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
@Table(name = "team_conversation")
public class TeamConversation extends Conversation {

	
	private static final long serialVersionUID = 5491139607891810867L;

	@ManyToOne @JsonIgnore
	@JoinColumn(name = "team_id", referencedColumnName = "id", nullable = true) 
	private Team team;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, mappedBy = "team_conversation") @JsonIgnore
	private Set<TeamMessage> messages;

}
