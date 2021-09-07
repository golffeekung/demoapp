package com.example.demoapp.employees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceUnitTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Test
	public void success_case() {
		// Arrange
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Mock name");
		when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
		// Constructor Injection
		EmployeeService employeeService = new EmployeeService(employeeRepository);
//		// Setter Injection
//		employeeService.setEmployeeRepository(employeeRepository);
		// Act
		EmployeeResponse result = employeeService.getById(1);
		// Assert
		assertEquals(1, result.getId());
		assertEquals("Mock name", result.getName());
		
	}
	
	@Test
	public void employee_not_found_case() {
		// Arrange
		when(employeeRepository.findById(1)).thenReturn(Optional.empty());
		// Act
		EmployeeService employeeService = new EmployeeService(employeeRepository);
		try {
			employeeService.getById(1);
			fail();
		} catch (EmployeeNotFoundException e) {
			// Pass
			if(!"Employee not found id=1".equals(e.getMessage())) {
                fail("Message fail with=" + e.getMessage());
            }
		}
	}

}
