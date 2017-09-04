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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Comment;
import BSEP.beans.Snippet;
import BSEP.beans.User;
import BSEP.service.AccessService;
import BSEP.service.CommentService;
import BSEP.service.LanguageService;
import BSEP.service.SnippetService;
import BSEP.service.UserService;
import BSEP.service.VisibilityService;
import BSEP.web.dto.CommentDTO;
import BSEP.web.dto.SnippetDTO;

@RestController
@RequestMapping(value = "/api/snippets")
public class SnippetController {

	@Autowired
	private SnippetService snippetService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private UserService userService;

	@Autowired
	private LanguageService languageService;

	@Autowired
	private AccessService accessService;

	@Autowired
	private VisibilityService visibilityService;



	@RequestMapping(
			method = RequestMethod.GET
			)
	public ResponseEntity<List<SnippetDTO>> getSnippets() {
		List<Snippet> snippets = snippetService.findAll();

		List<SnippetDTO> snippetsDTO = toDTO(snippets);
		return new ResponseEntity<List<SnippetDTO>>(snippetsDTO, HttpStatus.OK);
	}

	@RequestMapping(
			value = "/user_snippets",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<SnippetDTO>> getUserSnippets(@RequestHeader("X-Auth-Token") String token) {
		if(userService.findByToken(token) != null) {

			User user = userService.findByToken(token);
			Set<Snippet> userSnippets = user.getSnippets();
			List<Snippet> snippets = new ArrayList<>();
			for (Snippet snippet : userSnippets) {
				snippets.add(snippet);
			}
			List<SnippetDTO> snippetsDTO = toDTO(snippets);
			return new ResponseEntity<List<SnippetDTO>>(snippetsDTO, HttpStatus.OK);
		}
		return new ResponseEntity<List<SnippetDTO>>(HttpStatus.BAD_REQUEST);

	}

	@RequestMapping(
			value = "/not_user_snippets",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<SnippetDTO>> getNotUserSnippets(@RequestHeader("X-Auth-Token") String token) {
		if(userService.findByToken(token) != null) {

			User user = userService.findByToken(token);
			List<Snippet> allSnippets = snippetService.findAll();
			List<Snippet> snippets = new ArrayList<>();
			for (Snippet snippet : allSnippets) {
				if(!snippet.getCreator().equals(user)) {
					snippets.add(snippet);
				}
			}
			List<SnippetDTO> snippetsDTO = toDTO(snippets);
			return new ResponseEntity<List<SnippetDTO>>(snippetsDTO, HttpStatus.OK);
		}
		return new ResponseEntity<List<SnippetDTO>>(HttpStatus.BAD_REQUEST);

	}
	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET
			)
	public ResponseEntity<SnippetDTO> getSnippet(@PathVariable Integer id) {

		Snippet snippet = snippetService.findById(id);
		if (snippet == null) {
			return new ResponseEntity<SnippetDTO>(HttpStatus.NOT_FOUND);
		}

		SnippetDTO snippetDTO = new SnippetDTO(snippet);

		return new ResponseEntity<SnippetDTO>(snippetDTO, HttpStatus.OK);
	}


	@RequestMapping(
			value = "/create", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<List<SnippetDTO>> createSnippet(@RequestBody SnippetDTO snippetDTO, @RequestHeader("X-Auth-Token") String token) {


		if(userService.findByToken(token) != null) {

			User user = userService.findByToken(token);
			if(user.getBlocked() == true) {
				return new ResponseEntity<List<SnippetDTO>>(HttpStatus.BAD_REQUEST);
			}
			Snippet snippet = new Snippet();
			snippet.setDescription(snippetDTO.getDescription());
			snippet.setData(snippetDTO.getData());
			snippet.setLanguage(languageService.findByName(snippetDTO.getLanguageName()));
			snippet.setAccess(accessService.findByName(snippetDTO.getAccessName()));
			snippet.setVisibility(visibilityService.findByName(snippetDTO.getVisibilityName()));
			//snippet.setUrl(snippetDTO.getUrl());
			snippet.setDuration(snippetDTO.getDuration());
			snippet.setBlocked(false);
			snippet.setCreator(user);

			snippetService.save(snippet);

			SnippetDTO newSnippetDTO = new SnippetDTO(snippet);
			List<SnippetDTO> snippetsDTO = new ArrayList<SnippetDTO>();
			snippetsDTO.add(newSnippetDTO);

			return new ResponseEntity<List<SnippetDTO>>(snippetsDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<List<SnippetDTO>>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(
			value = "/create_comment", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<SnippetDTO> createComment(@RequestBody CommentDTO commentDTO, @PathVariable Integer id,  @RequestHeader("X-Auth-Token") String token) {

		if(userService.findByToken(token) != null) {
			User user = userService.findByToken(token);

			if(user.getBlocked() == false) {	// NE MOZE BLOKIRAN KORISNIK DA KOMENTARISE
				if(snippetService.findById(id) != null) {

					Snippet snippet = snippetService.findById(id);

					Comment comment = new Comment();
					comment.setText(commentDTO.getText());
					comment.setSnippet(snippet);
					comment.setUser(user);
					comment.setDate(new Date());

					commentService.save(comment); 	//sacuvam komentar

					Set<Comment> snippetComments = snippet.getComments();
					snippetComments.add(comment);	//dodam komentar medju sve komentare snippeta

					snippet.setComments(snippetComments);
					snippetService.save(snippet);	//sacuvam snippet sa novim komentarom

					/*List<CommentDTO> snippetCommentsDTO = new ArrayList<CommentDTO>();
						for (Comment comm : snippetComments) {
							CommentDTO commDTO = new CommentDTO(comm);
							snippetCommentsDTO.add(commDTO);
						}*/

					SnippetDTO snippetDTO = new SnippetDTO(snippet);
					return new ResponseEntity<SnippetDTO>(snippetDTO, HttpStatus.CREATED);



				}
			}

		}

		return null;

	}

	@RequestMapping(
			value = "/{id}/comments",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<CommentDTO>> getSnippetComments(@PathVariable Integer id) {

		Snippet snippet = snippetService.findById(id);
		if (snippet == null) {
			return new ResponseEntity<List<CommentDTO>>(HttpStatus.NOT_FOUND);
		}
		if(snippet.getComments().size() == 0) {
			return new ResponseEntity<List<CommentDTO>>(HttpStatus.NOT_FOUND);
		}

		Set<Comment> comments = snippet.getComments();
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for (Comment comment : comments) {
			CommentDTO commentDTO = new CommentDTO(comment);
			commentsDTO.add(commentDTO);
		}


		return new ResponseEntity<List<CommentDTO>>(commentsDTO, HttpStatus.OK);
	}

	// POMOCNA FUNKCIJA
	private List<SnippetDTO> toDTO(List<Snippet> snippets) {

		List<SnippetDTO> snippetsDTO = new ArrayList<SnippetDTO>();

		for (Snippet snippet : snippets) {
			SnippetDTO snippetDTO = new SnippetDTO(snippet);
			snippetsDTO.add(snippetDTO);
		}
		return snippetsDTO;
	}
}
