package com.proyect_back.proyect_back.service;

import com.proyect_back.proyect_back.entities.Jefe;
import com.proyect_back.proyect_back.entities.Operador;
import com.proyect_back.proyect_back.repository.JefeRepository;
import com.proyect_back.proyect_back.repository.OperadorRepository;
import org.springframework.stereotype.Service;

@Service
public class OperadorService {
    private final OperadorRepository operadorRepository;

    public OperadorService(OperadorRepository operadorRepository) {
        this.operadorRepository = operadorRepository;
    }
    public Operador createOperador(Operador operador){
        return operadorRepository.save(operador);
    }


    public Operador findByIdentificador(String identificador) {
        return operadorRepository.findTopByIdentificador(identificador);
    }
}
