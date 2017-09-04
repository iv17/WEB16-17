package BSEP.web.dto;

import java.util.List;

public class CreateCommentResponseDTO {

	private SnippetDTO snippet;
	private List<CommentDTO> comments;
	
	
	public CreateCommentResponseDTO() {
		
	}

	public CreateCommentResponseDTO(SnippetDTO snippet, List<CommentDTO> comments) {
		this.snippet = snippet;
		this.comments = comments;
	}

	public SnippetDTO getSnippet() {
		return snippet;
	}

	public void setSnippet(SnippetDTO snippet) {
		this.snippet = snippet;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
	
	
	
}
