package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
