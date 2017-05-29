package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}
