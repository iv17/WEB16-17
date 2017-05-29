package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Conversation;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {

}
