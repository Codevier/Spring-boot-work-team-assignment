package com.proyect_back.proyect_back.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="personal_apoyo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"propiedadNoSerializable1", "propiedadNoSerializable2"})
public class PersonalApoyo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "equipoTrabajo_id")
    private EquipoTrabajo equipoTrabajo;
    @ManyToOne
    @JoinColumn(name = "personalApoyo_id")
    private  PersonalApoyo operador;
}
