package com.proyect_back.proyect_back.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.proyect_back.proyect_back.repository.CoordinadorRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Random;
@Entity
@Table(name="coordinador")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"propiedadNoSerializable1", "propiedadNoSerializable2"})
public class Coordinador {
    @Id
    private String identificador;
    private String nombre;
    private String apellido;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date f_nacimiento;
    private String correo;
    private String contrasena;
    private String area;

}
