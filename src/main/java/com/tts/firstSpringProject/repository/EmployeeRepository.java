package com.tts.firstSpringProject.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.tts.firstSpringProject.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	List<Employee> findByLastName(String lastName);
}
