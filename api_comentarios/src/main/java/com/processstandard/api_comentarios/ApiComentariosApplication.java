package com.processstandard.api_comentarios;

// Importa las clases necesarias de Spring Boot
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Esta anotación indica que la clase es la principal del proyecto Spring Boot
@SpringBootApplication
public class ApiComentariosApplication {

	// Método principal que innicia la ejecución del microservicio de comentarios
	public static void main(String[] args) {
		SpringApplication.run(ApiComentariosApplication.class, args);
	}

}
