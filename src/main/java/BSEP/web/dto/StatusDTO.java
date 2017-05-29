package BSEP.web.dto;

import BSEP.beans.Status;

public class StatusDTO {

	private int id;
	private String name;
	
	public StatusDTO() {
	
	}
	
	public StatusDTO(Status status) {
		id = status.getId();
		name = status.getName();
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
