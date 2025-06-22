package com.processstandard.api_estandares.service;

// Importamos la clase Standard (modelo de la base de datos)
import com.processstandard.api_estandares.model.Standard;

// Importamos el repositorio que maneja las operaciones con la base de datos
import com.processstandard.api_estandares.repository.StandardRepository;

import org.springframework.beans.factory.annotation.Autowired; // Para inyectar dependencias automáticamente
import org.springframework.stereotype.Service; // Marca esta clase como un servicio de Spring

import java.util.List; // Para usar listas
import java.util.Optional;  // Para manejar posibles valores nulos al buscar por ID
 
// Esta clase maneja la lógica para gestionar los estándares del sistema
@Service
public class StandardService {

     @Autowired
    private StandardRepository standardRepository;

    // Obtener todos los estándares
    public List<Standard> obtenerTodos() {
        return standardRepository.findAll();
    }

    // Obtener un estándar por su ID
    public Optional<Standard> obtenerPorId(Integer id) {
        return standardRepository.findById(id);
    }

    // Actualizar un estandard existente
    public Standard actualizarEstandar(Standard estandar) {
    return standardRepository.save(estandar); // Guarda o actualiza según el ID
}

    // Guardar un nuevo estándar a actualizar uno existente
    public Standard guardar(Standard standard) {
        return standardRepository.save(standard);
    }

    // Eliminar un estándar por su ID
    public void eliminar(Integer id) {
        standardRepository.deleteById(id);
    }

    // Metodo para buscar por máquina y referencia
    public List<Standard> buscarPorMaquinaYReferencia( String maquina, String referencia) {
        return standardRepository.findByMaquinaContainingIgnoreCaseAndReferenciaContainingIgnoreCase(maquina, referencia);
    }
}
