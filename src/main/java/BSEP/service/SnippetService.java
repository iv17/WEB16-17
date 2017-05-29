package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Snippet;
import BSEP.repository.SnippetRepository;

@Service
public class SnippetService {

	@Autowired
	protected SnippetRepository snippetRepository;
	
	
	public Snippet findById(int id) {
		return snippetRepository.findOne(id);
	}
	
	public List<Snippet> findAll() {
		return  snippetRepository.findAll();
	}
	
	public Page<Snippet> findAll(Pageable page) {
		return snippetRepository.findAll(page);
	}
	
	public Snippet save(Snippet snippet) {
		return snippetRepository.save(snippet);
	}
	
	public Snippet saveAndFlush(Snippet snippet) {
		return snippetRepository.saveAndFlush(snippet);
	}
	
	public void removeById(int id) {
		snippetRepository.delete(id);
	}
	
	public void remove(Snippet snippet) {
		snippetRepository.delete(snippet);
	}
	
	
}
