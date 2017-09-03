package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Access;
import BSEP.service.AccessService;
import BSEP.web.dto.AccessDTO;

@RestController
@RequestMapping(value = "/api/accesses")
public class AccessController {

	@Autowired
	private AccessService accessService;

	
	@RequestMapping(
			method = RequestMethod.GET
			)
	public ResponseEntity<List<AccessDTO>> getVisibility() {
		List<Access> accesses = accessService.findAll();
		List<AccessDTO> accessesDTO = toDTO(accesses);

		return new ResponseEntity<List<AccessDTO>>(accessesDTO, HttpStatus.OK);
	}


	// POMOCNA FUNKCIJA
	private List<AccessDTO> toDTO(List<Access> accesses) {

		List<AccessDTO> accessesDTO = new ArrayList<AccessDTO>();

		for (Access access: accesses) {
			AccessDTO accessDTO = new AccessDTO(access);
			accessesDTO.add(accessDTO);
		}
		return accessesDTO;
	}
}
