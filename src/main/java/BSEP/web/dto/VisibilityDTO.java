package BSEP.web.dto;

import BSEP.beans.Visibility;

public class VisibilityDTO {

	private int id;
	private String name;
	
	public VisibilityDTO() {
	
	}
	
	public VisibilityDTO(Visibility visibility) {
		id = visibility.getId();
		name = visibility.getName();
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
