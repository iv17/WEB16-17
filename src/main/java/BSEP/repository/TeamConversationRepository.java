package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.TeamConversation;

public interface TeamConversationRepository extends JpaRepository<TeamConversation, Integer> {

}
