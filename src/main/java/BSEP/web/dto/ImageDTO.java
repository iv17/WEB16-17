package BSEP.web.dto;

import BSEP.beans.Image;

public class ImageDTO {

	private int id;	
	private String name;
	private byte[] file;
	
	private String fileString;
	
	public ImageDTO() {
		
	}
	
	public ImageDTO(Image image) {
		id = image.getId();
		name = image.getName();
		file = image.getFile();
		fileString = new String(file);
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
	
	public byte[] getFile() {
		return file;
	}
	
	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getFileString() {
		return fileString;
	}

	public void setFileString(String fileString) {
		this.fileString = fileString;
	}
	
	
}
