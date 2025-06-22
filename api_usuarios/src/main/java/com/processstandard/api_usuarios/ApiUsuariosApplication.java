package com.processstandard.api_usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// Clase principal del microservicio de usuarios
@SpringBootApplication
public class ApiUsuariosApplication {

	// Método principal que arranca la aplicación Spring Boot
	public static void main(String[] args) {
		SpringApplication.run(ApiUsuariosApplication.class, args);
	}

	// Bean que define el codificador de contraseñas con BCrypt
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
