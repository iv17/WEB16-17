package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Language;
import BSEP.beans.User;

import BSEP.service.LanguageService;
import BSEP.service.RoleService;
import BSEP.service.UserService;

import BSEP.web.dto.LanguageDTO;

@RestController
@RequestMapping(value = "/api/languages")
public class LanguageController {

	@Autowired
	private LanguageService languageService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	
	@RequestMapping(
			method = RequestMethod.GET
			)
	public ResponseEntity<List<LanguageDTO>> getLanguages() {
		List<Language> languages = languageService.findAll();
		List<LanguageDTO> languagesDTO  = toDTO(languages);

		return new ResponseEntity<List<LanguageDTO>>(languagesDTO, HttpStatus.OK);
	}

	@RequestMapping(
			value = "/add",
			method = RequestMethod.POST,
			consumes = "application/json")
	public ResponseEntity<List<LanguageDTO>> addNewLanguage(@RequestBody LanguageDTO languageDTO, @RequestHeader("X-Auth-Token") String token) {
		
		if(userService.findByToken(token) == null) {
			return new ResponseEntity<List<LanguageDTO>>(HttpStatus.BAD_REQUEST);
		} else {
			User user = userService.findByToken(token);
			if(!user.getRole().equals(roleService.findByName("ADMIN"))) {//prebaci na ADMIN
				return new ResponseEntity<List<LanguageDTO>>(HttpStatus.BAD_REQUEST);
			} else {
				if(languageService.findByName(languageDTO.getName()) == null) {
					Language newLanguage = new Language(languageDTO.getName());
					languageService.save(newLanguage);
					
					List<Language> languages = languageService.findAll();
					List<LanguageDTO> languagesDTO = toDTO(languages);
					return new ResponseEntity<List<LanguageDTO>>(languagesDTO, HttpStatus.OK);
				} else {
					return new ResponseEntity<List<LanguageDTO>>(HttpStatus.BAD_REQUEST);
				}
			}
		}
		
		
	}
	
	
	// POMOCNA FUNKCIJA
	private List<LanguageDTO> toDTO(List<Language> languages) {

		List<LanguageDTO> languagesDTO = new ArrayList<LanguageDTO>();

		for (Language language : languages) {
			LanguageDTO languageDTO = new LanguageDTO(language);
			languagesDTO.add(languageDTO);
		}
		return languagesDTO;
	}
}
