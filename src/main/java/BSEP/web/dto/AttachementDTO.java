package BSEP.web.dto;

import BSEP.beans.Attachment;

public class AttachementDTO {

	private int id;
	private String name;
	private String description;
	private byte [] data;
	private AttachmentTypeDTO attachmentTypeDTO;
	private AccessDTO accessDTO;
	private VisibilityDTO visibilityDTO;
	
	public AttachementDTO() {
		
	}
	
	public AttachementDTO(Attachment attachment) {
		id = attachment.getId();
		name = attachment.getName();
		description = attachment.getDescription();
		data = attachment.getData();
		attachmentTypeDTO = new AttachmentTypeDTO(attachment.getAttachmentType());
		accessDTO = new AccessDTO(attachment.getAccess());
		visibilityDTO = new VisibilityDTO(attachment.getVisibility());
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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public AttachmentTypeDTO getAttachmentTypeDTO() {
		return attachmentTypeDTO;
	}

	public void setAttachmentTypeDTO(AttachmentTypeDTO attachmentTypeDTO) {
		this.attachmentTypeDTO = attachmentTypeDTO;
	}

	public AccessDTO getAccessDTO() {
		return accessDTO;
	}

	public void setAccessDTO(AccessDTO accessDTO) {
		this.accessDTO = accessDTO;
	}

	public VisibilityDTO getVisibilityDTO() {
		return visibilityDTO;
	}

	public void setVisibilityDTO(VisibilityDTO visibilityDTO) {
		this.visibilityDTO = visibilityDTO;
	}
	
	
}
