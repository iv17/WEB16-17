package BSEP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Comment;
import BSEP.beans.Snippet;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

	Comment findById(int id);
	List<Comment> findBySnippet(Snippet snippet);
	
}
