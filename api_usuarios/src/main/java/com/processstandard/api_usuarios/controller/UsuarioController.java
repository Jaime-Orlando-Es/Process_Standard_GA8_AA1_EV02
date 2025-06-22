package com.processstandard.api_usuarios.controller;

import com.processstandard.api_usuarios.model.Usuario;
import com.processstandard.api_usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController // Esta anotación indica que esta clase es un controlador REST
@RequestMapping("/api/usuarios") // Ruta base para acceder a los endpoints de este controlador
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen (útil para el frontend)
public class UsuarioController {
    
      @Autowired // Inyección del servicio que contiene la lógica de negocio para usuarios
    private UsuarioService usuarioService;
    
    /**
     * Obtener todos los usuarios registrados.
     * Método GET que retorna una lista con todos los usuarios almacenados en la base de datos.
     */
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioService.obtenerTodos();
    }
    
     /**
     * Obtener un usuario por su ID.
     * Método GET que recibe el ID del usuario como parámetro en la URL.
     * 
     * @param id Identificador del usuario.
     * @return Un objeto Optional con los datos del usuario si existe.
     */
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuario(@PathVariable int id) {
        return usuarioService.obtenerPorId(id);
    }
    
    /**
     * Crear un nuevo usuario.
     * Método POST que recibe un objeto Usuario en formato JSON y lo guarda en la base de datos.
     * 
     * @param usuario Datos del nuevo usuario.
     * @return El usuario creado.
     */
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioService.crearUsuario(usuario);
    }
    
    /**
     * Actualizar los datos de un usuario existente.
     * Método PUT que recibe el ID del usuario y los nuevos datos.
     * 
     * @param id Identificador del usuario a actualizar.
     * @param usuario Datos actualizados del usuario.
     * @return El usuario actualizado.
     */
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuarioService.actualizarUsuario(usuario);
    }
    
    /**
     * Eliminar un usuario por su ID.
     * Método DELETE que borra un usuario de la base de datos.
     * 
     * @param id Identificador del usuario a eliminar.
     */
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }
}
