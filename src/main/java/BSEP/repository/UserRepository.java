package BSEP.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Role;
import BSEP.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsernameAndPassword(String username, String password);
	User findByEmailAndPassword(String email, String password);

	User findByUsername(String username);
	User findByEmail(String email);
	
	List<User> findByRole(Role role);

}
