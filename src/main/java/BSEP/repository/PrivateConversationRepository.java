package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.PrivateConversation;

public interface PrivateConversationRepository extends JpaRepository<PrivateConversation, Integer> {

}
