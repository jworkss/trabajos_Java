package com.jay.db.simple.datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jay.db.simple.domain.Persona;

public class PersonaDAO {
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
    private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido, email, telefono)"
            + " VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";

    public List<Persona> seleccionar() {
        Connection conexion = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_SELECT);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idPersona = resultSet.getInt("id_persona");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String email = resultSet.getString("email");
                String telefono = resultSet.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);

                personas.add(persona);
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
        return personas;
    }

    public int insertar(Persona persona) {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_INSERT);
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getEmail());
            statement.setString(4, persona.getTelefono());

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

    public int actualizar(Persona persona) {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_UPDATE);
            statement.setString(1, persona.getNombre());
            statement.setString(2, persona.getApellido());
            statement.setString(3, persona.getEmail());
            statement.setString(4, persona.getTelefono());
            statement.setInt(5, persona.getIdPersona());

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

    public int eliminar(Persona persona) {
        Connection conexion = null;
        PreparedStatement statement = null;
        int registros = 0;
        try {
            conexion = Conexion.getConnection();
            statement = conexion.prepareStatement(SQL_DELETE);
            statement.setInt(1, persona.getIdPersona());
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
