package com.jay.db.simple.datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jay.db.simple.domain.Usuario;

public class UsuarioDAO {
    private static final String SQL_SELECT = "SELECT id_usuario, usuario, password   FROM usuario";
    private static final String SQL_INSERT = "INSERT INTO usuario (usuario, password  )" + " VALUES (?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario = ?";

    public List<Usuario> seleccionar() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Usuario usuario = null;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id_usuario");
                String userName = resultSet.getString("usuario");
                String password = resultSet.getString("password");
                usuario = new Usuario(idUsuario, userName, password);

                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(resultSet);
                Conexion.close(statement);
                Conexion.close(conexion);
            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }

        }
        return usuarios;
    }

    public int insertar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_INSERT);
            statement.setString(1, usuario.getUserName());
            statement.setString(2, usuario.getPassword());

            registros = statement.executeUpdate();
            System.out.println( "Se creo el usuario: " + usuario.getUserName());

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(statement);
                Conexion.close(conexion);

            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int actualizar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_UPDATE);
            statement.setString(1, usuario.getUserName());
            statement.setString(2, usuario.getPassword());
            statement.setInt(3, usuario.getIdUsuario());

            registros = statement.executeUpdate();
            System.out.println("Registros eliminados " + registros);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(statement);
                Conexion.close(conexion);

            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }

        }
        return registros;

    }

    public int eliminar(Usuario usuario) {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_DELETE);
            statement.setInt(1, usuario.getIdUsuario());
            registros = statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(statement);
                Conexion.close(conexion);

            } catch (SQLException e) {

                e.printStackTrace(System.out);
            }

        }
        return registros;

    }
}
