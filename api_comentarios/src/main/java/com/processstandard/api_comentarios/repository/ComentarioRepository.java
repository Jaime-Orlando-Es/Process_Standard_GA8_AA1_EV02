package com.processstandard.api_comentarios.repository;

import com.processstandard.api_comentarios.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** 
 * Interfazx que extiende JpaRepository para gestionar la entidad Comentario
 * Proporciona métodos automáticos para operaciones CRUD (crear, leer, actualizar y eliminar)
 * sin necesidad de implementar código adicional
 */
@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {
    // No es necesario agregar métodos aquí si se usan solo los básicos (findALL, save, deleteById, ect.)
}