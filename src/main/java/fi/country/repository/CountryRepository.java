package fi.country.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fi.country.entity.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
	Country findByName(String name);
	
	@Transactional
	Long deleteByName(String name);
}
