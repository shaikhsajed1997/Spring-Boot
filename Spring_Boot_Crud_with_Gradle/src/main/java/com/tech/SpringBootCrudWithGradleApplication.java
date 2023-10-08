package com.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

import com.tech.entity.Student;
import com.tech.repository.StudentRepository;

@SpringBootApplication
public class SpringBootCrudWithGradleApplication  {

	
	public static void main(String[] args) {
		
		 SpringApplication.run(SpringBootCrudWithGradleApplication.class, args);
	
	
		
	}

}
