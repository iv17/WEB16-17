package BSEP.web.dto;

import BSEP.beans.Language;

public class LanguageDTO {

	private int id;
	private String name;
	
	public LanguageDTO() {
		
	}

	public LanguageDTO(Language language) {
		id  = language.getId();
		name = language.getName();
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
