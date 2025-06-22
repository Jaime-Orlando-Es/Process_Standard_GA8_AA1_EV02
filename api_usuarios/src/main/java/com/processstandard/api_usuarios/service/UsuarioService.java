package com.processstandard.api_usuarios.service;

import com.processstandard.api_usuarios.model.Usuario;
import com.processstandard.api_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder; // <- IMPORTANTE
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio que contiene la lógica de negocio para gestionar los usuarios
 * del sistema Process Standard.
 */
@Service
public class UsuarioService {

    // Inyección del repositorio para acceder a la base de datos
    @Autowired
    private UsuarioRepository usuarioRepository;

     // Inyección del codificador de contraseñas (BCrypt)
    @Autowired
    private PasswordEncoder passwordEncoder; // <- INYECTAR EL ENCRIPTADOR

    /**
     * Obtiene todos los usuarios almacenados en la base de datos
     * @return Lista de usuarios
     */
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

     /**
     * Busca un usuario por su ID
     * @param id identificador del usuario
     * @return Optional con el usuario si existe
     */
    public Optional<Usuario> obtenerPorId(int id) {
        return usuarioRepository.findById((long) id);
    }

      /**
     * Crea un nuevo usuario. Antes de guardar, encripta su contraseña
     * @param usuario Objeto con los datos del usuario
     * @return Usuario guardado en la base de datos
     */
    public Usuario crearUsuario(Usuario usuario) {
        // Encriptar la contraseña antes de guardar
        String encriptada = passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(encriptada);
        return usuarioRepository.save(usuario);
    }

     /**
     * Actualiza los datos de un usuario existente
     * @param usuario Objeto con los datos actualizados
     * @return Usuario actualizado
     */
    public Usuario actualizarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

     /**
     * Elimina un usuario de la base de datos por su ID
     * @param id identificador del usuario a eliminar
     */
    public void eliminarUsuario(int id) {
        usuarioRepository.deleteById((long) id);
    }
}