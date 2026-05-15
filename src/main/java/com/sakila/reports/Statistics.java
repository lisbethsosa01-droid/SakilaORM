package com.sakila.reports;
import com.sakila.data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase de estadisticas.
public class Statistics {

    /* Total de películas.
       @return total películas */
    public static int totalFilms() {

        try {

            Connection connection = Conexion.getConnection();
            String sql = "SELECT COUNT(*) total FROM film";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("total");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return 0;
    }

    /* Total de actores.
       @return total actores */
    public static int totalActors() {

        try {

            Connection connection = Conexion.getConnection();
            String sql = "SELECT COUNT(*) total FROM actor";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("total");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return 0;
    }

    /* Total clientes.
       @return total clientes */
    public static int totalCustomers() {

        try {

            Connection connection = Conexion.getConnection();
            String sql = "SELECT COUNT(*) total FROM customer";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getInt("total");
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return 0;
    }

    //Mostrar películas por actor.
    public static void filmsByActor() {

        try {

            Connection connection = Conexion.getConnection();
            String sql =
                    """
                    SELECT actor.first_name,
                           actor.last_name,
                           film.title
                    FROM actor
                    INNER JOIN film_actor
                    ON actor.actor_id = film_actor.actor_id
                    INNER JOIN film
                    ON film_actor.film_id = film.film_id
                    LIMIT 20""";

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println(
                        rs.getString("first_name") + " "
                                     + rs.getString("last_name") + " -> "
                                     + rs.getString("title"));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }
}