package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Access;
import BSEP.repository.AccessRepository;

@Service
public class AccessService {

	@Autowired
	AccessRepository accessRepository;
	
	
	public Access findById(int id) {
		return accessRepository.findById(id);
	}
		
	public Access findByName(String accessName) {
		return accessRepository.findByName(accessName);
	}
	
	public List<Access> findAll() {
		return accessRepository.findAll();
	}
	
	public Page<Access> findAll(Pageable page) {
		return accessRepository.findAll(page);
	}
	
	public Access save(Access access) {
		return accessRepository.save(access);
	}
	
	public Access saveAndFlush(Access access) {
		return accessRepository.saveAndFlush(access);
	}
	
	public void removeById(int id) {
		accessRepository.delete(id);
	}
	
	public void remove(Access access) {
		accessRepository.delete(access);
	}

	
	
}
