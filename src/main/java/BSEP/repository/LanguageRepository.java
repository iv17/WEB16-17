package BSEP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BSEP.beans.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

	Language findById(int id);

}
