package com.sakila.data;
import java.util.List;

/* Interface CRUD genérica
   @param <T> Tipo genérico
   @author Lisbeth Sosa */
public interface IDataPost<T> {

    /* Insertar nuevo registro
       @param obj objeto
       @return true si inserta */
    boolean post(T obj);

    /* Buscar por ID
       @param id ID
       @return objeto encontrado */
    T get(int id);

    /* Obtener todos los registros
       @return lista */
    List<T> get();

    /* Actualizar registro
       @param obj objeto actualizado
       @return true si actualiza */
    boolean put(T obj);

    /* Eliminar registro
       @param id ID
       @return true si elimina */
    boolean delete(int id);
}