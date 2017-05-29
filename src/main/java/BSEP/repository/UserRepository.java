package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
