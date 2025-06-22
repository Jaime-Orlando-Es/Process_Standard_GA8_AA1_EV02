package com.processstandard.api_estandares.model;

import jakarta.persistence.*;
import lombok.Data;

// Esta clase representa un estándar del sistema
// Cada estándar está asociado a una máquina y una referencia
@Entity
@Table(name = "standards")
@Data
public class Standard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Nombre o código de la máquina a la que pertenece el estándar
    private String maquina;

    // Referencia específica del proceso
    private String referencia;

    // Descripción general del estándar (puede contener instrucciones, notas, etc.)
    private String descripcion;

    // Se puede agregar más campos si el estándar lo require (ej: tiempo, temperatura, etc.)
}
