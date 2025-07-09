package com.processstandard.api_comentarios.controller;

import com.processstandard.api_comentarios.model.Comentario;
import com.processstandard.api_comentarios.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api_comentarios") // Ruta base para todos los endpoints de este controlador
@CrossOrigin(origins = "*") // Permite llamadas desde cualquier origen (útil para pruebas con frontend durante ekl desarrollo)
public class ComentarioController {

    @Autowired // Inyeccion automática del servicio de comentarios
    private ComentarioService comentarioService;
    
    // Endpoint para obtener todos los comentarios
    @GetMapping
    public List<Comentario> obtenerComentarios() {
        return comentarioService.obtenerTodos();
    }

    // Endpoint para crear un nuevo comentario ( recibe un objeto Comentario desde el cuerpo de la petición )
    @PostMapping
    public Comentario crearComentario(@RequestBody Comentario comentario) {
        return comentarioService.crearComentario(comentario);
    }

    // Endpoint para eliminar un comentario especifico por ID
    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable int id) {
        comentarioService.eliminarComentario(id);
    }
}
