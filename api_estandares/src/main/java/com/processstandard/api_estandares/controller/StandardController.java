package com.processstandard.api_estandares.controller;

import com.processstandard.api_estandares.model.Standard;
import com.processstandard.api_estandares.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api_estandares") // Ruta base para acceder a este microservicio
@CrossOrigin(origins = "*") // Permite solicitudes desde cualquier origen (ideal para pruebas)
public class StandardController {

      @Autowired
    private StandardService standardService;

    // Consulta publica: Obtener tos los estandares registrados 
    @GetMapping
    public List<Standard> obtenerEstandares() {
        return standardService.obtenerTodos();
    }

    // Buscar en estándar específico por su ID 
    @GetMapping("/{id}")
    public Optional<Standard> buscarEstandarPorId(@PathVariable Integer id) {
        return standardService.obtenerPorId(id);
    }

    // Consulta publica: Buscar por máquina y referencia
    @GetMapping("/buscar")
    public List<Standard> buscarPorMaquinaYReferencia(@RequestParam String maquina, @RequestParam String referencia) {
        return standardService.buscarPorMaquinaYReferencia(maquina, referencia);                                               
    }

    // Solo ADMIN puede actualizar un estándar
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarEstandar(@PathVariable int id, @RequestBody Standard estandar, @RequestHeader("rol") String rol) {
        if (!"ADMIN".equalsIgnoreCase(rol)){
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body("Acceso denegado: Solo los administradores pueden actualizar estándares");
        }
        estandar.setId(id);
        return ResponseEntity.ok(standardService.actualizarEstandar(estandar));
    }

    // Solo ADMIN puede crear un nuevo estándar
    @PostMapping
    public ResponseEntity<?> registrarEstandar(@RequestBody Standard standard, @RequestHeader("rol") String rol) {
        if (!"ADMIN".equalsIgnoreCase(rol)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body("Acceso denegado: solo los administradors pueden registrar estándares");
        }
        Standard creado = standardService.guardar(standard);
        return ResponseEntity.ok(creado);
    }

    // Solo ADMIN puede eliminar un estándar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarEstandar(@PathVariable Integer id, @RequestHeader("rol") String rol) {
        if (!"ADMIN".equalsIgnoreCase(rol)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body("Acceso denegado: Solo los administradores pueden eliminar estánadares");
        }

        standardService.eliminar(id);
        return ResponseEntity.ok("Estándar eliminado correctanmente");
    }
    
}
