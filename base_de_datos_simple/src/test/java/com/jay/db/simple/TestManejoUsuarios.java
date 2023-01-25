package com.jay.db.simple;

import java.util.List;

import com.jay.db.simple.datos.UsuarioDAO;
import com.jay.db.simple.domain.Usuario;

public class TestManejoUsuarios {

    public static void main(String[] args) {

        UsuarioDAO usuarioDao = new UsuarioDAO();

        Usuario usuarioNuevo = new Usuario ("octavo usuario", "1235123");
        usuarioDao.insertar(usuarioNuevo);
        

        List<Usuario> usuarios = usuarioDao.seleccionar();
        System.out.println("listado de personas:");
        usuarios.forEach(usuario -> {
            System.out.println(usuario);
        });
    }

}
