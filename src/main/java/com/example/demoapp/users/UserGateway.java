package com.example.demoapp.users;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class UserGateway {
	
	private RestTemplate restTemplate;
	
	@Autowired
	public UserGateway(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	public Optional<UserResponse> getUserById(int id) {
		String url = "https://jsonplaceholder.typicode.com/users/" + id;
//		UserResponse response = restTemplate.getForObject(url, UserResponse.class);
//		if(response == null) {
//			throw new RuntimeException("API error with id=" + id);
//		}
//		return response;
		
		try {
			UserResponse result = restTemplate.getForObject(url, UserResponse.class);
			return Optional.ofNullable(result);
		}catch(RestClientException e) {
			return Optional.empty();
		}
	}
}
