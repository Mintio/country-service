package fi.country.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.spi.DocumentationType.SWAGGER_2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "fi.country.api";
	private static final String TITLE = "Countries";
	private static final String DESCRIPTION = "Spring Boot REST API for handling country data.";
	
	@Bean
	public Docket api() {
		return new Docket(SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build();
	}
	
	private static ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.build();
	}
}
