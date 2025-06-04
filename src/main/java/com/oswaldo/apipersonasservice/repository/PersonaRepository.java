package com.oswaldo.apipersonasservice.repository;

import com.oswaldo.apipersonasservice.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByNombre(String nombre);
    Persona findByApellido(String apellido);
    Persona findByCorreo(String correo);
    Persona findByTelefono(String telefono);
}
