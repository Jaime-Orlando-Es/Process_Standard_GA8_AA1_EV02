package com.processstandard.login.model;

// Clase que representa la solicitud de inicio de sesión
public class LoginRequest {

    // Atributos: usuario y contraseña que el cliente envía
    private String usuario;
    private String contrasena;

    // Constructor vacío necesario para la deserialización JSON
    public LoginRequest() {}

    // Constructor con parámetros
    public LoginRequest(String usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    // Métodos getter y setter para el nombre de usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario= usuario;
    }
    
    // Métodos getter y setter para la contraseña
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
}
