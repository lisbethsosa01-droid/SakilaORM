package com.sakila.controllers;
import com.sakila.data.DataContext;
import com.sakila.models.Actor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* Controlador Actor
   Maneja operaciones CRUD de Actor. */
public final class ActorController
        extends DataContext<Actor> {

    /* Insertar actor
       @param actor objeto actor
       @return true si se inserto */
    @Override
    public boolean post(Actor actor) {

        try {

            String sql = "INSERT INTO actor(first_name,last_name) VALUES (?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println("Error insertando actor:");
            System.out.println(e.getMessage());

            return false;
        }
    }

    /* Buscar actor por ID
       @param id ID actor
       @return Actor encontrado */
    @Override
    public Actor get(int id) {

        try {

            String sql = "SELECT * FROM actor WHERE actor_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Actor(rs.getInt("actor_id"),
                                 rs.getString("first_name"),
                                 rs.getString("last_name")
                );
            }

        } catch (Exception e) {

            System.out.println("Error buscando actor:");
            System.out.println(e.getMessage());
        }

        return null;
    }

    /* Sobrecarga buscar actor por nombre
       @param firstName nombre actor
       @return Actor encontrado */
    public Actor get(String firstName) {

        try {

            String sql = "SELECT * FROM actor WHERE first_name=? LIMIT 1";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, firstName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Actor(rs.getInt("actor_id"),
                                 rs.getString("first_name"),
                                 rs.getString("last_name")
                );
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    /* Obtener listado de actores
       @return lista actores */
    @Override
    public List<Actor> get() {

        List<Actor> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM actor";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(
                        new Actor(rs.getInt("actor_id"),
                                  rs.getString("first_name"),
                                  rs.getString("last_name")
                        )
                );
            }

        } catch (Exception e) {

            System.out.println("Error listando actores:");
            System.out.println(e.getMessage());
        }

        return list;
    }

    /* Obtener actores en HashMap
       @return HashMap actores */
    public HashMap<Integer, Actor> getMap() {

        HashMap<Integer, Actor> map = new HashMap<>();

        for (Actor actor : get()) {

            map.put(actor.getId(), actor);
        }

        return map;
    }

    /* Actualizar actor
       @param actor actor actualizado
       @return true si se actualizo */
    @Override
    public boolean put(Actor actor) {

        try {

            String sql = "UPDATE actor SET first_name=?, last_name=? WHERE actor_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());
            ps.setInt(3, actor.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println("Error actualizando actor:");
            System.out.println(e.getMessage());

            return false;
        }
    }

    /* Eliminar actor
       @param id ID actor
       @return true si se elimino */
    @Override
    public boolean delete(int id) {

        try {

            String sql = "DELETE FROM actor WHERE actor_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println("Error eliminando actor:");
            System.out.println(e.getMessage());

            return false;
        }
    }
}