package fi.country.dto;

import javax.validation.constraints.Size;

public class CountryRequestDto {
	
	@Size(min = 4, max = 64, message = "Name must be between 4-64 chars.")
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
