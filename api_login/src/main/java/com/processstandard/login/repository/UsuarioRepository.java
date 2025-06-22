package com.processstandard.login.repository;

import com.processstandard.login.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

// Repositorio para acceder a los datos de los usuarios en la base de datos
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    // Método para buscar un usuario por su nombre de usuario
    Optional<Usuario> findByUsuario(String usuario);
}
