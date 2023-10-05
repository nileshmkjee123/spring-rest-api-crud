package com.example.springrest;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "spring boot rest api documentation",
				description = "pring boot rest api documentation",
				version = "1.0",
				contact = @Contact(
						name = "nil",
						email="nil@gmail.com"
				),
				license = @License(
						name = "Apache2.0",
						url = "javaguides.net/license"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Spring boot user management documentation",
				url = "javaguides.net/user_management.html"
		)
)
public class SpringRestApplication {
@Bean
	public ModelMapper modelMapper()
	{
		return  new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}
