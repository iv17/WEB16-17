package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Message;
import BSEP.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	
	public Message findById(int id) {
		return messageRepository.findById(id);
	}
	
	public List<Message> findAll() {
		return messageRepository.findAll();
	}
	
	public Page<Message> findAll(Pageable page) {
		return messageRepository.findAll(page);
	}
	
	public Message save(Message message) {
		return messageRepository.save(message);
	}
	
	public Message saveAndFlush(Message message) {
		return messageRepository.saveAndFlush(message);
	}
	
	public void removeById(int id) {
		messageRepository.delete(id);
	}
	
	public void remove(Message message) {
		messageRepository.delete(message);
	}
}
