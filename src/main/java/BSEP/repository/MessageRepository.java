package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

	Message findById(int id);

}
