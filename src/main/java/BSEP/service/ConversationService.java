package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Conversation;
import BSEP.repository.ConversationRepository;

@Service
public class ConversationService {

	@Autowired
	ConversationRepository conversationRepository;
	
	
	public Conversation findById(int id) {
		return conversationRepository.findById(id);
	}
		
	public List<Conversation> findAll() {
		return conversationRepository.findAll();
	}
	
	public Page<Conversation> findAll(Pageable page) {
		return conversationRepository.findAll(page);
	}
	
	public Conversation save(Conversation conversation) {
		return conversationRepository.save(conversation);
	}
	
	public Conversation saveAndFlush(Conversation conversation) {
		return conversationRepository.saveAndFlush(conversation);
	}
	
	public void removeById(int id) {
		conversationRepository.delete(id);
	}
	
	public void remove(Conversation conversation) {
		conversationRepository.delete(conversation);
	}
	
	
}
