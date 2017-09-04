package BSEP.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Role;
import BSEP.beans.Snippet;
import BSEP.beans.User;
import BSEP.security.MailAuthenticator;
import BSEP.security.TokenUtils;
import BSEP.service.RoleService;
import BSEP.service.UserService;
import BSEP.web.dto.LoginResponseDTO;
import BSEP.web.dto.SnippetDTO;
import BSEP.web.dto.UserDTO;

@RestController
@RequestMapping(value = "/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;


	//====================Security====================
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	TokenUtils tokenUtils;
	//====================Security====================


	@RequestMapping(
			method = RequestMethod.GET
			)
	public ResponseEntity<List<UserDTO>> getUsers(@RequestHeader("X-Auth-Token") String token) {
		User loggedUser = userService.findByToken(token);
		
		List<User> users = userService.findAll();
		List<User> usersBezAdmina = new ArrayList<User>();
		for (User user : users) {
			if(!user.getRole().equals(roleService.findByName("ADMIN")) || !user.equals(loggedUser)){
				usersBezAdmina.add(user);
			}
		}
		List<UserDTO> userDTOs = toDTO(usersBezAdmina);
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}

	@RequestMapping(
			value = "/{id}",
			method = RequestMethod.GET
			)
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {

		User user = userService.findById(id);
		if (user == null) {
			return new ResponseEntity<UserDTO>(HttpStatus.NOT_FOUND);
		}

		UserDTO userDTO = new UserDTO(user);

		return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UserDTO> registration(@RequestBody UserDTO userDTO) {

		 BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		User user = new User();

		if (userService.findByUsername(userDTO.getUsername()) == null
				|| userService.findByEmail(userDTO.getEmail()) == null) {

			System.out.println(userDTO.getPassword());
			System.out.println(userDTO.getRepeated_password());
			if (userDTO.getPassword().equals(userDTO.getRepeated_password())) {

				user.setName(userDTO.getName());
				user.setSurname(userDTO.getSurname());
				user.setEmail(userDTO.getEmail());
				user.setUsername(userDTO.getUsername());
				user.setPassword(encoder.encode(userDTO.getPassword()));
				
				user.setRole(roleService.findByName("REGISTRED_USER"));
				user.setBlocked(false);
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
			value = "/login", 
			method = RequestMethod.POST,
			consumes = "application/json")
	public ResponseEntity<LoginResponseDTO> login(@RequestBody UserDTO userDTO) {

		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				userDTO.getUsername(), userDTO.getPassword());

		Authentication authentication = authenticationManager.authenticate(token);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		UserDetails details = userDetailsService.loadUserByUsername(userDTO.getUsername());
		
		String userToken = tokenUtils.generateToken(details);
		
		User user = userService.findByToken(userToken);
		
		LoginResponseDTO loginResponseDTO = new LoginResponseDTO(new UserDTO(user), userToken);
		
		return new ResponseEntity<LoginResponseDTO>(loginResponseDTO, HttpStatus.OK);

	}

	@RequestMapping(
			value = "/request_to_change_password",
			method = RequestMethod.POST,
			consumes = "application/json"
			)
	public ResponseEntity<UserDTO> requestToChangePassword(@RequestBody UserDTO userDTO) {

		String email = userDTO.getEmail();
		System.out.println(email);
		User user = userService.findByEmail(email);
		if (userService.findByEmail(email) == null) {

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

		Session session = Session.getInstance(properties, new MailAuthenticator(usernameMail, passwordMail));
		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(mailFrom));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			// Set Subject: header field
			message.setSubject("Snipp - Confirm registration!");
			// Now set the actual message
			String mess = "Please, confirm your registration by clicking on link: ";
			String mail_html = "<html>\n" + "<head></head>\n" + "<body>\n" + "<p align=\"center\">" + mess
					+ "<a href=\"http://localhost:8080/#/start_change_password/" + email + "\">Confirm</a></p>\n"
					+ "</body></html>";

			message.setContent(mail_html, "text/html");
			// Send message
			Transport.send(message);

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
		return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);

	}

	@RequestMapping(
			value = "/change_password",
			method = RequestMethod.POST, 
			consumes = "application/json")
	public ResponseEntity<UserDTO> changePassword(@RequestBody UserDTO userDTO) {

		String email = userDTO.getEmail();
		System.out.println(email);
		String new_password = userDTO.getPassword();
		System.out.println(new_password);
		String repeated_new_password = userDTO.getRepeated_password();
		System.out.println(repeated_new_password);

		if (userService.findByEmail(email) != null && new_password.equals(repeated_new_password)) {
			User user = userService.findByEmail(email);
			user.setPassword(new_password);
			userService.save(user);
			UserDTO newUserDTO = new UserDTO(user);

			return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);

	}

	@RequestMapping(
			value = "/admins",
			method = RequestMethod.GET
			)
	public ResponseEntity<List<UserDTO>> getAdmins() {
		Role role = roleService.findByName("ADMIN");
		List<User> users = userService.findByRole(role);
		List<UserDTO> userDTOs = toDTO(users);
		return new ResponseEntity<List<UserDTO>>(userDTOs, HttpStatus.OK);
	}

	@RequestMapping(
			value = "/not_blocked_users", 
			method = RequestMethod.GET
			)
	public ResponseEntity<List<UserDTO>> getNotBlockedUsers(@RequestHeader("X-Auth-Token") String token) {
		User loggedUser = userService.findByToken(token);
		
		List<User> users = userService.findAll();
		List<User> notBlocked = new ArrayList<User>();
		for (User u : users) {
			if(!u.getBlocked() || !u.equals(loggedUser)) {
				notBlocked.add(u);
			}
		}
		List<UserDTO> usersDTO = toDTO(notBlocked); //samo one koji nisu blokirani ce prikazati

		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
	}

	
	@RequestMapping(
			value = "/block_user", // id - id admina koji ce blokirati user-a
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<List<UserDTO>> blockUser(@RequestBody UserDTO userDTO, @RequestHeader("X-Auth-Token") String token) {

		
		User admin = userService.findByToken(token);
		
		if(admin.getRole() == roleService.findByName("REGISTRED_USER")) {//VRATI NA ADMIN

			User user = userService.findById(userDTO.getId());
			if(user != null && !user.getBlocked().equals(true)) {

				user.setBlocked(true);
				userService.save(user);

				List<User> users = userService.findAll();
				List<User> notBlocked = new ArrayList<User>();
				for (User u : users) {
					if(!u.getBlocked()) {
						notBlocked.add(u);
					}
				}
				List<UserDTO> usersDTO = toDTO(notBlocked); //samo one koji nisu blokirani ce prikazati

				return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.CREATED);

			} else {
				return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_REQUEST);
			}
		} else {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.BAD_REQUEST);
		}

	}
	@RequestMapping(
			value = "/snippets", // id - id user-a ciji su snippeti
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<List<SnippetDTO>> getSnippets(@RequestHeader("X-Auth-Token") String token) {

		if(userService.findByToken(token) != null) {

			User user = userService.findByToken(token);
			
			Set<Snippet> snippetsSet = user.getSnippets();
			List<SnippetDTO> snippetsDTO = new ArrayList<SnippetDTO>();
			for (Snippet snippet : snippetsSet) {
				SnippetDTO newSnippetDTO = new SnippetDTO(snippet);
				snippetsDTO.add(newSnippetDTO);
			}

			return new ResponseEntity<List<SnippetDTO>>(snippetsDTO, HttpStatus.OK);

		}
		return new ResponseEntity<List<SnippetDTO>>(HttpStatus.NOT_FOUND);

	}


	@RequestMapping(
			value = "/search_username",
			method = RequestMethod.POST
			)
	public ResponseEntity<List<UserDTO>> searchByUsername(@RequestBody UserDTO userDTO, @RequestHeader("X-Auth-Token") String token) {
		
		//VRACA LISTU DA NE PRAVIM NOVI PRIKAZ	
		
		//User loggedUser = userService.findByToken(token);
		
		String username = userDTO.getUsername();
		 
		if(userService.findByUsername(userDTO.getUsername()) == null) {
			return new ResponseEntity<List<UserDTO>>(HttpStatus.NOT_FOUND);
		}
		User user = userService.findByUsername(username);
		
		UserDTO newUserDTO = new UserDTO(user);
		
		List<UserDTO> usersDTO = new ArrayList<UserDTO>();
		usersDTO.add(newUserDTO);
		return new ResponseEntity<List<UserDTO>>(usersDTO, HttpStatus.OK);
		
	}
	// POMOCNA FUNKCIJA
	private List<UserDTO> toDTO(List<User> users) {

		List<UserDTO> userDTOs = new ArrayList<UserDTO>();

		for (User user : users) {
			UserDTO userDTO = new UserDTO(user);
			userDTOs.add(userDTO);
		}
		return userDTOs;
	}

}
