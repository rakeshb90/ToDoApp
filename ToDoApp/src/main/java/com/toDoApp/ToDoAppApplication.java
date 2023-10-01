package com.toDoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(
		title="ToDo REST API Documentation",
		description="ToDo REST API Documentation",
		version="v1",
		contact=@Contact(
				name ="Rakesh",
				email ="grakesh.jee@gmail.com",
				url = "https://github.com/rakeshb90/"
				),
		license=@License(
				name="Apache 2.0",
				url="https://github.com/rakeshb90/"
				)
		)
)
public class ToDoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoAppApplication.class, args);
	}

}
