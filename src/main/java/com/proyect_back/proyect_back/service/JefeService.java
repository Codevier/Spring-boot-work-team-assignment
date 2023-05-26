package com.proyect_back.proyect_back.service;

import com.proyect_back.proyect_back.entities.Coordinador;
import com.proyect_back.proyect_back.entities.Jefe;
import com.proyect_back.proyect_back.repository.JefeRepository;
import org.springframework.stereotype.Service;

@Service
public class JefeService {
    private final JefeRepository jefeRepository;

    public JefeService(JefeRepository jefeRepository) {
        this.jefeRepository = jefeRepository;
    }
    public Jefe createJefe(Jefe jefe){
        return jefeRepository.save(jefe);
    }

    public Jefe findByIdentificador(String identificador) {
        return jefeRepository.findTopByIdentificador(identificador);
    }
}
