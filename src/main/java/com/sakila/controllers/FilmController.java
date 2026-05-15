package com.sakila.controllers;
import com.sakila.data.DataContext;
import com.sakila.models.Film;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Controlador Film.
public final class FilmController
        extends DataContext<Film> {

    @Override
    public boolean post(Film film) {

        try {

            String sql =
                    """
                    INSERT INTO film
                    (title, description, release_year, language_id)
                    VALUES (?,?,?,1)
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getDescription());
            ps.setInt(3, film.getReleaseYear());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;
        }
    }

    @Override
    public Film get(int id) {

        try {

            String sql = "SELECT * FROM film WHERE film_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Film(rs.getInt("film_id"),
                                rs.getString("title"),
                                rs.getString("description"),
                                rs.getInt("release_year")
                );
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Film> get() {

        List<Film> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM film";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(
                        new Film(rs.getInt("film_id"),
                                 rs.getString("title"),
                                 rs.getString("description"),
                                 rs.getInt("release_year")));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public boolean put(Film film) {

        try {

            String sql =
                    """
                    UPDATE film
                    SET title=?,
                        description=?,
                        release_year=?
                    WHERE film_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, film.getTitle());
            ps.setString(2, film.getDescription());
            ps.setInt(3, film.getReleaseYear());
            ps.setInt(4, film.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        try {

            String sql = "DELETE FROM film WHERE film_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            return false;
        }
    }
}