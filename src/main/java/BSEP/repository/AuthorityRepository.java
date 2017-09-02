package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

	Authority findById(Long id);
}
