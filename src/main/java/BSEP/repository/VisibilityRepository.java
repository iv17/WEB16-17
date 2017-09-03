package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Visibility;

public interface VisibilityRepository extends JpaRepository<Visibility, Integer> {

	Visibility findByName(String visibilityName);

}
