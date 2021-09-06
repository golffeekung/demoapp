package com.example.demoapp.exployees;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	
	@GetMapping("/employees")
	public EmployeesResponse[] listEmployees() {
		return new EmployeesResponse[]{new EmployeesResponse()};
	}
}
