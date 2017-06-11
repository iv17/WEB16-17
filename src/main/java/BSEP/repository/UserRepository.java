package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);

	User findByUsername(String username);

	User findByEmail(String email);

}
