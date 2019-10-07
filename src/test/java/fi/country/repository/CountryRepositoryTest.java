package fi.country.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.junit4.SpringRunner;

import fi.country.entity.Country;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CountryRepositoryTest {

	@Autowired
	private CountryRepository countryRepository;
	
    @Test
    public void testFindAllSuccessfully() {
        List<Country> countries = countryRepository.findAll();
        assertNotNull(countries);
        assertFalse(countries.isEmpty());
    }
	
    @Test
    public void testFindByNameSuccessfully() {
        Country country = countryRepository.findByName("Finland");
        assertNotNull(country);
        assertEquals("Finland", country.getName());
    }
    
    @Test
    public void testFindByNameUnsuccessfully() {
        Country country = countryRepository.findByName("Diipadaapa");
        assertNull(country);
    }
    
    @Test
    public void testDeleteByNameSuccessfully() {
        Long count = countryRepository.deleteByName("Sweden");
        assertEquals(1L, count.longValue());
    }
    
    @Test
    public void testDeleteByNameUnsuccessfully() {
        Long count = countryRepository.deleteByName("Diipadaapa");
        assertEquals(0L, count.longValue());
    }
    
    @Test
    public void testCreateSuccessfully() {
    	Country country = countryRepository.save(new Country("Jamaica"));
    	assertNotNull(country);
    	assertEquals("Jamaica", country.getName());
    }
    
    @Test(expected = DataIntegrityViolationException.class)
    public void testCreateUnsuccessfully() {
    	countryRepository.save(new Country("JamaicaJamaicaJamaicaJamaica"
    			+ "JamaicaJamaicaJamaicaJamaicaJamaicaaa"));
    }
    
    @Test
    public void testUpdateSuccessfully() {
    	Country countryToUpdate = countryRepository.findByName("United Kingdom");
    	assertNotNull(countryToUpdate);
    	assertEquals("United Kingdom", countryToUpdate.getName());
    	countryToUpdate.setName("United Kingdom and Northern Ireland");
    	Country countryUpdated = countryRepository.save(countryToUpdate);
    	assertNotNull(countryUpdated);
    	assertEquals("United Kingdom and Northern Ireland", countryUpdated.getName());
    }
    
    @Test
    public void testUpdateUnsuccessfully() {
    	Country countryToUpdate = countryRepository.findByName("United Kingdom");
    	assertNotNull(countryToUpdate);
    	assertEquals("United Kingdom", countryToUpdate.getName());
    	countryToUpdate.setName("United Kingdom and Northern Ireland and Scotland and "
    			+ "Ireland and Wales");
    	countryRepository.save(countryToUpdate);
    }
}
