package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.User;
import BSEP.service.UserService;
import BSEP.web.dto.UserDTO;

@RestController
@RequestMapping(value = "api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(
			value    = "/api/users",
			method   = RequestMethod.GET
			)
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<User> users = userService.findAll();
		List<UserDTO> userDTOs = toDTO(users);
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}
	
	private List<UserDTO> toDTO(List<User> users) {
		
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		
		for (User user : users) {
			UserDTO userDTO = new UserDTO(user);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}
}
