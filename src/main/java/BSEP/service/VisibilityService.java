package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Visibility;
import BSEP.repository.VisibilityRepository;

@Service
public class VisibilityService {

	@Autowired
	protected VisibilityRepository visibilityRepository;
	
	
	public Visibility findById(int id) {
		return visibilityRepository.findOne(id);
	}
	
	public List<Visibility> findAll() {
		return  visibilityRepository.findAll();
	}
	
	public Page<Visibility> findAll(Pageable page) {
		return visibilityRepository.findAll(page);
	}
	
	public Visibility save(Visibility visibility) {
		return visibilityRepository.save(visibility);
	}
	
	public Visibility saveAndFlush(Visibility visibility) {
		return visibilityRepository.saveAndFlush(visibility);
	}
	
	public void removeById(int id) {
		visibilityRepository.delete(id);
	}
	
	public void remove(Visibility visibility) {
		visibilityRepository.delete(visibility);
	}
	
	
}
