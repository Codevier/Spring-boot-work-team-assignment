package com.proyect_back.proyect_back.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.proyect_back.proyect_back.entities.Coordinador;
import com.proyect_back.proyect_back.entities.Jefe;
import com.proyect_back.proyect_back.entities.Operador;

import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable {
    private String identificador;
    private String nombre;
    private String apellido;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date f_nacimiento;
    private String correo;
    private String contrasena;
    private String area;
    private String rol;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public static Coordinador convertCoordinador(Usuario usuario){
        Coordinador aux= new Coordinador();
        aux.setIdentificador(usuario.getIdentificador());
        aux.setNombre(usuario.getNombre());
        aux.setApellido(usuario.getApellido());
        aux.setF_nacimiento(usuario.getF_nacimiento());
        aux.setCorreo(usuario.getCorreo());
        aux.setContrasena(usuario.getContrasena());
        aux.setArea(usuario.getArea());
        return  aux;

    }
    public static Jefe convertJefe(Usuario usuario){
        Jefe aux= new Jefe();
        aux.setIdentificador(usuario.getIdentificador());
        aux.setNombre(usuario.getNombre());
        aux.setApellido(usuario.getApellido());
        aux.setF_nacimiento(usuario.getF_nacimiento());
        aux.setCorreo(usuario.getCorreo());
        aux.setContrasena(usuario.getContrasena());
        aux.setArea(usuario.getArea());
        return aux;
    }
    public static Operador convertOperador(Usuario usuario){
        Operador aux= new Operador();
        aux.setIdentificador(usuario.getIdentificador());
        aux.setNombre(usuario.getNombre());
        aux.setApellido(usuario.getApellido());
        aux.setF_nacimiento(usuario.getF_nacimiento());
        aux.setCorreo(usuario.getCorreo());
        aux.setContrasena(usuario.getContrasena());
        aux.setArea(usuario.getArea());
        return aux;
    }


}
