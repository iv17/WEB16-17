package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import BSEP.beans.Role;
import BSEP.beans.User;
import BSEP.repository.UserRepository;
import BSEP.security.TokenUtils;

@Service
public class UserService {

	@Autowired
	protected UserRepository userRepository;

	//====================Security====================
	@Autowired
	private TokenUtils tokenUtils;

	@Autowired
	private UserDetailsService userDetailsService;
	//====================Security====================
	
	
	public User findById(int id) {
		return userRepository.findOne(id);
	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User findByUsernameAndPassword(String username, String password) {
		return userRepository.findByUsernameAndPassword(username, password);
	}

	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User findByToken(String token) {
		String username = tokenUtils.getUsernameFromToken(token);
		UserDetails details = userDetailsService.loadUserByUsername(username);

		User user = findByUsername(details.getUsername());
		return user;
	}

	public List<User> findByRole(Role role) {
		return userRepository.findByRole(role);
	}

	public List<User> findAll() {
		return  userRepository.findAll();
	}

	public Page<User> findAll(Pageable page) {
		return userRepository.findAll(page);
	}

	public User save(User user) {
		return userRepository.save(user);
	}

	public User saveAndFlush(User user) {
		return userRepository.saveAndFlush(user);
	}

	public void removeById(int id) {
		userRepository.delete(id);
	}

	public void remove(User user) {
		userRepository.delete(user);
	}


}
