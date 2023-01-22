package com.jay.catalogopeliculas.vista;

import java.util.Scanner;

import com.jay.catalogopeliculas.servicio.CatalogoPeliculasI;
import com.jay.catalogopeliculas.servicio.CatalogoPeliculasImpl;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        var opcion = -1;

        var scanner = new Scanner(System.in);
        CatalogoPeliculasI catalogo = new CatalogoPeliculasImpl();

        while (opcion != 0) {
            System.out.println("Elegir una opcion: \n"
                    + "1) Iniciar catalogo peliculas \n"
                    + "2) Agregar pelicula \n"
                    + "3) Listar peliculas \n"
                    + "4) Buscar Pelicula \n"
                    + "0) salir");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Ingresar nombre de pelicula");
                    var nombrePelicua = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicua);
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("Nombre de pelicula a buscar");
                    var bucarPelicula = scanner.nextLine();
                    catalogo.buscarPelicual(bucarPelicula);
                    break;
                case 0:
                    System.out.println("Hasta pronto");
                default:
                    System.out.println("Opcion no reconocida");
            }
        }
        scanner.close();
    }
}
