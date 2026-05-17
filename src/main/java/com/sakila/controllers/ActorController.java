package com.sakila.controllers;
import com.sakila.data.DataContext;
import com.sakila.models.Actor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/* Controlador Actor
   Maneja operaciones CRUD de Actor */
public final class ActorController extends DataContext<Actor> {

    /* Insertar actor */
    @Override
    public boolean post(Actor actor) {

        try {

            String sql =
                    """
                    INSERT INTO actor
                    (first_name,last_name)
                    VALUES (?,?)
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, actor.getFirstName());
            ps.setString(2, actor.getLastName());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;
        }
    }

    /* Buscar actor por ID */
    @Override
    public Actor get(int id) {

        try {

            String sql =
                    """
                    SELECT *
                    FROM actor
                    WHERE actor_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Actor(rs.getInt("actor_id"),
                                 rs.getString("first_name"),
                                 rs.getString("last_name"));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    /* Obtener todos */
    @Override
    public List<Actor> get() {

        List<Actor> list = new ArrayList<>();

        try {

            String sql =
                    """
                    SELECT *
                    FROM actor
                    ORDER BY actor_id ASC
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(
                        new Actor(rs.getInt("actor_id"),
                                  rs.getString("first_name"),
                                  rs.getString("last_name")));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

    /* Actualizar actor */
    @Override
    public boolean put(Actor actor) {

        try {

            String sql =
                    """
                    UPDATE actor
                    SET first_name=?,
                        last_name=?
                    WHERE actor_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, actor.getFirstName().toUpperCase());
            ps.setString(2, actor.getLastName().toUpperCase());
            ps.setInt(3, actor.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;
        }
    }

    /* Eliminar actor */
    @Override
    public boolean delete(int id) {

        try {

            String sql =
                    """
                    DELETE FROM actor
                    WHERE actor_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;
        }
    }
}
