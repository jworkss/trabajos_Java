package com.jay.db.simple;

import java.util.List;

import com.jay.db.simple.datos.PersonaDAO;
import com.jay.db.simple.domain.Persona;

public class TestManejoPersona {
    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        // Persona personaNueva = new Persona("cec", "peter", "cpeter@mail.com",
        // "15135345");
        // personaDao.insertar(personaNueva);

       // Persona personaEditar = new Persona(4, "Juan cec", "Peter", "jcec@mail.com", "15135345");
       //personaDao.actualizar(personaEditar);
       
       Persona personaEliminar = new Persona (4);
        personaDao.eliminar(personaEliminar);

        List<Persona> personas = personaDao.seleccionar();
        System.out.println("listado de personas:");
        personas.forEach(persona -> {
            System.out.println(persona);
        });

    }
}