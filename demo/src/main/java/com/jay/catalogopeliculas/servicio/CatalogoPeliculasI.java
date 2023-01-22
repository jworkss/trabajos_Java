package com.jay.catalogopeliculas.servicio;

public interface CatalogoPeliculasI {
    String NOMBRE_RECURSO = "peliculas.txt";

    void agregarPelicula(String nomrbe);

    void listarPeliculas();

    void buscarPelicual(String buscar);

    void iniciarCatalogoPeliculas();
}
