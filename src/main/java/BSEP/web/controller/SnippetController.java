package BSEP.web.controller;

import java.text.SimpleDateFormat;
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
import BSEP.service.LanguageService;
import BSEP.service.SnippetService;
import BSEP.service.UserService;
import BSEP.service.VisibilityService;
import BSEP.web.dto.CommentDTO;
import BSEP.web.dto.LanguageDTO;
import BSEP.web.dto.SnippetDTO;

@RestController
@RequestMapping(value = "/api/snippets")
public class SnippetController {

	@Autowired
	private SnippetService snippetService;

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
			System.out.println(snippetDTO.getLanguageName());
			if(snippetDTO.getLanguageName() == null) {	// OBAVEZNO JE UNDEFINED
				
				snippet.setLanguage(languageService.findByName("UNDEFINED"));
			}
			snippet.setLanguage(languageService.findByName(snippetDTO.getLanguageName()));
			snippet.setAccess(accessService.findByName(snippetDTO.getAccessName()));
			snippet.setVisibility(visibilityService.findByName(snippetDTO.getVisibilityName()));
			//snippet.setUrl(snippetDTO.getUrl());
			snippet.setDuration(snippetDTO.getDuration());
			snippet.setDate(new Date());
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

	@RequestMapping(
			value = "/search_description",
			method = RequestMethod.POST
			)
	public ResponseEntity<List<SnippetDTO>> searchByDescription(@RequestBody SnippetDTO snippetDTO) {
		
		String description = snippetDTO.getDescription();
		List<Snippet> allSnippets = snippetService.findAll();
		 
		List<Snippet> descSnippets = new ArrayList<Snippet>();
		for (Snippet snippet : allSnippets) {
			if(snippet.getDescription().contains(description)) {
				descSnippets.add(snippet);
			}
		}
		
		List<SnippetDTO> descSnippetsDTO = toDTO(descSnippets);
		return new ResponseEntity<List<SnippetDTO>>(descSnippetsDTO, HttpStatus.OK);
		
	}
	
	
	@RequestMapping(
			value = "/search_language",
			method = RequestMethod.POST
			)
	public ResponseEntity<List<SnippetDTO>> searchByLanguage(@RequestBody LanguageDTO languageDTO) {

		if(languageService.findByName(languageDTO.getName()) == null) {
			return new ResponseEntity<List<SnippetDTO>>(HttpStatus.NOT_FOUND);
		}
		String languageName = languageDTO.getName();
		List<Snippet> allSnippets = snippetService.findAll();
		 
		List<Snippet> languageSnippets = new ArrayList<Snippet>();
		for (Snippet snippet : allSnippets) {
			if(snippet.getLanguage().getName().equals(languageName)) {
				languageSnippets.add(snippet);
			}
		}
		
		List<SnippetDTO> languageSnippetsDTO = toDTO(languageSnippets);
		return new ResponseEntity<List<SnippetDTO>>(languageSnippetsDTO, HttpStatus.OK);
		
	}
	
	@RequestMapping(
			value = "/search_date",
			method = RequestMethod.POST
			)
	public ResponseEntity<List<SnippetDTO>> searchByDate(@RequestBody SnippetDTO snippetDTO) {

		String date = snippetDTO.getDateString();
		List<Snippet> allSnippets = snippetService.findAll();
		 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		List<Snippet> dateSnippets = new ArrayList<Snippet>();
		for (Snippet snippet : allSnippets) { 	//2017-09-04 17:32:14.0
			if(sdf.format(snippet.getDate()).equals(date)) {
				dateSnippets.add(snippet);
			}
		}
		
		List<SnippetDTO> dateSnippetsDTO = toDTO(dateSnippets);
		return new ResponseEntity<List<SnippetDTO>>(dateSnippetsDTO, HttpStatus.OK);
		
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
