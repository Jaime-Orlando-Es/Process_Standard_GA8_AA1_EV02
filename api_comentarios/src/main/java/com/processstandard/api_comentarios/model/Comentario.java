package com.processstandard.api_comentarios.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/** Clase que representa un comentario hecho por un usuario
 * Esta entidad se almacena en la tabla 'comentarios' de la tabla de datos
 */
@Entity
@Table(name = "comentarios")
public class Comentario {

    // Identificador unico de comentario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // Nombre del usuario que realiza el comentario
    private String nombre;

    // Contenido del comentario escrito por el usuario
    private String comentario;

    // Fecha en la que realizo el comentario
    private LocalDate fecha;

    // Constructor vacio necesario para JPA
    public Comentario() {}

    // Constructor con todos los atributos
    public Comentario(String nombre, String comentario, LocalDate fecha) {
        this.nombre = nombre;
        this.comentario = comentario;
        this.fecha = fecha;
    }

    // Metodos getters y setters para acceder y modificar los atributos
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
