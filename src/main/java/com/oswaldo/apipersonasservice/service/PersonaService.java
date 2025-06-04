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

    public Persona findByNombre(String nombre) {
        return personaRepository.findByNombre(nombre)
                .orElseThrow(() -> new RuntimeException("No encontrada la persona con nombre: " + nombre));
    }

    public Persona findByApellido(String apellido) {
        return personaRepository.findByApellido(apellido)
                .orElseThrow(() -> new RuntimeException("No encontrada la persona con nombre: " + apellido));
    }

    public Persona findByTelefono(String telefono) {
        return personaRepository.findByTelefono(telefono)
                .orElseThrow(() -> new RuntimeException("No encontrada la persona con nombre: " + telefono));
    }

    public Persona findByCorreo(String correo) {
        return personaRepository.findByCorreo(correo)
                .orElseThrow(() -> new RuntimeException("No encontrada la persona con correo: " + correo));
    }

    public Persona save(Persona persona) {
        return personaRepository.save(persona);
    }

    public void delete(Persona persona) {
        personaRepository.delete(persona);
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

        if (!persona.getApellido().isEmpty()) {
            persona1.setApellido(persona.getApellido());
        }

        if (persona.getNombre().isEmpty()) {
            persona1.setNombre(persona.getNombre());
        }

        if (persona.getTelefono().isEmpty()) {
            persona1.setTelefono(persona.getTelefono());
        }

        if (persona.getCorreo().isEmpty()) {
            persona1.setCorreo(persona.getCorreo());
        }

        return personaRepository.save(persona1);
    }
}
