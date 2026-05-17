package com.sakila.models;

/* Modelo Actor
   Representa la entidad actor de la base de datos Sakila */
public final class Actor extends Entity {

    private String firstName;
    private String lastName;

    public Actor() {
    }

    public Actor(int id, String firstName, String lastName) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
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

    @Override
    public String toString() {

        return id + " " + firstName + " " + lastName;
    }
}
