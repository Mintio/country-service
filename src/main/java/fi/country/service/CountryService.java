package fi.country.service;

import java.util.List;
import java.util.Objects;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import fi.country.converter.CountryConverter;
import fi.country.dto.CountryRequestDto;
import fi.country.dto.CountryResponseDto;
import fi.country.entity.Country;
import fi.country.repository.CountryRepository;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
public class CountryService {

	private final CountryRepository countryRepository;

	public CountryService(CountryRepository countryRepository) {
		super();
		this.countryRepository = countryRepository;
	}
	
	public List<CountryResponseDto> findAll() {
		return CountryConverter.toCountryResponses.apply(countryRepository.findAll(Sort.by(ASC, "name")));
	}
	
	public CountryResponseDto findByName(String name) {
		return CountryConverter.getCountryResponseDto(countryRepository.findByName(name));
	}
	
	public CountryResponseDto create(CountryRequestDto request) {
		Country country = CountryConverter.toCountry.apply(request);
		return CountryConverter.getCountryResponseDto(countryRepository.save(country));
	}
	
	public CountryResponseDto update(String name, CountryRequestDto request) {
		Country countryToUpdate = countryRepository.findByName(name);
		
		if (Objects.isNull(countryToUpdate)) {
			return null;
		}
		
		countryToUpdate.setName(request.getName());
		return CountryConverter.getCountryResponseDto(countryRepository.save(countryToUpdate));
	}
	
	public Long deleteByName(String name) {
		return countryRepository.deleteByName(name);
	}
}
