package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {

}
