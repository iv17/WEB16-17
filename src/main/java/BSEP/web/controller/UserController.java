package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.User;
import BSEP.service.UserService;
import BSEP.web.dto.UserDTO;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(
			method   = RequestMethod.GET
			)
	public ResponseEntity<List<UserDTO>> getUsers() {
		List<User> users = userService.findAll();
		List<UserDTO> userDTOs = toDTO(users);
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {

		User user = userService.findById(id);
		if(user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}

		UserDTO userDTO = new UserDTO(user);

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	
	@RequestMapping(
            value    = "/registration",
            method   = RequestMethod.POST,
            consumes = "application/json"
    )
	public ResponseEntity<UserDTO> registration(@RequestBody UserDTO userDTO) {

		User user = new User();

		if(userService.findByUsername(userDTO.getUsername()) == null || userService.findByEmail(userDTO.getEmail()) == null) {
			
			System.out.println(userDTO.getPassword());
			System.out.println(userDTO.getRepeated_password());
			if(userDTO.getPassword().equals(userDTO.getRepeated_password())) {

				user.setName(userDTO.getName());
				user.setSurname(userDTO.getSurname());
				user.setEmail(userDTO.getEmail());
				user.setUsername(userDTO.getUsername());
				user.setPassword(userDTO.getPassword());
				
				UserDTO newUserDTO = new UserDTO(user);

				userService.save(user);
				
				return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);
			}
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
			
		} else {
			
			return new ResponseEntity<UserDTO>(HttpStatus.BAD_REQUEST);
		}

	}
	
	@RequestMapping(
            value    = "/login",
            method   = RequestMethod.POST
    )
	public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTO) {

		String email = userDTO.getEmail();
		String username = userDTO.getUsername();
		String password = userDTO.getPassword();
		
		if(userService.findByEmail(email) == null && userService.findByUsername(username) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		User user = null;
		if(userService.findByEmail(email) != null) {
			user = userService.findByEmailAndPassword(email, password);
		}
		if(userService.findByUsername(username) != null) {
			user = userService.findByUsernameAndPassword(username, password);
		}
		UserDTO loggedUserDTO = new UserDTO(user);
		
		return new ResponseEntity<UserDTO>(loggedUserDTO, HttpStatus.OK);

	}
	
	//POMOCNA FUNKCIJA
	private List<UserDTO> toDTO(List<User> users) {
		
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		
		for (User user : users) {
			UserDTO userDTO = new UserDTO(user);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}
}
