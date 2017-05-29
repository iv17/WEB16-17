package BSEP.web.dto;

import BSEP.beans.Image;

public class ImageDTO {

	private int id;	
	private String name;
	private String file;
	
	
	public ImageDTO() {
		
	}
	
	public ImageDTO(Image image) {
		id = image.getId();
		name = image.getName();
		file = image.getFile();
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
	
	public String getFile() {
		return file;
	}
	
	public void setFile(String file) {
		this.file = file;
	}
	
	
}
