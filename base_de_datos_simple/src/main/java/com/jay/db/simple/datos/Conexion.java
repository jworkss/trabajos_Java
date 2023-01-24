package com.jay.db.simple.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/tests?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrival=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

   public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
   }

   public static void close(ResultSet resulSet) throws SQLException { 
    resulSet.close();
   }

   public static void close(Statement statement) throws SQLException{
    statement.close();
   }

   public static void close(PreparedStatement statement) throws SQLException{
    statement.close();
   }
public static void close (Connection conexion) throws SQLException {
    conexion.close();
}

}
