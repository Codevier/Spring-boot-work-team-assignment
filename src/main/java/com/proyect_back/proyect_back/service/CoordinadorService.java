package com.proyect_back.proyect_back.service;

import com.proyect_back.proyect_back.entities.Coordinador;
import com.proyect_back.proyect_back.repository.CoordinadorRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class CoordinadorService {
    private final CoordinadorRepository coordinadorRepository;

    public CoordinadorService(CoordinadorRepository coordinadorRepository) {
        this.coordinadorRepository = coordinadorRepository;
    }
    public Coordinador createCoordinador(Coordinador cinema){
        return coordinadorRepository.save(cinema);
    }


    public Coordinador findByIdentificador(String identificador) {
        return coordinadorRepository.findTopByIdentificador(identificador);
    }
}
