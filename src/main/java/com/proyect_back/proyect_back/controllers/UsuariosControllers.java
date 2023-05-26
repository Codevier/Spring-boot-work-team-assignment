package com.proyect_back.proyect_back.controllers;

import com.proyect_back.proyect_back.entities.Coordinador;
import com.proyect_back.proyect_back.entities.Jefe;
import com.proyect_back.proyect_back.entities.Operador;
import com.proyect_back.proyect_back.model.Usuario;
import com.proyect_back.proyect_back.service.CoordinadorService;
import com.proyect_back.proyect_back.service.JefeService;
import com.proyect_back.proyect_back.service.OperadorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.Random;


@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UsuariosControllers {
    private final CoordinadorService coordinadorService;
    private  final JefeService jefeService;
    private  final OperadorService operadorService;
    public UsuariosControllers(CoordinadorService coordinadorService, JefeService jefeService, com.proyect_back.proyect_back.service.OperadorService operadorService) {
        this.coordinadorService = coordinadorService;
        this.jefeService = jefeService;
        this.operadorService = operadorService;
    }
    @PostMapping
    public Object createUser(@RequestBody Usuario usuario){
        System.out.println("Se recibió un nuevo usuario: " + usuario.getNombre());
        String mensaje = "sin respuesta";
        if(esMayorDeEdad(usuario.getF_nacimiento())){
            switch (usuario.getRol()){
                case "coordinador":
                    usuario.setIdentificador(generarIdentificadorUnico("coordinador"));
                    return coordinadorService.createCoordinador(Usuario.convertCoordinador(usuario));
                case "jefe":
                    usuario.setIdentificador(generarIdentificadorUnico("jefe"));
                    return jefeService.createJefe(Usuario.convertJefe(usuario));
                case "operador":
                    usuario.setIdentificador(generarIdentificadorUnico("operador"));
                    return operadorService.createOperador(Usuario.convertOperador(usuario));
                default:
                    mensaje= "no ingreso un rol valido";
            }
        }
        else{
            mensaje=  "el usuario no es mayor de edad";
        }
        return ResponseEntity.ok().body(mensaje);
    }
    private String generarIdentificadorUnico(String rol) {
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        StringBuilder identificador = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 2; i++) {
            int indice = random.nextInt(letras.length());
            identificador.append(letras.charAt(indice));
        }
        for (int i = 0; i < 2; i++) {
            int indice = random.nextInt(numeros.length());
            identificador.append(numeros.charAt(indice));
        }
        // Verificar si el identificador generado ya existe en la base de datos
        // Si ya existe, volver a generar un identificador único
        switch (rol){
            case "coordinador":
                Coordinador coordinador = coordinadorService.findByIdentificador(identificador.toString());
                if (coordinador != null) {
                    return generarIdentificadorUnico(rol);
                }
            case "jefe":
                Jefe jefe = jefeService.findByIdentificador(identificador.toString());
                if (jefe != null) {
                    return generarIdentificadorUnico(rol);
                }
            case "operador":
                Operador operador = operadorService.findByIdentificador(identificador.toString());
                if (operador != null) {
                    return generarIdentificadorUnico(rol);
                }
        }
        return identificador.toString();
    }
    public static boolean esMayorDeEdad(Date fechaNacimiento) {
        Calendar calendarNacimiento = Calendar.getInstance();
        calendarNacimiento.setTime(fechaNacimiento);
        int anioNacimiento = calendarNacimiento.get(Calendar.YEAR);
        int mesNacimiento = calendarNacimiento.get(Calendar.MONTH);
        int diaNacimiento = calendarNacimiento.get(Calendar.DAY_OF_MONTH);
        Calendar calendarActual = Calendar.getInstance();
        int anioActual = calendarActual.get(Calendar.YEAR);
        int mesActual = calendarActual.get(Calendar.MONTH);
        int diaActual = calendarActual.get(Calendar.DAY_OF_MONTH);
        int edad = anioActual - anioNacimiento;
        if (mesActual < mesNacimiento || (mesActual == mesNacimiento && diaActual <= diaNacimiento)) {
            edad--;
        }
        return edad >= 18;
    }
}
