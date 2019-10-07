package fi.country.converter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import fi.country.dto.CountryRequestDto;
import fi.country.dto.CountryResponseDto;
import fi.country.entity.Country;

public class CountryConverter {
	
	private CountryConverter() {}
	
	public static final Function<List<Country>, List<CountryResponseDto>> toCountryResponses = countries -> {
		if (Objects.isNull(countries)) {
			return Collections.emptyList();
		}
		
		List<CountryResponseDto> response = new ArrayList<>();
		countries.forEach(c -> response.add(getCountryResponseDto(c)));
		return response;
	};
	
	public static final Function<CountryRequestDto, Country> toCountry = request -> {
		if (Objects.isNull(request)) {
			return null;
		}
		
		return new Country(request.getName());
	};
	
	public static final CountryResponseDto getCountryResponseDto(final Country country) {
		if (Objects.isNull(country)) {
			return null;
		}
		
		return new CountryResponseDto(
				country.getId(),
				country.getCreatedAt(),
				country.getUpdatedAt(),
				country.getName());
	}
}
