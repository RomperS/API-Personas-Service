package com.oswaldo.apipersonasservice.service;

import com.oswaldo.apipersonasservice.model.Persona;
import com.oswaldo.apipersonasservice.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonaService {

    private final PersonaRepository personaRepository;

    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

    public Persona findById(Integer id) {
        return personaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No encontrada la persona con id: " + id));
    }

    public List<Persona> findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre);
    }

    public List<Persona> findByApellido(String apellido) {
        return personaRepository.findByApellido(apellido);
    }

    public List<Persona> findByTelefono(String telefono) {
        return personaRepository.findByTelefono(telefono);
    }

    public List<Persona> findByCorreo(String correo) {
        return personaRepository.findByCorreo(correo);
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void delete(Integer id) {
        personaRepository.deleteById(id);
    }

    public Persona updatePersona(Persona persona, Integer id) {
        Persona persona1=findById(id);
        persona1.setNombre(persona.getNombre());
        persona1.setApellido(persona.getApellido());
        persona1.setTelefono(persona.getTelefono());
        persona1.setCorreo(persona.getCorreo());

        return personaRepository.save(persona1);
    }

    public Persona partialPersonUpdate(Persona persona, Integer id) {
        Persona persona1=findById(id);

        if (persona.getApellido() != null) {
            persona1.setApellido(persona.getApellido());
        }

        if (persona.getNombre() != null) {
            persona1.setNombre(persona.getNombre());
        }

        if (persona.getTelefono() != null) {
            persona1.setTelefono(persona.getTelefono());
        }

        if (persona.getCorreo() != null) {
            persona1.setCorreo(persona.getCorreo());
        }

        return personaRepository.save(persona1);
    }
}
