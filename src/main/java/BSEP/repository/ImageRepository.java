package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Image;

public interface ImageRepository extends JpaRepository<Image, Integer> {

	Image findById(int id);
	Image findByFile(String file);
	Image findByName(String name);
}
