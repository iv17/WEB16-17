package BSEP.web.dto;

import BSEP.beans.AttachmentType;

public class AttachmentTypeDTO {

	private int id;
	private String name;
	
	public AttachmentTypeDTO() {

	}

	public AttachmentTypeDTO(AttachmentType attachmentType) {
		id = attachmentType.getId();
		name = attachmentType.getName();
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
