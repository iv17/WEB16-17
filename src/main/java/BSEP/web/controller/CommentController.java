package BSEP.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import BSEP.beans.Comment;
import BSEP.beans.Snippet;
import BSEP.beans.User;
import BSEP.service.CommentService;
import BSEP.service.SnippetService;
import BSEP.web.dto.CommentDTO;

public class CommentController {

	@Autowired
	private SnippetService snippetService;

	@Autowired
	private CommentService commentService;

	@RequestMapping(
			value = "/{id}/add_comment", // id - id snippet-a za koji se kreira komentar, iz snippet-a ---> creator
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<List<CommentDTO>> addComment(@PathVariable int id, @RequestBody CommentDTO commentDTO) {
		
		if(snippetService.findById(id) != null) {
			
			Snippet snippet = snippetService.findById(id);
			User user = snippet.getCreator();
			
			Set<Comment> snippetComents = snippet.getComments();
			
			for (Comment comment : snippetComents) {
				if(comment.getUser().equals(user)) {
					return new ResponseEntity<List<CommentDTO>>(HttpStatus.BAD_REQUEST);
				}
			}
			Comment newComment = new Comment();
			newComment.setText(commentDTO.getText());
			newComment.setDate(new Date());
			newComment.setUser(user);
			newComment.setSnippet(snippet);
			
			commentService.save(newComment);
			
			List<Comment> comments = commentService.findBySnippet(snippet);
			List<CommentDTO> commentsDTO = toDTO(comments);
			
			return new ResponseEntity<List<CommentDTO>>(commentsDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<List<CommentDTO>>(HttpStatus.NOT_FOUND);
		
	}
	

	// POMOCNA FUNKCIJA
	private List<CommentDTO> toDTO(List<Comment> comments) {

		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();

		for (Comment comment : comments) {
			CommentDTO commentDTO = new CommentDTO(comment);
			commentsDTO.add(commentDTO);
		}
		return commentsDTO;
	}
}
