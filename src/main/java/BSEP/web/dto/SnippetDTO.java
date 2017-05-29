package BSEP.web.dto;

import BSEP.beans.Language;

public class SnippetDTO {

	private int id;
	private String description;
	private byte [] data;
	private Language language;
	private String url;
	private int duration;
	private Boolean blocked;
	private AccessDTO accessDTO;
	private VisibilityDTO visibilityDTO;
	private UserDTO creatorDTO;
}
