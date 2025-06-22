package com.processstandard.api_estandares;

// Importamos la clase que permite iniciar la aplicación Spring Boot
import org.springframework.boot.SpringApplication;

// Importamos la anotación que marca esta clase como aplicación principal de Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta clase es el punto de entrada principal de la aplicación del módulo de estándares
@SpringBootApplication // Anotación que configura automáticamente el proyecto como una aplicación Spring Boot
public class ApiEstandaresApplication {
	
	// Método principal que arranca la aplicación Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(ApiEstandaresApplication.class, args);
	}

}
