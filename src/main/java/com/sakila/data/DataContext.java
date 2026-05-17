package com.sakila.data;
import java.sql.Connection;

/* Padre abstracto ORM.
   @param <T> Tipo generico
   @author Lisbeth Sosa */
public abstract class DataContext<T> implements IDataPost<T> {

    protected Connection connection;

    // Constructor
    public DataContext() {

        connection = Conexion.getConnection();
    }

    /* Obtener conexion.
       No puede sobrescribirse.
       @return conexion */
    public final Connection getConnection() {

        return connection;
    }
}