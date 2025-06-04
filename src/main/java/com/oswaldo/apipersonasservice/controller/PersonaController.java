package com.oswaldo.apipersonasservice.controller;

import com.oswaldo.apipersonasservice.model.Persona;
import com.oswaldo.apipersonasservice.service.PersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persona")
@RequiredArgsConstructor
public class PersonaController {

    private final PersonaService personaService;

    @PostMapping
    public Persona addPersona(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @GetMapping
    public List<Persona> getAllPersonas() {
        return personaService.findAll();
    }

    @GetMapping("/id")
    public Persona getPersonaById(@RequestParam Integer id) {
        return personaService.findById(id);
    }

    @GetMapping("/nombre")
    public List<Persona> getPersonasByNombre(@RequestParam String nombre) {
        return personaService.findByNombre(nombre);
    }

    @GetMapping("/apellido")
    public List<Persona> getPersonaByApellido(@RequestParam String apellido) {
        return personaService.findByApellido(apellido);
    }

    @GetMapping("/correo")
    public List<Persona> getPersonaByCorreo(@RequestParam String correo) {
        return personaService.findByCorreo(correo);
    }

    @GetMapping("/telefono")
    public List<Persona> getPersonaByTelefono(@RequestParam String telefono) {
        return personaService.findByTelefono(telefono);
    }

    @PutMapping
    public Persona updatePersona(@RequestBody Persona persona, @RequestParam Integer id) {
        return personaService.updatePersona(persona, id);
    }

    @PatchMapping
    public Persona partialPersonUpdate(@RequestBody Persona persona, @RequestParam Integer id) {
        return personaService.partialPersonUpdate(persona, id);
    }

    @DeleteMapping
    public void deletePersona(@RequestParam Integer id) {
        personaService.delete(id);
    }

}
