package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Comment;
import BSEP.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	
	public Comment findById(int id) {
		return commentRepository.findById(id);
	}
		
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}
	
	public Page<Comment> findAll(Pageable page) {
		return commentRepository.findAll(page);
	}
	
	public Comment save(Comment comment) {
		return commentRepository.save(comment);
	}
	
	public Comment saveAndFlush(Comment comment) {
		return commentRepository.saveAndFlush(comment);
	}
	
	public void removeById(int id) {
		commentRepository.delete(id);
	}
	
	public void remove(Comment comment) {
		commentRepository.delete(comment);
	}
	
	
}
