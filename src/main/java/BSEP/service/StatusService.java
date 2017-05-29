package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Status;
import BSEP.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	protected StatusRepository statusRepository;
	
	
	public Status findById(int id) {
		return statusRepository.findOne(id);
	}
	
	public List<Status> findAll() {
		return  statusRepository.findAll();
	}
	
	public Page<Status> findAll(Pageable page) {
		return statusRepository.findAll(page);
	}
	
	public Status save(Status status) {
		return statusRepository.save(status);
	}
	
	public Status saveAndFlush(Status status) {
		return statusRepository.saveAndFlush(status);
	}
	
	public void removeById(int id) {
		statusRepository.delete(id);
	}
	
	public void remove(Status status) {
		statusRepository.delete(status);
	}
	
	
}
