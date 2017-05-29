package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Language;
import BSEP.repository.LanguageRepository;

@Service
public class LanguageService {

	@Autowired
	LanguageRepository languageRepository;
	
	
	public Language findById(int id) {
		return languageRepository.findById(id);
	}
	
	public List<Language> findAll() {
		return languageRepository.findAll();
	}
	
	public Page<Language> findAll(Pageable page) {
		return languageRepository.findAll(page);
	}
	
	public Language save(Language language) {
		return languageRepository.save(language);
	}
	
	public Language saveAndFlush(Language language) {
		return languageRepository.saveAndFlush(language);
	}
	
	public void removeById(int id) {
		languageRepository.delete(id);
	}
	
	public void remove(Language language) {
		languageRepository.delete(language);
	}
	
	
}
