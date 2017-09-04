package BSEP.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Comment;
import BSEP.beans.Snippet;
import BSEP.beans.User;
import BSEP.service.CommentService;
import BSEP.service.SnippetService;
import BSEP.service.UserService;
import BSEP.web.dto.CommentDTO;
import BSEP.web.dto.CreateCommentRequestDTO;
import BSEP.web.dto.CreateCommentResponseDTO;
import BSEP.web.dto.SnippetDTO;

@RestController
@RequestMapping(value = "/api/comments")
public class CommentController {

	@Autowired
	private UserService userService;

	@Autowired
	private SnippetService snippetService;

	@Autowired
	private CommentService commentService;


	@RequestMapping(
			value = "/create", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<CreateCommentResponseDTO> createComment(@RequestBody CreateCommentRequestDTO createCommentRequest,  @RequestHeader("X-Auth-Token") String token) {

		int id = createCommentRequest.getSnippetId();
		String text = createCommentRequest.getText();
		if(userService.findByToken(token) != null) {
			User user = userService.findByToken(token);

			if(user.getBlocked() == false) {	// NE MOZE BLOKIRAN KORISNIK DA KOMENTARISE
				if(snippetService.findById(id) != null) {

					Snippet snippet = snippetService.findById(id);

					Comment comment = new Comment();
					comment.setText(text);
					comment.setSnippet(snippet);
					comment.setUser(user);
					comment.setDate(new Date());

					commentService.save(comment); 	//sacuvam komentar

					Set<Comment> snippetComments = snippet.getComments();
					snippetComments.add(comment);	//dodam komentar medju sve komentare snippeta

					snippet.setComments(snippetComments);
					

					SnippetDTO snippetDTO = new SnippetDTO(snippet);
					
					if(snippet.getComments().size() == 0) {
						return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
					}

					Set<Comment> comments = snippet.getComments();
					List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
					for (Comment comm : comments) {
						CommentDTO commentDTO = new CommentDTO(comm);
						commentsDTO.add(commentDTO);
					}
					
					CreateCommentResponseDTO createCommentResponseDTO = new CreateCommentResponseDTO(snippetDTO, commentsDTO);
					return new ResponseEntity<CreateCommentResponseDTO>(createCommentResponseDTO, HttpStatus.CREATED);

				} else {
					return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
				}
			} else {
				return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.BAD_REQUEST);
			}

		} else {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.BAD_REQUEST);
		}


	}
/*
	// POMOCNA FUNKCIJA
	private List<CommentDTO> toDTO(List<Comment> comments) {

		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();

		for (Comment comment : comments) {
			CommentDTO commentDTO = new CommentDTO(comment);
			commentsDTO.add(commentDTO);
		}
		return commentsDTO;
	}
	*/
}
