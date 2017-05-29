package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.TeamMessage;

public interface TeamMessageRepository extends JpaRepository<TeamMessage, Integer> {

}
