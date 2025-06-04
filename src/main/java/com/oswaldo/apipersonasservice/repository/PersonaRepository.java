package com.oswaldo.apipersonasservice.repository;

import com.oswaldo.apipersonasservice.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    List<Persona> findByNombre(String nombre);
    List<Persona> findByApellido(String apellido);
    List<Persona> findByCorreo(String correo);
    List<Persona> findByTelefono(String telefono);
}
