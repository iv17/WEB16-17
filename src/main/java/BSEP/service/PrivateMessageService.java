package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.PrivateMessage;
import BSEP.repository.PrivateMessageRepository;

@Service
public class PrivateMessageService {

	@Autowired
	protected PrivateMessageRepository privateMessageRepository;
	
	
	public PrivateMessage findById(int id) {
		return privateMessageRepository.findOne(id);
	}
	
	public List<PrivateMessage> findAll() {
		return  privateMessageRepository.findAll();
	}
	
	public Page<PrivateMessage> findAll(Pageable page) {
		return privateMessageRepository.findAll(page);
	}
	
	public PrivateMessage save(PrivateMessage privateMessage) {
		return privateMessageRepository.save(privateMessage);
	}
	
	public PrivateMessage saveAndFlush(PrivateMessage privateMessage) {
		return privateMessageRepository.saveAndFlush(privateMessage);
	}
	
	public void removeById(int id) {
		privateMessageRepository.delete(id);
	}
	
	public void remove(PrivateMessage privateMessage) {
		privateMessageRepository.delete(privateMessage);
	}
	
	
}
