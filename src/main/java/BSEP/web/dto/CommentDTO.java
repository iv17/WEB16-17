package BSEP.web.dto;

import java.util.Date;

import BSEP.beans.Snippet;
import BSEP.beans.User;

public class CommentDTO {

	private int id;
	private String text;
	private Date date;
	private UserDTO userDTO;
	private SnippetDTO snippetDTO;
}
