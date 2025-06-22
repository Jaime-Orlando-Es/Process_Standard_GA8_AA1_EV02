package com.processstandard.api_estandares.repository;

import com.processstandard.api_estandares.model.Standard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

// Este repositorio permite realizar operaciones CRUD sobre los estándares
// Al extender JpaRepository, se heredan métodos como guardar, buscar, eliminar y listar
@Repository
public interface StandardRepository extends JpaRepository<Standard, Integer> {

    //metodo para buscar por maquina y referencia (coincidencias parcial, sin importal mayúsculas)
    List<Standard> findByMaquinaContainingIgnoreCaseAndReferenciaContainingIgnoreCase( String maquina, String referencia);
}