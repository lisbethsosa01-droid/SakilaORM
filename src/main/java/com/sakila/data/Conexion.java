package com.sakila.data;
import java.sql.Connection;
import java.sql.DriverManager;

/* Clase de conexión JDBC a MySQL Sakila.
   @author Lisbeth Sosa
   @version 1.0 */
public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/sakila";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    /* Obtener conexión JDBC
       @return conexion activa */
    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (Exception e) {

            System.out.println("Error conexión: " + e.getMessage());

            return null;
        }
    }
}