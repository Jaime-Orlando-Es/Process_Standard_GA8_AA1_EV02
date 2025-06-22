package com.processstandard.api_estandares;

// Importamos la anotación para marcar esta clase como clase de pruebas en Spring Boot
import org.junit.jupiter.api.Test;

// Importamos la anotación que permitye cargar el contexto de Spring para realizar pruebas
import org.springframework.boot.test.context.SpringBootTest;

// Esta clase contiene pruebas básicas para verificar que el contexto de la aplicación se carga correctamente
@SpringBootTest // Esta anotación indica que se debe iniciar el contexto de la aplicación para pruebas
class ApiEstandaresApplicationTests {

	// Prueba que verifica si el contexto de Spring Boot se carga sin errores
	@Test
	void contextLoads() {
		// Si esta prueba pasa, significa que la configuración básica del módulo está correcta
	}

}
