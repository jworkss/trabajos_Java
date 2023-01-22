package com.jay.catalogopeliculas.datos;

import java.util.List;

import com.jay.catalogopeliculas.domain.Pelicula;
import com.jay.catalogopeliculas.exepciones.AccesoDatosEx;
import com.jay.catalogopeliculas.exepciones.EscrituraDatosEx;
import com.jay.catalogopeliculas.exepciones.LecturaDatosEx;

public interface AccesoDatosI {
    boolean existe(String nombreRecurso) throws AccesoDatosEx;

    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;

    void escribir(Pelicula pelicula, String nomreRecurso, boolean anexar) throws EscrituraDatosEx;

    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx;

    void crear(String nombreRecurso) throws AccesoDatosEx;

    void borrar(String nomrbreRecurso) throws AccesoDatosEx;
}
