package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
