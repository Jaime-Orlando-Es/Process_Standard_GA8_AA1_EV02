package com.processstandard.api_comentarios.service;

import com.processstandard.api_comentarios.model.Comentario;
import com.processstandard.api_comentarios.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Este servicio contiene la lógica del negocio relacionada con los comentarios
@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    // Método que obtiene todos los comentarios almacenados en la base de datos
    public List<Comentario> obtenerTodos() {
        return comentarioRepository.findAll();
    }

    // Método que guarda un nuevo comentario en la base de datos
    public Comentario crearComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    // Método que elimina un comentario por su identificador unico (ID)
    public void eliminarComentario(int id) {
        comentarioRepository.deleteById(id);
    }
}