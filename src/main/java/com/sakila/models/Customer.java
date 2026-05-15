package com.sakila.models;

//Modelo Customer
public final class Customer extends Entity {

    private String firstName;
    private String lastName;
    private String email;
    private City city;

    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, String email, City city) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.city = city;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public City getCity() {

        return city;
    }

    public void setCity(City city) {

        this.city = city;
    }
}