package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.PrivateConversation;
import BSEP.repository.PrivateConversationRepository;

@Service
public class PrivateConversationService {

	@Autowired
	protected PrivateConversationRepository privateConversationRepository;
	
	
	public PrivateConversation findById(int id) {
		return privateConversationRepository.findOne(id);
	}
	
	public List<PrivateConversation> findAll() {
		return  privateConversationRepository.findAll();
	}
	
	public Page<PrivateConversation> findAll(Pageable page) {
		return privateConversationRepository.findAll(page);
	}
	
	public PrivateConversation save(PrivateConversation privateConversation) {
		return privateConversationRepository.save(privateConversation);
	}
	
	public PrivateConversation saveAndFlush(PrivateConversation privateConversation) {
		return privateConversationRepository.saveAndFlush(privateConversation);
	}
	
	public void removeById(int id) {
		privateConversationRepository.delete(id);
	}
	
	public void remove(PrivateConversation privateConversation) {
		privateConversationRepository.delete(privateConversation);
	}
	
	
}
