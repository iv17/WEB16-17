package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

	Location findById(int id);

}
