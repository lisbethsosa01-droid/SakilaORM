package com.sakila.controllers;
import com.sakila.data.DataContext;
import com.sakila.models.City;
import com.sakila.models.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Controlador Customer
public final class CustomerController
        extends DataContext<Customer> {

    @Override
    public boolean post(Customer customer) {

        try {

            String sql =
                    """
                    INSERT INTO customer
                    (
                        store_id,
                        first_name,
                        last_name,
                        email,
                        address_id,
                        active
                    )
                    VALUES
                    (1,?,?,?,?,1)
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setInt(4, 1);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return false;
        }
    }

    @Override
    public Customer get(int id) {

        try {

            String sql =
                    """
                    SELECT *
                    FROM customer
                    WHERE customer_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                return new Customer(rs.getInt("customer_id"),
                                    rs.getString("first_name"),
                                    rs.getString("last_name"),
                                    rs.getString("email"), new City());
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public List<Customer> get() {

        List<Customer> list = new ArrayList<>();

        try {

            String sql = "SELECT * FROM customer";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                list.add(
                        new Customer(rs.getInt("customer_id"),
                                     rs.getString("first_name"),
                                     rs.getString("last_name"),
                                     rs.getString("email"), new City())
                );
            }

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

    @Override
    public boolean put(Customer customer) {

        try {

            String sql =
                    """
                    UPDATE customer
                    SET first_name=?,
                        last_name=?,
                        email=?
                    WHERE customer_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setInt(4, customer.getId());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            return false;
        }
    }

    @Override
    public boolean delete(int id) {

        try {

            String sql =
                    """
                    UPDATE customer
                    SET active=0
                    WHERE customer_id=?
                    """;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            return false;
        }
    }
}