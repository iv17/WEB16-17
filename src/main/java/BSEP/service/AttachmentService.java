package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Attachment;
import BSEP.repository.AttachmentRepository;

@Service
public class AttachmentService {

	@Autowired
	AttachmentRepository attachmentRepository;
	
	
	public Attachment findById(int id) {
		return attachmentRepository.findById(id);
	}
	
	public List<Attachment> findAll() {
		return attachmentRepository.findAll();
	}
	
	public Page<Attachment> findAll(Pageable page) {
		return attachmentRepository.findAll(page);
	}
	
	public Attachment save(Attachment attachment) {
		return attachmentRepository.save(attachment);
	}
	
	public Attachment saveAndFlush(Attachment attachment) {
		return attachmentRepository.saveAndFlush(attachment);
	}
	
	public void removeById(int id) {
		attachmentRepository.delete(id);
	}
	
	public void remove(Attachment attachment) {
		attachmentRepository.delete(attachment);
	}
	
	
}
