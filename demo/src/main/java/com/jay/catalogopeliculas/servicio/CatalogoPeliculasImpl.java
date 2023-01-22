package com.jay.catalogopeliculas.servicio;

import com.jay.catalogopeliculas.datos.AccesoDatosI;
import com.jay.catalogopeliculas.datos.AccesoDatosImpl;
import com.jay.catalogopeliculas.domain.Pelicula;
import com.jay.catalogopeliculas.exepciones.*;

public class CatalogoPeliculasImpl implements CatalogoPeliculasI{

    private final AccesoDatosI datos;
    
    public CatalogoPeliculasImpl() {
        this.datos = new AccesoDatosImpl();

    }
    @Override
    public void agregarPelicula(String nomrbePelicula) {
        var pelicula = new Pelicula(nomrbePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEx e) {

            System.out.println("Error de aceso a datos");
            e.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPeliculas() {
        try {
            var peliculas = this.datos.listar(NOMBRE_RECURSO);
            for (var pelicula : peliculas) {
                System.out.println("Pelicula = " + pelicula);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error de Acceso datos");
            e.printStackTrace(System.out);

        }
    }

    @Override
    public void buscarPelicual(String buscar) {
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEx e) {
            System.out.println("Error de acceso datos");
            e.printStackTrace(System.out);
        }
        System.out.println("Resultado: " + resultado);
    }

    @Override
    public void iniciarCatalogoPeliculas() {
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                datos.borrar(NOMBRE_RECURSO);
                ;
                datos.crear(NOMBRE_RECURSO);
            } else {
                datos.crear(NOMBRE_RECURSO);
            }
        } catch (AccesoDatosEx e) {
            System.out.println("Error al iniciar catalogo de Peliculas");
            e.printStackTrace(System.out);
        }

    }
    
}
