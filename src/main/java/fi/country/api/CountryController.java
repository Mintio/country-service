package fi.country.api;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fi.country.dto.CountryRequestDto;
import fi.country.dto.CountryResponseDto;
import fi.country.service.CountryService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/api/v1/countries", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CountryController {

	private final CountryService countryService;

	public CountryController(CountryService countryService) {
		super();
		this.countryService = countryService;
	}
	
	@GetMapping(path = "/all")
	@ApiOperation(value = "Fetches all countries.")
    public ResponseEntity<List<CountryResponseDto>> findAll() {
        return ResponseEntity.ok(countryService.findAll());
    }
	
	@GetMapping(path = {"/find/{name}"})
	@ApiOperation(value = "Fetches one country by name.")
	public ResponseEntity<CountryResponseDto> findByName(@PathVariable(required = true) String name) {
		return Optional.ofNullable(countryService.findByName(name))
				.map(c -> ResponseEntity.ok().body(c))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping(path = "/create")
	@ApiOperation(value = "Creates country.")
	public ResponseEntity<CountryResponseDto> create(@Valid @RequestBody CountryRequestDto request) {
	    return ResponseEntity.ok().body(countryService.create(request));
	}
	
	@PutMapping(value="/update/{name}")
	@ApiOperation(value = "Updates country by name.")
	public ResponseEntity<CountryResponseDto> update(@PathVariable(required = true) String name, 
			@Valid @RequestBody CountryRequestDto request) {
		return Optional.ofNullable(countryService.update(name, request))
				.map(c -> ResponseEntity.ok().body(c))
				.orElse(ResponseEntity.notFound().build());
	}
	
    @DeleteMapping("/delete/{name}")
    @ApiOperation(value = "Deletes country by name.")
    public ResponseEntity<Long> deleteByName(@PathVariable(required = true) String name) {
    	Long count = countryService.deleteByName(name);
    	return count == 1 ? ResponseEntity.ok().body(count) : ResponseEntity.badRequest().body(count);  
    }
}
