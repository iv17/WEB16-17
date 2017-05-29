package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Snippet;

public interface SnippetRepository extends JpaRepository<Snippet, Integer>{

}
