package BSEP.web.dto;

public class CreateCommentRequestDTO {

	private int snippetId;
	private String text;
	
	
	public CreateCommentRequestDTO() {
		
	}
	
	public CreateCommentRequestDTO(int snippetId, String text) {
	
		this.snippetId = snippetId;
		this.text = text;
	}
	
	public int getSnippetId() {
		return snippetId;
	}
	
	public void setSnippetId(int snippetId) {
		this.snippetId = snippetId;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	
}
