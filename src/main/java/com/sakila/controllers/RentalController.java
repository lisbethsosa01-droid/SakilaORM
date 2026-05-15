package com.sakila.controllers;
import com.sakila.data.DataContext;
import com.sakila.models.Customer;
import com.sakila.models.Inventory;
import com.sakila.models.Rental;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Controlador Rental.
   @author Lisbeth Sosa */
public final class RentalController
        extends DataContext<Rental> {

    @Override
    public boolean post(Rental rental) {

        try {

            String sql =
                    """
                    INSERT INTO rental
                    (
                        rental_date,
                        inventory_id,
                        customer_id,
                        staff_id
                    )
                    VALUES
                    (NOW(),?,?,1)
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, rental.getInventory().getId());

            ps.setInt(2, rental.getCustomer().getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;
        }
    }

    @Override
    public Rental get(int id) {

        try {

            String sql =
                    """
                    SELECT *
                    FROM rental
                    WHERE rental_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Inventory inventory = new Inventory();
                inventory.setId(rs.getInt("inventory_id"));
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id"));

                return new Rental(rs.getInt("rental_id"),
                                  rs.getTimestamp("rental_date"),
                                  inventory, customer);
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Rental> get() {

        List<Rental> list = new ArrayList<>();

        try {

            String sql =
                    """
                    SELECT *
                    FROM rental
                    LIMIT 50
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Inventory inventory = new Inventory();
                inventory.setId(rs.getInt("inventory_id"));
                Customer customer = new Customer();
                customer.setId(rs.getInt("customer_id")
                );

                list.add(
                        new Rental(rs.getInt("rental_id"),
                                   rs.getTimestamp("rental_date"),
                                   inventory,
                                   customer));
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public boolean put(Rental rental) {

        try {

            String sql =
                    """
                    UPDATE rental
                    SET inventory_id=?,
                        customer_id=?
                    WHERE rental_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, rental.getInventory().getId());
            ps.setInt(2, rental.getCustomer().getId());
            ps.setInt(3, rental.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        try {

            String sql =
                    """
                    DELETE FROM rental
                    WHERE rental_id=?
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