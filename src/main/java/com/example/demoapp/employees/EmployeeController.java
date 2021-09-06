package com.example.demoapp.employees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping("/employees")
	public EmployeeResponse[] listEmployees() {
		return new EmployeeResponse[]{new EmployeeResponse()};
	}
}
