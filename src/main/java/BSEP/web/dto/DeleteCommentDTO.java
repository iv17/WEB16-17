package BSEP.web.dto;

public class DeleteCommentDTO {

	
	private int commentId;
	private int snippetId;
	
	public DeleteCommentDTO() {
		
	}
	
	public DeleteCommentDTO(int commentId, int snippetId) {
		
		this.commentId = commentId;
		this.snippetId = snippetId;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getSnippetId() {
		return snippetId;
	}
	public void setSnippetId(int snippetId) {
		this.snippetId = snippetId;
	}
	
	
	
}
