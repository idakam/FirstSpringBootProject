package com.tts.firstSpringProject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tts.firstSpringProject.model.Employee;
import com.tts.firstSpringProject.repository.EmployeeRepository;

@SpringBootApplication
public class FirstSpringProjectApplication {
	private static final Logger log = LoggerFactory.getLogger(FirstSpringProjectApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FirstSpringProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(EmployeeRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new Employee("Michael", "Smith", 32, "Central"));
			repository.save(new Employee("Aaron", "Moon", 23, "South"));
			repository.save(new Employee("Kim", "Lassiter", 43, "West"));
			repository.save(new Employee("Joan", "Daniels", 28, "North"));
			repository.save(new Employee("Eric", "Patterson", 35, "East"));

			// read all customers
			log.info("Employeess found with findAll():");
			log.info("-------------------------------");
			for (Employee employee : repository.findAll()) {
				log.info(employee.toString());
			}
			log.info("");

			// read an individual customer by ID
			repository.findById(1L)
				.ifPresent(employee -> {
					log.info("Employee found with findById(1L):");
					log.info("--------------------------------");
					log.info(employee.toString());
					log.info("");
				});

			// read customers by last name
			log.info("Employee found with findByLastName('Patterson'):");
			log.info("--------------------------------------------");
			repository.findByLastName("Patterson").forEach(bauer -> {
				log.info(bauer.toString());
			});
			
			log.info("");
		};
	}
}
