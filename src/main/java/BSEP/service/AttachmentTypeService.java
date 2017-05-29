package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.AttachmentType;
import BSEP.repository.AttachmentTypeRepository;

@Service
public class AttachmentTypeService {

	@Autowired
	AttachmentTypeRepository attachmentTypeRepository;
	
	
	public AttachmentType findById(int id) {
		return attachmentTypeRepository.findById(id);
	}
	
	public List<AttachmentType> findAll() {
		return attachmentTypeRepository.findAll();
	}
	
	public Page<AttachmentType> findAll(Pageable page) {
		return attachmentTypeRepository.findAll(page);
	}
	
	public AttachmentType save(AttachmentType attachmentType) {
		return attachmentTypeRepository.save(attachmentType);
	}
	
	public AttachmentType saveAndFlush(AttachmentType attachmentType) {
		return attachmentTypeRepository.saveAndFlush(attachmentType);
	}
	
	public void removeById(int id) {
		attachmentTypeRepository.delete(id);
	}
	
	public void remove(AttachmentType attachmentType) {
		attachmentTypeRepository.delete(attachmentType);
	}
	
	
}
