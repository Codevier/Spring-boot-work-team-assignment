package com.proyect_back.proyect_back.repository;

import com.proyect_back.proyect_back.entities.Coordinador;
import com.proyect_back.proyect_back.entities.Jefe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JefeRepository extends JpaRepository<Jefe, String> {

    Jefe findTopByIdentificador(String identificador);
}
