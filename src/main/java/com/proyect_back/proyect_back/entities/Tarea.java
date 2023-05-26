package com.proyect_back.proyect_back.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name="tarea")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"propiedadNoSerializable1", "propiedadNoSerializable2"})
public class Tarea {

    @Id
    private String identificador;

    @ManyToOne
    @JoinColumn(name = "equipoTrabajo_id")
    private EquipoTrabajo equipoTrabajo;
    private String area;
    private Date HoraCreacion;
    private Date HoraMaxResolucion;
    private String descipcion;
    private String prioridad;
}
