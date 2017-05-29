package BSEP.web.dto;

import BSEP.beans.Role;

public class RoleDTO {

	private int id;
	private String name;
	
	public RoleDTO() {
		
	}
	
	public RoleDTO(Role role) {
		id = role.getId();
		name = role.getName();
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

	
}
