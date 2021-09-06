package com.example.demoapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@SpringBootApplication
public class DemoappApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoappApplication.class, args);
		
		String[] names = context.getBeanDefinitionNames();
		Arrays.stream(names).forEach(System.out::println);
		
		System.out.println(context.getBeanDefinitionCount());
	}

}
