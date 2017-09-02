package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Role;
import BSEP.repository.RoleRepository;

@Service
public class RoleService {

	@Autowired
	protected RoleRepository roleRepository;
	
	
	public Role findById(int id) {
		return roleRepository.findOne(id);
	}
	
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
	
	public List<Role> findAll() {
		return  roleRepository.findAll();
	}
	
	public Page<Role> findAll(Pageable page) {
		return roleRepository.findAll(page);
	}
	
	public Role save(Role role) {
		return roleRepository.save(role);
	}
	
	public Role saveAndFlush(Role role) {
		return roleRepository.saveAndFlush(role);
	}
	
	public void removeById(int id) {
		roleRepository.delete(id);
	}
	
	public void remove(Role role) {
		roleRepository.delete(role);
	}
	
	
}
