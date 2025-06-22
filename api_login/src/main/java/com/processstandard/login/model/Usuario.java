package com.processstandard.login.model;

import jakarta.persistence.*;

// Esta clase representa la entidad Usuario, vinculada a la tabla "Usuarios" en la base de datos
@Entity
@Table(name = "Usuarios")
public class Usuario {
    
     // Identificador único del usuario (clave primaria)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre completo del usuario
    private String nombre;

    // Área o departamento al que pertenece el usuario
    private String area;

     // Nombre de usuario para iniciar sesión
    private String usuario;

     // Contraseña encriptada del usuario
    private String contrasena;

    // Rol del usuario: Puede ser ADMIN o USER
    private String rol;

    // Métodos getter y setter para acceder a los atributos

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol;  }
    
}
