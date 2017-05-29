package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.PrivateMessage;

public interface PrivateMessageRepository extends JpaRepository<PrivateMessage, Integer> {

}
