package com.processstandard.api_usuarios.repository;

import com.processstandard.api_usuarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Repositorio para la entidad Usuario.
 * Permite realizar operaciones CRUD y consultas personalizadas a la tabla 'usuarios'.
 */
@Repository  // Marca esta interfaz como un componente de acceso a datos
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario en la base de datos por su nombre de usuario (campo 'usuario').
     *
     * @param usuario nombre de usuario a buscar
     * @return Optional que contiene el Usuario si lo encuentra, o vacío si no existe
     */
    Optional<Usuario> findByUsuario(String usuario);

    // Aquí se puede agregar consultas personalizadas si se necesita
    
}