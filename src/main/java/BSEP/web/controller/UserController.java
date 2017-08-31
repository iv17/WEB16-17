package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
			method   = RequestMethod.POST,
			consumes = "application/json"
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

	@RequestMapping(
			value    = "/request_to_change_password",
			method   = RequestMethod.POST,
			consumes = "application/json"
			)
	public ResponseEntity<UserDTO> requestToChangePassword(@RequestBody UserDTO userDTO) {

		String email = userDTO.getEmail();
		System.out.println(email);
		User user = userService.findByEmail(email);
		if(userService.findByEmail(email) == null) {

			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		} 
		user.setPassword("");
		userService.save(user);
		
		UserDTO newUserDTO = new UserDTO(user);
		
		String mailFrom = "ivana17.ostalo@gmail.com";
		String usernameMail = "ivana17.ostalo";
		String passwordMail = "lozinkazaprojekat2017";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.starttls.enable", "true"); 
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.user", usernameMail); // User name
		properties.put("mail.smtp.password", passwordMail); // password
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.auth", "true");


		Session session = Session.getInstance(properties, new MyAuthenticator(usernameMail, passwordMail));
		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(mailFrom));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(email));
			// Set Subject: header field
			message.setSubject("Snipp - Confirm registration!");
			// Now set the actual message
			String mess = "Please, confirm your registration by clicking on link: ";
			String mail_html = "<html>\n" +
					"<head></head>\n" +
					"<body>\n" +
					"<p align=\"center\">" + mess + "<a href=\"http://localhost:8080/#/start_change_password/" + email + "\">Confirm</a></p>\n" +
					"</body></html>";

			message.setContent(mail_html,"text/html");
			// Send message
			Transport.send(message);

		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);

	}

	@RequestMapping(
			value    = "/change_password",
			method   = RequestMethod.POST,
			consumes = "application/json"
			)
	public ResponseEntity<UserDTO> changePassword(@RequestBody UserDTO userDTO) {
		
		String email = userDTO.getEmail();
		System.out.println(email);
		String new_password = userDTO.getPassword();
		System.out.println(new_password);
		String repeated_new_password = userDTO.getRepeated_password();
		System.out.println(repeated_new_password);
		
		if(userService.findByEmail(email) != null && new_password.equals(repeated_new_password)) {
			User user = userService.findByEmail(email);
			user.setPassword(new_password);
			userService.save(user);
			UserDTO newUserDTO = new UserDTO(user);
			
			return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
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
