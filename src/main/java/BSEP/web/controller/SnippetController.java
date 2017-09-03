package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Snippet;
import BSEP.beans.User;
import BSEP.service.AccessService;
import BSEP.service.LanguageService;
import BSEP.service.SnippetService;
import BSEP.service.UserService;
import BSEP.service.VisibilityService;
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
			value = "/add", // id - id user-a koji kreira snippet
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<List<SnippetDTO>> addSnippet(@RequestBody SnippetDTO snippetDTO, @RequestHeader("X-Auth-Token") String token) {
		
		if(userService.findByToken(token) != null) {
		
			User user = userService.findByToken(token);
			if(user.getBlocked() == true) {
				return new ResponseEntity<List<SnippetDTO>>(HttpStatus.BAD_REQUEST);
			}
			Snippet snippet = new Snippet();
			snippet.setDescription(snippetDTO.getDescription());
			snippet.setData(snippetDTO.getData());
			snippet.setLanguage(languageService.findById(snippetDTO.getLanguage().getId()));
			snippet.setUrl(snippetDTO.getUrl());
			snippet.setDuration(snippetDTO.getDuration());
			snippet.setBlocked(false);
			snippet.setAccess(accessService.findById(snippetDTO.getAccessDTO().getId()));
			snippet.setVisibility(visibilityService.findById(snippetDTO.getVisibilityDTO().getId()));
			snippet.setCreator(user);
			
			snippetService.save(snippet);
			
			List<Snippet> snippets = snippetService.findAll();
			List<SnippetDTO> snippetsDTO = toDTO(snippets);
			
			return new ResponseEntity<List<SnippetDTO>>(snippetsDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<List<SnippetDTO>>(HttpStatus.NOT_FOUND);
		
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
