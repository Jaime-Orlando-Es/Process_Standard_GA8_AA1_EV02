package com.processstandard.login.config; // Ubicación del archivo en el proyecto

// Importaciones necesarias para la configuración y codificación de contraseñas
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// Anotación que indica que esta clase es de configuración (Spring leerá esta clase al iniciar la app)
public class SecurityConfig {

    // Bean para codificar contraseñas con BCrypt
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    // Este método define un "bean" de tipo PasswordEncoder que será usado en otras partes de la aplicación
    // como en LoginService para comparar contraseñas encriptadas con las que vienen del formulario 
    
     // Bean para configurar reglas de seguridad y permitir todas las solicitudes sin autenticación
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desactiva la protección CSRF (útil para pruebas con Postman)
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll() // Permite todas las peticiones sin autenticación
            );
        return http.build();
    }
}