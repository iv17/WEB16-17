package BSEP.web.dto;

import java.util.Set;

import BSEP.beans.Team;
import BSEP.beans.User;

public class TeamDTO {

	private int id;
	private String name;
	private String description;
	private UserDTO teamLeader;
	private Set<UserDTO> members;
	
	public TeamDTO() {
		
	}

	public TeamDTO(Team team) {
		id = team.getId();
		name = team.getName();
		description = team.getDescription();
		teamLeader = new UserDTO(team.getTeamLeader());
		for (User user : team.getMembers()) {
			members.add(new UserDTO(user));
		}
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
	
	public UserDTO getTeamLeader() {
		return teamLeader;
	}
	
	public void setTeamLeader(UserDTO teamLeader) {
		this.teamLeader = teamLeader;
	}

	public Set<UserDTO> getMembers() {
		return members;
	}

	public void setMembers(Set<UserDTO> members) {
		this.members = members;
	}

	
	
}
