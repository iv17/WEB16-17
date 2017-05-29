package BSEP.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import BSEP.beans.Rating;
import BSEP.repository.RatingRepository;

@Service
public class RatingService {

	@Autowired
	protected RatingRepository ratingRepository;
	
	
	public Rating findById(int id) {
		return ratingRepository.findOne(id);
	}
	
	public List<Rating> findAll() {
		return  ratingRepository.findAll();
	}
	
	public Page<Rating> findAll(Pageable page) {
		return ratingRepository.findAll(page);
	}
	
	public Rating save(Rating rating) {
		return ratingRepository.save(rating);
	}
	
	public Rating saveAndFlush(Rating rating) {
		return ratingRepository.saveAndFlush(rating);
	}
	
	public void removeById(int id) {
		ratingRepository.delete(id);
	}
	
	public void remove(Rating rating) {
		ratingRepository.delete(rating);
	}
	
	
}
