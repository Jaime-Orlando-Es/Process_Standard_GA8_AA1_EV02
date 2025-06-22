package com.processstandard.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal del microservicio de inicio de sesión.
 * Anotada con @SpringBootApplication para habilitar la configuración automática,
 * el escaneo de componentes y la configuración del contexto de Spring.
 */
@SpringBootApplication(scanBasePackages = "com.processstandard.login")
public class ApiLoginApplication {
	
	 /**
     * Método principal que lanza la aplicación Spring Boot.
     * @param args Argumentos de la línea de comandos (no se usan en este caso).
     */
	public static void main(String[] args) {
		SpringApplication.run(ApiLoginApplication.class, args);
	}

}
