package com.sakila.reports;
import com.sakila.data.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/* Clase de estadísticas
   Maneja consultas agregadas del sistema Sakila */
public class Statistics {

    /* Total de actores */
    public static int totalActors() {

        try {

            Connection connection = Conexion.getConnection();

            String sql =
                    """
                    SELECT COUNT(*) total
                    FROM actor
                    """;

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
}