package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Access;

public interface AccessRepository extends JpaRepository<Access, Integer> {

	Access findById(int id);

}
