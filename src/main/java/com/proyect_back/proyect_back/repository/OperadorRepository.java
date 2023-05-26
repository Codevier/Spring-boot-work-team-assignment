package com.proyect_back.proyect_back.repository;

import com.proyect_back.proyect_back.entities.Operador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperadorRepository extends JpaRepository<Operador, String> {
    Operador findTopByIdentificador(String identificador);
}
