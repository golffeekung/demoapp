package com.example.demoapp.employees;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public EmployeeResponse getById(int id) {
//		EmployeeResponse response = new EmployeeResponse();
//		response.setId(id);
//		response.setName("Pongsakorn");
		
		Optional<Employee> result = employeeRepository.findById(id);
		if(result.isPresent()) {
			EmployeeResponse response = new EmployeeResponse();
			response.setId(result.get().getId());
			response.setName(result.get().getName());
			return response;
		}
		throw new EmployeeNotFoundException("Employee not found id=" + id);
	}
	
	@Transactional
	public void xxx() {
		employeeRepository.save(null);
		employeeRepository.deleteAll();
		
	}
	
	
}
