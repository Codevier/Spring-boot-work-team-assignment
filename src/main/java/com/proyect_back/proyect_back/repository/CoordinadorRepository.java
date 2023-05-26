package com.proyect_back.proyect_back.repository;

import com.proyect_back.proyect_back.entities.Coordinador;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CoordinadorRepository extends JpaRepository<Coordinador, String> {
    Coordinador findTopByIdentificador(String identificador);
}
