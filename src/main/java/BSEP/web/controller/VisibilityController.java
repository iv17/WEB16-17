package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Visibility;
import BSEP.service.VisibilityService;
import BSEP.web.dto.VisibilityDTO;

@RestController
@RequestMapping(value = "/api/visibilities")
public class VisibilityController {

	@Autowired
	private VisibilityService visibilityService;

	
	@RequestMapping(
			method = RequestMethod.GET
			)
	public ResponseEntity<List<VisibilityDTO>> getVisibility() {
		List<Visibility> visibilities = visibilityService.findAll();
		List<VisibilityDTO> visibilitiesDTO = toDTO(visibilities);

		return new ResponseEntity<List<VisibilityDTO>>(visibilitiesDTO, HttpStatus.OK);
	}


	// POMOCNA FUNKCIJA
	private List<VisibilityDTO> toDTO(List<Visibility> visibilities) {

		List<VisibilityDTO> visibilitiesDTO = new ArrayList<VisibilityDTO>();

		for (Visibility visibility: visibilities) {
			VisibilityDTO visibilityDTO = new VisibilityDTO(visibility);
			visibilitiesDTO.add(visibilityDTO);
		}
		return visibilitiesDTO;
	}
}
