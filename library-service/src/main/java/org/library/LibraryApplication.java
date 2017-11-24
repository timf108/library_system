package org.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * 	Library App
 *
 */
@EnableJpaRepositories(basePackages = {"org.library","org.repository"})
@EntityScan("org.repository.domain.*")  
@SpringBootApplication
@ComponentScan(
		basePackages = {"org.library","org.repository"})
public class LibraryApplication {
	
	public static void main(String[] args) {
	  SpringApplication.run(LibraryApplication.class, args);
	}
}
