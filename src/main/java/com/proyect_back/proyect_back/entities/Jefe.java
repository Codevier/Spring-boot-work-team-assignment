package com.proyect_back.proyect_back.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="jefe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"propiedadNoSerializable1", "propiedadNoSerializable2"})
public class Jefe {
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
