package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
