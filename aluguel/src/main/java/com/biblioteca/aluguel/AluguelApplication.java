package com.biblioteca.aluguel;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class AluguelApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	/**
	 * Start via Spring Boot
	 * @param args
	 */
	public static void main(String[] args) {
		new AluguelApplication()
				.configure(new SpringApplicationBuilder(AluguelApplication.class))
				.run(args);
	}
}