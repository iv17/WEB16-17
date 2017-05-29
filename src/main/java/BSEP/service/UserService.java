package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.User;
import BSEP.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	protected UserRepository userRepository;
	
	
	public User findById(int id) {
		return userRepository.findOne(id);
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
