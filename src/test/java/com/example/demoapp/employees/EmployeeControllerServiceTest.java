package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerServiceTest {
	
	@Autowired 
	private TestRestTemplate restTemplate;
	
	@MockBean
	private EmployeeRepository employeeRepository;
	
	@Test
	@DisplayName("Success")
	public void case01() {
		// Arrange
		int id = 1;
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Pongsakorn");
		when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
		// Act
		EmployeeResponse result = restTemplate.getForObject("/employees/" + id, EmployeeResponse.class);
		
		// Assert
		assertEquals(id , result.getId());
		assertEquals("Pongsakorn" , result.getName());
	}
	
	@Test
	@DisplayName("Failure case :: Employee not found id = 100")
	public void case02() {
		int id = 100;
		Employee employee = new Employee();
		employee.setId(1);
		when(employeeRepository.findById(100)).thenReturn(Optional.empty());
		// Act
		ResponseEntity<ErrorResponse> result = restTemplate.getForEntity("/employees/" + id, ErrorResponse.class);
		
		// Assert
		assertEquals(404 , result.getStatusCodeValue());
		assertEquals(404, result.getBody().getCode());
		assertEquals("Employee not found id=100", result.getBody().getDetail());
	}
}