package com.processstandard.api_usuarios.model;

import jakarta.persistence.*; // Importaciones para mapear esta clase como una entidad JPA
import lombok.Data; // Anotación de Lombok para generar automáticamente getters, setters, etc.

/**
 * Clase que representa la entidad Usuario.
 * Se mapea a la tabla 'usuarios' en la base de datos.
 */
@Entity // Indica que esta clase es una entidad JPA
@Data // Lombok genera automáticamente métodos como getters, setters, equals, hashCode y toString
@Table(name = "usuarios") // Define el nombre de la tabla en la base de datos
public class Usuario {

    @Id // Indica que este campo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incrementa el ID
    private Integer id;

    // Nombre completo del usuario
    private String nombre;

    // Área o departamento al que pertenece el usuario
    private String area;

      // Nombre de usuario para iniciar sesión
    private String usuario;

    // Contraseña encriptada del usuario
    private String contrasena;

     // Estado de bloqueo del usuario (true si está bloqueado, false si está activo)
    private boolean bloqueado;
}
