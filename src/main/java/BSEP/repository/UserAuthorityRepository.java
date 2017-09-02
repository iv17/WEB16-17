package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.UserAuthority;

public interface UserAuthorityRepository extends JpaRepository<UserAuthority, Long> {

	UserAuthority findById(Long id);
}
