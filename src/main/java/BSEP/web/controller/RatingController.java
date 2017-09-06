package BSEP.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import BSEP.beans.Comment;
import BSEP.beans.Rating;
import BSEP.beans.Snippet;
import BSEP.beans.User;

import BSEP.service.CommentService;
import BSEP.service.RatingService;
import BSEP.service.UserService;

import BSEP.web.dto.CommentDTO;
import BSEP.web.dto.CreateCommentResponseDTO;
import BSEP.web.dto.SnippetDTO;

@RestController
@RequestMapping(value = "/api/ratings")
public class RatingController {


	@Autowired
	private UserService userService;

	@Autowired
	private CommentService commentService;

	@Autowired
	private RatingService ratingService;

	@RequestMapping(
			value = "/add_minus", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<CreateCommentResponseDTO> createRatingMinus(@RequestBody CommentDTO commentDTO,  @RequestHeader("X-Auth-Token") String token) {

		if(userService.findByToken(token) == null) {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.BAD_REQUEST);
		} 
		User user = userService.findByToken(token);

		if(user.getBlocked() == true) {	// NE MOZE BLOKIRAN KORISNIK DA OCENJUJE
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.BAD_REQUEST);
		}
		if(commentService.findById(commentDTO.getId()) == null) {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
		}

		Comment comment = commentService.findById(commentDTO.getId());

		Set<Rating> ratings = comment.getRatings();
		for (Rating rating : ratings) {
			if(rating.getUser().equals(user)) { 	//NE MOZE DVA PUTA DA OCENJUJE
				return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
			}
		}

		Rating rating = new Rating();
		rating.setMinus_rate(1);
		rating.setUser(user);
		rating.setComment(comment);
		rating.setDate(new Date());

		ratingService.save(rating);

		Set<Rating> commentRatings = comment.getRatings();
		commentRatings.add(rating);

		comment.setRatings(commentRatings);

		Snippet snippet = comment.getSnippet();
		SnippetDTO snippetDTO = new SnippetDTO(snippet);

		if(snippet.getComments().size() == 0) {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
		}

		Set<Comment> comments = snippet.getComments();
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for (Comment comm : comments) {

			CommentDTO commDTO = new CommentDTO(comm);
			int minus = 0;
			int plus = 0;
			if(comment.getRatings().size() == 0) {
				commDTO.setMinus(minus);
				commDTO.setPlus(plus);

				commentsDTO.add(commDTO);

			} else {
				for (Rating rat : comm.getRatings()) {
					minus += rat.getMinus_rate();
					plus += rat.getPlus_rate();
				}
				commDTO.setMinus(minus);
				commDTO.setPlus(plus);

				commentsDTO.add(commDTO);
			}
		}
		CreateCommentResponseDTO createCommentResponseDTO = new CreateCommentResponseDTO(snippetDTO, commentsDTO);
		return new ResponseEntity<CreateCommentResponseDTO>(createCommentResponseDTO, HttpStatus.CREATED);

	}

	
	@RequestMapping(
			value = "/add_plus", 
			method = RequestMethod.POST, 
			consumes = "application/json"
			)
	public ResponseEntity<CreateCommentResponseDTO> createRatingPlus(@RequestBody CommentDTO commentDTO,  @RequestHeader("X-Auth-Token") String token) {

		if(userService.findByToken(token) == null) {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.BAD_REQUEST);
		} 
		User user = userService.findByToken(token);

		if(user.getBlocked() == true) {	// NE MOZE BLOKIRAN KORISNIK DA OCENJUJE
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.BAD_REQUEST);
		}
		if(commentService.findById(commentDTO.getId()) == null) {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
		}

		Comment comment = commentService.findById(commentDTO.getId());

		Set<Rating> ratings = comment.getRatings();
		for (Rating rating : ratings) {
			if(rating.getUser().equals(user)) { 	//NE MOZE DVA PUTA DA OCENJUJE
				return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
			}
		}

		Rating rating = new Rating();
		rating.setPlus_rate(1);
		rating.setUser(user);
		rating.setComment(comment);
		rating.setDate(new Date());

		ratingService.save(rating);

		Set<Rating> commentRatings = comment.getRatings();
		commentRatings.add(rating);

		comment.setRatings(commentRatings);

		Snippet snippet = comment.getSnippet();
		SnippetDTO snippetDTO = new SnippetDTO(snippet);

		if(snippet.getComments().size() == 0) {
			return new ResponseEntity<CreateCommentResponseDTO>(HttpStatus.NOT_FOUND);
		}

		Set<Comment> comments = snippet.getComments();
		List<CommentDTO> commentsDTO = new ArrayList<CommentDTO>();
		for (Comment comm : comments) {

			CommentDTO commDTO = new CommentDTO(comm);
			int minus = 0;
			int plus = 0;
			if(comment.getRatings().size() == 0) {
				commDTO.setMinus(minus);
				commDTO.setPlus(plus);

				commentsDTO.add(commDTO);

			} else {
				for (Rating rat : comm.getRatings()) {
					minus += rat.getMinus_rate();
					plus += rat.getPlus_rate();
				}
				commDTO.setMinus(minus);
				commDTO.setPlus(plus);

				commentsDTO.add(commDTO);
			}
		}
		CreateCommentResponseDTO createCommentResponseDTO = new CreateCommentResponseDTO(snippetDTO, commentsDTO);
		return new ResponseEntity<CreateCommentResponseDTO>(createCommentResponseDTO, HttpStatus.CREATED);

	}

}
