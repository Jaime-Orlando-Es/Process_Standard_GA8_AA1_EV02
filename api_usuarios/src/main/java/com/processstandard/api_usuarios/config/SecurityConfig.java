package com.processstandard.api_usuarios.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // Indica que esta clase proporciona configuración para Spring
public class SecurityConfig {

    /**
     * Define un filtro de seguridad personalizado.
     * En este caso, se desactiva la protección CSRF y se permite el acceso libre a todas las rutas.
     * Esto es útil en desarrollo cuando aún no se requiere autenticación.
     * 
     * @param http Objeto para configurar la seguridad HTTP
     * @return La cadena de filtros de seguridad configurada
     * @throws Exception Si ocurre un error al construir la configuración
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Desactiva la protección CSRF (recomendado solo en fase de desarrollo o pruebas)
            .csrf(csrf -> csrf.disable()) 

            // Permite todas las peticiones sin exigir autenticación
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permite todas las peticiones sin autenticación
            );

         // Retorna la cadena de filtros de seguridad configurada
        return http.build();
    }
}