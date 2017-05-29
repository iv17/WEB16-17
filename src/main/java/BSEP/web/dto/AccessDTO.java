package BSEP.web.dto;

import BSEP.beans.Access;

public class AccessDTO {

	private int id;
	private String name;
	
	public AccessDTO() {
		
	}
	
	public AccessDTO(Access access) {
		id = access.getId();
		name = access.getName();
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
