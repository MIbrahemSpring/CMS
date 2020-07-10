package com.mohamed.cms;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

@SpringBootApplication
public class CmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmsApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource() {

		var source = new ResourceBundleMessageSource();
		source.setBasenames("message");
		source.setUseCodeAsDefaultMessage(true);

		return source;
	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
