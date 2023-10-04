package com.example.springrest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
