package com.sakila.models;
import java.util.Date;

//Modelo Rental.
public final class Rental extends Entity {

    private Date rentalDate;
    private Inventory inventory;
    private Customer customer;

    public Rental() {
    }

    public Rental(
            int id,
            Date rentalDate,
            Inventory inventory,
            Customer customer
    ) {

        this.id = id;
        this.rentalDate = rentalDate;
        this.inventory = inventory;
        this.customer = customer;
    }

    public Date getRentalDate() {

        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {

        this.rentalDate = rentalDate;
    }

    public Inventory getInventory() {

        return inventory;
    }

    public void setInventory(Inventory inventory) {

        this.inventory = inventory;
    }

    public Customer getCustomer() {

        return customer;
    }

    public void setCustomer(Customer customer) {

        this.customer = customer;
    }

    @Override
    public String toString() {

        return id + " " + rentalDate;
    }
}