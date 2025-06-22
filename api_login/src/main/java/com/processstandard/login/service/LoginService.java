package com.processstandard.login.service;

import com.processstandard.login.model.LoginRequest;
import com.processstandard.login.model.Usuario;
import com.processstandard.login.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Servicio encargado de validar el inicio de sesión de los usuarios
@Service
public class LoginService {

    // Inyección del repositorio para acceder a los datos de usuarios
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Inyección del codificador de contraseñas para comparar contraseñas encriptadas
    @Autowired
    private PasswordEncoder passwordEncoder;

     // Método que valida las credenciales ingresadas por el usuario
    public boolean validarInicioSesion( LoginRequest solicitud) {
        String usuarioIngresado = solicitud.getUsuario();
        String contrasenaIngresada= solicitud.getContrasena();

        // Buscar al usuario por su nombre de usuario
        Optional<Usuario> usuarioDB = usuarioRepository.findByUsuario(usuarioIngresado);

        // Validar que el usuario exista y que la contraseña coincida
        if (usuarioDB.isPresent()) {
            Usuario usuario = usuarioDB.get();
            return passwordEncoder.matches(contrasenaIngresada, usuario.getContrasena());
        }
         // Si no se encuentra el usuario o la contraseña no coincide
        return false;
    }
    
    // Nuevo método: devuelve el usuario si la contraseña es válida
    public Usuario obtenerUsuarioPorCredenciales(LoginRequest solicitud) {
        String usuarioIngresado = solicitud.getUsuario();
        String contrasenaIngresada = solicitud.getContrasena();

        Optional<Usuario> usuarioDB = usuarioRepository.findByUsuario(usuarioIngresado);
        if (usuarioDB.isPresent()) {
            Usuario usuario = usuarioDB.get();
            if (passwordEncoder.matches(contrasenaIngresada, usuario.getContrasena())) {
                return usuario;
            }
        }
        return null;
    }
}