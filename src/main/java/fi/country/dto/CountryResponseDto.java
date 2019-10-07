package fi.country.dto;

import java.time.LocalDateTime;

public class CountryResponseDto {
	public final Long id;
	public final LocalDateTime createdAt;
	public final LocalDateTime updatedAt;
	public final String name;
	
	public CountryResponseDto(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String name) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.name = name;
	}
}
