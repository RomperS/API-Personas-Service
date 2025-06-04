package com.oswaldo.apipersonasservice.repository;

import com.oswaldo.apipersonasservice.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Optional<Persona> findByNombre(String nombre);
    Optional<Persona> findByApellido(String apellido);
    Optional<Persona> findByCorreo(String correo);
    Optional<Persona> findByTelefono(String telefono);
}
