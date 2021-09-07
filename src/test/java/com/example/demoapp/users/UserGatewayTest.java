package com.example.demoapp.users;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserGatewayTest {

	@Autowired
	private UserGateway userGateway;
	
	@Test
	public void getUserById() {
		// Act
		Optional<UserResponse> response = userGateway.getUserById(1);
		// Assert
		assertTrue(response.isPresent());
		assertEquals(1, response.get().getId());
		assertEquals("Bret", response.get().getUsername());
	}
}
