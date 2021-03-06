package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Image;
import BSEP.repository.ImageRepository;
import BSEP.repository.UserRepository;

@Service
public class ImageService {

	@Autowired
	ImageRepository imageRepository;

	@Autowired
	UserRepository userRepository;


	public Image findById(int id) {
		return imageRepository.findById(id);
	}
	
	public Image findByName(String name) {
		return imageRepository.findByName(name);
	}
	
	public Image findByFile(String file) {
		return imageRepository.findByFile(file);
	}

	public List<Image> findAll() {
		return imageRepository.findAll();
	}

	public Page<Image> findAll(Pageable page) {
		return imageRepository.findAll(page);
	}

	public Image save(Image image) {
		return imageRepository.save(image);
	}

	public Image saveAndFlush(Image image) {
		return imageRepository.saveAndFlush(image);
	}

	public void removeById(int id) {
		imageRepository.delete(id);
	}

	public void remove(Image image) {
		imageRepository.delete(image);
	}
	

}
